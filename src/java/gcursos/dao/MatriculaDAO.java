/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcursos.dao;

import gcursos.modelo.Matricula;
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
public class MatriculaDAO implements GenericoDAOLogico<Matricula> {

    private static final String INSERT = "";
    private static final String UPDATE = "";
    private static final String DELETE = "";
    private static final String SELECT_BY_ID = "";
    private static final String SELECT_ALL = " ";

   @Override
    public boolean save(Matricula matricula) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (matricula == null) {
            System.err.println("O valor oassado nÃ£o pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERT);
            

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
    public boolean update(Matricula matricula) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (matricula == null) {
            System.err.println("O valor oassado nÃ£o pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(UPDATE);
           
          
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
    public boolean delete(Matricula matricula) {
        PreparedStatement ps = null;
        Connection conn = null;
        boolean flagControlo = false;
        if (matricula == null) {
            System.err.println("O valor oassado nÃ£o pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, 0);
          
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
    public Matricula findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Matricula matricula = new Matricula();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
                return null;
            }
            popularComDados(matricula, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
        return matricula;
    }

    @Override
    public List<Matricula> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Matricula> matriculas = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Matricula matricula = new Matricula();
                popularComDados(matricula, rs);
                matriculas.add(matricula);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return matriculas;
    }

  

    @Override
    public void popularComDados(Matricula matricula, ResultSet rs) {
        try {
            matricula.setIdMatricula(rs.getInt(""));
        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }
}
