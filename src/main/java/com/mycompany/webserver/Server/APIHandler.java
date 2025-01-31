package com.mycompany.webserver.Server;

public class APIHandler {

  public static String handleAPIRequest(String path) {
    if (path.equals("/api/hello")) {
      return "{ \"message\": \"Hola, bienvenido a la API\" }";
    } else if (path.equals("/api/libros")) {
      return (
        "{ \"libros\": [" +
        "{ \"título\": \"El señor de los anillos\", \"autor\": \"J.R.R. Tolkien\", \"año\": 1954 }," +
        "{ \"título\": \"1984\", \"autor\": \"George Orwell\", \"año\": 1949 }," +
        "{ \"título\": \"Matar a un ruiseñor\", \"autor\": \"Harper Lee\", \"año\": 1960 }" +
        "] }"
      );
    } else {
      return "{ \"error\": \"Ruta no encontrada\" }";
    }
  }
}
