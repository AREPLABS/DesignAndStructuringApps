const libros = {
  "libros": [
    { "título": "El señor de los anillos", "autor": "J.R.R. Tolkien", "año": 1954 },
    { "título": "1984", "autor": "George Orwell", "año": 1949 },
    { "título": "Matar a un ruiseñor", "autor": "Harper Lee", "año": 1960 }
  ]
};

// Imágenes de ejemplo para los libros
const imagenes = {
  "El señor de los anillos": "https://images.unsplash.com/photo-1506466010722-395aa2bef877",
  "1984": "https://images.unsplash.com/photo-1544716278-ca5e3f4abd8c",
  "Matar a un ruiseñor": "https://images.unsplash.com/photo-1589829085413-56de8ae18c73"
};

function crearTarjetaLibro(libro) {
  return `
    <div class="libro-card">
      <img class="libro-imagen" src="${imagenes[libro.título]}" alt="${libro.título}">
      <h2 class="libro-titulo">${libro.título}</h2>
      <p class="libro-autor">por ${libro.autor}</p>
      <p class="libro-año">Publicado en ${libro.año}</p>
    </div>
  `;
}

function mostrarLibros() {
  const contenedor = document.getElementById('libros');
  const librosHTML = libros.libros.map(crearTarjetaLibro).join('');
  contenedor.innerHTML = librosHTML;
}

// Inicializar la página
document.addEventListener('DOMContentLoaded', mostrarLibros);