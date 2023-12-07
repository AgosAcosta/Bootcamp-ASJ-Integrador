let productos = document.getElementById("productos");
let productosLista = JSON.parse(localStorage.getItem("productos")) || [];
let contenidoProductos = document.getElementById("productosListado");

function cargarProducto(){
    contenidoProductos.innerHTML = "";

    let table = document.createElement("table");
    table.classList.add("table", "table-bordered");

    let titulo = document.createElement("thead");
    let cabeceraFila = document.createElement("tr");
    ["Nombre", "Descripcion", "Precio", "Proveedor", "Acciones"].forEach(headerText => {
        let cabecera = document.createElement("th");
        cabecera.textContent = headerText;
        cabeceraFila.appendChild(cabecera);
    });
    titulo.appendChild(cabeceraFila);
    table.appendChild(titulo);

    let tbody = document.createElement("tbody");
    for (let i = 0; i < productosLista.length; i++) {
        let produ = productosLista[i];
        let row = document.createElement("tr");
    
        let col1 = document.createElement("td");
        col1.textContent = produ.nombreProducto;
        row.appendChild(col1);
        
        let col2 = document.createElement("td");
        col2.textContent = produ.descripcionProducto;
        row.appendChild(col2);

        let col3 = document.createElement("td");
        col3.textContent = produ.precioProducto;
        row.appendChild(col3);

        let col4 = document.createElement("td");
        col4.textContent = produ.proveedorNombre;
        row.appendChild(col4);
    
        let col5 = document.createElement("td");
        let btnEditar = document.createElement("button");
        btnEditar.textContent = "Editar";
        btnEditar.classList.add("btn", "btn-primary");
        col5.appendChild(btnEditar);

        let btnEliminar = document.createElement("button");
        btnEliminar.textContent = "Eliminar";
        btnEliminar.classList.add("btn", "btn-danger", "ms-1");
        col5.appendChild(btnEliminar);
       
        btnEliminar.setAttribute("borrar", i);

        btnEliminar.addEventListener("click", () => {

            let i = parseInt(btnEliminar.getAttribute("borrar"));
            productosLista.splice(i, 1);
            localStorage.setItem("productos", JSON.stringify(productosLista));
            cargarProducto();
        });

        row.appendChild(col5);

        tbody.appendChild(row);
    }
    table.appendChild(tbody);

    productos.innerHTML = "";
    productos.appendChild(table);

}



cargarProducto()



