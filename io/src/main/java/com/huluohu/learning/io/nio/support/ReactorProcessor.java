package com.huluohu.learning.io.nio.support;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2017/2/20.
 */
public class ReactorProcessor {
    private static final Logger LOGGER = Logger.getLogger(ReactorProcessor.class.getName());

    private static final ExecutorService es = Executors.newFixedThreadPool(2 * Runtime.getRuntime().availableProcessors());

    private Selector selector;

    public ReactorProcessor() throws IOException {
        this.selector = SelectorProvider.provider().openSelector();
        start();
    }

    public void addChannel(SocketChannel channel) throws ClosedChannelException {
        channel.register(selector,SelectionKey.OP_READ);
    }

    private void start() {
        es.submit(() -> {
            while (true){
                if(selector.selectNow() < 0){
                    continue;
                }
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    if(key.isAcceptable()){
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        int count = socketChannel.read(buffer);
                        if(count < 0){
                            socketChannel.close();
                            key.cancel();
                            LOGGER.info(String.format("%s \t Read End.",socketChannel));
                            continue;
                        }else if(count == 0) {
                            LOGGER.info(String.format("%s \t Message Size is 0.",socketChannel));
                            continue;
                        }else {
                            LOGGER.info(String.format("%s \\t Read Message : %s",socketChannel, new String(buffer.array())));
                        }
                    }
                    iterator.remove();
                }
            }
        });
    }
}
