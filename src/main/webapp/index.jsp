
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Componentes/header.jsp" %>
<%@include file="Componentes/bodyPrimeraParte.jsp" %>
<%@include file="Componentes/bodyFinal.jsp" %>


             

<!-- Mensaje de Alerta al realizar Operacion -->

 <script>
    // Función para mostrar el mensaje de alerta
    function mostrarAlerta() {
        var mensaje = '<%= session.getAttribute("mensajeAlerta") %>';
        if (mensaje) {
            alert(mensaje);
          <% session.removeAttribute("mensajeAlerta"); %>

        }
    }
    
    // Llamar a la función al cargar la página
    window.onload = function() {
        mostrarAlerta();
    };
</script>