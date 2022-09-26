package empresa.apiempresa.servicio;

import java.util.List;

import empresa.apiempresa.modelo.*;

public interface TransaccionServicio {

    public List<Transaccion> listar(); //Permite ver todos los empleados
	
	public Transaccion obtener(Long id); // Obtiene los datos de un solo empleado

	public Transaccion guardar(Transaccion transaccion); //Permite agregar y modificar informacion del Empelado

	public boolean eliminar(Long id); //Eliminar el usuario

	public List<Transaccion> buscar(long empresa);
    
}
