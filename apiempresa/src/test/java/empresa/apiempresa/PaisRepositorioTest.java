package empresa.apiempresa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import empresa.apiempresa.modelo.*;
import empresa.apiempresa.repositorio.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PaisRepositorioTest {

    @Autowired
    private TransaccionRepositorio repositorio;

    private Transaccion generarTransaccion() {
        Transaccion transaccion = new Transaccion();
        transaccion.setConcepto("compra");
        transaccion.setMonto(50000);
        return transaccion;
    }

    @Test
    public void testFindbyId() {
        Transaccion transaccion = generarTransaccion();
        transaccion = repositorio.save(transaccion);

        Transaccion resultado = repositorio.findById(transaccion.getId()).get();

        assertEquals(transaccion.getId(), resultado.getId());
        repositorio.deleteById(transaccion.getId());
    }

}
