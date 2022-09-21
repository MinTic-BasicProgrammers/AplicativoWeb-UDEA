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
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_empleado")
    @GenericGenerator(name = "secuencia_empleado", strategy="increment")
    @Column(name = "id")
    private long id;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "rol", nullable = true, length = 13)
    @Enumerated(value = EnumType.STRING)
    private Rol rol;

    @OneToOne
    @JoinColumn(name = "idperfil", referencedColumnName = "id")
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "idempresa", referencedColumnName = "id")
    private Empresa empresa;

    @Column(name = "crearat")
    private Date crearat;

    @Column(name = "actualizarat")
    private Date actualizarat;
     
}
