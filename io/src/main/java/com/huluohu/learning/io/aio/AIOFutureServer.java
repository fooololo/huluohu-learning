package com.huluohu.learning.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.concurrent.*;

/**
 * Created by Administrator on 2017/2/24.
 */
public class AIOFutureServer {
    public final static int PORT = 9999;
    private static Charset charset = Charset.forName("UTF-8");
    private AsynchronousServerSocketChannel server;
    ExecutorService executorService = Executors.newCachedThreadPool();
    AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withCachedThreadPool(executorService, 1);

    public static void main(String[] args) throws IOException {
        AIOFutureServer server = new AIOFutureServer();
        server.start();
    }

    public AIOFutureServer() throws IOException {
        server = AsynchronousServerSocketChannel.open(channelGroup);
        server.bind(new InetSocketAddress(PORT));
        System.out.println(String.format("server Listening on %d",PORT));
    }

    public void start(){
        doAccept(server);
        try {
            channelGroup.awaitTermination(Integer.MAX_VALUE, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doAccept(AsynchronousServerSocketChannel server) {
        Future<AsynchronousSocketChannel> future = server.accept();
        try {
            while (future.get() != null){
                AsynchronousSocketChannel client = future.get();
                doRead(client);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private void doRead(AsynchronousSocketChannel client) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Future<Integer> future = client.read(buffer);
        try {
            Integer count = future.get();
            if(count > 0){
                buffer.flip();
                String message = new String(buffer.array());
                System.out.println(String.format("server accept:%s",message));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
