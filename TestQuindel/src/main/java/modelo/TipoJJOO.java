package modelo;

public class TipoJJOO {
	private int ID_TIPO_JJOO;
	private String DESCRIPCION_TIPO;
	public TipoJJOO(int iD_TIPO_JJOO, String dESCRIPCION_TIPO) {
		super();
		ID_TIPO_JJOO = iD_TIPO_JJOO;
		DESCRIPCION_TIPO = dESCRIPCION_TIPO;
	}
	public int getID_TIPO_JJOO() {
		return ID_TIPO_JJOO;
	}
	public void setID_TIPO_JJOO(int iD_TIPO_JJOO) {
		ID_TIPO_JJOO = iD_TIPO_JJOO;
	}
	public String getDESCRIPCION_TIPO() {
		return DESCRIPCION_TIPO;
	}
	public void setDESCRIPCION_TIPO(String dESCRIPCION_TIPO) {
		DESCRIPCION_TIPO = dESCRIPCION_TIPO;
	}
	
}
