
package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;


@WebServlet(name = "SvElimPacientes", urlPatterns = {"/SvElimPacientes"})
public class SvElimPacientes extends HttpServlet {

   
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
        
        int idPaciente = Integer.parseInt(request.getParameter("id"));
        
        Controladora control = new Controladora();
        
        control.borrarPaciente(idPaciente);
        
        response.sendRedirect("verPacientes.jsp");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
