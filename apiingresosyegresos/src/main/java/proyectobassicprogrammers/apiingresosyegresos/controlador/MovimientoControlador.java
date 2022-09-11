package proyectobassicprogrammers.apiingresosyegresos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import proyectobassicprogrammers.apiingresosyegresos.modelo.*;
import proyectobassicprogrammers.apiingresosyegresos.repositorio.*;

@RestController
@RequestMapping("/movimientodinero")
@CrossOrigin(origins = "*")
public class MovimientoControlador {
    @Autowired
    private movimientodinero movimientodinero;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<movimientodinero> listar() {
        return repositorio.findAll();
    }

    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public movimientodinero obtener(@PathVariable long id) {
        return repositorio.findById(id).get();
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public movimientodinero crearmovimientodinero(@RequestBody movimientodinero movimientodinero) {
        return repositorio.save(movimientodinero);
    }

    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public Empresa modificarmovimientodinero(@RequestBody movimientodinero movimientodinero) {
        return repositorio.save(movimientodinero);
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public void eliminarmovimientodinero(@PathVariable long id) {
        repositorio.eliminarmovimientodinero(id);
    }
}