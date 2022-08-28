package proyectobassicprogrammers.apiingresosyegresos.modelo;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="perfil")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="imagen")
    private String perfilImagen;
    @Column(name="telefono")
    private String perfilTelefono;
    @Column(name="crearat")
    private Date crearAt;
    @Column(name="actualizarat")
    private Date actualizarAt;
    @OneToOne
    @JoinColumn(name="idempleado",referencedColumnName = "id")
    private Empleado empleado;
    
    public Perfil(Long id, String perfilImagen, String perfilTelefono, Date crearAt, Date actualizarAt,
            Empleado empleado) {
        this.id = id;
        this.perfilImagen = perfilImagen;
        this.perfilTelefono = perfilTelefono;
        this.crearAt = crearAt;
        this.actualizarAt = actualizarAt;
        this.empleado = empleado;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPerfilImagen() {
        return perfilImagen;
    }
    public void setPerfilImagen(String perfilImagen) {
        this.perfilImagen = perfilImagen;
    }
    public String getPerfilTelefono() {
        return perfilTelefono;
    }
    public void setPerfilTelefono(String perfilTelefono) {
        this.perfilTelefono = perfilTelefono;
    }
    public Date getCrearAt() {
        return crearAt;
    }
    public void setCrearAt(Date crearAt) {
        this.crearAt = crearAt;
    }
    public Date getActualizarAt() {
        return actualizarAt;
    }
    public void setActualizarAt(Date actualizarAt) {
        this.actualizarAt = actualizarAt;
    }
    public Empleado getEmpleado() {
        return empleado;
    }
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
   

}
