package empresa.apiempresa.modelo;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_empresa")
    @GenericGenerator(name = "secuencia_empresa", strategy = "increment")
    @Column(name = "id")
    private long id;

    @Column(name="nombre", unique = true, length=50)
    private String nombre;

    @Column(name="documento", unique = true, length=50)
    private String documento;

    @Column(name="telefono", length=12)
    private String telefono;

    @Column(name="direccion", length=50)
    private String direccion;

    @Column(name="crearat", nullable = true)
    private Date crearat;

    @Column(name="actualizarat", nullable = true)
    private Date actualizarat;
    
    //Las relaciones respecto a la entidad empresa,
    //estan en las tablas Empleado y Transaccion
    
    /*public Empresa(long id, String nombre, String documento, String telefono, String direccion, Date crearat,
            Date actualizarat) {
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.crearat = crearat;
        this.actualizarat = actualizarat;
    }*/
    /* */
    public Empresa() {
    }
 

    public long getId() {
        return id;
    }   
    
    public void setId(long id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }


    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public Date getCrearat() {
        return crearat;
    }
    public void setCrearat(Date crearat) {
        this.crearat = crearat;
    }


    public Date getActualizarat() {
        return actualizarat;
    }
    public void setActualizarat(Date actualizarat) {
        this.actualizarat = actualizarat;
    }


}
