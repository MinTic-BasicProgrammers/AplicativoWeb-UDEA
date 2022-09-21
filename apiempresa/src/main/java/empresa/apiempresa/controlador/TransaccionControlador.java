package empresa.apiempresa.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import empresa.apiempresa.modelo.Transaccion;
import empresa.apiempresa.repositorio.TransaccionRepositorio;



@RestController
@RequestMapping("/transaccion")
public class TransaccionControlador {
    @Autowired
    private TransaccionRepositorio transaccion;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Transaccion> listar() {
        return transaccion.findAll();
    }

    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Transaccion obtener(@PathVariable long id) {
        return transaccion.findById(id).get();
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Transaccion crear(@RequestBody Transaccion transaccionn) {
        return transaccion.save(transaccionn);
    }

    @RequestMapping(value = "/modificar", method = RequestMethod.PATCH)
    public Transaccion actualizar(@RequestBody Transaccion tranzaccion) {
        return transaccion.save(tranzaccion);
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable long id) {
      transaccion.deleteById(id);
    }
}

