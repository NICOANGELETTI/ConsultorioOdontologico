
package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Usuario;



@WebServlet(name = "SvUsuarios", urlPatterns = {"/SvUsuarios"})
public class SvUsuarios extends HttpServlet {

    
   Controladora control = new Controladora();
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        List<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios = control.getUsuarios();
        
       HttpSession sesion=  request.getSession();
       sesion.setAttribute("listaUsuarios", listaUsuarios);
       response.sendRedirect("verUsuarios.jsp");
        
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
     
      
    
           processRequest(request, response);
//Traigo los parametros
String nombre = request.getParameter("nombre");
        String password = request.getParameter("password");
        String rol = request.getParameter("rol");

        control.crearUsuario(nombre, password, rol);
        HttpSession sesion = request.getSession();
        // Después de cada operación exitosa, establece un mensaje de alerta genérico en la sesión
        sesion.setAttribute("mensajeAlerta", "Operación completada exitosamente.");
        response.sendRedirect("index.jsp");

    }




     
  
    }

 



