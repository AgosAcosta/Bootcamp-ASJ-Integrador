let btnCargar = document.getElementById("botonCargar");

btnCargar.addEventListener("click", () => {
    let razonSocial = document.getElementById("razonSocial").value;
    let cuit = document.getElementById("cuit").value;
    let condicionAfip = document.getElementById("condicionAfip").value;
    let rubro = document.getElementById("rubro").value;

    let proveedorLista = JSON.parse(localStorage.getItem("proveedores")) || [];

    let proveedor = {
        razonSocial: razonSocial,
        cuit: parseInt(cuit),
        condicionAfip: condicionAfip,
        rubro: rubro
    }

    proveedorLista.push(proveedor);
    localStorage.setItem("proveedores", JSON.stringify(proveedorLista));

    if (proveedorLista.includes(proveedor)) {
        alert("Se cargo con exito!!!!")

        location.href= "/1° Entrega/Proveedores/proveedores.html"
    } else {
        alert("Algo esta pasando! Revisar")
    }
});
