package com.mycompany.webserver.Server;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {

  private static final String BASE_PATH = "public"; // Carpeta donde estarán los archivos

  public static byte[] serveStaticFile(String path) throws IOException {
    if (path.equals("/")) {
      path = "/index.html"; // Archivo por defecto
    }

    Path filePath = Paths.get(BASE_PATH + path);

    if (Files.exists(filePath) && !Files.isDirectory(filePath)) {
      return Files.readAllBytes(filePath);
    } else {
      return null; // Indica que el archivo no se encontró
    }
  }

  public static String getContentType(String path) {
    if (path.endsWith(".css")) {
      return "text/css";
    } else if (path.endsWith(".js")) {
      return "application/javascript";
    } else if (path.endsWith(".html")) {
      return "text/html";
    } else if (path.endsWith(".jpg") || path.endsWith(".jpeg")) {
      return "image/jpeg"; // Usa "image/jpeg" en vez de "image/jpg"
    } else if (path.endsWith(".png")) {
      return "image/png";
    } else if (path.endsWith(".gif")) {
      return "image/gif";
    } else {
      return "text/plain";
    }
  }
}
