
package persistencia;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Odontologo;
import logica.Paciente;
import logica.Turno;
import logica.Usuario;
import persistencia.exceptions.NonexistentEntityException;


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

    public void crearTurno(Turno turno) {
        try {
            turnoJPA.create(turno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

  
       
     
      
        

    }


    

    
    
    
    

