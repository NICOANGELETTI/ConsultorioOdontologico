
package servlet;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import logica.Odontologo;
import logica.Paciente;


@WebServlet(name = "SvTurnos", urlPatterns = {"/SvTurnos"})
public class SvTurnos extends HttpServlet {

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
             
        
             
             //FECHA
         String fechaTurnoString = request.getParameter("fechaTurno");

         
          SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        // Crear un objeto Date mediante el análisis del String
        Date fechaTurno = null;
        try {
            fechaTurno = dateFormat.parse(fechaTurnoString);
        } catch (ParseException ex) {
            Logger.getLogger(SvTurnos.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         

        //HORA    
        String horaTurno = request.getParameter("horaTurno");
        
            //AFECCION
        String afeccion = request.getParameter("afeccion");
      
        
            //ODONTOLOGO
        int idOdontologo = Integer.parseInt(request.getParameter("odontologo"));
        Odontologo odo = control.traerOdontologo(idOdontologo);
        
            //PACIENTE
        int idPaciente = Integer.parseInt(request.getParameter("paciente"));
        Paciente paci = control.traerPaciente(idPaciente);
        
        
       

        
        control.crearTurno(fechaTurno , horaTurno , afeccion , odo , paci);
        response.sendRedirect("index.jsp");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
