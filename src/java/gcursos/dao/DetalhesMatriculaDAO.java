/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcursos.dao;

import gcursos.modelo.DetalhesMatricula;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author informatica
 */
public class DetalhesMatriculaDAO implements GenericoDAO<DetalhesMatricula>{
    private static final String INSERIR = "";
    private static final String ACTUALIZAR = "";
    private static final String ELIMINAR = "";
    private static final String BUSCAR_POR_CODIGO = "";
    private static final String LISTAR_TUDO = " ";

    @Override
    public void save(DetalhesMatricula t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(DetalhesMatricula t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(DetalhesMatricula t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetalhesMatricula findById(DetalhesMatricula t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetalhesMatricula> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void popularComDados(DetalhesMatricula t, ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
