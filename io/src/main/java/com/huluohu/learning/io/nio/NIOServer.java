package com.huluohu.learning.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Administrator on 2017/2/17.
 */
public class NIOServer {
    public static final int PORT = 9988;
    public static void main(String[] args) {
        try {
            Selector selector = Selector.open();
            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.configureBlocking(false);
            channel.bind(new InetSocketAddress(PORT));
            channel.register(selector, SelectionKey.OP_ACCEPT);

            while (selector.select() > 0){
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    iterator.remove();

                    if(key.isAcceptable()){
                        ServerSocketChannel acceptChannel = (ServerSocketChannel) key.channel();
                        SocketChannel accept = acceptChannel.accept();
                        accept.configureBlocking(false);

                        accept.register(selector,SelectionKey.OP_READ);
                    }else if (key.isReadable()){
                        SocketChannel readableChannel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        int count = readableChannel.read(buffer);

                        if(count <= 0){
                            readableChannel.close();
                            key.cancel();
                            continue;
                        }

                        String acceptMsg = new String(buffer.array());
                        System.out.println("server accept:" + acceptMsg);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
