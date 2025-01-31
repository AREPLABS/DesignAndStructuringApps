# Web Server Prototype

Este es un prototipo de un servidor web desarrollado en Java, utilizando Maven, que sirve archivos estáticos como HTML, CSS, JavaScript e imágenes. Además, incluye una API REST para consultar libros.

## Instalación

### Requisitos previos

1. **JDK 17 o superior**: Asegúrate de tener instalado Java Development Kit (JDK) versión 17 o superior.
2. **Maven**: Asegúrate de tener Maven instalado para gestionar las dependencias y compilar el proyecto.

### Pasos de instalación

1. Clona este repositorio:
   ```bash
   git clone https://github.com/tu_usuario/webserver-prototype.git
   ```

2. Navega al directorio del proyecto y ejecuta Maven para instalar las dependencias:
   ```bash
   mvn install
   ```

3. Ejecuta el servidor:
   ```bash
   mvn exec:java
   ```

4. Abre tu navegador y accede a `http://localhost:35000` para ver la página de inicio.

## Ejecución

Una vez que hayas instalado las dependencias y ejecutado el servidor, el servidor estará funcionando en `http://localhost:35000`. 

- **Página principal**: `http://localhost:35000/` 
- **API de libros**: `http://localhost:35000/api/libros`

## Arquitectura

El servidor tiene una arquitectura simple que consta de los siguientes componentes:

1. **Servidor web**: Utiliza Java para servir archivos estáticos (HTML, CSS, JS, imágenes) y manejar rutas.
2. **API REST**: Proporciona una ruta `/api/libros` que devuelve una lista de libros en formato JSON.
3. **Archivos estáticos**: Los archivos HTML, CSS y JS se encuentran en la carpeta `src/main/resources/public`.

## Evaluación

### Pruebas realizadas

1. **Acceso a archivos estáticos**: Se verificó que el servidor sirviera correctamente archivos como `index.html`, imágenes (`.jpg`, `.png`), y archivos estáticos `.css` y `.js`.
2. **API de libros**: Se probó que la API respondiera correctamente con un JSON que contiene la información de los libros.
3. **Manejo de errores**: Se probó que el servidor manejara correctamente las rutas no encontradas, devolviendo un error 404 cuando fuera necesario.

El prototipo ha sido probado localmente y se espera que funcione correctamente en cualquier entorno con Java y Maven correctamente configurados.
