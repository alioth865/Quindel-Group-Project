package modelo;

public class Pais {
	private int ID_PAIS;
	private String NOMBRE_PAIS;
	private String CODIGO_PAIS;
	private int VALOR_PAIS;
	public Pais(int iD_PAIS, String nOMBRE_PAIS, String cODIGO_PAIS, int vALOR_PAIS) {
		super();
		ID_PAIS = iD_PAIS;
		NOMBRE_PAIS = nOMBRE_PAIS;
		CODIGO_PAIS = cODIGO_PAIS;
		VALOR_PAIS = vALOR_PAIS;
	}
	public int getID_PAIS() {
		return ID_PAIS;
	}
	public void setID_PAIS(int iD_PAIS) {
		ID_PAIS = iD_PAIS;
	}
	public String getNOMBRE_PAIS() {
		return NOMBRE_PAIS;
	}
	public void setNOMBRE_PAIS(String nOMBRE_PAIS) {
		NOMBRE_PAIS = nOMBRE_PAIS;
	}
	public String getCODIGO_PAIS() {
		return CODIGO_PAIS;
	}
	public void setCODIGO_PAIS(String cODIGO_PAIS) {
		CODIGO_PAIS = cODIGO_PAIS;
	}
	public int getVALOR_PAIS() {
		return VALOR_PAIS;
	}
	public void setVALOR_PAIS(int vALOR_PAIS) {
		VALOR_PAIS = vALOR_PAIS;
	}
	
}
