package controlador;

import java.util.List;

import modelo.CiudadDAO;

public class ConsultaEspecialControler {
	private List<String[]> consulta;
	private CiudadDAO ciudadDAO;

	public ConsultaEspecialControler() {
		ciudadDAO=new CiudadDAO();
		consulta=ciudadDAO.consultaTarea2();
	}
	
	public List<String[]> getConsulta() {
		return consulta;
	}
	
	
}
