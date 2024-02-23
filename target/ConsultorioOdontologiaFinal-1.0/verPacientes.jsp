<%@page import="logica.Paciente"%>


<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>





<%@include file="Componentes/header.jsp" %>
<%@include file="Componentes/bodyPrimeraParte.jsp" %>
  <div class="container text-center"> <!-- Agregar el contenedor y la clase para centrar -->
  <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Ver Pacientes</h1>
                    <p class="mb-4">A continuacion estara la lista de Pacientes</p>
                        
   <!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Pacientes</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre del Paciente</th>
                        <th>Apellido del Paciente</th>
                        <th>Obra Social</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>Id</th>
                        <th>Nombre del Paciente</th>
                        <th>Apellido del Paciente</th>
                        <th>Obra Social</th>
                        <th>Acciones</th>
                    </tr>
                </tfoot>
                <tbody>
                    <%  List<Paciente> listita = (List)request.getSession().getAttribute("listaPacientes"); 
                        for(Paciente paci : listita){ %>
                    <tr>
                        <td><%= paci.getId()%></td>
                        <td><%= paci.getNombre()%></td>
                        <td><%= paci.getApellido()%></td>
                        <td><%= paci.isTiene_OS()%></td>
                        <td style="display:flex;">
                            <form name="eliminar" action="SvElimPacientes" method="POST">
                                <button type="submit" class="btn btn-primary btn-user" style="background-color:red; margin-right:5px;">
                                    <i class="fas fa-trash-alt"></i>
                                    Eliminar
                                </button>
                                <input type="hidden" name="id" value="<%= paci.getId()%>">
                            </form>
                            <form name="editar" action="SvEditPacientes" >
                                <button type="submit" class="btn btn-primary btn-user">
                                    <i class="fas fa-edit"></i>
                                    Editar
                                </button>
                                <input type="hidden" name="id" value="<%= paci.getId()%>">
                            </form>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
</div>




<%@include file="Componentes/bodyFinal.jsp" %>>