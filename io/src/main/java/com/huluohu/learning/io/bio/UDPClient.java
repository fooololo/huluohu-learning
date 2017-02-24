package com.huluohu.learning.io.bio;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * Created by Administrator on 2017/2/24.
 */
public class UDPClient {
    public static final int PORT = 9999;
    public static void main(String[] args) throws IOException {
        DatagramSocket client = new DatagramSocket();
        InetSocketAddress address = new InetSocketAddress("localhost",PORT);
        System.out.println("请输入:\t");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        while (true){
            if(StringUtils.isNotBlank(line)){
                DatagramPacket data = new DatagramPacket(line.getBytes(), line.length(),address);
                client.send(data);
                line = reader.readLine();
            }
        }
    }
}
