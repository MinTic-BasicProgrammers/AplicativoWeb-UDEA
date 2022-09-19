package empresa.apiempresa.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import empresa.apiempresa.modelo.Perfil;

@Repository
public interface PefilRepositorio extends JpaRepository <Perfil, Long>{
    
}
