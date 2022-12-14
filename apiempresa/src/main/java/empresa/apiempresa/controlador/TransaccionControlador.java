package empresa.apiempresa.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import empresa.apiempresa.modelo.*;
import empresa.apiempresa.servicio.*;


@RestController
@RequestMapping("/transaccion")
public class TransaccionControlador {
    @Autowired
    private TransaccionServicio servicio;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Transaccion> listar() {
        return servicio.listar();
    }

    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Transaccion obtener(@PathVariable Long id){
        return servicio.obtener(id);
    }
   
    
    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Transaccion crear(@RequestBody Transaccion transaccion) {
        return servicio.guardar(transaccion);
    }

    @RequestMapping(value = "/modificar/{id}", method = RequestMethod.PATCH)
    public Transaccion actualizar(@RequestBody Transaccion transaccion) {
        return servicio.guardar(transaccion);
    }

    @RequestMapping(value = "/eliminar/{empresa}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable long empresa) {
        return servicio.eliminar(empresa);
    }

    @RequestMapping(value = "/buscar/{empresa}", method = RequestMethod.GET)
    public List<Transaccion> buscar(@PathVariable Long empresa) {
        return servicio.buscar(empresa);
    }

}

