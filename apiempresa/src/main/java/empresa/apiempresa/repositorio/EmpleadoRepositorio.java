package empresa.apiempresa.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import empresa.apiempresa.modelo.Empleado;

@Repository
public interface EmpleadoRepositorio extends JpaRepository <Empleado, Long>{

    @Query("SELECT c FROM Empleado c WHERE c.email LIKE '%'||?1||'%'")
    List<Empleado> buscar(String email);
}
