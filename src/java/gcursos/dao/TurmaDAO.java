/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcursos.dao;

import gcursos.modelo.Turma;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author informatica
 */
public class TurmaDAO implements GenericoDAO<Turma>{
    private static final String INSERIR = "INSERT INTO turma(turma) VALUES(?)";
    private static final String ACTUALIZAR = "UPDATE turma SET turma = ? WHERE id_turma = ?";
    private static final String ELIMINAR = "DELETE FROM turma WHERE id_turma = ?";
    private static final String BUSCAR_POR_CODIGO = "SELECT id_turma, turma FROM turma WHERE id_turma = ?";
    private static final String LISTAR_TUDO = "SELECT id_turma, turma FROM turma ";

    @Override
    public void save(Turma t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Turma t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Turma t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Turma findById(Turma t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Turma> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void popularComDados(Turma t, ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
