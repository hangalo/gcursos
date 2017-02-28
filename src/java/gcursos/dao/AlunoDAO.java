package gcursos.dao;

import gcursos.modelo.Aluno;
import gcursos.modelo.Sexo;
import gcursos.util.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author informatica
 */
public class AlunoDAO implements GenericoDAO<Aluno> {

    private static final String INSERIR = "INSERT INTO aluno(primeiro_nome_aluno, segundo_nome_aluno, sobrenome_aluno, data_nascimento_aluno, sexo_aluno, telefone_fixo_aluno, telefone_unitel_aluno, telefone_movicel_aluno, email_aluno, facebook_aluno, foto_aluno) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String ACTUALIZAR = "UPDATE aluno SET primeiro_nome_aluno = ?, segundo_nome_aluno = ?, sobrenome_aluno = ?, data_nascimento_aluno = ?, sexo_aluno = ?, telefone_fixo_aluno = ?, telefone_unitel_aluno = ?, telefone_movicel_aluno = ?, email_aluno = ?, facebook_aluno = ?, foto_aluno = ? WHERE id_aluno = ?";
    private static final String ELIMINAR = "DELETE FROM aluno WHERE id_aluno = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT * FROM aluno WHERE id_aluno = ?";
    private static final String LISTAR_TUDO = "SELECT * FROM aluno";
    private static final String TOTAL_DE_ALUNOS = "SELECT count(*) as total FROM aluno";

    private Connection conn = null;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public void save(Aluno aluno) {
        addOrEditAluno(INSERIR, aluno);
    }

    @Override
    public void update(Aluno aluno){
        addOrEditAluno(ACTUALIZAR, aluno);
    }

    @Override
    public void delete(Aluno aluno){
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, aluno.getId());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public Aluno findById(Integer id) {
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            return rs.next() ? getAlunoFromResultSet(rs) : null;
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getMessage());
            return null;
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }

    }

    @Override
    public List<Aluno> findAll() {
        List<Aluno> alunos = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                alunos.add(getAlunoFromResultSet(rs));
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }

        return alunos;
    }

    public Integer count() {

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(TOTAL_DE_ALUNOS);
            
            rs = ps.executeQuery();
            return rs.next() ? rs.getInt("total") : 0;
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getMessage());
            return null;
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
    }

    private void addOrEditAluno(String SQL, Aluno aluno) {
        try {
            conn = Conexao.getConnection();

            ps = conn.prepareStatement(SQL);
            ps.setString(1, aluno.getPrimeiroNome());
            ps.setString(2, aluno.getSegundoNome());
            ps.setString(3, aluno.getSobrenome());
            ps.setDate(4, new Date(aluno.getDataNascimento().getTime()));
            ps.setString(5, aluno.getSexo().getAbreviatura());
            ps.setString(6, aluno.getTelefoneFixo());
            ps.setString(7, aluno.getTelefoneUnitel());
            ps.setString(8, aluno.getTelefoneMovicel());
            ps.setString(9, aluno.getEmail());
            ps.setString(10, aluno.getFacebook());
            ps.setString(10, aluno.getFacebook());
            ps.setString(11, aluno.getFoto());

            if (aluno.getId() > 0) {
                ps.setInt(12, aluno.getId());
            }

            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    private Aluno getAlunoFromResultSet(ResultSet resultSet) throws SQLException {
        Aluno aluno = new Aluno();
        aluno.setId(resultSet.getInt("id_aluno"));
        aluno.setPrimeiroNome(resultSet.getString("primeiro_nome_aluno"));
        aluno.setSegundoNome(resultSet.getString("segundo_nome_aluno"));
        aluno.setSobrenome(resultSet.getString("sobrenome_aluno"));
        aluno.setDataNascimento(resultSet.getDate("data_nascimento_aluno"));
        aluno.setSexo(Sexo.getAbreviatura(resultSet.getString("sexo_aluno")));
        aluno.setTelefoneFixo(resultSet.getString("telefone_fixo_aluno"));
        aluno.setTelefoneUnitel(resultSet.getString("telefone_unitel_aluno"));
        aluno.setTelefoneMovicel(resultSet.getString("telefone_movicel_aluno"));
        aluno.setEmail(resultSet.getString("email_aluno"));
        aluno.setFacebook(resultSet.getString("facebook_aluno"));
        aluno.setFoto(resultSet.getString("foto_aluno"));

        return aluno;
    }

    @Override
    public void popularComDados(Aluno t, ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}