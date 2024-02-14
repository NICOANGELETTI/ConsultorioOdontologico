
package logica;

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
 
 
    
}
