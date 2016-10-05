package unityTest;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import modelo.TipoJJOO;
import modelo.TipoJJOODAO;

public class TipoJJOODAOTest extends TestCase {

	TipoJJOODAO tipoJJOODAO=new TipoJJOODAO();
	TipoJJOO tipoJ;
	
	@Before
	protected void setUp() throws Exception {
		tipoJ=new TipoJJOO(3, "JUVENTUD");
		
	}
	
	@Test
	public void testCreate(){
		tipoJJOODAO.create(tipoJ);
		TipoJJOO tipoJ1=tipoJJOODAO.read(tipoJ.getID_TIPO_JJOO());
		assertNotNull(tipoJ1);
		assertEquals(tipoJ1.getID_TIPO_JJOO(), tipoJ.getID_TIPO_JJOO());
		tipoJJOODAO.delete(tipoJ);
	}
	
	@Test
	public void testDelete(){
		tipoJJOODAO.create(tipoJ);
		TipoJJOO tipoJ1=tipoJJOODAO.read(tipoJ.getID_TIPO_JJOO());
		assertNotNull(tipoJ1);
		tipoJJOODAO.delete(tipoJ);
		assertNull(tipoJJOODAO.read(tipoJ.getID_TIPO_JJOO()));
	}
	
	@Test
	public void testUpdate(){
		tipoJJOODAO.create(tipoJ);
		tipoJ.setDESCRIPCION_TIPO("PARALIMPICOS");
		tipoJJOODAO.update(tipoJ);
		TipoJJOO tipoJ1=tipoJJOODAO.read(tipoJ.getID_TIPO_JJOO());
		assertEquals(tipoJ1.getDESCRIPCION_TIPO(), "PARALIMPICOS");
		tipoJJOODAO.delete(tipoJ);
	}
	
	@Test
	public void testRead(){
		tipoJJOODAO.create(tipoJ);
		TipoJJOO tipoJ1=tipoJJOODAO.read(tipoJ.getID_TIPO_JJOO());
		assertEquals(tipoJ1.getDESCRIPCION_TIPO(),"JUVENTUD");
		assertEquals(tipoJ1.getID_TIPO_JJOO(), 3);
		tipoJJOODAO.delete(tipoJ);
	}
	
	@Test 
	public void testListar(){
		List<TipoJJOO> tipos=tipoJJOODAO.listAll();
		assertEquals(2, tipos.size());
	}

}