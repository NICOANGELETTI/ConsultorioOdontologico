
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Paciente;


@WebServlet(name = "SvPacientes", urlPatterns = {"/SvPacientes"})
public class SvPacientes extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        List<Paciente> listaPacientes = new ArrayList<>();
        
        listaPacientes = control.traerPacientes();
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaPacientes", listaPacientes);
        
        response.sendRedirect("verPacientes.jsp");
        
        
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String obraSocial = request.getParameter("obraSocial");

        boolean tiene_OS;

        if (obraSocial != null && obraSocial.equalsIgnoreCase("si")) {
            tiene_OS = true;
        } else {
            tiene_OS = false;
        }

        control.crearPaciente(nombre,apellido,tiene_OS);
        
        response.sendRedirect("index.jsp");
      
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
