
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Usuario;


@WebServlet(name = "SvEditUsuarios", urlPatterns = {"/SvEditUsuarios"})
public class SvEditUsuarios extends HttpServlet {

   Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
     }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        
       Usuario usu =  control.traerUsuario(id);
        
       HttpSession sesion = request.getSession();
       
       sesion.setAttribute("usuEdit", usu);
        response.sendRedirect("editarUsuarios.jsp");

    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        String nombre = request.getParameter("nombre");
        String password = request.getParameter("password");
        String rol = request.getParameter("rol");
   
        
        Usuario usu = (Usuario )request.getSession().getAttribute("usuEdit");
        usu.setNombreUsuario(nombre);
        usu.setPassword(password);
        usu.setRol(rol);
        
        control.editarUsuario(usu);
        
        //Redirigimos al servlet que muestra usuarios
        response.sendRedirect("SvUsuarios");
        
        
        
    }

  
 
}
