/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.facade;

import java.util.List;
import mx.desarrollo.delegate.DelegateUnidadDeAprendizaje;
import mx.desarrollo.entidad.UnidadDeAprendizaje;

/**
 *
 * @author EduardoCardona <>
 */
public class FacadeUnidadDeAprendizaje {
    
    private final DelegateUnidadDeAprendizaje delegateUnidadDeAprendizaje;

    public FacadeUnidadDeAprendizaje() {
        this.delegateUnidadDeAprendizaje = new DelegateUnidadDeAprendizaje();
    }
    
    public void guardarUnidadDeAprendizaje(UnidadDeAprendizaje unidaddeaprendizaje){
        delegateUnidadDeAprendizaje.saveUnidadDeAprendizaje(unidaddeaprendizaje);
    }
    
    public List<UnidadDeAprendizaje> obtenerUnidades() {
        return delegateUnidadDeAprendizaje.getUnidades();
        
    }
    
}
