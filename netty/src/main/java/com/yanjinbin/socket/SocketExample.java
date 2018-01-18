package com.yanjinbin.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 吉利不布吉
 * @since 2018/1/18
 */
public class SocketExample {
    public void wtf() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8081);
        Socket clientSocket = serverSocket.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

        String request,response;
        while ((request = reader.readLine()) != null) {
            if ("Done".equals(request)) {
                break;
            }
            response = processRequest(request);
            System.out.println(response);
        }

    }

    private String processRequest(String request) {
        return "哈哈哈";
    }


}
