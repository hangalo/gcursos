/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcursos.dao;

import gcursos.modelo.DetalhesMatricula;
import gcursos.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author informatica
 */
public class DetalhesMatriculaDAO implements GenericoDAO<DetalhesMatricula> {

    private static final String INSERIR = "";
    private static final String ACTUALIZAR = "";
    private static final String ELIMINAR = "";
    private static final String BUSCAR_POR_CODIGO = "";
    private static final String LISTAR_TUDO = " ";

    @Override
    public void save(DetalhesMatricula t) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (t == null) {
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);

            /* Codigo aqui*/
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(DetalhesMatricula t) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (t == null) {
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);

            /* Codigo aqui*/
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(DetalhesMatricula t) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (t == null) {
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);

            /* Codigo aqui*/
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public DetalhesMatricula findById(DetalhesMatricula detalhesMatricula) {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);

            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: ");
            }
            /*Codigo Aqui*/

            popularComDados(null, null);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }

        return detalhesMatricula;
    }

    @Override
    public List<DetalhesMatricula> findAll() {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            ps.executeQuery();
            while (rs.next()) {
                /*Codigo Aqui*/
                popularComDados(null, null);

            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }

        return null;
    }

    @Override
    public void popularComDados(DetalhesMatricula t, ResultSet rs) {

    }
}
