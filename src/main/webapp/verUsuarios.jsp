
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
                                          
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Id</th>
                                            <th>Nombre de Usuario</th>
                                            <th>Rol</th>
                                           
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>Nicolas</td>
                                            <td>Admin</td>
                                         
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
</div>
            <!-- End of Main Content -->
            



<%@include file="Componentes/bodyFinal.jsp" %>>