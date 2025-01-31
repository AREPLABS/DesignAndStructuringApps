package com.mycompany.webserver.Server;

import java.io.*;
import java.net.*;

public class HTTPServer {

  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket = new ServerSocket(35002);
    System.out.println("Servidor iniciado en el puerto 35002");

    while (true) {
      try (Socket clientSocket = serverSocket.accept()) {
        handleRequest(clientSocket);
      } catch (IOException e) {
        System.err.println("Error en la conexión: " + e.getMessage());
      }
    }
  }

  private static void handleRequest(Socket clientSocket) throws IOException {
    BufferedReader in = new BufferedReader(
      new InputStreamReader(clientSocket.getInputStream())
    );
    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

    String requestLine = in.readLine();
    System.out.println("Solicitud recibida: " + requestLine);
    String[] requestParts = requestLine.split(" ");
    if (requestParts.length < 2) return;

    String method = requestParts[0];
    String path = requestParts[1];

    if (path.startsWith("api/")) {
      String jsonResponse = APIHandler.handleAPIRequest(path);
      sendResponse(out, "200 OK", "application/json", jsonResponse);
    } else {
      if (path.equals("/") || path.equals("/index.html")) {
        File indexFile = new File(
          "src\\main\\java\\com\\mycompany\\webserver\\Public\\index.html"
        );
        if (indexFile.exists()) {
          BufferedReader reader = new BufferedReader(new FileReader(indexFile));
          StringBuilder contentBuilder = new StringBuilder();
          String line;
          while ((line = reader.readLine()) != null) {
            contentBuilder.append(line).append("\n");
          }
          reader.close();
          String fileResponse = contentBuilder.toString();
          sendResponse(out, "200 OK", "text/html", fileResponse);
        } else {
          sendResponse(
            out,
            "404 Not Found",
            "text/html",
            "<h1>404 Not Found</h1>"
          );
        }
      } else {
        String fileResponse = FileHandler.serveStaticFile(path);
        String contentType = FileHandler.getContentType(path);
        if (fileResponse == null) {
          sendResponse(
            out,
            "404 Not Found",
            "text/html",
            "<h1>404 Not Found</h1>"
          );
        } else {
          sendResponse(out, "200 OK", contentType, fileResponse);
        }
      }
    }
    in.close();
    out.close();
  }

  private static void sendResponse(
    PrintWriter out,
    String status,
    String contentType,
    String content
  ) {
    out.println("HTTP/1.1 " + status);
    out.println("Content-Type: " + contentType);
    out.println("\r\n" + content);
  }
}
