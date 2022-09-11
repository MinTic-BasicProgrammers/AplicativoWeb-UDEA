package empresa.apiempresa.modelo;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="imagen", length=50)
    private String imagen;

    @Column(name="telefono", length=12)
    private String telefono;

    @Column(name="crearat", nullable = true)
    private Date crearat;

    @Column(name="actualizarat", nullable = true)
    private Date actualizarat;
    
    //Posible correccion a esta relacion
    @OneToOne
    @JoinColumn(name="id",referencedColumnName = "id")
    private Empleado empleado;
  
    public Perfil(Long id, String imagen, String telefono, Date crearat, Date actualizarat, Empleado empleado) {
        this.id = id;
        this.imagen = imagen;
        this.telefono = telefono;
        this.crearat = crearat;
        this.actualizarat = actualizarat;
        this.empleado = empleado;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }


    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }


    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
