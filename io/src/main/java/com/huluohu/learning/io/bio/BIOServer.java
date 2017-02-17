package com.huluohu.learning.io.bio;


import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Date;

/**
 * Created by Administrator on 2017/2/17.
 */
public class BIOServer {
    public static final int PORT = 9988;
    public static void main(String[] args) {
        System.out.println("server bind in "+ PORT + " ...");
        BIOServer server = new BIOServer();
        server.init();
    }

    private void init() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true){
                Socket client = serverSocket.accept();
                HandlerThread handlerThread = new HandlerThread(client);
                handlerThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class HandlerThread extends Thread{
        private Socket socket;

        public HandlerThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
//                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                PrintWriter writer = new PrintWriter(socket.getOutputStream());


                while (true){
                    String acceptMsg = in.readUTF();
                    System.out.println("server accept:" + acceptMsg);

                    String sendMsg = String.format("accepted[%s]",DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
                    out.writeUTF(sendMsg);
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(socket != null){
                    try {
                        socket.close();
                    } catch (IOException e) {
                        socket = null;
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
