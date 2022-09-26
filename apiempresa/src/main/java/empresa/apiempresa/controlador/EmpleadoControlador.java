package empresa.apiempresa.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import empresa.apiempresa.modelo.*;
import empresa.apiempresa.servicio.*;

@RestController
@RequestMapping("/empleado")
public class EmpleadoControlador {
    @Autowired
    private EmpleadoServicio servicio;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Empleado> listar() {
        return servicio.listar();
    }

    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Empleado obtener(@PathVariable long id) {
        return servicio.obtener(id);
    }
    
    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Empleado crear(@RequestBody Empleado empleado) {
        return servicio.guardar(empleado);
    }

    @RequestMapping(value = "/modificar/{id}", method = RequestMethod.PATCH)
    public Empleado actualizar(@RequestBody Empleado empleado) {
        return servicio.guardar(empleado);
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable long id) {
        return servicio.eliminar(id);
    }    

}

    
