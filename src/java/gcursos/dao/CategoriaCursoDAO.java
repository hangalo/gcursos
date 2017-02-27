/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcursos.dao;

import gcursos.modelo.CategoriaCurso;
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
public class CategoriaCursoDAO implements GenericoDAO<CategoriaCurso> {

    private static final String INSERIR = "INSERT INTO categoria_curso(categoria_curso) VALUES(?)";
    private static final String ACTUALIZAR = "UPDATE categoria_curso SET categoria_curso =? WHERE id_categoria_curso =? ";
    private static final String ELIMINAR = "DELETE FROM categoria_curso WHERE id_categoria_curso =? ";
    private static final String BUSCAR_POR_CODIGO = "SELECT id_categoria_curso, categoria_curso FROM categoria_curso WHERE id_categoria_curso =?";
    private static final String LISTAR_TUDO = "SELECT id_categoria_curso, categoria_curso FROM categoria_curso";

    @Override
    public void save(CategoriaCurso categoriaCurso) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (categoriaCurso == null) {
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, categoriaCurso.getCategoriaCurso());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(CategoriaCurso categoriaCurso) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (categoriaCurso == null) {
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, categoriaCurso.getCategoriaCurso());
            ps.setInt(2, categoriaCurso.getIdCategoriaCurso());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(CategoriaCurso categoriaCurso) {
        PreparedStatement ps = null;
        Connection conn = null;

        if (categoriaCurso == null) {
            System.err.println("O valor passado nao pode ser nulo");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, categoriaCurso.getIdCategoriaCurso());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao eliminar dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public CategoriaCurso findById(CategoriaCurso categoriaCurso) {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, categoriaCurso.getIdCategoriaCurso());
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: "+ categoriaCurso.getIdCategoriaCurso());
            }
          
            popularComDados(categoriaCurso, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }

        return categoriaCurso;
    }

    @Override
    public List<CategoriaCurso> findAll() {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<CategoriaCurso> categoriaCursos = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs=ps.executeQuery();
            while (rs.next()) {
                CategoriaCurso categoriaCurso = new CategoriaCurso();
                popularComDados(categoriaCurso, rs);
                categoriaCursos.add(categoriaCurso);

            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }

        return categoriaCursos;
    }

    @Override
    public void popularComDados(CategoriaCurso categoriaCurso, ResultSet rs) {
        try {
            categoriaCurso.setIdCategoriaCurso(rs.getInt("id_categoria_curso"));
            categoriaCurso.setCategoriaCurso(rs.getString("categoria_curso"));

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
