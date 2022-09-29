package empresa.apiempresa.servicio;

import java.util.List;

import empresa.apiempresa.modelo.*;

public interface TransaccionServicio {

    public List<Transaccion> listar(); //Permite ver todos los empleados
	
	public Transaccion obtener(Long id); // Obtiene los datos de una sola transaccion

	public Transaccion guardar(Transaccion transaccion); //Permite agregar y modificar informacion del Empelado

	public boolean eliminar(Long empresa); //Eliminar el usuario

	public List<Transaccion> buscar(Long Empresa);
    
}
