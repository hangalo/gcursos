/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcursos.dao;

import gcursos.modelo.CategoriaCurso;
import gcursos.modelo.Turma;
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
public class TurmaDAO implements GenericoDAO<Turma> {

    private static final String INSERIR = "INSERT INTO turma(turma) VALUES(?)";
    private static final String ACTUALIZAR = "UPDATE turma SET turma = ? WHERE id_turma = ?";
    private static final String ELIMINAR = "DELETE FROM turma WHERE id_turma = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT id_turma, turma FROM turma WHERE id_turma = ?";
    private static final String LISTAR_TUDO = "SELECT id_turma, turma FROM turma";

    @Override
    public void save(Turma turma) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (turma == null) {
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, turma.getTurma());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(Turma turma) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (turma == null) {
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);

            ps.setString(1, turma.getTurma());
            ps.setInt(2, turma.getIdTurma());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(Turma turma) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (turma == null) {
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);

            ps.setInt(1, turma.getIdTurma());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public Turma findById(Integer id) {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Turma turma = new Turma();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id:"+turma.getTurma());
            }
            popularComDados(turma, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }

        return null;
    }

    @Override
    public List<Turma> findAll() {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        List<Turma> turmas = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Turma turma = new Turma();
                popularComDados(turma, rs);
                turmas.add(turma);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }

        return turmas;
    }

    @Override
    public void popularComDados(Turma turma, ResultSet rs) {

        try {
            turma.setIdTurma(rs.getInt("id_turma"));
            turma.setTurma(rs.getString("turma"));
        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }

    }

}
