package org.example;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public class IOClient {

    public static void main(String[] args) {
        //维护一个连接服务端的线程
        new Thread(() -> {

            try {
                //连接服务端
                Socket socket = new Socket("127.0.0.1", 8000);

                while (true){

                    try {
                        //输出流写数据
                        socket.getOutputStream().write((LocalDateTime.now() + " : Hello World").getBytes(StandardCharsets.UTF_8));
                    } catch (IOException e) {

                    }

                    Thread.sleep(2000L);
                }

            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

    }

}
