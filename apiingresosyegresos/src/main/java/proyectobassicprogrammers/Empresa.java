package proyectobassicprogrammers;
import javax.persistence.*;

@Entity
@Table(name = "empresa")

public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

   

        //atributos 
        @Column(name = "nombreempresa")
        private String nombreEmpresa;
        @Column(name = "direccionempresa")
        private String direccionEmpresa;
        @Column(name = "telefonoempresa")
        private int telefonoEmpresa;
        @Column(name = "nitempresa")
        private int nitEmpresa;
        
        
        /**
         * @param nombreEmpresa
         * @param direccionEmpresa
         * @param telefonoEmpresa
         * @param nitEmpresa
         */
        public Empresa(String nombreEmpresa, String direccionEmpresa, int telefonoEmpresa, int nitEmpresa) {
            this.nombreEmpresa = nombreEmpresa;
            this.direccionEmpresa = direccionEmpresa;
            this.telefonoEmpresa = telefonoEmpresa;
            this.nitEmpresa = nitEmpresa;
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
