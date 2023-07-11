<%-- 
    Document   : javascript.jsp
    Created on : 05/07/2023
    Author     : Jonathan Diaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src="public/js/jquery-3.1.1.min.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="public/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="public/js/app.min.js"></script>
<!-- DATATABLES -->
<script src="public/datatables/jquery.dataTables.min.js"></script>
<script src="public/datatables/dataTables.buttons.min.js"></script>
<script src="public/datatables/buttons.html5.min.js"></script>
<script src="public/datatables/buttons.colVis.min.js"></script>
<script src="public/datatables/jszip.min.js"></script>
<script src="public/datatables/pdfmake.min.js"></script>
<script src="public/datatables/vfs_fonts.js"></script>
<script src="public/js/bootbox.min.js"></script>
<script src="public/js/bootstrap-select.min.js"></script>




<script>
    // Validar solo letras en el campo de nombre
    var nombreInput = document.getElementById('nombre');
    nombreInput.addEventListener('input', function (event) {
        if (!nombreInput.checkValidity()) {
            nombreInput.classList.add('is-invalid');
        } else {
            nombreInput.classList.remove('is-invalid');
        }
    });
</script>

<script>
    var formularioregistros = document.getElementById("formularioregistros");
    var btnAgregar = document.getElementById("btnAgregar");

    btnAgregar.addEventListener("click", function () {
        mostrarFormulario();
    });

    function mostrarFormulario() {
        if (formularioregistros.style.display === "none") {
            formularioregistros.style.display = "block";
        } else {
            formularioregistros.style.display = "none";
        }
    }
</script>
