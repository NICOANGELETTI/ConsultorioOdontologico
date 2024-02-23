
package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Odontologo;


@WebServlet(name = "SvEditOdontologos", urlPatterns = {"/SvEditOdontologos"})
public class SvEditOdontologos extends HttpServlet {

 
    
    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     
        }
 

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        int idOdonto = Integer.parseInt(request.getParameter("id"));
        
        Odontologo odontoEdit = control.traerOdontologo(idOdonto);
        
        HttpSession sesion = request.getSession();
        
        sesion.setAttribute("odontoEdit", odontoEdit);
        response.sendRedirect("editarOdontologos.jsp");
        
        
        
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String especialidad = request.getParameter("especialidad");
  
        Odontologo odo = (Odontologo)request.getSession().getAttribute("odontoEdit");
        odo.setNombre(nombre);
        odo.setApellido(apellido);
        odo.setEspecialidad(especialidad);
        
        control.editarOdontologo(odo);
        HttpSession sesion = request.getSession();
        // Después de cada operación exitosa, establece un mensaje de alerta genérico en la sesión
        sesion.setAttribute("mensajeAlerta", "Operación completada exitosamente.");
        response.sendRedirect("SvOdontologos");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
