package proyectobassicprogrammers.apiingresosyegresos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import proyectobassicprogrammers.apiingresosyegresos.modelo.*;
import proyectobassicprogrammers.apiingresosyegresos.repositorio.*;

@RestController
@RequestMapping("/empresas")
@CrossOrigin(origins = "*")
public class EmpresaControlador {
    @Autowired
    private EmpresaRepositorio repositorio;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Empresa> listar() {
        return repositorio.findAll();
    }

    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Empresa obtener(@PathVariable long id) {
        return repositorio.findById(id).get();
    }

    @RequestMapping(value = "/buscar/{nombre}", method = RequestMethod.GET)
    public List<Empresa> buscar(@PathVariable String nombre) {
        return repositorio.buscar(nombre);
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Empresa crearEmpresa(@RequestBody Empresa empresa) {
        return repositorio.save(empresa);
    }

    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public Empresa modificarEmpresa(@RequestBody Empresa empresa) {
        return repositorio.save(empresa);
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public void eliminarEmpresa(@PathVariable long id) {
        repositorio.eliminarEmpresa(id);
    }
    
}
