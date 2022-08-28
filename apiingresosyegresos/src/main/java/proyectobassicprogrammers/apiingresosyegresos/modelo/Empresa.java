package proyectobassicprogrammers.apiingresosyegresos.modelo;


import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "empresa")

public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    // atributos
    @Column(name = "nombreempresa")
    private String nombreEmpresa;
    @Column(name = "direccionempresa")
    private String direccionEmpresa;
    @Column(name = "telefonoempresa")
    private int telefonoEmpresa;
    @Column(name = "nitempresa")
    private int nitEmpresa;
    @Column(name="crearat")
    private Date crearAt;
    @Column(name="actualizarat")
    private Date actualizarAt;

    @OneToMany
    @JoinColumn(name="idempeado",referencedColumnName = "id")
    private Empleado empleado;

    @OneToMany
    @JoinColumn(name="idmovimientodinero",referencedColumnName = "id")
    private movimientodinero movimientodinero;

    
    public Empresa(long id, String nombreEmpresa, String direccionEmpresa, int telefonoEmpresa, int nitEmpresa,
            Date crearAt, Date actualizarAt, Empleado empleado,
            proyectobassicprogrammers.apiingresosyegresos.modelo.movimientodinero movimientodinero) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
        this.nitEmpresa = nitEmpresa;
        this.crearAt = crearAt;
        this.actualizarAt = actualizarAt;
        this.empleado = empleado;
        this.movimientodinero = movimientodinero;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public movimientodinero getMovimientodinero() {
        return movimientodinero;
    }

    public void setMovimientodinero(movimientodinero movimientodinero) {
        this.movimientodinero = movimientodinero;
    }


    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public int getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(int telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public int getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNitEmpresa(int nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }

}
