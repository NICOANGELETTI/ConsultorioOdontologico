
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


@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {

 
    
    Controladora control = new Controladora();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
   
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

     
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        
           String nombreUsuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        boolean validacion = false ;
        validacion = control.validarIngreso(nombreUsuario,password);
        
        
        if(validacion==true){
          HttpSession sesion =  request.getSession(true);
          sesion.setAttribute("nombreUsuario", nombreUsuario);
          response.sendRedirect("index.jsp");
          
        }else{
          response.sendRedirect("loginError.jsp");
        }  

  

        
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
