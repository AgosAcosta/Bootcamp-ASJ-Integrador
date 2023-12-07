let btnCargar = document.getElementById("botonCargar");

btnCargar.addEventListener("click",()=>{
let fechaEmision = document.getElementById("fechaEmision").value;
let fechaEntrega = document.getElementById("fechaEntrega").value;
let productoNombre = document.getElementById("productoNombre").value;
let cantidadProducto = document.getElementById("cantidadProducto")

let ordenCompraLista = JSON.parse(localStorage.getItem("ordenCompras")) || [];

let ordenCompra ={
    fechaEmision : new Date(fechaEmision),
    fechaEntrega : new Date(fechaEntrega),
    productoNombre: productoNombre,
    cantidadProducto: parseInt(cantidadProducto.value)
}
ordenCompraLista.push(ordenCompra);
localStorage.setItem("ordenCompras", JSON.stringify(ordenCompraLista));

if (ordenCompraLista.includes(ordenCompra)) {
    alert("Se cargo con exito!!!!")

    location.href= "/1° Entrega/OrdenCompa/ordenCompra.html";
} else {
    alert("Algo esta pasando! Revisar")
}

})
