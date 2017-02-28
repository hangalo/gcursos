/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcursos.dao;

import gcursos.excepcao.GCursoException;
import gcursos.modelo.Turma;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class TurmaDAOTest {

    public TurmaDAOTest() {
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
     * Test of save method, of class TurmaDAO.
     */
    @Test
    public void testSave() {
        try {
            System.out.println("save");
            Turma turma = new Turma();
            TurmaDAO instance = new TurmaDAO();
            turma.setId(1);
            turma.setNome("A");
            
            turma.setId(2);
            turma.setNome("B");
            
            turma.setId(3);
            turma.setNome("C");
            turma.setId(4);
            turma.setNome("D");
            
            instance.save(turma);
        } catch (GCursoException ex) {
            Logger.getLogger(TurmaDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Test of update method, of class TurmaDAO.
     */
    @Test
    public void testUpdate() {
        try {
            System.out.println("update");
            Turma turma = new Turma();
            TurmaDAO instance = new TurmaDAO();
            turma.setId(2);
            turma.setNome("JP");
            instance.update(turma);
        } catch (GCursoException ex) {
            Logger.getLogger(TurmaDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Test of delete method, of class TurmaDAO.
     */
    @Test
    public void testDelete() {
        try {
            System.out.println("delete");
            Turma turma = new Turma();
            TurmaDAO instance = new TurmaDAO();
            turma.setId(4);
            instance.delete(turma);
        } catch (GCursoException ex) {
            Logger.getLogger(TurmaDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Test of findById method, of class TurmaDAO.
     */
    @Test
    public void testFindById() {
/*        System.out.println("findById");
        Turma turma = new Turma();

       turma.setIdTurma(3);
        TurmaDAO instance = new TurmaDAO();
       
        Turma result = instance.findById(turma);

      assertTrue(result!=null);
*/
    }

    /**
     * Test of findAll method, of class TurmaDAO.
     */
    @Test
    public void testFindAll() {
        try {
            System.out.println("findAll");
            TurmaDAO instance = new TurmaDAO();
            
            List<Turma> result = instance.findAll();
            assertTrue(result.size() > 0);
        } catch (GCursoException ex) {
            Logger.getLogger(TurmaDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
