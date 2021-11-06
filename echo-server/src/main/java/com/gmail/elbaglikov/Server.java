package com.gmail.elbaglikov;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static org.apache.log4j.Logger.getLogger;

public class Server implements Runnable{
    private static final Logger LOGGER = getLogger(Server.class);
    private int port;

    public Server(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(clientSocket.getInputStream()));
        ) {
            LOGGER.info("server start working");
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                out.println("response: " + inputLine);
            }
            LOGGER.info("server stop working");
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
