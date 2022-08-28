package proyectobassicprogrammers.apiingresosyegresos.modelo;
import javax.persistence.*;
@Entity

public class movimientodinero {
    

    @Id
    private long idempleado;
    @Column(name="actualizarat", nullable=true, length=undefined)
    private String actualizarat;
    @Column(name="monto", nullable=true, length=undefined)
    private String monto;
    private long id;
    private long idempresa;
    public Student() {}

    public long getIdempleado() {
        return idempleado;
    }
    public void setIdempleado(long idempleado) {
        this.idempleado = idempleado;
    }


    public String getActualizarat() {
        return actualizarat;
    }
    public void setActualizarat(String actualizarat) {
        this.actualizarat = actualizarat;
    }


    public String getMonto() {
        return monto;
    }
    public void setMonto(String monto) {
        this.monto = monto;
    }


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }


    public long getIdempresa() {
        return idempresa;
    }
    public void setIdempresa(long idempresa) {
        this.idempresa = idempresa;
    }


}
    
    


