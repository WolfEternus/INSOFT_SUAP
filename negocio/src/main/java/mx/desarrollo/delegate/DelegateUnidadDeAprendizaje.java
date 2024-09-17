/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.delegate;

import java.util.List;
import mx.desarrollo.entidad.UnidadDeAprendizaje;
import mx.desarrollo.integracion.ServiceLocator;


public class DelegateUnidadDeAprendizaje {
    
    /**
     * Metodo de ejemplo para guardar Alumno
     * @param unidaddeaprendizaje de tipo usuario con id 0 para que se cree un id nuevo
     */
    
    public void saveUnidadDeAprendizaje(UnidadDeAprendizaje unidaddeaprendizaje){
        ServiceLocator.getInstanceUnidadDeAprendizajeDAO().save(unidaddeaprendizaje);
    }
    
    public List<UnidadDeAprendizaje> getUnidades() {
        return ServiceLocator.getInstanceUnidadDeAprendizajeDAO().findAll();    
    }
  

    public List<UnidadDeAprendizaje> obtenerUnidades() {
        List<UnidadDeAprendizaje> unidades = ServiceLocator.getInstanceUnidadDeAprendizajeDAO().findAll();
            return unidades;
    }
    
    
}
