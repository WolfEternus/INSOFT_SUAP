/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.beanUI;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.entidad.UnidadDeAprendizaje;
import mx.desarrollo.entidad.Usuario;
import mx.desarrollo.helper.ProfesorHelper;
import mx.desarrollo.helper.UnidadHelper;

/**
 *
 * @author Kevin
 */
@ManagedBean(name = "profesorUI")
@SessionScoped
@ViewScoped
public class ProfesorBeanUI {
    public  List<Profesor> listaprofesor;
    public Profesor prof;
    public ProfesorHelper profesorhelper;
    public UnidadHelper unidadhelper;
    public List<UnidadDeAprendizaje> unidaddeaprendizaje;
    public List<UnidadDeAprendizaje> listaUnidadSeleccionada;
    public List<Profesor> profesorSeleccionado;
    private ArrayList<Profesor> filtroProfesores = new ArrayList<>();

    public List<Profesor> getProfesorSeleccionado() {
        return profesorSeleccionado;
    }

    public void setProfesorSeleccionado(List<Profesor> profesorSeleccionado) {
        this.profesorSeleccionado = profesorSeleccionado;
    }

    public List<UnidadDeAprendizaje> getListaUnidadseleccionada() {
            System.out.println("UNIDAD SELECCIONADA" + listaUnidadSeleccionada);
        return listaUnidadSeleccionada;
    }

    
    public void setListaunidadseleccionada(List<UnidadDeAprendizaje> listaunidadseleccionada) {
        this.listaUnidadSeleccionada = listaunidadseleccionada;      
        prof.setUnidadDeAprendizajeList(listaunidadseleccionada);
    }
    
    public ProfesorBeanUI(){
        profesorhelper = new ProfesorHelper();
        unidadhelper = new UnidadHelper();
        
    }
    
    @PostConstruct
    public void init(){
        obtenerProfesDeBD();
        prof = new Profesor();
        obtenerUnidadesDeBD();
        listaUnidadSeleccionada = new ArrayList<UnidadDeAprendizaje>();
        profesorSeleccionado = new ArrayList<Profesor>();
    }

    public List<UnidadDeAprendizaje> getUnidadaprendizaje() {
        
        return unidaddeaprendizaje;
    }
    
    public void obtenerUnidadesDeBD(){
        this.unidaddeaprendizaje = unidadhelper.obtenerUnidades();
        
        System.out.println("Unidades:"+unidaddeaprendizaje.toString());
    }

    public void obtenerProfesDeBD(){
        listaprofesor= profesorhelper.obtenerProfesores();
        System.out.println("Profesores:"+listaprofesor.toString());
    }
    
    public void setUnidadaprendizaje(List<UnidadDeAprendizaje> unidaddeaprendizaje) {
        this.unidaddeaprendizaje = unidaddeaprendizaje;
    }

    public List<Profesor> getListaprofesor() {
        return listaprofesor;
    }

    public void setListaprofesor(List<Profesor> listaprofesor) {
        this.listaprofesor = listaprofesor;
    }

    public Profesor getProf() {
        return prof;
    }

    public void setProf(Profesor prof) {
        this.prof = prof;
    }
    
    public void openNew(){
        this.prof= new Profesor();
    }
    
    
   public void saveProfesor() {
    // Validar que el RFC tenga exactamente 13 caracteres
    if (prof.getRfc() == null || prof.getRfc().length() != 13) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El RFC debe contener exactamente 13 caracteres."));
        return; // Salir del método si el RFC no es válido.
    }

    

    if (this.prof.getIdProfesor() != null) {
        actualizarProfesor();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Información del profesor actualizada"));
    } else {
        profesorhelper.saveProfesor(prof);
        guardarUnidades();
        obtenerProfesDeBD();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "El profesor se ha registrado correctamente.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}


// Función para validar que solo se ingresen letras
private boolean validarLetras(String texto) {
    Pattern patron = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$"); // Acepta letras, espacios y caracteres acentuados
    Matcher matcher = patron.matcher(texto);
    return matcher.matches();
}
    public void borrarProfesor() {
        
       profesorhelper.eliminarProfesor(this.prof);
     
       FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "El profesor se ha eliminado correctamente.");
       FacesContext.getCurrentInstance().addMessage(null, message);
         obtenerProfesDeBD();
    }
    
    public void actualizarProfesor(){
        profesorhelper.actualizarProfesor(prof);
    }
    
    public void guardarUnidades(){
        
    }

    public ArrayList<Profesor> getFiltroProfesores() {
        return filtroProfesores;
    }

    public void setFiltroProfesores(ArrayList<Profesor> filtroProfesores) {
        this.filtroProfesores = filtroProfesores;
    }
    
    
    
    
    
    
    
    

    

    
}
