package hibernatefestival;
// Generated 27-feb-2017 14:12:30 by Hibernate Tools 4.3.1



/**
 * Guitarra generated by hbm2java
 */
public class Guitarra  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private boolean visible;

    public Guitarra() {
    }

    public Guitarra(String nombre, boolean visible) {
       this.nombre = nombre;
       this.visible = visible;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean isVisible() {
        return this.visible;
    }
    
    public void setVisible(boolean visible) {
        this.visible = visible;
    }




}


