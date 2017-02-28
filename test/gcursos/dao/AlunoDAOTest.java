package gcursos.dao;

import gcursos.excepcao.GCursoException;
import gcursos.modelo.Aluno;
import gcursos.modelo.Sexo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * @author CHANDIMBA
 */
public class AlunoDAOTest {
    
    private SimpleDateFormat formatadorDeData;
    private AlunoDAO alunoDAO;
    
    @Before
    public void setUp() {
        formatadorDeData = new SimpleDateFormat("yyyy-MM-dd");
        alunoDAO = new AlunoDAO();
    }
    
    @Test
    public void inserirAluno() throws ParseException {
        Aluno aluno = new Aluno();
        
        aluno.setPrimeiroNome("Francisco");
        aluno.setSegundoNome("");
        aluno.setSobrenome("Capita");
        aluno.setDataNascimento(formatadorDeData.parse("1990-05-05"));
        aluno.setSexo(Sexo.MASCULINO);
        aluno.setEmail("ciscocapita@yahoo.com");
        aluno.setFacebook("https://www.facebook.com/cisco.capita");
        aluno.setTelefoneFixo("222000003");
        aluno.setTelefoneUnitel("921000003");
        aluno.setTelefoneMovicel("918652437");
       // aluno.setFoto("foto/ciscocapita.png");
        
        assertTrue("INSERT: O aluno não pode ser nulo", aluno != null);
        
        alunoDAO.save(aluno);
        System.out.println("Aluno salvo com sucesso");
    }
    
    @Test
    public void actualizarAluno() throws ParseException {
        alunoDAO = new AlunoDAO();
        Aluno aluno = alunoDAO.findById(1);
        
        assertTrue("UPDATE: O aluno não pode ser nulo", aluno != null);
        
        aluno.setPrimeiroNome("Nelson");
        aluno.setSegundoNome("Chandimba");
        aluno.setSobrenome("da Silva");
        aluno.setDataNascimento(formatadorDeData.parse("1986-12-16"));
        aluno.setSexo(Sexo.MASCULINO);
        aluno.setEmail("dismao16@gmail.com");
        aluno.setFacebook("https://www.facebook.com/Nelson.Chandimba.da.Silva");
        aluno.setTelefoneFixo("222000001");
        aluno.setTelefoneUnitel("945263402");
        aluno.setTelefoneMovicel("995355983");
     //   aluno.setFoto("foto/chandimba.png");
        
        alunoDAO.update(aluno);
        System.out.println("Aluno actualizado com sucesso!!!");
    }
    
    @Test
    public void buscarTodos() throws ParseException {
        alunoDAO = new AlunoDAO();
        List<Aluno> alunos = alunoDAO.findAll();
        
        assertTrue(alunos != null);
        
        alunos.forEach(System.out::println);
    }
    
    @Test
    public void excluirAluno() throws ParseException {
        alunoDAO = new AlunoDAO();
        Aluno aluno = alunoDAO.findById(2);
        
        assertTrue("DELETE: O aluno não pode ser nulo", aluno != null);
        
        alunoDAO.delete(aluno);
        System.out.println("Aluno com id " + aluno.getId() + " excluido com sucesso!!!");
        
    }
    
}
