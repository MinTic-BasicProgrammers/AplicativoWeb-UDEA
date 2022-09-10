package proyectobassicprogrammers.apiingresosyegresos.repositorio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


import proyectobassicprogrammers.apiingresosyegresos.modelo.movimientodinero;

@Repository
    public interface MovimientoRepositorio extends JpaRepository<movimientodinero, Long> {
        @Modifying
        @Transactional
        @Query(value="DELETE FROM Empresa e WHERE e.id = ?1")
        void eliminarmovimientodinero(long id);
    
        @Query("SELECT e FROM Empresa e WHERE e.nombre LIKE '%'||?1||'%'")
        List<movimientodinero> buscar(String nombre);

}