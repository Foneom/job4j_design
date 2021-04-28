package ru.job4j.chapter_002.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.chapter_002.log.UsageLog4j;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

        public static void main(String[] args) {
            try (ServerSocket server = new ServerSocket(9000)) {
                while (!server.isClosed()) {
                    Socket socket = server.accept();
                    try (OutputStream out = socket.getOutputStream();
                         BufferedReader in = new BufferedReader(
                                 new InputStreamReader(socket.getInputStream()))) {
                        String str;
                        while (!(str = in.readLine()).isEmpty()) {
                            System.out.println(str);
                            if (str.contains("msg=Exit")) {
                                out.write("HTTP/1.1 200 OK\r\n".getBytes());
                                server.close();
                            } else if (str.contains("msg=Hello")) {
                                out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                                out.write("Hello".getBytes());
                            } else if (str.contains("msg=Any")) {
                                out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                                out.write("What".getBytes());
                            }
                        }
                    }
                }
            } catch (Exception e) {
                LOG.error("Exception in log example", e);
            }
        }
    }
