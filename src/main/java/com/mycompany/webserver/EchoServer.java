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

    public class EchoServer {
     public static void main(String[] args) throws IOException {
     ServerSocket serverSocket = null;
    try {
     serverSocket = new ServerSocket(35000);
     //crea un serversocket que escucha en ese puerto
    } catch (IOException e) {
     System.err.println("Could not listen on port: 35000.");
     System.exit(1);
     }
     Socket clientSocket = null;
    try {
     clientSocket = serverSocket.accept();
     //apenas recibe coneccion se pone a esperar
    } catch (IOException e) {
     System.err.println("Accept failed.");
    System.exit(1);
     }
     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(
     new InputStreamReader(
    clientSocket.getInputStream()));
     String inputLine, outputLine;
     while ((inputLine = in.readLine()) != null) {
         //apenas le llegue algo por la entrada
        System.out.println("Mensaje:" + inputLine);
        outputLine = "Respuesta: " + inputLine ;
        out.println(outputLine);
        if (outputLine.equals("Respuesta: Bye."))
            break;
        }
    out.close();
    in.close();
    clientSocket.close();
    serverSocket.close();
    }
    }
