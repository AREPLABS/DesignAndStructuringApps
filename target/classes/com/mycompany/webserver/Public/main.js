
const imagenes = {
  "El señor de los anillos": "https://images.unsplash.com/photo-1506466010722-395aa2bef877",
  "1984": "https://images.unsplash.com/photo-1544716278-ca5e3f4abd8c",
  "Matar a un ruiseñor": "https://images.unsplash.com/photo-1589829085413-56de8ae18c73"
};

function crearTarjetaLibro(libro) {
  return `
    <div class="libro-card">
      <img class="libro-imagen" src="${libro.imagen}" alt="${libro.titulo}">
      <h2 class="libro-titulo">${libro.titulo}</h2>
      <p class="libro-autor">por ${libro.autor}</p>
      <p class="libro-anio">Publicado en ${libro.anio}</p>
    </div>
  `;
}

function mostrarLibros() {
  fetch('/api/libros')
    .then(response => response.json())
    .then(data => {
      const contenedor = document.getElementById('libros');
      const librosHTML = data.libros.map(crearTarjetaLibro).join('');
      contenedor.innerHTML = librosHTML;
    })
    .catch(error => console.error('Error al obtener los libros:', error));
}

// Inicializar la página
document.addEventListener('DOMContentLoaded', mostrarLibros);