/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcursos.dao;

import gcursos.excepcao.GCursoException;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author informatica
 * @param <T>
 */
public interface GenericoDAO<T> {

    void save(T t) throws GCursoException;

    void update(T t) throws GCursoException;

    void delete(T t) throws GCursoException;
    
    void delete(Integer id) throws GCursoException;

    T findById(Integer id) throws GCursoException;

    List<T> findAll() throws GCursoException;
    
    Integer count() throws GCursoException;

}