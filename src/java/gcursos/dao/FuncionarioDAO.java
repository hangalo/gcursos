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

    private static final String INSERIR = "INSERT INTO funcionario(primeiro_nome_funcionario, segundo_nome_funcionario, sobrenome_funcionario, data_nascimento_funcionario, sexo_funcionario, telefone_principal, telefone_alternativo, email_funcionario, facebook_funcionario)VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String ACTUALIZAR = "UPDATE funcionario SET primeiro_nome_funcionario=?, segundo_nome_funcionario=?, sobrenome_funcionario=?, data_nascimento_funcionario=?, sexo_funcionario=?, telefone_principal=?, telefone_alternativo=?, email_funcionario=?, emali_funcionario=?, facebook_funcionario=? WHERE id_funcionario=?";
    private static final String ELIMINAR = "DELETE FROM funcionario WHERE id_funcionario=?";
    private static final String BUSCAR_POR_CODIGO = "SELECT id_funcionario, primeiro_nome_funcionario, segundo_nome_funcionario, sobrenome_funcionario, data_nascimento_funcionario,sexo_funcionario, telefone_principal, telefone_alternativo, email_funcionario, facebook_funcionario FROM funcionario WHERE id_funcionario =?;";
    private static final String LISTAR_TUDO = "SELECT id_funcionario, primeiro_nome_funcionario, segundo_nome_funcionario, sobrenome_funcionario, data_nascimento_funcionario,sexo_funcionario, telefone_principal, telefone_alternativo, email_funcionario, facebook_funcionario FROM funcionario;";

    
    
      PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        
    @Override
    public void save(Funcionario funcionario) {
     
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
            ps.setDate(4, new java.sql.Date(funcionario.getDataNascimento().getTime()));
            ps.setString(5, funcionario.getSexo().getAbreviatura());
            ps.setString(6, funcionario.getTelefonePrincipal());
            ps.setString(7, funcionario.getTelefoneAlternativo());
            ps.setString(8, funcionario.getEmail());
            ps.setString(9, funcionario.getFacebook());

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
    
       
        if (funcionario == null) {
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps.setString(1, funcionario.getPrimeiroNome());
            ps.setString(2, funcionario.getSegundoNome());
            ps.setString(3, funcionario.getSobrenome());
            ps.setDate(4, new java.sql.Date(funcionario.getDataNascimento().getTime()));
            ps.setString(5, funcionario.getSexo().getAbreviatura());
            ps.setString(6, funcionario.getTelefonePrincipal());
            ps.setString(7, funcionario.getTelefoneAlternativo());
            ps.setString(8, funcionario.getEmail());
            ps.setString(9, funcionario.getFacebook());
            ps.setInt(10, funcionario.getId());

            /* Codigo aqui*/
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao editar dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(Funcionario funcionario) {
    
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
            System.out.println("Erro ao eliminar dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public Funcionario findById(Integer id) {

       
        Funcionario funcionario = null;

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: ");
            }
            funcionario = new Funcionario();

            popularComDados(funcionario, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }

        return funcionario;
    }

    @Override
    public List<Funcionario> findAll() {      
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs=ps.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                popularComDados(funcionario, rs);
                funcionarios.add(funcionario);

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
            funcionario.setTelefonePrincipal(rs.getString("telefone_principal"));
            funcionario.setTelefoneAlternativo(rs.getString("telefone_alternativo"));
            funcionario.setEmail(rs.getString("email_funcionario"));
            funcionario.setFacebook(rs.getString("facebook_funcionario"));

        } catch (SQLException ex) {
            System.out.println("Erro ao Carregar dados" + ex.getLocalizedMessage());
        }
    }
}
