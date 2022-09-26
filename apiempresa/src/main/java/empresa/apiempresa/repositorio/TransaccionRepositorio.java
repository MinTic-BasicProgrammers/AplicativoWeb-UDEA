package empresa.apiempresa.repositorio;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import empresa.apiempresa.modelo.Transaccion;

@Repository
public interface TransaccionRepositorio extends JpaRepository <Transaccion, Long> {

    @Query("SELECT d FROM Transaccion d WHERE d.empresa LIKE '%'||?1||'%'")
    List<Transaccion> buscar(long empresa);

}
