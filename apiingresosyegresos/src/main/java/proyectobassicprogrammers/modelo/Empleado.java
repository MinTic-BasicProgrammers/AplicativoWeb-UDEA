package proyectobassicprogrammers.modelo;

import javax.persistence.*;
@Entity
@Table(name="empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="nombreEmpleado")
    private String nombreEmpleado;
    @Column(name="correoEmpleado")
    private String correoEmpleado;
    @Column(name="numeroEmpresa")
    private int numeroEmpresa;
    @Column(name="nitEmpresa")
    private int nitEmpresa;
    
    @Column(name="rol")
    private Rol rol;

    @OneToOne
    @JoinColumn(name="idperfil",referencedColumnName = "id")
    private Perfil perfil;
    


}
