
package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;



@Entity
public class Responsable extends Persona implements Serializable{
    
    
    
    private String tipo_reso;

    public Responsable() {
    }

    public Responsable(String tipo_reso) {
        this.tipo_reso = tipo_reso;
    }

    public Responsable(String tipo_reso, int id, String dni, String nombre, String apellido, String telefono, String direccion, Date fecha_nac) {
        super(id, dni, nombre, apellido, telefono, direccion, fecha_nac);
        this.tipo_reso = tipo_reso;
    }

  


    public String getTipo_reso() {
        return tipo_reso;
    }

    public void setTipo_reso(String tipo_reso) {
        this.tipo_reso = tipo_reso;
    }
    
    
    
    
}
