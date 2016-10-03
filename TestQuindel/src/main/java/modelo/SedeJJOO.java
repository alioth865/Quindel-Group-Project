package modelo;

public class SedeJJOO {
	private int AÑO;
	private int ID_TIPO_JJOO;
	private int SEDE;
	public SedeJJOO(int aÑO, int iD_TIPO_JJOO, int sEDE) {
		super();
		AÑO = aÑO;
		ID_TIPO_JJOO = iD_TIPO_JJOO;
		SEDE = sEDE;
	}
	public int getAÑO() {
		return AÑO;
	}
	public void setAÑO(int aÑO) {
		AÑO = aÑO;
	}
	public int getID_TIPO_JJOO() {
		return ID_TIPO_JJOO;
	}
	public void setID_TIPO_JJOO(int iD_TIPO_JJOO) {
		ID_TIPO_JJOO = iD_TIPO_JJOO;
	}
	public int getSEDE() {
		return SEDE;
	}
	public void setSEDE(int sEDE) {
		SEDE = sEDE;
	}
	
}
