package empresa.apiempresa.repositorio;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import empresa.apiempresa.modelo.*;

@Repository
public interface TransaccionRepositorio extends JpaRepository <Transaccion, Long> {
    @Query("SELECT t  from Transaccion t JOIN Empresa e on t.empresa = e.id")
    List<Transaccion> buscar(Long empresa);


}
