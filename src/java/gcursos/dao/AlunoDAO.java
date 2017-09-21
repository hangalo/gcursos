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
public class AlunoDAO implements GenericoDAOLogico<Aluno> {

    private static final String INSERT = "INSERT INTO aluno(primeiro_nome_aluno, segundo_nome_aluno, sobrenome_aluno, data_nascimento_aluno, sexo_aluno, telefone_fixo_aluno, telefone_unitel_aluno, telefone_movicel_aluno, email_aluno, facebook_aluno, foto_aluno) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE aluno SET primeiro_nome_aluno = ?, segundo_nome_aluno = ?, sobrenome_aluno = ?, data_nascimento_aluno = ?, sexo_aluno = ?, telefone_fixo_aluno = ?, telefone_unitel_aluno = ?, telefone_movicel_aluno = ?, email_aluno = ?, facebook_aluno = ?, foto_aluno = ? WHERE id_aluno = ?";
    private static final String DELETE = "DELETE FROM aluno WHERE id_aluno = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM aluno WHERE id_aluno = ?";
    private static final String SELECT_ALL = "SELECT * FROM aluno";
    private static final String COUNT_ALL_ALUNO = "SELECT count(*) as total FROM aluno";

    private Connection conn = null;
    private PreparedStatement ps;
    private ResultSet rs;

    private void addOrEditAluno(String SQL, Aluno aluno) {
        try {
            conn = Conexao.getConnection();

            ps = conn.prepareStatement(SQL);

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

        return aluno;
    }

    @Override
    public boolean save(Aluno aluno) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (aluno == null) {
            System.err.println("O valor oassado nÃ£o pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERT);
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
            ps.setBytes(11, aluno.getFoto());

            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados inseridos com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }

            return flagControlo;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public boolean update(Aluno aluno) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (aluno == null) {
            System.err.println("O valor oassado nÃ£o pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(UPDATE);
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
            ps.setBytes(11, aluno.getFoto());
            ps.setInt(12, aluno.getId());

            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados inseridos com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }

            return flagControlo;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public boolean delete(Aluno aluno) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (aluno == null) {
            System.err.println("O valor oassado nÃ£o pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, aluno.getId());

            int retorno = ps.executeUpdate();
            if (retorno > 0) {
                System.out.println("Dados inseridos com sucesso: " + ps.getUpdateCount());
                flagControlo = true;
            }

            return flagControlo;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
            return false;
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public Aluno findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Aluno aluno = new Aluno();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
                return null;
            }
            popularComDados(aluno, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return aluno;
    }

    @Override
    public List<Aluno> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Aluno> alunos = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                popularComDados(aluno, rs);
                alunos.add(aluno);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return alunos;
    }

    @Override
    public void popularComDados(Aluno aluno, ResultSet rs) {
        try {
            aluno.setId(rs.getInt("id_aluno"));
            aluno.setPrimeiroNome(rs.getString("primeiro_nome_aluno"));
            aluno.setSegundoNome(rs.getString("segundo_nome_aluno"));
            aluno.setSobrenome(rs.getString("sobrenome_aluno"));
            aluno.setDataNascimento(rs.getDate("data_nascimento_aluno"));
            aluno.setSexo(Sexo.getAbreviatura(rs.getString("sexo_aluno")));
            aluno.setTelefoneFixo(rs.getString("telefone_fixo_aluno"));
            aluno.setTelefoneUnitel(rs.getString("telefone_unitel_aluno"));
            aluno.setTelefoneMovicel(rs.getString("telefone_movicel_aluno"));
            aluno.setEmail(rs.getString("email_aluno"));
            aluno.setFacebook(rs.getString("facebook_aluno"));
            aluno.setFoto(rs.getBytes("foto_aluno"));
        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }

}
