/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcursos.dao;

import gcursos.modelo.Instrutor;
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
public class InstrutorDAO implements GenericoDAO<Instrutor>{
    private static final String INSERIR = "INSERT INTO instrutor (primeiro_nome_instrutor, segundo_nome_instrutor, sobrenome_instrutor, data_nascimento_instrutor, sexo_instrutor, telefone_princiapl, telefone_alternativo, email_instrutor, facebook_instrutor, foto_instrutor) VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String ACTUALIZAR = "UPDATE instrrutor SET primerio_nome_instrutor=?, segundo_nome_instrutor=?, sobrenome_instrutor=?, data_nascimento_instrutor=?, sexo_instrutor=?, telefone_pricipal_instrutor=?, telefone_alternativo_instrutor=?, facebook_instrutor=?, foto_instrutor=? WHERE id_instrutor=?";
    private static final String ELIMINAR = "DELETE FROM instrutor HWERE id_instrutor=?";
    private static final String BUSCAR_POR_CODIGO = "SELECT *FROM instrutor WHERE id_instrutor=?";
    private static final String LISTAR_TUDO = "SELECT *FROM istrutor";

    @Override
    public void save(Instrutor instrutor) {
       PreparedStatement ps = null;
        Connection conn = null;
        if (instrutor == null) {
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, instrutor.getPrimeiroNome());
            ps.setString(2, instrutor.getSegundoNome());
            ps.setString(3, instrutor.getSobrenome());
            ps.setDate(4, new java.sql.Date(instrutor.getDataNascimento().getTime()));
            ps.setString(5, instrutor.getEmail());
            ps.setString(6, instrutor.getFacebook());
            ps.setString(7, instrutor.getTelefonePrincipal());
            ps.setString(8, instrutor.getTelefoneAlternatico());
            ps.setBytes(9, instrutor.getFotoInstrutor());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void update(Instrutor instrutor) {
         PreparedStatement ps = null;
        Connection conn = null;
        if (instrutor == null) {
            System.err.println("O valor oassado não pode ser nulo!");
        }
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(ACTUALIZAR);
            ps = conn.prepareStatement(INSERIR);
            ps.setString(1, instrutor.getPrimeiroNome());
            ps.setString(2, instrutor.getSegundoNome());
            ps.setString(3, instrutor.getSobrenome());
            ps.setDate(4, new java.sql.Date(instrutor.getDataNascimento().getTime()));
            ps.setString(5, instrutor.getEmail());
            ps.setString(6, instrutor.getFacebook());
            ps.setString(7, instrutor.getTelefonePrincipal());
            ps.setString(8, instrutor.getTelefoneAlternatico());
            ps.setBytes(9, instrutor.getFotoInstrutor());
            
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    @Override
    public void delete(Instrutor instrutor) {
       Connection conn=null;
       PreparedStatement ps=null;
        if (instrutor==null) {
            System.out.println("O Valor Passado nao Pode ser nulo");
        }
        try {
            conn= Conexao.getConnection();
            ps.setInt(1, instrutor.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao Deletar dados"+e.getLocalizedMessage());
        }finally{
        Conexao.closeConnection(conn, ps);
       }
    }

    @Override
   public Instrutor findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Instrutor instrutor = null;
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(BUSCAR_POR_CODIGO);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            instrutor = new Instrutor();
            popularComDados(instrutor, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }

        return instrutor;
    }

    @Override
    public List<Instrutor> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Instrutor> instrutors = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(LISTAR_TUDO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Instrutor instrutor = new Instrutor();
                popularComDados(instrutor, rs);
                instrutors.add(instrutor);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return instrutors;

    }

    @Override
    public void popularComDados(Instrutor instrutor, ResultSet rs) {
        try {
            instrutor.setIdInstudor(rs.getInt("id_instrutor"));
            instrutor.setPrimeiroNomeInstrutor("primeiro_nome_instrutor");
            instrutor.setSegundoNomeInstrutor("segundo_nome_instrutor");
            instrutor.setSobrenomeInstrutor("sobrenome_instrutor");
            instrutor.setDataNascimentoInstrutor(rs.getDate("data_nascimento_instrutor"));
            instrutor.setSexo(Sexo.getAbreviatura(rs.getString("sexo_instrutor")));
            instrutor.setEmail(rs.getString("email_instrutor"));
            instrutor.setFacebookInstrutor(rs.getString("facebook_instrutor"));
            instrutor.setTelefonePrincipal(rs.getString("telefone_principal_instrutor"));
            instrutor.setTelefoneAlternatico(rs.getString("telefone_alternativo_instrutor"));
            instrutor.setFotoInstrutor(rs.getBytes("foto_instrutor"));
        } catch (SQLException ex) {
            System.out.println("erro ao carregar dados"+ex.getLocalizedMessage());
        }
    }
}
