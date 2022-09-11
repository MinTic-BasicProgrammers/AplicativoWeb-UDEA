package empresa.apiempresa.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import empresa.apiempresa.modelo.Empresa;

@Repository
public interface EmpresaRepositorio extends JpaRepository <Empresa, Long>{
    
}
