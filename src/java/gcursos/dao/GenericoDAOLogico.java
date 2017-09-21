/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcursos.dao;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author informatica
 * @param <T>
 */
public interface GenericoDAOLogico<T> {

    boolean save(T t);

    boolean update(T t);

    boolean delete(T t);

    T findById(Integer id);

    List<T> findAll();

    void popularComDados(T t, ResultSet rs);
}
