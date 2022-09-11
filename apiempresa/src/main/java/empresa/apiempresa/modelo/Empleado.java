package empresa.apiempresa.modelo;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "email", nullable = true, unique = true, length = 50)
    private String email;

    @Column(name = "rol", nullable = false, length = 13)
    @Enumerated(value = EnumType.STRING)
    private Rol rol;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "idempresa", referencedColumnName = "id")
    private Empresa empresa;

    @Column(name = "crearat", nullable = true)
    private Date crearat;

    @Column(name = "actualizarat", nullable = true)
    private Date actualizarat;


    public Empleado(long id, String email, Rol rol, Perfil perfil, Empresa empresa, Date crearat, Date actualizarat) {
        this.id = id;
        this.email = email;
        this.rol = rol;
        this.perfil = perfil;
        this.empresa = empresa;
        this.crearat = crearat;
        this.actualizarat = actualizarat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
