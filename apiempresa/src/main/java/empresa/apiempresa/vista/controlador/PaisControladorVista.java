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

import empresa.apiempresa.modelo.*;
import empresa.apiempresa.modelo.Usuario;
import empresa.apiempresa.util.Login;
import empresa.apiempresa.vista.servicio.PaisServicioVista;

@Controller
@RequestMapping("/transaccion")
public class PaisControladorVista {

    @Autowired
    PaisServicioVista servicioTransaccion;

    @GetMapping("/listar/{pagina}/{tamaño}")
    public String listar(@PathVariable int pagina, @PathVariable int tamaño,
            Model modelo, HttpSession sesion) {
        Usuario usuario = (Usuario) sesion.getAttribute("usuario");
        if (usuario != null) {
            Page<Transaccion> paginaActual = servicioTransaccion.listarPagina(PageRequest.of(pagina - 1, tamaño), usuario);

            modelo.addAttribute("paginaActual", paginaActual);
            List<Integer> numerosPaginas = IntStream.rangeClosed(1, paginaActual.getTotalPages())
                    .boxed()
                    .collect(Collectors.toList());

            modelo.addAttribute("numerosPaginas", numerosPaginas);
            modelo.addAttribute("plantilla", "transaccion");
            sesion.setAttribute("numeroPaginaActual", paginaActual.getNumber() + 1);
        } else {
            modelo.addAttribute("plantilla", "presentacion");
            modelo.addAttribute("mensajeerror", "usuario no logueado");
        }
        modelo.addAttribute("menu", InicioControladorVista.generarMenu());
        modelo.addAttribute("transaccioneditado", new Transaccion());
        modelo.addAttribute("login", new Login());
        return "inicio";
    }

    @GetMapping("/buscar")
    public String buscar(String dato, Model modelo, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario != null) {
            if (dato.isEmpty()) {
                servicioTransaccion.listar(usuario);
            } else {
                servicioTransaccion.buscar(dato, usuario);
            }

            Page<Transaccion> paginaActual = servicioTransaccion
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
        modelo.addAttribute("transaccioneditado", new Transaccion());
        return "transaccion";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable long id, Model modelo, HttpSession sesion) {
        Usuario usuario = (Usuario) sesion.getAttribute("usuario");
        servicioTransaccion.listar(usuario);
        Transaccion transaccion = new Transaccion();
        if (id > 0) {
            transaccion = servicioTransaccion.obtener(id, usuario);
        }

        modelo.addAttribute("transaccioneditado", transaccion);
        return "transaccioneditar";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("transaccioneditado") Transaccion transaccion, HttpSession sesion) {
        Usuario usuario = (Usuario) sesion.getAttribute("usuario");
        transaccion = servicioTransaccion.guardar(transaccion, usuario);
        servicioTransaccion.listar(usuario);
        int pagina = servicioTransaccion.encontrarPagina(transaccion.getId(),
                InicioControladorVista.TAMAÑO_PAGINA);

        String ruta = "redirect:/transaccion/listar/" + pagina + "/" + InicioControladorVista.TAMAÑO_PAGINA;
        return ruta;
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable long id, Model modelo, HttpSession sesion,
            RedirectAttributes redirectAttributes) {
        Usuario usuario = (Usuario) sesion.getAttribute("usuario");
        if (servicioTransaccion.eliminar(id, usuario)) {
            servicioTransaccion.listar(usuario);
        } else {
            redirectAttributes.addFlashAttribute("mensajeerror", "No se pudo eliminar el Transaccion");
        }
        int pagina = (int) sesion.getAttribute("numeroPaginaActual");
        String ruta = "redirect:/transaccion/listar/" + pagina + "/" + InicioControladorVista.TAMAÑO_PAGINA;
        return ruta;
    }

}
