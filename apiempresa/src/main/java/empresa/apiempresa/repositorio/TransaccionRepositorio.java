package empresa.apiempresa.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import empresa.apiempresa.modelo.Transaccion;

@Repository
public interface TransaccionRepositorio extends JpaRepository <Transaccion, Long> {
    
}
