package controlador;

import java.util.List;

import modelo.Ciudad;
import modelo.CiudadDAO;
import modelo.SedeJJOO;
import modelo.SedeJJOODAO;
import modelo.TipoJJOO;
import modelo.TipoJJOODAO;

public class ListarSedesControler {
	private SedeJJOODAO sedesDAO;
	private CiudadDAO ciudadDAO;
	private TipoJJOODAO tipoJJOODAO;
	
	public ListarSedesControler() {
		sedesDAO=new SedeJJOODAO();
		ciudadDAO=new CiudadDAO();
		tipoJJOODAO=new TipoJJOODAO();
	}
	
	public List<SedeJJOO> allSedes(){
		return sedesDAO.listAll();		
	}
	
	public Ciudad getCiudadById(int id){
		return ciudadDAO.read(id);
	}
	
	public TipoJJOO getTipoJJOOById(int id){
		return tipoJJOODAO.read(id);
	}

	public void delete(SedeJJOO sedeJJOO) {
		sedesDAO.delete(sedeJJOO);;
		
	}
}
