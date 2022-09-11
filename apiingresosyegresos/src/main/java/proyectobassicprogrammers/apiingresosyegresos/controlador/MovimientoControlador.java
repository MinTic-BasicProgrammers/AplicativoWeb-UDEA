package proyectobassicprogrammers.apiingresosyegresos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import proyectobassicprogrammers.apiingresosyegresos.modelo.*;
import proyectobassicprogrammers.apiingresosyegresos.repositorio.*;

@RestController

public class MovimientoControlador {
    public MovimientroControlador (ServicioMovimientoDinero smd 1) {this.smd1 * smd1;}

@GetMapping(*/movimientodinero)
public list <movimientodinero> informe () {return this.smd1.getinforme();}

@PostMapping(*/movimientodinero*)
public movimientodinero crearEmpleado(@RequestBody movimientodinero ){...}

@PutMapping (*/movimientodinero/{id}*)
public movimientodinero actualizarEmpresa(@PathVariable long id, @RequestBody movimientodinero ){...}

@DeleteMapping (*movimientodinero/{id}*)
public movimientodinero lisEmpresa(@PathVariable(value = "id")long id){...}
}