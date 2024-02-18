
package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import persistencia.ControladoraPersistencia;


public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public Controladora() {
    }



 public void crearUsuario(String usuario , String password , String rol) {
     Usuario usu = new Usuario();
     usu.setNombreUsuario(usuario);
     usu.setPassword(rol);
     usu.setRol(rol);
     
     controlPersis.crearUsuario(usu);
     
 }
 
 public List<Usuario> getUsuarios(){
     return controlPersis.traerUsuarios();     
 }

    public void borrarUsuario(int id) {
        
        controlPersis.borrarUsuario(id);
        
    }

    public Usuario traerUsuario(int id) {

        return controlPersis.traerUsuario(id);
    }

    public void editarUsuario(Usuario usu) {

        controlPersis.editarUsuario(usu);

    }

    public boolean validarIngreso(String nombreUsuario, String password) {

        boolean ingreso = false;

      List<Usuario> listaUsuarios = new ArrayList<Usuario>();
              
              listaUsuarios = controlPersis.traerUsuarios();

        for (Usuario usu : listaUsuarios) {
            if (usu.getNombreUsuario().equals(nombreUsuario)) {
                if(usu.getPassword().equals(password)){
                   ingreso = true;  
                }
               
            else{
                ingreso=false;
            }
        }
       
        
        }
        return ingreso;
        }

    
    
    //Metodos Odontologo
    public void crearOdontologo(String nombre ,String apellido , String especialidad) {
        
        Odontologo odontologo = new Odontologo();
        odontologo.setNombre(nombre);
        odontologo.setApellido(apellido);
        odontologo.setEspecialidad(especialidad);
   
        
        controlPersis.crearOdontologo(odontologo);
        
        
        
        
        
    }

    public List<Odontologo> traerOdontologos() {

        return controlPersis.traerOdontologos();
    }

    
    
    
     public Odontologo traerOdontologo(int id) {

        return controlPersis.traerOdontologo(id);
    }

    
    
    //Metodos Paciente
    public void crearPaciente(String nombre, String apellido, boolean tiene_OS) {
       Paciente paciente = new Paciente();
        paciente.setNombre(nombre);
        paciente.setApellido(apellido);
        paciente.setTiene_OS(tiene_OS);
        
        controlPersis.crearPaciente(paciente);
        
        

    }

    public List<Paciente> traerPacientes() {
        return controlPersis.traerPacientes();

    }
      public Paciente traerPaciente(int id) {

        return controlPersis.traerPaciente(id);
    }

    public void crearTurno(Date fechaTurno, String horaTurno, String afeccion, Odontologo odo, Paciente paci) {
        Turno turno = new Turno();
        turno.setFecha_turno(fechaTurno);
        turno.setHora_turno(horaTurno);
        turno.setAfeccion(afeccion);
        turno.setOdonto(odo);
        turno.setPaciente(paci);
        
        controlPersis.crearTurno(turno);
    }

}
