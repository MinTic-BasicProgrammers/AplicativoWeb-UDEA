package empresa.apiempresa.servicio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import empresa.apiempresa.modelo.*;
import empresa.apiempresa.repositorio.EmpresaRepositorio;

@Service
public class EmpresaServicioimplementacion implements EmpresaServicio {

    @Autowired
    private EmpresaRepositorio repositorio;

    @PersistenceContext
    public EntityManager em;

    @Override
    public List<Empresa> listar() {
        return repositorio.findAll();
    }

    @Override
    public Empresa obtener(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Empresa guardar(Empresa empresa) {
        return repositorio.save(empresa);
    }

    @Override
    public boolean eliminar(Long id) {
        try {
            repositorio.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}