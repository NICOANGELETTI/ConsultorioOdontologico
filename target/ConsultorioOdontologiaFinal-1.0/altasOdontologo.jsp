<%@page contentType="text/html" pageEncoding="UTF-8"%>



<%@include file="Componentes/header.jsp" %>
<%@include file="Componentes/bodyPrimeraParte.jsp" %>
  


<body class="bg-gradient-primary">

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Alta Odontologos</h1>
                            </div>
                           <form class="user">
    <div class="form-group">
        <input type="text" class="form-control form-control-user" id="dni" placeholder="DNI">
    </div>
    <div class="form-group">
        <input type="text" class="form-control form-control-user" id="nombre" placeholder="Nombre">
    </div>
    <div class="form-group">
        <input type="text" class="form-control form-control-user" id="apellido" placeholder="Apellido">
    </div>
    <div class="form-group">
        <input type="text" class="form-control form-control-user" id="telefono" placeholder="Teléfono">
    </div>
    <div class="form-group">
        <input type="text" class="form-control form-control-user" id="direccion" placeholder="Dirección">
    </div>
    <div class="form-group">
        <input type="text" class="form-control form-control-user" id="fechaNacimiento" placeholder="Fecha de Nacimiento (dd/mm/yyyy)">
    </div>
    <div class="form-group">
        <input type="text" class="form-control form-control-user" id="especialidad" placeholder="Especialidad">
    </div>
    <a href="login.html" class="btn btn-primary btn-user btn-block">
       Crear Odontólogo
    </a>
</form>

                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>


        <%@include file="Componentes/bodyFinal.jsp" %>
  