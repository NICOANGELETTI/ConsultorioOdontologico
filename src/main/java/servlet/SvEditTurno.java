/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import logica.Turno;


@WebServlet(name = "SvEditTurno", urlPatterns = {"/SvEditTurno"})
public class SvEditTurno extends HttpServlet {

    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        }
  
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        int idTurno = Integer.parseInt(request.getParameter("id"));
        
       
        HttpSession sesion = request.getSession();
       Turno turnoEdit = control.traerTurno(idTurno);
   
        sesion.setAttribute("turnoEdit", turnoEdit);
        response.sendRedirect("editarTurnos.jsp");
        
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
        
        
        Turno turno = (Turno)request.getSession().getAttribute("turnoEdit");
        turno.setFecha_turno(fechaTurno);
        turno.setHora_turno(horaTurno);
        turno.setAfeccion(afeccion);
        turno.setOdonto(odo);
        turno.setPaciente(paci);

        control.editarTurno(turno);
        HttpSession sesion = request.getSession();
        // Después de cada operación exitosa, establece un mensaje de alerta genérico en la sesión
        sesion.setAttribute("mensajeAlerta", "Operación completada exitosamente.");
        response.sendRedirect("SvTurnos");

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
