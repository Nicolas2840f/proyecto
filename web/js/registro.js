
validarDocumento = () => {
    var cajaDocumento = document.getElementById("fDocumento").value;
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const p = document.getElementById("cajaValidarD");
            if (xhr.responseText === "true" && cajaDocumento !== "") {
                p.textContent = "Este documento ya ha sido registrado anteriormente";
            } else {
                p.textContent = "";
            }
        }
    };
    xhr.open("POST", "ControladorPersona", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    var datos = "fDocumento=" + cajaDocumento + "&fEnviar=ValidarDocumento";
    xhr.send(datos);
};

validarCorreo = () => {
    var cajaCorreo = document.getElementById("fCorreo").value;
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const p2 = document.getElementById("cajaValidarC");
            p2.textContent = xhr.responseText;
            if (xhr.responseText === "true" && cajaCorreo !== "") {
                p2.textContent = "Este correo ya está en uso";
            } else {
                p2.textContent = "";
            }

        }
    };
    xhr.open("POST", "ControladorPersona", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    var datos = "fCorreo=" + cajaCorreo + "&fEnviar=ValidarCorreo";
    xhr.send(datos);
};