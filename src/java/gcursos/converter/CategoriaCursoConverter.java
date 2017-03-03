/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcursos.converter;

import gcursos.dao.CategoriaCursoDAO;
import gcursos.modelo.CategoriaCurso;
import java.util.HashMap;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


/**
 *
 * @author informatica
 */
@FacesConverter(value = "categoriaCursoConverter")
public class CategoriaCursoConverter implements Converter {

    private static Map<String, CategoriaCurso> mapa = new HashMap<String, CategoriaCurso>();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return mapa.get(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof CategoriaCurso) {
            CategoriaCurso c = (CategoriaCurso) value;
            mapa.put(String.valueOf(c.getIdCategoriaCurso()), c);
            return String.valueOf(c.getIdCategoriaCurso());
        } else {
            return "";
        }
    }

}
