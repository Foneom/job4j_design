package ru.job4j.chapter_002.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {

        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    while (!(str = in.readLine()).isEmpty()) {
                        System.out.println(str);
                        if (str.contains("msg=Bye")) {
                            out.write("HTTP/1.1 200 OK\r\n".getBytes());
                            server.close();
                        }
                    }
                    out.write("HTTP/1.1 200 OK\r\n".getBytes());
                }

            }
        }
    }
}