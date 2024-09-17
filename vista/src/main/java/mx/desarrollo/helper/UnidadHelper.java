/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.entidad.UnidadDeAprendizaje;
import mx.desarrollo.integracion.ServiceFacadeLocator;

/**
 *
 * @author Viann
 */
public class UnidadHelper {

    public List<UnidadDeAprendizaje> obtenerUnidades() {
       return ServiceFacadeLocator.getInstanceFacadeUnidadDeAprendizaje().obtenerUnidades();
    }
     
    public void guardarUnidadAprendizaje(UnidadDeAprendizaje unidad){
      
        
        unidad.setNombre(unidad.getNombre().toUpperCase());
        
        ServiceFacadeLocator.getInstanceFacadeUnidadDeAprendizaje().guardarUnidadDeAprendizaje(unidad);
    }
}