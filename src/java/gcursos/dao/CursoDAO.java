/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcursos.dao;

import gcursos.modelo.Curso;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author informatica
 */
public class CursoDAO implements GenericoDAO<Curso>{
    private static final String INSERIR = "INSERT INTO curso(nome_curso,requisito_curso, conteudo_curso, carga_horaria_curso, preco_curso, id_categoria_curso) VALUES(?, ?, ?, ?, ?,?)";
    private static final String ACTUALIZAR = "UPDATE curso SET nome_curso = ?, requisito_curso = ?, conteudo_curso = ?, carga_horaria_curso = ?, preco_curso = ?, id_categoria_curso = ? WHERE id_curso = ?;";
    private static final String ELIMINAR = "DELETE FROM curso WHERE id_curso = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT id_curso,nome_curso, requisito_curso, conteudo_curso, carga_horaria_curso, preco_curso, categoria_curso  FROM curso c INNER JOIN categoria_curso cg ON c.id_categoria_curso = cg.id_categoria_curso WHERE id_curso = ?;";
    private static final String LISTAR_TUDO = "SELECT id_curso,nome_curso, requisito_curso, conteudo_curso, carga_horaria_curso, preco_curso, categoria_curso  FROM curso c INNER JOIN categoria_curso cg ON c.id_categoria_curso = cg.id_categoria_curso; ";

    @Override
    public void save(Curso t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Curso t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Curso t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curso findById(Curso t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Curso> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void popularComDados(Curso t, ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
