/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcursos.dao;

import gcursos.excepcao.GCursoException;
import gcursos.modelo.Aluno;
import gcursos.modelo.CategoriaCurso;
import gcursos.modelo.Sexo;
import gcursos.modelo.Turma;
import gcursos.util.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author informatica
 */
public class TurmaDAO implements GenericoDAO<Turma> {

    private static final String INSERIR = "INSERT INTO turma(turma) VALUES(?)";
    private static final String ACTUALIZAR = "UPDATE turma SET turma = ? WHERE id_turma = ?";
    private static final String ELIMINAR = "DELETE FROM turma WHERE id_turma = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT id_turma, turma FROM turma WHERE id_turma = ?";
    private static final String LISTAR_TUDO = "SELECT id_turma, turma FROM turma";
    private static final String TOTAL_DE_ALUNOS = "SELECT count(*) as total FROM turma";

    private Connection conn = null;
    private PreparedStatement ps;
    private ResultSet rs;
    
    @Override
    public void save(Turma turma) throws GCursoException{
        addOrEditAluno(INSERIR, turma);
    }

    @Override
    public void update(Turma turma) throws GCursoException{
        addOrEditAluno(ACTUALIZAR, turma);
    }

    @Override
    public void delete(Turma turma) throws GCursoException{
        delete(turma.getId());
    }

    @Override
    public void delete(Integer id) throws GCursoException {
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir dados: " + ex.getMessage());
            throw new GCursoException(ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public Turma findById(Integer id) throws GCursoException{
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            return rs.next()? getTurmaFromResultSet(rs): null;
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
            throw new GCursoException(ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
    }

    @Override
    public List<Turma> findAll()  throws GCursoException{
        List<Turma> turmas = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                turmas.add(getTurmaFromResultSet(rs));
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
            throw new GCursoException(ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }

        return turmas;
    }
    
    @Override
    public Integer count()  throws GCursoException{

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(TOTAL_DE_ALUNOS);
            
            rs = ps.executeQuery();
            return rs.next() ? rs.getInt("total") : 0;
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
            throw new GCursoException(ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
    }
    
    private void addOrEditAluno(String SQL, Turma turma) throws GCursoException {
        try {
            conn = Conexao.getConnection();

            ps = conn.prepareStatement(SQL);
            ps.setString(1, turma.getNome());

            if (turma.getId() > 0) {
                ps.setInt(2, turma.getId());
            }

            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
            throw new GCursoException(ex.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }

    }

    private Turma getTurmaFromResultSet(ResultSet resultSet) throws SQLException {
        Turma turma = new Turma();
        turma.setId(resultSet.getInt("id_turma"));
        turma.setNome(resultSet.getString("turma"));
        
        return turma;
    }

}
