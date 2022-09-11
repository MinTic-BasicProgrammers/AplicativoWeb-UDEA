package empresa.apiempresa.modelo;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "transaccion")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name="concepto", nullable=true, length=200)
    private String concepto;

    @Column(name="monto")
    private float monto;

    @ManyToOne
    @JoinColumn(name = "idempleado", referencedColumnName = "id")
    private Empleado empleado;
    
    @ManyToOne
    @JoinColumn(name = "idempresa", referencedColumnName = "id")
    private Empresa empresa;

    @Column(name="crearat", nullable = true)
    private Date crearat;

    @Column(name="actualizarat", nullable = true)
    private Date actualizarat;        

    public Transaccion(long id, String concepto, float monto, Empleado empleado, Empresa empresa, Date crearat,
    Date actualizarat) {
        this.id = id;
        this.concepto = concepto;
        this.monto = monto;
        this.empleado = empleado;
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


    public Empleado getEmpleado() {
        return empleado;
    }
    public void setIdempleado(Empleado empleado) {
        this.empleado = empleado;
    }


    public Empresa getEmpresa() {
        return empresa;
    }
    public void setIdempresa(Empresa empresa) {
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
