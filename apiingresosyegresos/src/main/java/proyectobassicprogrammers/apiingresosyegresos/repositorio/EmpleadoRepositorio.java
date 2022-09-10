package proyectobassicprogrammers.apiingresosyegresos.repositorio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import proyectobassicprogrammers.apiingresosyegresos.modelo.Empleado;

@Repository
    public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {
        @Modifying
        @Transactional
        @Query(value="DELETE FROM Empresa e WHERE e.id = ?1")
        void eliminarEmpleado(long id);
    
        @Query("SELECT e FROM Empresa e WHERE e.nombre LIKE '%'||?1||'%'")
        List<Empleado> buscar(String nombre);

}