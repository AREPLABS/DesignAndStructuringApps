/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.webserver;

/**
 *
 * @author diego.chicuazuque
 */
import java.net.*;
import java.io.*;

public class HTTPServer {

    public static void main(String[] args) throws IOException, URISyntaxException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35002);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        boolean running = true;
        while (running) {
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine, outputLine;
            boolean isFirstLine = true;
            String file = "";
            while ((inputLine = in.readLine()) != null) {
                if (isFirstLine) {
                    file = inputLine.split(" ")[1];
                    isFirstLine = false;
                }
                System.out.println("Received: " + inputLine);
                if (!in.ready()) {
                    break;
                }
            }
            URI requestFile = new URI(file);
            System.out.println("file: " + requestFile);

            if (requestFile.getPath().startsWith("/app/hello")) {
                outputLine = helloRestService(requestFile.getPath(), requestFile.getQuery());
                out.println(outputLine);
            } else {
                outputLine
                        = "HTTP/1.1 200 OK\r\n"
                        + "Content-Type: text/html\r\n"
                        + "\r\n"
                        + "<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "<head>\n"
                        + "<meta charset=\"UTF-8\">\n"
                        + "<title>Title of the document</title>\n"
                        + "</head>\n"
                        + "<body>\n"
                        + "My Web Site\n"
                        + "</body>\n"
                        + "</html>\n";
                out.println(outputLine);
            }
            out.close();
            in.close();
            clientSocket.close();
        }
        serverSocket.close();

    }

    private static String helloRestService(String path, String query) {
        String response = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: application/json\r\n"
                + "\r\n"
                + "{\n"
                + "  \"libros\": [\n"
                + "    {\n"
                + "      \"título\": \"El señor de los anillos\",\n"
                + "      \"autor\": \"J.R.R. Tolkien\",\n"
                + "      \"año\": 1954\n"
                + "    },\n"
                + "    {\n"
                + "      \"título\": \"1984\",\n"
                + "      \"autor\": \"George Orwell\",\n"
                + "      \"año\": 1949\n"
                + "    },\n"
                + "    {\n"
                + "      \"título\": \"Matar a un ruiseñor\",\n"
                + "      \"autor\": \"Harper Lee\",\n"
                + "      \"año\": 1960\n"
                + "    }\n"
                + "  ]\n"
                + "}";
        return response;
    }
}
