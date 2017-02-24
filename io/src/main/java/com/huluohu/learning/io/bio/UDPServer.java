package com.huluohu.learning.io.bio;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by Administrator on 2017/2/24.
 */
public class UDPServer {
    public static final int PORT = 9999;
    public static void main(String[] args) throws IOException {
        DatagramSocket server = new DatagramSocket(PORT);

        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        while (true){
            server.receive(packet);
            String data = new String(packet.getData(), 0, packet.getLength());
            System.out.println(String.format("server receive:%s",data));
        }
    }
}
