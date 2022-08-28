package proyectobassicprogrammers.apiingresosyegresos.modelo;

import java.util.Date;

import javax.persistence.*;
@Entity
@Table(name="empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id; 
    @Column(name="email")
    private String email;  
    @Column(name="rol")
    private Rol rol;

    @OneToOne
    @JoinColumn(name="idperfil",referencedColumnName = "id")
    private Perfil perfil;

    @OneToOne
    @JoinColumn(name="idempresa",referencedColumnName = "id")
    private Empresa empresa;

    @OneToMany
    @JoinColumn(name="idmovimientodinero",referencedColumnName = "id")
    private movimientodinero movimientodinero;
    @Column(name="crearat")
    private Date crearAt;
    @Column(name="actualizarat")
    private Date actualizarAt;
    
    public Empleado(Long id, String email, Rol rol, Perfil perfil, Empresa empresa,
            proyectobassicprogrammers.apiingresosyegresos.modelo.movimientodinero movimientodinero, Date crearAt,
            Date actualizarAt) {
        this.id = id;
        this.email = email;
        this.rol = rol;
        this.perfil = perfil;
        this.empresa = empresa;
        this.movimientodinero = movimientodinero;
        this.crearAt = crearAt;
        this.actualizarAt = actualizarAt;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    public Perfil getPerfil() {
        return perfil;
    }
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    public Empresa getEmpresa() {
        return empresa;
    }
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    public movimientodinero getMovimientodinero() {
        return movimientodinero;
    }
    public void setMovimientodinero(movimientodinero movimientodinero) {
        this.movimientodinero = movimientodinero;
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


}
