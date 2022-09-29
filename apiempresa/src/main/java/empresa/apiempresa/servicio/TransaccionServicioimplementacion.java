package empresa.apiempresa.servicio;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import empresa.apiempresa.modelo.*;
import empresa.apiempresa.repositorio.TransaccionRepositorio;



@Service
public class TransaccionServicioimplementacion implements TransaccionServicio {

    @Autowired
    private TransaccionRepositorio repositorio;

    @Override
    public List<Transaccion>  listar() {
        return repositorio.findAll();
    }

    @Override
    public Transaccion obtener(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Transaccion guardar(Transaccion transaccion) {
        return repositorio.save(transaccion);
    }
    
    @Override
    public boolean eliminar(Long empresa) {
        try {
            repositorio.deleteById(empresa);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public List<Transaccion> buscar(Long empresa) {
        return repositorio.buscar(empresa);
    }

}