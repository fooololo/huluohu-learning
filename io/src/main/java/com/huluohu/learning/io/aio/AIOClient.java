package com.huluohu.learning.io.aio;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/2/24.
 */
public class AIOClient {
    public final static int PORT = 9999;
    private static Charset charset = Charset.forName("UTF-8");
    private AsynchronousSocketChannel client;
    public static void main(String[] args) throws IOException {
        AIOClient client = new AIOClient();
        client.start();
    }

    public AIOClient() throws IOException {
        client = AsynchronousSocketChannel.open();
    }

    public void start(){
        client.connect(new InetSocketAddress("localhost", PORT), null, new CompletionHandler<Void, Object>() {
            @Override
            public void completed(Void result, Object attachment) {
                System.out.println("请输入:\t");
                while (true){
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    try {
                        String readLine = reader.readLine();

                        if(StringUtils.isNotBlank(readLine)){
                            Future<Integer> future = client.write(ByteBuffer.wrap(readLine.getBytes()));
                            Integer count = future.get();
                            System.out.println("send data to server");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.err.println(String.format("Failed connect:%s",exc));
            }
        });

        final ByteBuffer buf = ByteBuffer.allocate(1024);
        client.read(buf, null, new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer result, Object attachment) {
                System.out.println("===========================start=========================");
                if(result.intValue() <= 0){
                    try {
                        System.err.println(String.format("Server disconnect:%s",client.getRemoteAddress().toString()));
                        attachment = null;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return;
                }
                buf.flip();
                String message = charset.decode(buf).toString();
                buf.compact();
                client.read(buf,buf,this);

                System.out.println(String.format("read server:%s",message));
                System.out.println("============================end==========================");
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.err.println(String.format("Failed connect:%s",exc));
            }
        });

        try {
            TimeUnit.DAYS.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
