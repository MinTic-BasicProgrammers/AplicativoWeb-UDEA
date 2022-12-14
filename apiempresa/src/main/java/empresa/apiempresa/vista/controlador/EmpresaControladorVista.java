package empresa.apiempresa.vista.controlador;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import empresa.apiempresa.modelo.Empresa;
import empresa.apiempresa.modelo.Usuario;
import empresa.apiempresa.util.Login;
import empresa.apiempresa.vista.servicio.EmpresaServicioVista;
import empresa.apiempresa.vista.servicio.PaisServicioVista;

@Controller
@RequestMapping("/empresa")
public class EmpresaControladorVista {

    @Autowired
    EmpresaServicioVista servicioEmpresa;
    @Autowired
    PaisServicioVista servicioPais;

    @GetMapping("/listar/{pagina}/{tamaño}")
    public String listar(@PathVariable int pagina, @PathVariable int tamaño,
            Model modelo, HttpSession sesion) {
        Usuario usuario = (Usuario) sesion.getAttribute("usuario");
        if (usuario != null) {
            Page<Empresa> paginaActual = servicioEmpresa.listarPagina(PageRequest.of(pagina - 1, tamaño), usuario);

            modelo.addAttribute("paginaActual", paginaActual);
            List<Integer> numerosPaginas = IntStream.rangeClosed(1, paginaActual.getTotalPages())
                    .boxed()
                    .collect(Collectors.toList());

            modelo.addAttribute("numerosPaginas", numerosPaginas);
            modelo.addAttribute("plantilla", "empresa");
            sesion.setAttribute("numeroPaginaActual", paginaActual.getNumber() + 1);
        } else {
            modelo.addAttribute("plantilla", "presentacion");
            modelo.addAttribute("mensajeerror", "usuario no logueado");
        }
        modelo.addAttribute("menu", InicioControladorVista.generarMenu());
        modelo.addAttribute("empresaeditada", new Empresa());
        modelo.addAttribute("login", new Login());
        return "inicio";
    }

    @GetMapping("/buscar")
    public String buscar(String dato, Model modelo, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario != null) {
            if (dato.isEmpty()) {
                servicioEmpresa.listar(usuario);
            } else {
                servicioEmpresa.buscar(dato, usuario);
            }

            Page<Empresa> paginaActual = servicioEmpresa
                    .listarPagina(PageRequest.of(1, InicioControladorVista.TAMAÑO_PAGINA), usuario);

            modelo.addAttribute("paginaActual", paginaActual);
            session.setAttribute("numeroPaginaActual", paginaActual.getNumber() + 1);

            int totalPaginas = paginaActual.getTotalPages();
            if (totalPaginas > 0) {
                List<Integer> numerosPaginas = IntStream.rangeClosed(1, totalPaginas)
                        .boxed()
                        .collect(Collectors.toList());
                modelo.addAttribute("numerosPaginas", numerosPaginas);
            }
        }
        modelo.addAttribute("empresaeditada", new Empresa());
        return "empresa";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable long id, Model modelo, HttpSession sesion) {
        Usuario usuario = (Usuario) sesion.getAttribute("usuario");
        servicioPais.listar(usuario);
        Empresa empresa = new Empresa();
        if (id > 0) {
            empresa = servicioEmpresa.obtener(id, usuario);
        }

        modelo.addAttribute("listapaises", servicioPais.getLista());
        modelo.addAttribute("empresaeditada", empresa);
        return "empresaeditar";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("empresaeditada") Empresa empresa, HttpSession sesion) {
        Usuario usuario = (Usuario) sesion.getAttribute("usuario");
        empresa = servicioEmpresa.guardar(empresa, usuario);
        servicioEmpresa.listar(usuario);
        int pagina = servicioEmpresa.encontrarPagina(empresa.getId(),
                InicioControladorVista.TAMAÑO_PAGINA);

        String ruta = "redirect:/empresa/listar/" + pagina + "/" + InicioControladorVista.TAMAÑO_PAGINA;
        return ruta;
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable long id, Model modelo, HttpSession sesion,
            RedirectAttributes redirectAttributes) {
        Usuario usuario = (Usuario) sesion.getAttribute("usuario");
        if (servicioEmpresa.eliminar(id, usuario)) {
            servicioEmpresa.listar(usuario);
        } else {
            redirectAttributes.addFlashAttribute("mensajeerror", "No se pudo eliminar la Empresa");
        }
        int pagina = (int) sesion.getAttribute("numeroPaginaActual");
        String ruta = "redirect:/empresa/listar/" + pagina + "/" + InicioControladorVista.TAMAÑO_PAGINA;
        return ruta;
    }

}
