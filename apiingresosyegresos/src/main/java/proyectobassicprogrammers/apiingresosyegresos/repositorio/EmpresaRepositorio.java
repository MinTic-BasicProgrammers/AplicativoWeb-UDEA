package proyectobassicprogrammers.apiingresosyegresos.repositorio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import proyectobassicprogrammers.apiingresosyegresos.modelo.Empresa;;

@Repository
    public interface EmpresaRepositorio extends JpaRepository<Empresa, Long> {
        @Modifying
        @Transactional
        @Query(value="DELETE FROM Empresa e WHERE e.id = ?1")
        void eliminarEmpresa(long id);
    
        @Query("SELECT e FROM Empresa e WHERE e.nombre LIKE '%'||?1||'%'")
        List<Empresa> buscar(String nombre);

}
