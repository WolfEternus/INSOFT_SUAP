/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.integracion.ServiceFacadeLocator;
import mx.desarrollo.facade.FacadeProfesor;

/**
 *
 * @author Viann
 */
public class ProfesorHelper implements Serializable{
    
    public Profesor login(String apellidoP){
        return ServiceFacadeLocator.getInstanceFacadeProfesor().login(apellidoP);
    }
    
    public List<Profesor> obtenerProfesores(){
        return ServiceFacadeLocator.getInstanceFacadeProfesor().obtenerProfesores();
    }
    
    public void guardarProfesor(Profesor profesor){
        
        ArrayList<Profesor> listprof = (ArrayList<Profesor>) obtenerProfesores();
        Collections.sort(listprof, new Comparator<Profesor>(){
            @Override
            public int compare(Profesor o1, Profesor o2) {
                return o1.getIdProfesor().compareTo(o2.getIdProfesor());
            }
        });
        
        profesor.setIdProfesor(listprof.get(listprof.size()-1).getIdProfesor()+1);
        
        //System.out.println("nuevo ID " + profesor.getIdprofesor());
        profesor.setApellido(profesor.getApellido().toUpperCase());
        profesor.setNombre(profesor.getNombre().toUpperCase());
        profesor.setRfc(profesor.getRfc().toUpperCase());
        
        ServiceFacadeLocator.getInstanceFacadeProfesor().saveProfesor(profesor);

    }

    public void actualizarProfesor(Profesor prof) {
        ServiceFacadeLocator.getInstanceFacadeProfesor().actualizarProfesor(prof);
    }

    public void eliminarProfesor(Profesor prof) {
        // List<Profesor> listaProfesores = new ArrayList();
        //listaProfesores = ServiceFacadeLocator.getInstanceFacadeProfesor().obtenerProfesores();
        
        //for(Profesor pr : listaProfesores){
           // if(id == pr.getIdprofesor()){
                ServiceFacadeLocator.getInstanceFacadeProfesor().borrarProfesor(prof);
           // }
       // }
    }
    
}
