package empresa.apiempresa.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import empresa.apiempresa.repositorio.PefilRepositorio;
import empresa.apiempresa.modelo.*;

@RestController
@RequestMapping("/perfiles")
public class PerfilControlador {
    @Autowired // crea una clase implementacion de empresa repositorio con los metodos que
    // automaticamente ya tioene en el JPArepositorio
    private PefilRepositorio repositorio;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Perfil> listar() {
        return repositorio.findAll();
    }

    @RequestMapping(value = "/obtener/{empresa}", method = RequestMethod.GET)
    public Perfil obtener(@PathVariable long empresa) {
        return repositorio.findById(empresa).get();
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Perfil crear(@RequestBody Perfil perfil) {
        return repositorio.save(perfil);
    }

    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public Perfil actualizar(@RequestBody Perfil perfil) {
        return repositorio.save(perfil);
    }

    /*
     * @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET)
     * public void eliminar(@PathVariable long id) {
     * repositorio.deleteById(id);
     * }
     */

}
