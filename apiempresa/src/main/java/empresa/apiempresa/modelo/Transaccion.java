package empresa.apiempresa.modelo;

import java.util.Date;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "transaccion")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable=true)
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
    }
