let proveedor = document.getElementById("proveedores");
let proveedoresLista=  JSON.parse(localStorage.getItem("proveedores")) || [];
let contenidoProveedores = document.getElementById("proveedoresListado")

function CargarProveedor() {
    contenidoProveedores.innerHTML = "";

    let table = document.createElement("table");
    table.classList.add("table", "table-bordered");

    let titulo = document.createElement("thead");
    let cabeceraFila = document.createElement("tr");
    ["Razon Social", "CUIT", "Condición AFIP", "Rubro", "Acciones"].forEach(headerText => {
        let cabecera = document.createElement("th");
        cabecera.textContent = headerText;
        cabeceraFila.appendChild(cabecera);
    });
    titulo.appendChild(cabeceraFila);
    table.appendChild(titulo);

    let tbody = document.createElement("tbody");
    for (let i = 0; i < proveedoresLista.length; i++) {
        let proved = proveedoresLista[i];
        let row = document.createElement("tr");

        let col1 = document.createElement("td");
        col1.textContent = proved.razonSocial;
        row.appendChild(col1);

        let col2 = document.createElement("td");
        col2.textContent = proved.cuit;
        row.appendChild(col2);

        let col3 = document.createElement("td");
        col3.textContent = proved.condicionAfip;
        row.appendChild(col3);

        let col4 = document.createElement("td");
        col4.textContent = proved.rubro;
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
            proveedoresLista.splice(i, 1);
            localStorage.setItem("proveedores", JSON.stringify(proveedoresLista));
            CargarProveedor();
        });

        row.appendChild(col5);

        tbody.appendChild(row);
    }
    table.appendChild(tbody);

    proveedor.innerHTML = "";
    proveedor.appendChild(table);
}

CargarProveedor();

