package com.huluohu.learning.io.nio;

import com.huluohu.learning.io.nio.support.ReactorProcessor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2017/2/20.
 */
public class NIOMultiReactorServer {
    public static final int PORT = 9988;
    private static final Logger LOGGER = Logger.getLogger(NIOMultiReactorServer.class.getName());
    public static void main(String[] args) {
        try {
            Selector selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(PORT));
            SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            int processorCount = Runtime.getRuntime().availableProcessors() -2;
            ReactorProcessor[] processors = new ReactorProcessor[processorCount];
            for (int i = 0; i < processors.length; i++) {
                processors[i] = new ReactorProcessor();
            }

            int index = 0;
            while (selector.select() > 0){
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if(key.isAcceptable()){
                        ServerSocketChannel acceptServerSocketChannel = (ServerSocketChannel) key.channel();
                        SocketChannel socketChannel = acceptServerSocketChannel.accept();
                        LOGGER.info(String.format("Accept Request From %s",socketChannel.getRemoteAddress()));
                        ReactorProcessor processor = processors[(index++) / processorCount];
                        processor.addChannel(socketChannel);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
