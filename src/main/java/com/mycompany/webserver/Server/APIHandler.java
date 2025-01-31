package com.mycompany.webserver.Server;

public class APIHandler {

  public static String handleAPIRequest(String path) {
    if (path.equals("/api/hello")) {
      return "{ \"message\": \"Hola, bienvenido a la API\" }";
    } else if (path.equals("/api/libros")) {
      return (
        "{ \"libros\": [" +
        "{ \"titulo\": \"El señor de los anillos\", \"autor\": \"J.R.R. Tolkien\", \"anio\": 1954, \"imagen\": \"/imagenes/lotr.jpg\" }," +
        "{ \"titulo\": \"1984\", \"autor\": \"George Orwell\", \"anio\": 1949, \"imagen\": \"/imagenes/1984.jpg\" }," +
        "{ \"titulo\": \"Matar a un ruiseñor\", \"autor\": \"Harper Lee\", \"anio\": 1960, \"imagen\": \"/imagenes/mockingbird.jpg\" }," +
        "{ \"titulo\": \"Orgullo y prejuicio\", \"autor\": \"Jane Austen\", \"anio\": 1813, \"imagen\": \"/imagenes/pride.jpg\" }," +
        "{ \"titulo\": \"Crimen y castigo\", \"autor\": \"Fiódor Dostoyevski\", \"anio\": 1866, \"imagen\": \"/imagenes/crimen.jpg\" }," +
        "{ \"titulo\": \"Cien años de soledad\", \"autor\": \"Gabriel García Márquez\", \"anio\": 1967, \"imagen\": \"/imagenes/soledad.jpg\" }," +
        "{ \"titulo\": \"Don Quijote de la Mancha\", \"autor\": \"Miguel de Cervantes\", \"anio\": 1605, \"imagen\": \"/imagenes/quijote.jpg\" }," +
        "{ \"titulo\": \"Los miserables\", \"autor\": \"Victor Hugo\", \"anio\": 1862, \"imagen\": \"/imagenes/miserables.jpg\" }," +
        "{ \"titulo\": \"El Gran Gatsby\", \"autor\": \"F. Scott Fitzgerald\", \"anio\": 1925, \"imagen\": \"/imagenes/gatsby.jpg\" }," +
        "{ \"titulo\": \"Ulises\", \"autor\": \"James Joyce\", \"anio\": 1922, \"imagen\": \"/imagenes/ulises.jpg\" }," +
        "{ \"titulo\": \"La Odisea\", \"autor\": \"Homero\", \"anio\": -800, \"imagen\": \"/imagenes/odisea.jpg\" }," +
        "{ \"titulo\": \"Fahrenheit 451\", \"autor\": \"Ray Bradbury\", \"anio\": 1953, \"imagen\": \"/imagenes/fahrenheit.jpg\" }," +
        "{ \"titulo\": \"En busca del tiempo perdido\", \"autor\": \"Marcel Proust\", \"anio\": 1913, \"imagen\": \"/imagenes/tiempo.jpg\" }," +
        "{ \"titulo\": \"El extranjero\", \"autor\": \"Albert Camus\", \"anio\": 1942, \"imagen\": \"/imagenes/extranjero.jpg\" }," +
        "{ \"titulo\": \"Las aventuras de Sherlock Holmes\", \"autor\": \"Arthur Conan Doyle\", \"anio\": 1892, \"imagen\": \"/imagenes/sherlock.jpg\" }" +
        "] }"
      );
    } else {
      return "{ \"error\": \"Ruta no encontrada\" }";
    }
  }
}
