
package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;


@WebServlet(name = "SvElimPacientes", urlPatterns = {"/SvElimPacientes"})
public class SvElimPacientes extends HttpServlet {

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
        
        int idPaciente = Integer.parseInt(request.getParameter("id"));
        
        control.borrarPaciente(idPaciente);
        HttpSession sesion = request.getSession();
        // Después de cada operación exitosa, establece un mensaje de alerta genérico en la sesión
        sesion.setAttribute("mensajeAlerta", "Operación completada exitosamente.");
        response.sendRedirect("SvPacientes");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
