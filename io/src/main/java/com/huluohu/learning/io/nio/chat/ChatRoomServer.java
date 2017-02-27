package com.huluohu.learning.io.nio.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.*;

/**
 * Created by Administrator on 2017/2/23.
 */
public class ChatRoomServer {
    private Selector selector;
    public static final int PORT = 9999;
    private static List<SocketChannel> channels = Collections.synchronizedList( new ArrayList<SocketChannel>() );

    public static void main(String[] args) throws IOException {
        ChatRoomServer server = new ChatRoomServer();
        server.start();
    }

    private void init() throws IOException {
        selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(PORT));
        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("server is listening on " + PORT + "...");


    }

    public void start() throws IOException {
        init();
        HandlerSelectionKey handler = new HandlerSelectorKeyImpl();
        while (true){
            int acceptCount = selector.select();
            if(acceptCount > 0){
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();
                    handler.handle(selectionKey,selector);
                }
            }
        }
    }


    public  interface HandlerSelectionKey{
        void handle(SelectionKey key,Selector selector)throws IOException;
    }

    public static class HandlerSelectorKeyImpl implements HandlerSelectionKey{
        @Override
        public void handle(SelectionKey key, Selector selector) throws IOException {
            int keyState = selectionKeyState(key);
            switch (keyState){
                case SelectionKey.OP_ACCEPT:
                    doAccept(key,selector);
                    break;
                case SelectionKey.OP_READ:
                    doRead(key,selector);
                    break;
                case SelectionKey.OP_WRITE:

                case SelectionKey.OP_CONNECT:
                    doConnect(key,selector);
                    break;
            }
        }


        /**
         * 接收连接
         * @param key
         * @param selector
         * @throws IOException
         */
        private void doAccept(SelectionKey key, Selector selector) throws IOException {
            ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
            SocketChannel clientChannel = serverChannel.accept();
            clientChannel.configureBlocking(false);
            clientChannel.register(selector,SelectionKey.OP_READ);
            channels.add(clientChannel);
        }

        /**
         * 读取数据
         * @param key
         * @param selector
         * @throws IOException
         */
        private void doRead(SelectionKey key, Selector selector) throws IOException {
            ByteBuffer buf = ByteBuffer.allocate(256);
            SocketChannel clientChannel = (SocketChannel) key.channel();
            String msg;
            while (clientChannel.read(buf) > 0){
                buf.flip();
                msg = new String(buf.array());
                System.out.println(String.format("server accept message:%s",msg));
                buf.clear();
                write(key,msg);
            }
        }

        /**
         * 建立连接
         * @param key
         */
        private void doConnect(SelectionKey key, Selector selector) {
            System.out.println("Server connected!");
        }


        /**
         * 响应客户端请求
         * @param key
         * @param msg
         */
        private void write(SelectionKey key, String msg) throws IOException {
            SocketChannel clientChannel = (SocketChannel) key.channel();
            msg = String.format("游客 %d \r\n %s",clientChannel.hashCode(),msg);
            byte[] response = msg.getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(response.length);
            buffer.put(response);
            buffer.flip();

            //响应客户端
            int size = channels.size();
            for (int i = 0; i < size; i++) {
//                if(!readSocketChannel.equals(channels.get(i))){
//
//                }
                channels.get(i).write(buffer);
            }
        }

        /**
         * 获取SelectionKey的事件类型
         * @param key
         * @return
         */
        private int selectionKeyState(SelectionKey key) {
            if(key.isAcceptable()){
                return SelectionKey.OP_ACCEPT;
            }else if(key.isReadable()){
                return SelectionKey.OP_READ;
            }else if(key.isWritable()){
                return SelectionKey.OP_WRITE;
            }else if(key.isConnectable()){
                return SelectionKey.OP_CONNECT;
            }
            return -1;
        }
    }

}
