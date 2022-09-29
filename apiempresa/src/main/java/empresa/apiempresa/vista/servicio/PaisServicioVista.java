package empresa.apiempresa.vista.servicio;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import empresa.apiempresa.modelo.*;

@Service
public class PaisServicioVista {
    
    private String urlBase = "http://localhost:8080/transacciones";
    //private String urlBase = "https://tiendavideomintic.herokuapp.com/transacciones";

    private List<Transaccion> transacciones;

    public List<Transaccion> getLista(){
        return transacciones;
    }

    private HttpHeaders obtenerHeader(Usuario usuario) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", usuario.getToken());
        return headers;
    }

    public void listar(Usuario usuario) {
        String url = urlBase + "/listar";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = obtenerHeader(usuario);
        HttpEntity<String> request = new HttpEntity<String>(headers);

        ResponseEntity<Transaccion[]> response = restTemplate.exchange(url, HttpMethod.GET, request, Transaccion[].class);
        transacciones = Arrays.asList(response.getBody());
    }

    public Page<Transaccion> listarPagina(Pageable pageable, Usuario usuario) {
        if (transacciones == null) {
            listar(usuario);
        }
        int tamañoPagina = pageable.getPageSize();
        int paginaActual = pageable.getPageNumber();
        int posicionInicial = tamañoPagina * paginaActual;
        List<Transaccion> lista;
        if (transacciones.size() < posicionInicial) {
            lista = Collections.emptyList();
        } else {
            int posicionFinal = Math.min(posicionInicial + tamañoPagina, transacciones.size());
            lista = transacciones.subList(posicionInicial, posicionFinal);
        }

        Page<Transaccion> transaccionesPage = new PageImpl<Transaccion>(lista, PageRequest.of(paginaActual, tamañoPagina),
                transacciones.size());
        return transaccionesPage;
    }

    public void buscar(String dato, Usuario usuario) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = obtenerHeader(usuario);

        HttpEntity<String> request = new HttpEntity<String>(headers);

        String urlT = urlBase + "/buscar/" + dato;
        ResponseEntity<Transaccion[]> response = restTemplate.exchange(urlT, HttpMethod.GET, request, Transaccion[].class);

        transacciones = Arrays.asList(response.getBody());
    }

    public Transaccion guardar(Transaccion empresa, Usuario usuario) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = obtenerHeader(usuario);

        HttpEntity<Transaccion> request = new HttpEntity<Transaccion>(empresa, headers);

        ResponseEntity<Transaccion> response;
        String url;
        if (empresa.getId() == 0) {
            url = urlBase + "/agregar";
            response = restTemplate.exchange(url, HttpMethod.POST, request, Transaccion.class);
        } else {
            url = urlBase + "/modificar";
            response = restTemplate.exchange(url, HttpMethod.PUT, request, Transaccion.class);
        }
        return response.getBody();

    }

    public int encontrarPagina(long id, int tamañoPagina) {
        int indice = IntStream.range(0, transacciones.size())
                .filter(i -> transacciones.get(i).getId() == id)
                .findFirst()
                .orElse(-1);

        int pagina = (int) (indice / tamañoPagina) + 1;
        return pagina;
    }

    public Transaccion obtener(long id, Usuario usuario) {
        String url = urlBase + "/obtener/" + id;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = obtenerHeader(usuario);
        HttpEntity<String> request = new HttpEntity<String>(headers);

        ResponseEntity<Transaccion> response = restTemplate.exchange(url, HttpMethod.GET, request, Transaccion.class);
        return response.getBody();
    }

    public boolean eliminar(long id, Usuario usuario) {
        String url = urlBase + "/eliminar/" + id;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = obtenerHeader(usuario);
        HttpEntity<String> request = new HttpEntity<String>(headers);

        try{
            ResponseEntity<Boolean> response = restTemplate.exchange(url, HttpMethod.DELETE, request, Boolean.class);
            return response.getBody();
        }
        catch(Exception ex){
            return false;
        }
    }


    

}
