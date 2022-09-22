package empresa.apiempresa.servicio;

import java.util.List;

import empresa.apiempresa.modelo.*;

public interface EmpresaServicio {

    public List<Empresa> listar(); //Permite ver todos los empleados
	
	public Empresa obtener(Long id); // Obtiene los datos de un solo empleado

	public Empresa guardar(Empresa empresa); //Permite agregar y modificar informacion del Empelado

	public boolean eliminar(Long id); //Eliminar el usuario
    
}
