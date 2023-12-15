let ordenCompra = document.getElementById("ordenCompra");
let ordenCompraLista = JSON.parse(localStorage.getItem("ordenCompras")) || [];
let contenidoOrdenCompra = document.getElementById("ordenCompraListado");

function cargarOdenCompra(){
    contenidoOrdenCompra.innerHTML="";

    let table = document.createElement("table");
    table.classList.add("table");

    let titulo = document.createElement("thead");
    let cabeceraFila = document.createElement("tr");
    ["Fecha Emision", "Fecha Entrega", "Producto", "Cantidad", "Acciones"].forEach(tituloCabecera => {
        let cabecera = document.createElement("th");
        cabecera.textContent = tituloCabecera;
        cabeceraFila.appendChild(cabecera);
    });
    titulo.appendChild(cabeceraFila);
    table.appendChild(titulo);
    let tbody = document.createElement("tbody");
    for (let i = 0; i < ordenCompraLista.length; i++) {
        let orden = ordenCompraLista[i];
        let row = document.createElement("tr");
    
        let col1 = document.createElement("td");
        col1.textContent = orden.fechaEmision;
        row.appendChild(col1);
        
        let col2 = document.createElement("td");
        col2.textContent = orden.fechaEntrega;
        row.appendChild(col2);

        let col3 = document.createElement("td");
        col3.textContent = orden.productoNombre;
        row.appendChild(col3);

        let col4 = document.createElement("td");
        col4.textContent = orden.cantidadProducto;
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
            ordenCompraLista.splice(i, 1);
            JSON.parse(localStorage.getItem("ordenCompras"));
            cargarOdenCompra();
        });

        row.appendChild(col5);

        tbody.appendChild(row);
    }
    table.appendChild(tbody);

    ordenCompra.innerHTML = "";
    ordenCompra.appendChild(table);
}

cargarOdenCompra();

