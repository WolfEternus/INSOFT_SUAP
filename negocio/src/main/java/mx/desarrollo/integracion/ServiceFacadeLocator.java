/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.integracion;

import mx.desarrollo.facade.FacadeProfesor;
import mx.desarrollo.facade.FacadeUsuario;
import mx.desarrollo.facade.FacadeUnidadDeAprendizaje;

/**
 *
 * @author EduardoCardona <>
 */
public class ServiceFacadeLocator {
    
    private static FacadeProfesor facadeProfesor;
    private static FacadeUsuario facadeUsuario;
    private static FacadeUnidadDeAprendizaje facadeUnidadDeAprendizaje;
    
    public static FacadeProfesor getInstanceFacadeProfesor() {
        if (facadeProfesor == null) {
            facadeProfesor = new FacadeProfesor();
            return facadeProfesor;
        } else {
            return facadeProfesor;
        }
    }
    
    public static FacadeUsuario getInstanceFacadeUsuario() {
        if (facadeUsuario == null) {
            facadeUsuario = new FacadeUsuario();
            return facadeUsuario;
        } else {
            return facadeUsuario;
        }
    }
    
    public static FacadeUnidadDeAprendizaje getInstanceFacadeUnidadDeAprendizaje(){
        if(facadeUnidadDeAprendizaje == null){
            facadeUnidadDeAprendizaje = new FacadeUnidadDeAprendizaje();
            return facadeUnidadDeAprendizaje;
        } else {
            return facadeUnidadDeAprendizaje;
        }
    }
    
}
