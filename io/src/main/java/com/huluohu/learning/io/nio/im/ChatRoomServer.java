package com.huluohu.learning.io.nio.im;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
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
        server.init();
    }

    public void init() throws IOException {
        selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(PORT));
        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("server is listening on " + PORT + "...");

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
                    ServerSocketChannel acceptServerSocketChannel = (ServerSocketChannel) key.channel();
                    accept(acceptServerSocketChannel,selector);
                    break;
                case SelectionKey.OP_READ:
                    SocketChannel readSocketChannel = (SocketChannel) key.channel();
                    read(readSocketChannel,selector);
                    break;
            }
        }

        /**
         * 读取客户端发生过来的数据
         * @param readSocketChannel
         * @param selector
         */
        private void read(SocketChannel readSocketChannel, Selector selector) throws IOException {
            ByteBuffer buf = ByteBuffer.allocate(8192);
            int read = readSocketChannel.read(buf);
            String msg = "";
            if(read > 0){
                msg = new String(buf.array(),0,read);
                System.out.println(String.format("server accept message:%s",msg));
            }
            write(readSocketChannel,msg);
        }

        /**
         * 响应客户端请求
         * @param readSocketChannel
         * @param msg
         */
        private void write(SocketChannel readSocketChannel, String msg) throws IOException {
            msg = String.format("游客 %d \r\n %s",readSocketChannel.hashCode(),msg);
            byte[] response = msg.getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(response.length);
            buffer.put(response);
            buffer.flip();

            //响应客户端
            int size = channels.size();
            for (int i = 0; i < size; i++) {
                if(!readSocketChannel.equals(channels.get(i))){
                    channels.get(i).write(buffer);
                }
            }
        }

        /**
         * 接收客户端请求
         * @param serverSocketChannel
         * @param selector
         */
        private void accept(ServerSocketChannel serverSocketChannel, Selector selector) throws IOException {
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            channels.add(socketChannel);

            //注册读事件
            socketChannel.register(selector,SelectionKey.OP_READ);
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
            }
            return -1;
        }
    }

}
