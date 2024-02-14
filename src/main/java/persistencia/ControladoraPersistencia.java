
package persistencia;


import logica.Usuario;


public class ControladoraPersistencia {

    
    
    
    
    
    UsuarioJpaController usuJPA = new UsuarioJpaController();
    
    
    
    
    
    public ControladoraPersistencia() {
    }

    public void crearUsuario(Usuario usu)  {
       usuJPA.create(usu);
      
 }
    
    
    
    
    
    
    
    
    
}
