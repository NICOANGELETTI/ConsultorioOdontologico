
package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Paciente;


@WebServlet(name = "SvEditPacientes", urlPatterns = {"/SvEditPacientes"})
public class SvEditPacientes extends HttpServlet {


    
    Controladora control = new Controladora();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
   
        }
 


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        int idPaciente =  Integer.parseInt(request.getParameter("id"));
        
        Paciente pacienteEdit = control.traerPaciente(idPaciente);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("pacienteEdit", pacienteEdit);
        response.sendRedirect("editarPacientes.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String obraSocial = request.getParameter("obraSocial");
        
        boolean valorObraSocial = false; 
        
        if(obraSocial.equals("si")){
            valorObraSocial = true; 
            
        }else{
            valorObraSocial = false;
        }
        
        Paciente paciente = (Paciente) request.getSession().getAttribute("pacienteEdit");
        paciente.setNombre(nombre);
        paciente.setApellido(apellido);
        paciente.setTiene_OS(valorObraSocial);
        
        
        control.editarPaciente(paciente);
        response.sendRedirect("SvPacientes");
        
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
