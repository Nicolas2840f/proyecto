
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

const password = document.getElementById("password");
const passwordConfirmation = document.getElementById("password-confirmation");
const mensaje = document.getElementById("mensaje");
passwordConfirmation.addEventListener("keyup", () => {
    if (password.value === passwordConfirmation.value) {
        mensaje.innerHTML = "Las contraseñas coinciden";
        mensaje.style.color = "#00dc06";
    } else {
        mensaje.innerHTML = "Las contraseñas no coinciden";
        mensaje.style.color = "#b50000";
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
        documento.addEventListener('change', (e) => {
            documento.classList.remove('invalido');
            mensajedocumento.textContent = "";
        });
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
    if(!nombreValido.test(nombre.value)){
        nombre.classList.add("invalido");
        const mensajenombre = document.getElementById("cajaValidarN");
        mensajenombre.textContent = "Escriba su nombre completo ej:Pepito Pérez Acuña ";
        e.preventDefault();
        nombre.addEventListener('change',()=>{
            nombre.classList.remove("invalido");
            mensajenombre.textContent = "";
        });
    }else{
        nombre.classList.remove("invalido");
    }
    
    if(telefono.value.length < 10 || telefono.value.length > 10){
        telefono.classList.add("invalido");
        const mensajeTelefono = document.getElementById("cajaValidarT");
        mensajeTelefono.textContent = "El numero de telefono debe tener 10 caracteres";
        e.preventDefault();
        telefono.addEventListener('change',()=>{
            telefono.classList.remove("invalido");
            mensajeTelefono.textContent = "";
        });
    }else{
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
});

