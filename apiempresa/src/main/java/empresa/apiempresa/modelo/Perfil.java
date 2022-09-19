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
@Table(name="perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable=true)
    private Long id;

    @Column(name="imagen", length=50)
    private String imagen;

    @Column(name="telefono", length=12)
    private String telefono;

    @Column(name="crearat")
    private Date crearat;

    @Column(name="actualizarat")
    private Date actualizarat;
      
}
