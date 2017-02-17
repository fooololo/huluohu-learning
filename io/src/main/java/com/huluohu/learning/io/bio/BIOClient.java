package com.huluohu.learning.io.bio;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.Socket;

/**
 * Created by Administrator on 2017/2/17.
 */
public class BIOClient {
    public static final String IP = "localhost";//服务器地址
    public static final int PORT = 9988;//服务器端口号
    public static void main(String[] args) {
        System.out.println("client starting...");
        Socket socket = null;
        try {
            socket = new Socket(IP,PORT);

            System.out.println("请输入:\t");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            DataInputStream  in = new DataInputStream (socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            String line = reader.readLine();
            while (true){
                if(StringUtils.isNotBlank(line)){
                    out.writeUTF(line);

                    String acceptMsg = in.readUTF();
                    System.out.println("client accept:" + acceptMsg);
                }
                line = reader.readLine();
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
