
<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>





<%@include file="Componentes/header.jsp" %>
<%@include file="Componentes/bodyPrimeraParte.jsp" %>
  <div class="container text-center"> <!-- Agregar el contenedor y la clase para centrar -->
  <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Ver Usuarios</h1>
                    <p class="mb-4">Acontinuacion estara la lista de usuarios<a target="_blank"
                            href="https://datatables.net">official DataTables documentation</a>.</p>

                  <!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Usuarios</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre de Usuario</th>
                        <th>Rol</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>Id</th>
                        <th>Nombre de Usuario</th>
                        <th>Rol</th>
                        <th>Acciones</th>
                    </tr>
                </tfoot>
                <tbody>
                    <%  List<Usuario> listita = (List)request.getSession().getAttribute("listaUsuarios"); 
                        for(Usuario usu : listita){ %>
                    <tr>
                        <td><%= usu.getId_usuario()%></td>
                        <td><%= usu.getNombreUsuario()%></td>
                        <td><%= usu.getRol()%></td>
                        <td style="display:flex;">
                            <form name="eliminar" action="SvElimUsuarios" method="POST">
                                <button type="submit" class="btn btn-primary btn-user" style="background-color:red; margin-right:5px;">
                                    <i class="fas fa-trash-alt"></i>
                                    Eliminar
                                </button>
                                <input type="hidden" name="id" value="<%= usu.getId_usuario()%>">
                            </form>
                            <form name="editar" action="SvEditUsuarios" >
                                <button type="submit" class="btn btn-primary btn-user">
                                    <i class="fas fa-edit"></i>
                                    Editar
                                </button>
                                <input type="hidden" name="id" value="<%= usu.getId_usuario()%>">
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