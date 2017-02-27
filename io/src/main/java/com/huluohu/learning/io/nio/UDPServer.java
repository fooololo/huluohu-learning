package com.huluohu.learning.io.nio;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Administrator on 2017/2/24.
 */
public class UDPServer {
    public static final int PORT = 9999;
    public static void main(String[] args) throws IOException {
        DatagramChannel server = DatagramChannel.open();
        server.configureBlocking(false);
        server.bind(new InetSocketAddress(PORT));
        Selector selector = Selector.open();
        server.register(selector, SelectionKey.OP_READ);


        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true){
            int count = selector.select();
            if(count > 0){
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();
                    if(selectionKey.isReadable()){
                        DatagramChannel client = (DatagramChannel) selectionKey.channel();
                        buffer.clear();
                        //读数据
                        SocketAddress address = client.receive(buffer);
                        String message = new String(buffer.array());
                        System.out.println(String.format("server accept:%s",message));


                        //写数据
                        buffer.clear();
                        String response = String.format("server accepted:%s", DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
                        buffer.put(response.getBytes());
                        buffer.flip();
                        client.send(buffer,address);
                    }
                }
            }
        }
    }
}
