package empresa.apiempresa.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import empresa.apiempresa.modelo.*;
import empresa.apiempresa.servicio.*;

@RestController
@RequestMapping("/empresas")
public class EmpresaControlador {

    @Autowired
    private EmpresaServicio servicio;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Empresa> listar() {
        return servicio.listar();
    }

    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Empresa obtener(@PathVariable long id) {
        return servicio.obtener(id);
    }
    
    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Empresa crear(@RequestBody Empresa empresa) {
        return servicio.guardar(empresa);
    }

    @RequestMapping(value = "/modificar/{id}", method = RequestMethod.PATCH)
    public Empresa actualizar(@RequestBody Empresa empresa) {
        return servicio.guardar(empresa);
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable long id) {
        return servicio.eliminar(id);
    }

}
