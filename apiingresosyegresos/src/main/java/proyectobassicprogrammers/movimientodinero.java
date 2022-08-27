package proyectobassicprogrammers;

public class movimientodinero {
    private int monto;
    private String concepto;
    private String usuario;

    public movimientodinero(int monto, String concepto, String usuario){
        this.monto= monto;
        this.concepto= concepto;
        this.usuario = usuario;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    

}
