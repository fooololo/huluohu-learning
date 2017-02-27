package com.huluohu.learning.io.nio.udp;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

/**
 * Created by Administrator on 2017/2/27.
 */
public class UDPClient {
    public static final int PORT = 9999;
    public static void main(String[] args) throws IOException {
        DatagramChannel client = DatagramChannel.open();
        client.configureBlocking(false);
        InetSocketAddress address = new InetSocketAddress("localhost", PORT);

        Selector selector = Selector.open();
        client.register(selector, SelectionKey.OP_READ);

        System.out.println("请输入:\t");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        while (true){
            if(StringUtils.isNotBlank(line)){

                line = reader.readLine();
            }
        }

    }
}
