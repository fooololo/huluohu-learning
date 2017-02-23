package com.huluohu.learning.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.*;

/**
 * Created by Administrator on 2017/2/23.
 */
public class AIOHandlerServer {
    public final static int PORT = 9888;
    private AsynchronousServerSocketChannel server;
    ExecutorService executorService = Executors.newCachedThreadPool();
    AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withCachedThreadPool(executorService, 1);

    public static void main(String[] args) throws IOException {
        AIOHandlerServer server = new AIOHandlerServer();
        server.startWithHandler();
    }


    public AIOHandlerServer() throws IOException {
        server = AsynchronousServerSocketChannel.open(channelGroup);
        server.bind(new InetSocketAddress(PORT));
    }



    private void startWithHandler() {
        server.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            final ByteBuffer buf = ByteBuffer.allocate(1024);
            @Override
            public void completed(AsynchronousSocketChannel result, Object attachment) {
                System.out.println(Thread.currentThread().getName());
                System.out.println("===========================start=========================");
                try {
                    buf.clear();
                    Future<Integer> future = result.read(buf);
                    Integer count = future.get(100, TimeUnit.SECONDS);
                    buf.flip();

                    String message = new String(buf.array(), 0, count);
                    System.out.println(String.format("server accept message:%s",message));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        result.close();
                        server.accept(null,this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("============================end==========================");

            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.err.println(String.format("Failed:%s",exc));
            }
        });
        System.out.println(String.format("server Listening on %d",PORT));
        try {
            channelGroup.awaitTermination(Integer.MAX_VALUE,TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
