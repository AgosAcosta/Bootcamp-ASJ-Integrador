let btnCargar = document.getElementById("botonCargar");
btnCargar.addEventListener("click",()=>{

    let nombreProducto = document.getElementById("nombreProducto").value;
    let descripcionProducto = document.getElementById("descripcionProducto").value;
    let precioProducto = document.getElementById("precioProducto");
    let proveedorNombre = document.getElementById("proveedorNombre").value;

    let productoLista = JSON.parse(localStorage.getItem("productos")) || [];

    let producto ={
        nombreProducto : nombreProducto,
        descripcionProducto : descripcionProducto,
        precioProducto : parseFloat(precioProducto.value),
        proveedorNombre : proveedorNombre
    }
    productoLista.push(producto);
    localStorage.setItem("productos", JSON.stringify(productoLista));

    if (productoLista.includes(producto)) {
        alert("Se cargo con exito!!!!")

        location.href= "/1° Entrega/Productos_Servicios/productos.html"
    } else {
        alert("Algo esta pasando! Revisar")
    }

})


