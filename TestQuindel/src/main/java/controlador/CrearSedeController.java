package controlador;

import java.util.List;

import modelo.Ciudad;
import modelo.CiudadDAO;
import modelo.SedeJJOO;
import modelo.SedeJJOODAO;
import modelo.TipoJJOO;
import modelo.TipoJJOODAO;

public class CrearSedeController {
	private SedeJJOODAO sedeJJOODAO;
	private TipoJJOODAO tipoJJOODAO;
	private CiudadDAO ciudadDAO;
	
	public CrearSedeController() {
		this.sedeJJOODAO = new SedeJJOODAO();
		this.tipoJJOODAO = new TipoJJOODAO();
		this.ciudadDAO=new CiudadDAO();
	}
	
	public void crearSede(SedeJJOO sedeJJOO){
		sedeJJOODAO.create(sedeJJOO);
	}
	
	public List<TipoJJOO> todosTiposJJOO(){
		return tipoJJOODAO.listAll();
	}
	
	public List<Ciudad> todasCiudad(){
		return ciudadDAO.listAll();
	}
	
}
