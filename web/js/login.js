const formulario = document.forms["formulario-login"];
const mensaje = document.getElementById("mensaje");
const tipoDocumento = formulario.fTipoDocumento;
tipoDocumento.addEventListener('change', (e) => {
    e.preventDefault();
    tipoDocumento.classList.remove('invalido');
    mensaje.innerHTML = "";
});

formulario.addEventListener('submit', (e) => {    
    if (tipoDocumento.value === "Seleccione el tipo de Documento") {
        tipoDocumento.classList.add('invalido');
        mensaje.innerHTML = "Por favor Seleccione el Tipo de Documento";
        mensaje.style.color = "#b50000";
        e.preventDefault();
    } else {
        
        tipoDocumento.classList.remove('invalido');
    }
    
});



