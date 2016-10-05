package modelo;

public class Ciudad{
	private int ID_CIUDAD;
	private String NOMBRE_CIUDAD;
	private int ID_PAIS;
	private int VALOR_CIUDAD;
	
	
	
	public Ciudad(int iD_CIUDAD, String nOMBRE_CIUDAD, int iD_PAIS, int vALOR_CIUDAD) {
		ID_CIUDAD = iD_CIUDAD;
		NOMBRE_CIUDAD = nOMBRE_CIUDAD;
		ID_PAIS = iD_PAIS;
		VALOR_CIUDAD = vALOR_CIUDAD;
	}

	public int getID_CIUDAD() {
		return ID_CIUDAD;
	}

	public void setID_CIUDAD(int iD_CIUDAD) {
		ID_CIUDAD = iD_CIUDAD;
	}

	public String getNOMBRE_CIUDAD() {
		return NOMBRE_CIUDAD;
	}

	public void setNOMBRE_CIUDAD(String nOMBRE_CIUDAD) {
		NOMBRE_CIUDAD = nOMBRE_CIUDAD;
	}

	public int getID_PAIS() {
		return ID_PAIS;
	}

	public void setID_PAIS(int iD_PAIS) {
		ID_PAIS = iD_PAIS;
	}

	public int getVALOR_CIUDAD() {
		return VALOR_CIUDAD;
	}

	public void setVALOR_CIUDAD(int vALOR_CIUDAD) {
		VALOR_CIUDAD = vALOR_CIUDAD;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Ciudad){
			return ((Ciudad)obj).ID_CIUDAD==this.ID_CIUDAD;
		}
		return false;
	}

}
