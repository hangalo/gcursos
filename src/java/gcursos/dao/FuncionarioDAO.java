/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcursos.dao;

import gcursos.modelo.Funcionario;
import gcursos.modelo.Sexo;
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
public class FuncionarioDAO implements GenericoDAO<Funcionario> {

    private static final String INSERIR = "INSERT INTO funcionario(primeiro_nome_funcionario, segundo_nome_funcionario, sobrenome_funcionario, data_nascimento_funcionario, sexo_funcionario, telefone_fixo_funcionario, telefone_unitel_funcionario, telefone_movicel_funcionario, emali_funcionario, facebook_funcionario, foto_funcionario)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String ACTUALIZAR = "UPDATE funcionario SET primeiro_nome_funcionario=?, segundo_nome_funcionario=?, sobrenome_funcionario=?, data_nascimento_funcionario=?, sexo_funcionario=?, telefone_fixo_funcionario=?, telefone_unitel_funcionario=?, telefone_movicel_funcionario=?, emali_funcionario=?, facebook_funcionario=?, foto_funcionario WHERE id_funcionario=?";
    private static final String ELIMINAR = "SELECT FROM funcionario WHERE id_funcionario=?";
    private static final String BUSCAR_POR_CODIGO = "SELECT id_funcionario, primeiro_nome_funcionario, segundo_nome_funcionario, sobrenome_funcionario, data_nascimento_funcionario, sexo_funcionario, telefone_fixo_funcionario, telefone_unitel_funcionario, telefone_movicel_funcionario  FROM curso";
    private static final String LISTAR_TUDO = "SELECT id_funcionario,primeiro_nome_funcionario, segundo_nome_funcionario, sobrenome_funcionario, data_nascimento_funcionario, sexo_funcionario, telefone_fixo_funcionario, telefone_unitel_funcionario, telefone_movicel_funcionario, email_funcionario, facebook_funcionario FROM funcionario";

    @Override
    public void save(Funcionario funcionario) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (funcionario == null) {
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, funcionario.getPrimeiroNome());
            ps.setString(2, funcionario.getSegundoNome());
            ps.setString(3, funcionario.getSobrenome());
            ps.setDate(1, new java.sql.Date(funcionario.getDataNascimento().getTime()));
            ps.setString(5, funcionario.getSexo().getAbreviatura());
            ps.setString(6, funcionario.getTelefoneFixo());
            ps.setString(7, funcionario.getTelefoneUnitel());
            ps.setString(8, funcionario.getTelefoneMovicel());
            ps.setString(9, funcionario.getEmail());
            ps.setString(10, funcionario.getFacebook());
            ps.setString(11, funcionario.getUrlFoto());
            
            /* Codigo aqui*/
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(Funcionario funcionario) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (funcionario == null) {
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, funcionario.getPrimeiroNome());
            ps.setString(2, funcionario.getSegundoNome());
            ps.setString(3, funcionario.getSobrenome());
            ps.setDate(1, new java.sql.Date(funcionario.getDataNascimento().getTime()));
            ps.setString(5, funcionario.getSexo().getAbreviatura());
            ps.setString(6, funcionario.getTelefoneFixo());
            ps.setString(7, funcionario.getTelefoneUnitel());
            ps.setString(8, funcionario.getTelefoneMovicel());
            ps.setString(9, funcionario.getEmail());
            ps.setString(10, funcionario.getFacebook());
            ps.setString(11, funcionario.getUrlFoto());
            /* Codigo aqui*/
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(Funcionario funcionario) {
        PreparedStatement ps = null;
        Connection conn = null;
        if (funcionario == null) {
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ELIMINAR);
            ps.setInt(1, funcionario.getId());
            /* Codigo aqui*/
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public Funcionario findById(Integer id) {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Funcionario funcionario = new Funcionario();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);

            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: ");
            }
            /*Codigo Aqui*/
            Funcionario f= new Funcionario();
            popularComDados(null, null);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }

        return funcionario;
    }

    @Override
    public List<Funcionario> findAll() {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            ps.executeQuery();
            while (rs.next()) {
                /*Codigo Aqui*/
                Funcionario f= new Funcionario();
                popularComDados(null, null);
                funcionarios.add(f);

            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }

        return funcionarios;
    }

    @Override
    public void popularComDados(Funcionario funcionario, ResultSet rs) {
        try {
            funcionario.setId(rs.getInt("id_funcionario"));
            funcionario.setPrimeiroNome(rs.getString("primeiro_nome_funcionario"));
            funcionario.setSegundoNome(rs.getString("segundo_nome_funcionario"));
            funcionario.setSobrenome(rs.getString("sobrenome_funcionario"));
            funcionario.setDataNascimento(rs.getDate("data_nascimento_funcionario"));
            funcionario.setSexo(Sexo.getAbreviatura(rs.getString("sexo_funcionario")));
            funcionario.setTelefoneFixo(rs.getString("telefone_fixo_funcionario"));
            funcionario.setTelefoneUnitel(rs.getString("telefone_unitel_funcionario"));
            funcionario.setTelefoneMovicel(rs.getString("telefone_funcionario"));
            funcionario.setEmail(rs.getString("emali_funcionario"));
            funcionario.setFacebook(rs.getString("facebook_funcionario"));
            funcionario.setUrlFoto(rs.getString("foto_funcionario"));
                        
        } catch (SQLException ex) {
            System.out.println("Erro ao Carregar dados"+ex.getLocalizedMessage());
        }
    }
}
