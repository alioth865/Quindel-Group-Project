package unityTest;


import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import modelo.Pais;
import modelo.PaisDAO;

public class PaisDAOTest extends TestCase {

	PaisDAO paisDAO=new PaisDAO();
	Pais p;
	
	@Before
	protected void setUp() throws Exception {
		p=new Pais(25, "Cuba", "CU", 252);
		
	}
	
	@Test
	public void testCreate(){
		paisDAO.create(p);
		Pais p1=paisDAO.read(p.getID_PAIS());
		assertNotNull(p1);
		assertEquals(p1.getID_PAIS(), p.getID_PAIS());
		paisDAO.delete(p);
	}
	
	@Test
	public void testDelete(){
		paisDAO.create(p);
		Pais p1=paisDAO.read(p.getID_PAIS());
		assertNotNull(p1);
		paisDAO.delete(p);
		assertNull(paisDAO.read(p.getID_PAIS()));
	}
	
	@Test
	public void testUpdate(){
		paisDAO.create(p);
		p.setNOMBRE_PAIS("LA ESPAÑOLA");
		paisDAO.update(p);
		Pais p1=paisDAO.read(p.getID_PAIS());
		assertEquals(p1.getNOMBRE_PAIS(), "LA ESPAÑOLA");
		paisDAO.delete(p);
	}
	
	@Test
	public void testRead(){
		paisDAO.create(p);
		Pais p1=paisDAO.read(p.getID_PAIS());
		assertEquals(p1.getID_PAIS(), 25);
		assertEquals(p1.getNOMBRE_PAIS(), "Cuba");
		assertEquals(p1.getCODIGO_PAIS(), "CU");
		assertEquals(p1.getVALOR_PAIS(), 252);	
		paisDAO.delete(p);
	}
	
	@Test 
	public void testListar(){
		List<Pais> paises=paisDAO.listAll();
		assertEquals(4, paises.size());
	}

}
