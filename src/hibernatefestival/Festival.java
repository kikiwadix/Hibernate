package hibernatefestival;
// Generated 27-feb-2017 14:12:30 by Hibernate Tools 4.3.1



/**
 * Festival generated by hbm2java
 */
public class Festival  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private String ciudad;
     private boolean visible;

    public Festival() {
    }

    public Festival(String nombre, String ciudad, boolean visible) {
       this.nombre = nombre;
       this.ciudad = ciudad;
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
    public String getCiudad() {
        return this.ciudad;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public boolean isVisible() {
        return this.visible;
    }
    
    public void setVisible(boolean visible) {
        this.visible = visible;
    }




}


