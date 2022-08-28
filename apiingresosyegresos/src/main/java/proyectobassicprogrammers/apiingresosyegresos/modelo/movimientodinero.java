package proyectobassicprogrammers.apiingresosyegresos.modelo;
import java.util.Date;

import javax.persistence.*;
@Entity
@Table(name="movimientodinero")
public class movimientodinero {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="concepto")
    private String concepto;

    @Column(name="monto")
    private float monto;

    @Column(name="crearat")
    private Date crearAt;
    @Column(name="actualizarat")
    private Date actualizarAt;
    
    @ManyToOne
    @JoinColumn(name="idempresa",referencedColumnName = "id")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name="idempleado",referencedColumnName = "id")
    private Empleado empleado;

    public movimientodinero(Long id, String concepto, float monto, Date crearAt, Date actualizarAt, Empresa empresa,
            Empleado empleado) {
        this.id = id;
        this.concepto = concepto;
        this.monto = monto;
        this.crearAt = crearAt;
        this.actualizarAt = actualizarAt;
        this.empresa = empresa;
        this.empleado = empleado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    
    

}
    
    


