package com.huluohu.learning.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.util.concurrent.*;

/**
 * Created by Administrator on 2017/2/23.
 */
public class AIOHandlerServer {
    public final static int PORT = 9999;
    private static Charset charset = Charset.forName("UTF-8");
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



    public void startWithHandler() {
        doAccept(server);
        try {
            channelGroup.awaitTermination(Integer.MAX_VALUE,TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void doAccept(AsynchronousServerSocketChannel server) {
        server.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            final ByteBuffer buf = ByteBuffer.allocate(1024);
            @Override
            public void completed(AsynchronousSocketChannel client, Object attachment) {
                server.accept(null,this);
                doRead(client,attachment);
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.err.println(String.format("Failed accept:%s",exc));
            }
        });
        System.out.println(String.format("server Listening on %d",PORT));
    }

    private void doRead(AsynchronousSocketChannel client, Object attachment) {
        System.out.println(Thread.currentThread().getName());
        ByteBuffer buf = ByteBuffer.allocate(1024);
        client.read(buf, buf, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println("===========================start=========================");
                if(result.intValue() <= 0){
                    try {
                        System.err.println(String.format("Client disconnect:%s",client.getRemoteAddress().toString()));
                        attachment = null;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return;
                }
                attachment.flip();
                String message = charset.decode(attachment).toString();
                attachment.compact();
                client.read(attachment,attachment,this);

                System.out.println(String.format("server read message:%s",message));

                ByteBuffer response = ByteBuffer.wrap(String.format("server accepted :%s",message).getBytes());
                doWrite(client,response,response);
                System.out.println("============================end==========================");
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                System.err.println(String.format("Failed read:%s",exc));
            }
        });


//        try {
//            buf.clear();
//            Future<Integer> future = client.read(buf);
//            Integer count = future.get(100, TimeUnit.SECONDS);
//            buf.flip();
//
//            String message = new String(buf.array(), 0, count);
//            System.out.println(String.format("server accept message:%s",message));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                client.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }


    }

    private void doWrite(AsynchronousSocketChannel client, ByteBuffer response, ByteBuffer attachment) {
        client.write(attachment, attachment, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                if(result <= 0){
                    try {
                        System.err.println(String.format("Client disconnect:%s",client.getRemoteAddress().toString()));
                        attachment = null;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                System.err.println(String.format("Failed write:%s",exc));
            }
        });
    }
}
