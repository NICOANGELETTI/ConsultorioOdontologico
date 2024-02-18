<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="logica.Paciente" %>
<%@ page import="logica.Odontologo" %>
<%@ include file="Componentes/header.jsp" %>
<%@ include file="Componentes/bodyPrimeraParte.jsp" %>


<body class="bg-gradient-primary">

    <div class="container">
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Alta Turnos</h1>
                            </div>
                            <form class="user" action="SvTurnos" method="POST">
                                <div class="form-group">
                                    <input type="date" class="form-control form-control-user" name="fechaTurno" id="fechaTurno" placeholder="Fecha del Turno">
                                </div>
                                <div class="form-group">
                                    <input type="time" class="form-control form-control-user" name="hora" id="hora" placeholder="Hora">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" name="afeccion" id="afeccion" placeholder="Afección">
                                </div>

                                <div class="form-group">
                                        <label for="odontologo">Seleccionar Odontólogo</label>
                                    <select class="form-control" id="odontologo" name="odontologo">
                                        <% List<Odontologo> listaOdontologos = (List)request.getSession().getAttribute("listaOdontologos");
                                           if (listaOdontologos != null && !listaOdontologos.isEmpty()) {
                                               for (Odontologo odo : listaOdontologos) { %>
                                                   <option value="<%= odo.getId() %>"><%= odo.getNombre() + " " + odo.getApellido() %></option>
                                           <%  }
                                           } %>
                                    </select>
                                </div>

                                <div class="form-group">
                                       <label for="odontologo">Seleccionar Paciente</label>
                                    <select class="form-control" id="paciente" name="paciente">
                                        <% List<Paciente> listaPacientes = (List)request.getSession().getAttribute("listaPacientes");
                                           if (listaPacientes != null && !listaPacientes.isEmpty()) {
                                               for (Paciente pac : listaPacientes) { %>
                                                   <option value="<%= pac.getId() %>"><%= pac.getNombre() + " " + pac.getApellido() %></option>
                                           <%  }
                                           } %>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-primary btn-user btn-block">Crear Turno</button>
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

<%@ include file="Componentes/bodyFinal.jsp" %>
