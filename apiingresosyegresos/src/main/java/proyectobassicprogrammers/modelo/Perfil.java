package proyectobassicprogrammers.modelo;

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
    private String crearAt;
    @Column(name="actualizarat")
    private String actualizarAt;
    
    
    public Perfil(Long id, String perfilImagen, String perfilTelefono, String crearAt, String actualizarAt) {
        this.id = id;
        this.perfilImagen = perfilImagen;
        this.perfilTelefono = perfilTelefono;
        this.crearAt = crearAt;
        this.actualizarAt = actualizarAt;
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
    public String getCrearAt() {
        return crearAt;
    }
    public void setCrearAt(String crearAt) {
        this.crearAt = crearAt;
    }
    public String getActualizarAt() {
        return actualizarAt;
    }
    public void setActualizarAt(String actualizarAt) {
        this.actualizarAt = actualizarAt;
    }



}
