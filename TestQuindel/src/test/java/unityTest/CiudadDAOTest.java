package unityTest;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import modelo.Ciudad;
import modelo.CiudadDAO;

public class CiudadDAOTest extends TestCase {
	CiudadDAO ciudadDAO=new CiudadDAO();
	Ciudad c;
	
	@Before
	protected void setUp() throws Exception {
		c=new Ciudad(25, "Cantabria", 1, 25);
		
	}
	
	@Test
	public void testCreate(){
		ciudadDAO.create(c);
		Ciudad c1=ciudadDAO.read(c.getID_CIUDAD());
		assertNotNull(c1);
		assertEquals(c1.getID_CIUDAD(), c.getID_CIUDAD());
		ciudadDAO.delete(c);
	}
	
	@Test
	public void testDelete(){
		ciudadDAO.create(c);
		Ciudad c1=ciudadDAO.read(c.getID_CIUDAD());
		assertNotNull(c1);
		ciudadDAO.delete(c);
		assertNull(ciudadDAO.read(c.getID_CIUDAD()));
	}
	
	@Test
	public void testUpdate(){
		ciudadDAO.create(c);
		c.setNOMBRE_CIUDAD("Tenerife");
		ciudadDAO.update(c);
		Ciudad c1=ciudadDAO.read(c.getID_CIUDAD());
		assertEquals(c1.getNOMBRE_CIUDAD(), "Tenerife");
		ciudadDAO.delete(c);
	}
	
	@Test
	public void testRead(){
		ciudadDAO.create(c);
		Ciudad c1=ciudadDAO.read(c.getID_CIUDAD());
		assertEquals(c1.getID_CIUDAD(), 25);
		assertEquals(c1.getNOMBRE_CIUDAD(), "Cantabria");
		assertEquals(c1.getID_PAIS(), 1);
		assertEquals(c1.getVALOR_CIUDAD(), 25);	
		ciudadDAO.delete(c);
	}
	
	@Test 
	public void testListar(){
		List<Ciudad> ciudades=ciudadDAO.listAll();
		assertEquals(13, ciudades.size());
	}
	
	@Test 
	public void testConsultaTarea2(){
		List<String[]> consulta=ciudadDAO.consultaTarea2();
		assertEquals(13, consulta.size());
	}
	
	

}
