package empresa.apiempresa.servicio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import empresa.apiempresa.modelo.*;
import empresa.apiempresa.repositorio.EmpleadoRepositorio;

@Service
public class EmpleadoServicioimplementacion implements EmpleadoServicio {

    @Autowired
    private EmpleadoRepositorio repositorio;

    @PersistenceContext
    public EntityManager em;

    @Override
    public List<Empleado> listar() {
        return repositorio.findAll();
    }

    @Override
    public Empleado obtener(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public List<Empleado> buscar(String email) {
        return repositorio.buscar(email);
    }

    @Override
    public Empleado guardar(Empleado ciudad) {
        return repositorio.save(ciudad);
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
