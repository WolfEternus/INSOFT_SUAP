/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.facade;

import java.util.List;
import mx.desarrollo.delegate.DelegateProfesor;
import mx.desarrollo.entidad.Profesor;


public class FacadeProfesor {
    
    private final DelegateProfesor delegateProfesor;

    public FacadeProfesor() {
        this.delegateProfesor = new DelegateProfesor();
    }
    
    public Profesor login(String apellidoP){
        return delegateProfesor.login(apellidoP);
    }
    
    public void saveProfesor(Profesor profesor){
        delegateProfesor.saveProfesor(profesor);
    }

    public List<Profesor> obtenerProfesores() {
        return delegateProfesor.obtenerProfesores();
    }

    public void actualizarProfesor(Profesor profesor) {
        delegateProfesor.actualizarProfesor(profesor);
    }

    public void borrarProfesor(Profesor profesor) {
        delegateProfesor.borrarProfesor(profesor);
    }
    
}
