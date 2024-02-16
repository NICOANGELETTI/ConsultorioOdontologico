
package logica;

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
    
}
