package com.huluohu.learning.io.nio.support;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2017/2/20.
 */
public class ThreadProcessor {
    private static final Logger LOGGER = Logger.getLogger(ThreadProcessor.class.getName());
    private static final ExecutorService es = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public void process(SelectionKey key){
        es.submit(() -> {
            ByteBuffer buf = ByteBuffer.allocate(1024);
            SocketChannel socketChannel = (SocketChannel) key.channel();
            try {
                int count = socketChannel.read(buf);
                if(count < 0){
                    socketChannel.close();
                    key.cancel();;
                    LOGGER.info(String.format("%s \t read end.",socketChannel));
                }else if(count == 0){
                    return null;
                }
                LOGGER.info(String.format("%s \t read message %s",socketChannel,new String(buf.array())));
                return null;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        });
    }

}
