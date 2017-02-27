/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcursos.dao;

import gcursos.modelo.CategoriaCurso;
import java.sql.ResultSet;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author informatica
 */
public class CategoriaCursoDAOTest {
    
    public CategoriaCursoDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of save method, of class CategoriaCursoDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        CategoriaCurso categoriaCurso = new CategoriaCurso();
        CategoriaCursoDAO instance = new CategoriaCursoDAO();
        categoriaCurso.setIdCategoriaCurso(1);
        categoriaCurso.setCategoriaCurso("A");
        categoriaCurso.setIdCategoriaCurso(2);
        categoriaCurso.setCategoriaCurso("B");
        categoriaCurso.setIdCategoriaCurso(3);
        categoriaCurso.setCategoriaCurso("C");
          categoriaCurso.setIdCategoriaCurso(4);
        categoriaCurso.setCategoriaCurso("D");
        
        instance.save(categoriaCurso);
       
    }

    /**
     * Test of update method, of class CategoriaCursoDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        CategoriaCurso categoriaCurso = new CategoriaCurso();
        CategoriaCursoDAO instance = new CategoriaCursoDAO();
        categoriaCurso.setIdCategoriaCurso(2);
        categoriaCurso.setCategoriaCurso("FD");
        instance.update(categoriaCurso);
      
    }

    /**
     * Test of delete method, of class CategoriaCursoDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        CategoriaCurso categoriaCurso = new CategoriaCurso();
        CategoriaCursoDAO instance = new CategoriaCursoDAO();
        categoriaCurso.setIdCategoriaCurso(4);
        instance.delete(categoriaCurso);
        
    }

    /**
     * Test of findById method, of class CategoriaCursoDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        CategoriaCurso categoriaCurso = new CategoriaCurso();
        CategoriaCursoDAO instance = new CategoriaCursoDAO();
        categoriaCurso.setIdCategoriaCurso(2);
        
        CategoriaCurso result = instance.findById(categoriaCurso);
        assertTrue(result!=null);
    
    }

    /**
     * Test of findAll method, of class CategoriaCursoDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        CategoriaCursoDAO instance = new CategoriaCursoDAO();
       
        List<CategoriaCurso> result = instance.findAll();
        assertTrue(result.size()>0);
      
    }

  
    
}
