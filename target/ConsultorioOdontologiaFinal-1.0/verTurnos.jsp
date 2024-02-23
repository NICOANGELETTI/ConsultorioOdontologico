<%@page import="logica.Turno"%>
<%@page import="logica.Paciente"%>


<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>





<%@include file="Componentes/header.jsp" %>
<%@include file="Componentes/bodyPrimeraParte.jsp" %>
  <div class="container text-center"> <!-- Agregar el contenedor y la clase para centrar -->
  <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Ver Turnos</h1>
                    <p class="mb-4">A continuacion estara la lista de los Turnos</p>
                        
   <!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Turnos</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                    <tr>
                        <th>Id del Turno</th>
                        <th>Fecha</th>
                        <th>Hora</th>
                        <th>Afeccion</th>
                        <th>Odontologo</th>
                        <th>Paciente</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>Id del Turno</th>
                        <th>Fecha</th>
                        <th>Hora</th>
                        <th>Afeccion</th>
                        <th>Odontologo</th>
                        <th>Paciente</th>
                        <th>Acciones</th>
                    </tr>
                </tfoot>
                <tbody>
                    <%  List<Turno> listita = (List)request.getSession().getAttribute("listaTurnos"); 
                        for(Turno turno : listita){ %>
                        <tr>
                            <td><%= turno.getId_turno()%></td>
                            <td><%= turno.getFecha_turno()%></td>
                            <td><%= turno.getHora_turno()%></td>
                            <td><%= turno.getAfeccion()%></td>
                            <td><%= turno.getOdonto().getNombre() %></td>
                            <td><%= turno.getPaciente().getNombre() %></td>
                        <td style="display:flex;">
                            <form name="eliminar" action="SvElimTurno" method="POST">
                                <button type="submit" class="btn btn-primary btn-user" style="background-color:red; margin-right:5px;">
                                    <i class="fas fa-trash-alt"></i>
                                    Eliminar
                                </button>
                                <input type="hidden" name="id" value="<%= turno.getId_turno()  %>">
                            </form>
                            <form name="editar" action="SvEditTurno" >
                                <button type="submit" class="btn btn-primary btn-user">
                                    <i class="fas fa-edit"></i>
                                    Editar
                                </button>
                                <input type="hidden" name="id" value="<%= turno.getId_turno()%>">
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