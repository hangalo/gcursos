/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcursos.dao;

import gcursos.excepcao.GCursoException;
import gcursos.modelo.CategoriaCurso;
import gcursos.modelo.Curso;
import gcursos.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author informatica
 */
public class CursoDAO implements GenericoDAO<Curso> {

    private static final String INSERIR = "INSERT INTO curso(nome_curso,requisito_curso, conteudo_curso, carga_horaria_curso, preco_curso, id_categoria_curso) VALUES(?, ?, ?, ?, ?,?)";
    private static final String ACTUALIZAR = "UPDATE curso SET nome_curso = ?, requisito_curso = ?, conteudo_curso = ?, carga_horaria_curso = ?, preco_curso = ?, id_categoria_curso = ? WHERE id_curso = ?;";
    private static final String ELIMINAR = "DELETE FROM curso WHERE id_curso = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT id_curso,nome_curso, requisito_curso, conteudo_curso, carga_horaria_curso, preco_curso, categoria_curso  FROM curso c INNER JOIN categoria_curso cg ON c.id_categoria_curso = cg.id_categoria_curso WHERE id_curso = ?;";
    private static final String LISTAR_TUDO = "SELECT id_curso,nome_curso, requisito_curso, conteudo_curso, carga_horaria_curso, preco_curso, categoria_curso  FROM curso c INNER JOIN categoria_curso cg ON c.id_categoria_curso = cg.id_categoria_curso; ";
    private static final String TOTAL_CURSO = "";

    @Override
    public void save(Curso curso) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (curso == null) {
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);

            ps.setString(1, curso.getNomeCurso());
            ps.setString(2, curso.getRequisitosCurso());
            ps.setString(3, curso.getConteudoCurso());
            ps.setInt(4, curso.getCargaHorariaCurso());
            ps.setDouble(5, curso.getPrecoCurso());
            ps.setInt(6, curso.getCategoriaCurso().getIdCategoriaCurso());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(Curso curso) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (curso == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, curso.getNomeCurso());
            ps.setString(2, curso.getRequisitosCurso());
            ps.setString(3, curso.getConteudoCurso());
            ps.setInt(4, curso.getCargaHorariaCurso());
            ps.setDouble(5, curso.getPrecoCurso());
            ps.setInt(6, curso.getCategoriaCurso().getIdCategoriaCurso());
            ps.setInt(7, curso.getIdCurso());
            ps.executeUpdate();

        } catch (Exception ex) {
            System.err.println("Erro ao actualizar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(Curso curso) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (curso == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, curso.getIdCurso());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(Integer id) throws GCursoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curso findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            //popularComDados(id, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }

        return null;
    }

    @Override
    public List<Curso> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Curso> cursos = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Curso curso = new Curso();
                popularComDados(curso, rs);
                cursos.add(curso);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return cursos;

    }

    @Override
    public Integer count() throws GCursoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void popularComDados(Curso curso, ResultSet rs) {
        try {

            curso.setIdCurso(rs.getInt("id_curso"));
            curso.setNomeCurso(rs.getString("nome_curso"));
            curso.setRequisitosCurso(rs.getString("requisito_curso"));
            curso.setConteudoCurso(rs.getString("conteudo_curso"));
            curso.setCargaHorariaCurso(rs.getInt("carga_horaria_curso"));
            curso.setPrecoCurso(rs.getDouble("preco_curso"));
            CategoriaCurso categoriaCurso = new CategoriaCurso();
            categoriaCurso.setCategoriaCurso(rs.getString("categoria_curso"));
            curso.setCategoriaCurso(categoriaCurso);

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }
}
