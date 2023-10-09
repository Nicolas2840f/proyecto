
validarDocumento = () => {
    var cajaDocumento = document.getElementById("fDocumento").value;
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const p = document.getElementById("cajaValidarD");
            var cajita = document.getElementById("fDocumento");
            if (xhr.responseText === "true" && cajaDocumento !== "") {
                cajita.classList.add("invalido");
                p.textContent = "Este documento ya ha sido registrado anteriormente";
            } else {
                cajita.classList.remove("invalido");
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

const contraseña2 = document.getElementById("password-confirmation");
const contraseña = document.getElementById("password");
const mensajeContra = document.getElementById("cajaValidarContra");
const mensajeConfirmacion = document.getElementById("cajaValidarConfir");


contraseña2.addEventListener("keyup", () => {
    if (contraseña2.value === contraseña.value) {
        contraseña.classList.remove("invalido");
        contraseña2.classList.remove("invalido");
        mensajeConfirmacion.textContent = "";
        mensajeContra.textContent = "";
    } else {
        contraseña.classList.add("invalido");
        contraseña2.classList.add("invalido");
        mensajeConfirmacion.textContent = "Las contraseñas no coinciden";
    }
});
contraseña.addEventListener("keyup", () => {
    mensajeContra.textContent = "";
    if (contraseña2.value === contraseña.value) {
        contraseña.classList.remove("invalido");
        contraseña2.classList.remove("invalido");
        mensajeConfirmacion.textContent = "";
    } else {
        contraseña.classList.add("invalido");
        contraseña2.classList.add("invalido");
        mensajeConfirmacion.textContent = "Las contraseñas no coinciden";
    }
});


const formulario = document.getElementById("formulario-registrar");

formulario.addEventListener("submit", (e) => {

    const tipoDocumento = document.getElementById('fTipoDocumento');
    const documento = document.getElementById('fDocumento');
    const nombre = document.getElementById('validationCustom01');
    const telefono = document.getElementById('validationCustom02');
    const correo = document.getElementById('fCorreo');


    if (documento.value.length < 8) {
        documento.classList.add('invalido');
        const mensajedocumento = document.getElementById("cajaValidarD");
        mensajedocumento.textContent = "El documento ingresado debe ser mayor a 8 digitos";
        e.preventDefault();
    } else {
        documento.classList.remove('invalido');
    }

    if (tipoDocumento.value === "") {
        tipoDocumento.classList.add('invalido');
        const mensajedoc = document.getElementById("mensajedoc");
        mensajedoc.textContent = "Por favor seleccione el tipo de Documento";
        e.preventDefault();
        tipoDocumento.addEventListener('change', (e) => {
            tipoDocumento.classList.remove('invalido');
            mensajedoc.textContent = "";
        });
    } else {
        tipoDocumento.classList.remove('invalido');
    }

    const nombreValido = /^[A-Za-zá-úñ]+ [a-zA-Zá-úñ]+ ([a-zA-Zá-úñ]+)? ?([a-zA-Zá-úñ]+)?$/;
    if (!nombreValido.test(nombre.value)) {
        nombre.classList.add("invalido");
        const mensajenombre = document.getElementById("cajaValidarN");
        mensajenombre.textContent = "Escriba su nombre completo ej:Pepito Pérez Acuña ";
        e.preventDefault();
        nombre.addEventListener('change', () => {
            nombre.classList.remove("invalido");
            mensajenombre.textContent = "";
        });
    } else {
        nombre.classList.remove("invalido");
    }

    if (telefono.value.length < 10 || telefono.value.length > 10) {
        telefono.classList.add("invalido");
        const mensajeTelefono = document.getElementById("cajaValidarT");
        mensajeTelefono.textContent = "El numero de telefono debe tener 10 caracteres";
        e.preventDefault();
        telefono.addEventListener('change', () => {
            telefono.classList.remove("invalido");
            mensajeTelefono.textContent = "";
        });
    } else {
        telefono.classList.remove("invalido");
    }

    const correoValido = /^[a-zA-Z\.-_\d]+@[a-zA-Z]+\.(com|edu)+\.?(co|net)?$/;

    if (!correoValido.test(correo.value)) {
        correo.classList.add("invalido");
        const p2 = document.getElementById("cajaValidarC");
        p2.textContent = "El correo debe estar en formato correo@correo.com";
        e.preventDefault();
        correo.addEventListener("change", () => {
            correo.classList.remove("invalido");
            p2.textContent = "";
        });
    } else {
        correo.classList.remove("invalido");
        p2.textContent = "";
    }
    if (contraseña.value === "") {
        contraseña.classList.add("invalido");
        mensajeContra.textContent = "La contraseña no puede ser un valor vacío";
        e.preventDefault();
    } else {
        contraseña.classList.remove("invalido");
        mensajeContra.textContent = "";
    }
    if (contraseña2.value === "") {
        contraseña2.classList.add("invalido");
        mensajeConfirmacion.textContent = "La confirmación de la contraseña es obligatoria";
        e.preventDefault();
    } else {
        contraseña2.classList.remove("invalido");
        mensajeConfirmacion.textContent = "";
    }

});

