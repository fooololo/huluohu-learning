package com.huluohu.learning.io.nio;

import com.huluohu.learning.io.nio.support.Processor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2017/2/20.
 */
public class NIOMultiThreadServer {
    public static final int PORT = 9988;
    private static final Logger LOGGER = Logger.getLogger(NIOMultiThreadServer.class.getName());
    public static void main(String[] args) {
        try {
            Selector selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(PORT));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true){
                if(selector.selectNow() < 0){
                    continue;
                }
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if(key.isAcceptable()){
                        ServerSocketChannel acceptServerSocketChannel = (ServerSocketChannel) key.channel();
                        SocketChannel socketChannel = acceptServerSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        LOGGER.info(String.format("Accept request from %s",socketChannel.getRemoteAddress()));

                        SelectionKey readKey = socketChannel.register(selector, SelectionKey.OP_READ);
                        readKey.attach(new Processor());
                    }else if(key.isReadable()){
                        Processor processor = (Processor) key.attachment();
                        processor.process(key);
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
