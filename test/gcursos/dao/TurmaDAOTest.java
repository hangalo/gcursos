/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcursos.dao;

import gcursos.modelo.Turma;
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
        System.out.println("save");
        Turma turma = new Turma();
        TurmaDAO instance = new TurmaDAO();
        turma.setIdTurma(1);
        turma.setTurma("A");

        turma.setIdTurma(2);
        turma.setTurma("B");

        turma.setIdTurma(3);
        turma.setTurma("C");
        turma.setIdTurma(4);
        turma.setTurma("D");

        instance.save(turma);

    }

    /**
     * Test of update method, of class TurmaDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Turma turma = new Turma();
        TurmaDAO instance = new TurmaDAO();
        turma.setIdTurma(2);
        turma.setTurma("JP");
        instance.update(turma);

    }

    /**
     * Test of delete method, of class TurmaDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Turma turma = new Turma();
        TurmaDAO instance = new TurmaDAO();
        turma.setIdTurma(4);
        instance.delete(turma);

    }

    /**
     * Test of findById method, of class TurmaDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Turma turma = new Turma();

        Integer id = 2;
        TurmaDAO instance = new TurmaDAO();
       
        Turma result = instance.findById(id);

      

    }

    /**
     * Test of findAll method, of class TurmaDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        TurmaDAO instance = new TurmaDAO();

        List<Turma> result = instance.findAll();
        assertTrue(result.size() > 0);

    }

}
