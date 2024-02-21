
package persistencia;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Odontologo;
import logica.Paciente;
import logica.Turno;
import logica.Usuario;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.RollbackFailureException;


public class ControladoraPersistencia {

    
    
    
    
    
    UsuarioJpaController usuJPA = new UsuarioJpaController();
    OdontologoJpaController odoJPA = new OdontologoJpaController();
    PacienteJpaController paciJPA = new PacienteJpaController();
    TurnoJpaController turnoJPA = new TurnoJpaController();


    
    public ControladoraPersistencia() {
    }

    //Metodos de CRUD USUARIOS
    public void crearUsuario(Usuario usu) {
        usuJPA.create(usu);

    }

    public List<Usuario> traerUsuarios() {
        return usuJPA.findUsuarioEntities();

    }

    public void borrarUsuario(int id) {
      
   
        try {
            usuJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

      
           
      
    }

    public Usuario traerUsuario(int id) {
        return usuJPA.findUsuario(id);
    }

    public void editarUsuario(Usuario usu) {

        try {
            usuJPA.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }

        //Metodos Odontologo
    public void crearOdontologo(Odontologo odontologo) {
       odoJPA.create(odontologo);
    }

    public List<Odontologo> traerOdontologos() {

        return odoJPA.findOdontologoEntities();
    }
  public Odontologo traerOdontologo(int id) {
        return odoJPA.findOdontologo(id);

    }
  
   public void borrarOdontologo(int id) {
      
   
        try {
            odoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

      
           
      
    }

   
     public void editarOdontologo(Odontologo odo) {
        try {
            odoJPA.edit(odo);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
    //Metodos Paciente
    public void crearPaciente(Paciente paciente) {
  
            paciJPA.create(paciente);
       
    }

    public List<Paciente> traerPacientes() {

        return paciJPA.findPacienteEntities();
    }

    public Paciente traerPaciente(int id) {

        return paciJPA.findPaciente(id);
    }
    
    
    public void borrarPaciente(int id) {
      
   
        try {
            paciJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

      
           
      
    }
    
    
    public void editarPaciente(Paciente paciente) {
        try {
            paciJPA.edit(paciente);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    //Turnos

    public void crearTurno(Turno turno) {
        try {
            turnoJPA.create(turno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public List<Turno> traerTurnos() {

        return turnoJPA.findTurnoEntities();
    }

    public void borrarTurno(int idTurno) {
        try {
            turnoJPA.destroy(idTurno);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Turno traerTurno(int idTurno) {

       return turnoJPA.findTurno(idTurno);
    }

    public void editarTurno(Turno turno) {

        try {
            turnoJPA.edit(turno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  

  
  
       
     
      
        

    }


    

    
    
    
    

