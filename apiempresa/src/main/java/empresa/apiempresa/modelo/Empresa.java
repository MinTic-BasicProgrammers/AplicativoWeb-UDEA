package empresa.apiempresa.modelo;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

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
@Table(name = "empresa")
public class Empresa {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_empresa")
    @GenericGenerator(name = "secuencia_empresa", strategy = "increment")
    @Column(name = "id")
    private long id;

    @Column(name="nombre", unique = true, length=50)
    private String nombre;

    @Column(name="documento", unique = true, length=50)
    private String documento;

    @Column(name="telefono", length=12)
    private String telefono;

    @Column(name="direccion", length=50)
    private String direccion;

    @Column(name="crearat", nullable = true)
    private Date crearat;

    @Column(name="actualizarat", nullable = true)
    private Date actualizarat;
    
}
