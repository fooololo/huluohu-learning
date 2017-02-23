package com.huluohu.learning.io.nio.chat;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.Socket;

/**
 * Created by Administrator on 2017/2/23.
 */
public class ChatClient {
    public static final int PORT = 9999;
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", PORT);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        InputStream in = socket.getInputStream();
                        byte[] buf = new byte[8192];
                        int read = in.read(buf);
                        String msg = new String(buf, 0, read);
                        System.out.println(String.format("client accept message:%s",msg));
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        System.out.println("请输入:\t");
        while (true){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String readLine = reader.readLine();

            if(StringUtils.isNotBlank(readLine)){
                OutputStream out = socket.getOutputStream();
                out.write(readLine.getBytes());
                out.flush();
            }
        }
    }
}
