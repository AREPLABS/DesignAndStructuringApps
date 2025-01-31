package com.mycompany.webserver.Server;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHandler {

  private static final String BASE_PATH = "public"; // Carpeta donde estarán los archivos

  public static String serveStaticFile(String path) {
    if (path.equals("/")) {
      path = "/index.html"; // Archivo por defecto
    }

    try {
      return new String(Files.readAllBytes(Paths.get(BASE_PATH + path)));
    } catch (IOException e) {
      return null;
    }
  }

  public static String getContentType(String path) {
    if (path.endsWith(".html")) return "text/html";
    if (path.endsWith(".css")) return "text/css";
    if (path.endsWith(".js")) return "application/javascript";
    if (path.endsWith(".png")) return "image/png";
    if (path.endsWith(".jpg") || path.endsWith(".jpeg")) return "image/jpeg";
    if (path.endsWith(".gif")) return "image/gif";
    return "text/plain";
  }
}
