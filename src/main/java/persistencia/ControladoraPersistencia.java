
package persistencia;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Usuario;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.RollbackFailureException;


public class ControladoraPersistencia {

    
    
    
    
    
    UsuarioJpaController usuJPA = new UsuarioJpaController();
    
    
    
    
    
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


    
    
    
    
    
    
}
