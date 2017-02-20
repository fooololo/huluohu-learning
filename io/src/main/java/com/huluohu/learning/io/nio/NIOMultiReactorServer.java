package com.huluohu.learning.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2017/2/20.
 */
public class NIOMultiReactorServer {
    public static final int PORT = 9988;
    private static final Logger LOGGER = Logger.getLogger(NIOMultiThreadServer.class.getName());
    public static void main(String[] args) {
        try {
            Selector selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(PORT));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);


            int processors = Runtime.getRuntime().availableProcessors();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
