package empresa.apiempresa.servicio;

import java.util.List;

import empresa.apiempresa.modelo.*;


public interface EmpleadoServicio {

	public List<Empleado> listar();
	
	public Empleado obtener(Long id);

    public List<Empleado> buscar(String email);

	public Empleado guardar(Empleado empleado);

	public boolean eliminar(Long id);

}