package empresa.apiempresa.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import empresa.apiempresa.repositorio.EmpresaRepositorio;

import empresa.apiempresa.modelo.*;

@RestController
@RequestMapping("/empresas")
public class EmpresaControlador {
    @Autowired // crea una clase implementacion de empresa repositorio con los metodos que
    // automaticamente ya tioene en el JPArepositorio
    private EmpresaRepositorio repositorio;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Empresa> listar() {
        return repositorio.findAll();
    }

    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Empresa obtener(@PathVariable long id) {
        return repositorio.findById(id).get();
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Empresa crear(@RequestBody Empresa empresa) {
        return repositorio.save(empresa);
    }

    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public Empresa actualizar(@RequestBody Empresa empresa) {
        return repositorio.save(empresa);
    }

    /*
     * @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET)
     * public void eliminar(@PathVariable long id) {
     * repositorio.deleteById(id);
     * }
     */

}
