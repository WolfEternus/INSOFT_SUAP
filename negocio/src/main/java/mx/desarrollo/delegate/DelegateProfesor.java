/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.delegate;

import java.util.List;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.integracion.ServiceLocator;

/**
 *
 * @author EduardoCardona <>
 */
public class DelegateProfesor {
    
    /**
     * Metodo de ejemplo para guardar Profesor
     * @param profesor de tipo usuario con id 0 para que se cree un id nuevo
     */
    public void saveProfesor(Profesor profesor){
        ServiceLocator.getInstanceProfesorDAO().save(profesor);
    }
    
    public Profesor login(String apellidoP){
        Profesor profesor = new Profesor();
        
        List<Profesor> profesores = ServiceLocator.getInstanceProfesorDAO().findAll();
        for(Profesor prof:profesores){
            if(prof.getApellido().equalsIgnoreCase(apellidoP)){
                profesor = prof;
            }
        }
        return profesor;
    }

    public List<Profesor> obtenerProfesores() {
        List<Profesor> profesores = ServiceLocator.getInstanceProfesorDAO().findAll();
            return profesores;
    }
    
    public void guardarProfesor(Profesor prof){
       try{
           ServiceLocator.getInstanceProfesorDAO().save(prof);
       }catch(Exception e){
           System.out.println("No se guardo");
       }
    }

    public void actualizarProfesor(Profesor profesor) {
        ServiceLocator.getInstanceProfesorDAO().update(profesor);
    }

    public void borrarProfesor(Profesor profesor) {
        try{
            ServiceLocator.getInstanceProfesorDAO().delete(profesor);
        } catch(Exception e){
            System.out.println("No se borro");
        }
    }
    
}
