/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.integracion;

import mx.desarrollo.DAO.ProfesorDAO;
import mx.desarrollo.DAO.UnidadDeAprendizajeDAO;
import mx.desarrollo.DAO.UsuarioDAO;


/**
 *
 * @author total
 */
public class ServiceLocator {
    
    private static ProfesorDAO profesorDAO;
    private static UnidadDeAprendizajeDAO unidaddeaprendizajeDAO;
    private static UsuarioDAO usuarioDAO;
    /**
     * se crea la instancia para  profesorDAO si esta no existe
     * @return 
     */
    public static ProfesorDAO getInstanceProfesorDAO(){
        if(profesorDAO == null){
            profesorDAO = new ProfesorDAO();
            return profesorDAO;
        } else{
            return profesorDAO;
        }
    }
    /**
     * se crea la instancia para  unidaddeaprendizajeDAO si esta no existe
     * @return 
     */
    public static UnidadDeAprendizajeDAO getInstanceUnidadDeAprendizajeDAO(){
        if(unidaddeaprendizajeDAO == null){
            unidaddeaprendizajeDAO = new UnidadDeAprendizajeDAO();
            return unidaddeaprendizajeDAO;
        } else{
            return unidaddeaprendizajeDAO;
        }
    }
    /**
     * se crea la instancia de usuarioDAO si esta no existe
     * @return 
     */
    public static UsuarioDAO getInstanceUsuarioDAO(){
        if(usuarioDAO == null){
            usuarioDAO = new UsuarioDAO();
            return usuarioDAO;
        } else{
            return usuarioDAO;
        }
    }
    
}
