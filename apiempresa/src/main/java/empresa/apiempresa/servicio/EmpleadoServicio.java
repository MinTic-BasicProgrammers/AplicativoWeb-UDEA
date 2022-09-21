package empresa.apiempresa.servicio;

import java.util.List;

import empresa.apiempresa.modelo.*;


public interface EmpleadoServicio {

	public List<Empleado> listar(); //Permite ver todos los empleados
	
	public Empleado obtener(Long id); // Obtiene los datos de un solo empleado

	public Empleado guardar(Empleado empleado); //Permite agregar y modificar informacion del Empelado

	public boolean eliminar(Long id); //Eliminar el usuario
	
	public List<Empleado> buscar(String email);

}