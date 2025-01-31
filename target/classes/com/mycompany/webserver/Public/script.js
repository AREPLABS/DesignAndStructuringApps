function fetchMessage() {
    fetch('/api/hello')
        .then(response => response.json())
        .then(data => {
            document.getElementById("response").innerText = data.message;
        })
        .catch(error => console.error("Error:", error));
}

function fetchBooks() {
    fetch('/api/libros')
        .then(response => response.json())
        .then(data => {
            let output = "<h3>Lista de Libros:</h3><ul>";
            data.libros.forEach(libro => {
                output += `<li><strong>${libro.título}</strong> - ${libro.autor} (${libro.año})</li>`;
            });
            output += "</ul>";
            document.getElementById("response").innerHTML = output;
        })
        .catch(error => console.error("Error:", error));
}