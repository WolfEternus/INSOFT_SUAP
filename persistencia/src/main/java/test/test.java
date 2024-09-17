/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.List;
import mx.desarrollo.DAO.UsuarioDAO;
import mx.desarrollo.DAO.ProfesorDAO;
import mx.desarrollo.DAO.UnidadDeAprendizajeDAO;
import mx.desarrollo.entidad.Usuario;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.entidad.UnidadDeAprendizaje;

/**
 *
 * @author lukki
 */
public class test {
    public static void main(String[] args) {
        
        List<Usuario> listaUsuarios = new ArrayList();
        UsuarioDAO usuarioDao = new UsuarioDAO();
        listaUsuarios = usuarioDao.findAll();
        
        for(Usuario us : listaUsuarios){
            System.out.println("Correo: " + us.getCorreo());
        }
        
        List<Profesor> listaProfesores = new ArrayList();
        ProfesorDAO profesorDao = new ProfesorDAO();
        listaProfesores = profesorDao.findAll();
        
        for(Profesor prof : listaProfesores){
            System.out.println("Nombre: " + prof.getNombre());
        }
        
        List<UnidadDeAprendizaje> listaUnidadDeAprendizaje = new ArrayList();
        UnidadDeAprendizajeDAO unidaddeaprendizajeDao = new UnidadDeAprendizajeDAO();
        listaUnidadDeAprendizaje = unidaddeaprendizajeDao.findAll();
        
        for(UnidadDeAprendizaje ua : listaUnidadDeAprendizaje){
            System.out.println("Nombre: " + ua.getNombre());
        }
    }
}
