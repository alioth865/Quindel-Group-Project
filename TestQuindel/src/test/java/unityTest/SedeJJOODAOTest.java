package unityTest;


import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import modelo.SedeJJOO;
import modelo.SedeJJOODAO;

public class SedeJJOODAOTest extends TestCase {

	SedeJJOODAO sedeJJOODAO=new SedeJJOODAO();
	SedeJJOO sedeJ;
	
	@Before
	protected void setUp() throws Exception {
		sedeJ=new SedeJJOO(2020, 2, 12);
		
	}
	
	@Test
	public void testCreate(){
		sedeJJOODAO.create(sedeJ);
		SedeJJOO sedeJ1=sedeJJOODAO.read(sedeJ.getAÑO(), sedeJ.getID_TIPO_JJOO());
		assertNotNull(sedeJ1);
		assertEquals(sedeJ1.getAÑO(), sedeJ.getAÑO());
		sedeJJOODAO.delete(sedeJ);
	}
	
	@Test
	public void testDelete(){
		sedeJJOODAO.create(sedeJ);
		SedeJJOO sedeJ1=sedeJJOODAO.read(sedeJ.getAÑO(),sedeJ.getID_TIPO_JJOO());
		assertNotNull(sedeJ1);
		sedeJJOODAO.delete(sedeJ);
		assertNull(sedeJJOODAO.read(sedeJ.getAÑO(),sedeJ.getID_TIPO_JJOO()));
	}
	
	@Test
	public void testUpdate(){
		sedeJJOODAO.create(sedeJ);
		sedeJ.setSEDE(3);
		sedeJJOODAO.update(sedeJ);
		SedeJJOO sedeJ1=sedeJJOODAO.read(sedeJ.getAÑO(),sedeJ.getID_TIPO_JJOO());
		assertEquals(sedeJ1.getSEDE(), 3);
		sedeJJOODAO.delete(sedeJ);
	}
	
	@Test
	public void testRead(){
		sedeJJOODAO.create(sedeJ);
		SedeJJOO sedeJ1=sedeJJOODAO.read(sedeJ.getAÑO(),sedeJ.getID_TIPO_JJOO());
		assertEquals(sedeJ1.getAÑO(), 2020);
		assertEquals(sedeJ1.getID_TIPO_JJOO(), 2);
		assertEquals(sedeJ1.getSEDE(), 12);	
		sedeJJOODAO.delete(sedeJ);
	}
	
	@Test 
	public void testListar(){
		List<SedeJJOO> sedes=sedeJJOODAO.listAll();
		assertEquals(6, sedes.size());
	}

}
