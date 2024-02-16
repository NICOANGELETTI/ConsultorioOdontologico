
<%@page import="logica.Usuario"%>
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
                                <h1 class="h4 text-gray-900 mb-4">Editar Usuarios</h1>
                            </div>
                            
                            
                            <%   Usuario usu = (Usuario)request.getSession().getAttribute("usuEdit");         %>
                            <form class="user" action="SvEditUsuarios" method="POST">
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" name="nombre" id="nombre" placeholder="Usuario" value="<%=usu.getNombreUsuario()   %>">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" name="password" id="password" placeholder="Contraseña" value="<%= usu.getPassword() %>">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" name="rol" id="rol" placeholder="rol" value="<%= usu.getRol()  %>">
                                </div>
                                <button type="submit" class="btn btn-primary btn-user btn-block">
                                    Editar Usuario
                                </button>
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