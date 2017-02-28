/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcursos.dao;

import gcursos.excepcao.GCursoException;
import gcursos.modelo.Funcionario;
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
public class FuncionarioDAO implements GenericoDAO<Funcionario> {

    private static final String INSERIR = "";
    private static final String ACTUALIZAR = "";
    private static final String ELIMINAR = "";
    private static final String BUSCAR_POR_CODIGO = "";
    private static final String LISTAR_TUDO = " ";
    private static final String TOTAL_FUNCIONARIOS = " ";

    @Override
    public void save(Funcionario t) {
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
    public void update(Funcionario t) {
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
    public void delete(Funcionario t) {
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
    public void delete(Integer id) throws GCursoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Funcionario findById(Integer id) {

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

        return null;
    }

    @Override
    public List<Funcionario> findAll() {

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
    public Integer count() throws GCursoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void popularComDados(Funcionario t, ResultSet rs) {

    }
}
