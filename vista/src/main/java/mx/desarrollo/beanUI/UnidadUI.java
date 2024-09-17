/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.beanUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
import mx.desarrollo.helper.ProfesorHelper;
import mx.desarrollo.helper.UnidadHelper;

/**
 *
 * @author riky3
 */
@ManagedBean(name = "UnidadUI")
@SessionScoped
@ViewScoped
public class UnidadUI {
    public  List<Profesor> listaprofesor;
    public Profesor prof;
    public  List<UnidadDeAprendizaje> listaunidad;
    public UnidadDeAprendizaje unidad;
    public ProfesorHelper profesorhelper;
    public UnidadHelper unidadhelper;
    public List<UnidadDeAprendizaje> unidadaddeprendizaje;
    public List<UnidadDeAprendizaje> listaUnidadSeleccionada;
    private ArrayList<UnidadDeAprendizaje> filtroUnidadA = new ArrayList<>();

    public List<UnidadDeAprendizaje> getListaUnidadseleccionada() {
        return listaUnidadSeleccionada;
    }

    public void setListaunidadseleccionada(List<UnidadDeAprendizaje> listaunidadseleccionada) {
        this.listaUnidadSeleccionada = listaunidadseleccionada;
    }
    
    public UnidadUI(){
        profesorhelper = new ProfesorHelper();
        unidadhelper = new UnidadHelper();
        
    }
    
    @PostConstruct
    public void init(){
        obtenerProfesDeBD();
        prof = new Profesor();
        obtenerUnidadesDeBD();
        unidad = new UnidadDeAprendizaje();
        listaUnidadSeleccionada = new ArrayList<UnidadDeAprendizaje>(); 
    }

    public List<UnidadDeAprendizaje> getUnidadaprendizaje() {
        return  unidadaddeprendizaje;
    }
    
    public void obtenerUnidadesDeBD(){
        this.unidadaddeprendizaje = unidadhelper.obtenerUnidades();
        
        System.out.println("Unidades:"+unidadaddeprendizaje.toString());
    }

    public void obtenerProfesDeBD(){
        listaprofesor= profesorhelper.obtenerProfesores();
        System.out.println("Profesores:"+listaprofesor.toString());
    }
    
    public void setUnidadaprendizaje(List<UnidadDeAprendizaje> unidadaddeprendizaje) {
        this.unidadaddeprendizaje = unidadaddeprendizaje;
    }
    

    public List<Profesor> getListaprofesor() {
        return listaprofesor;
    }
 public List<UnidadDeAprendizaje> getListaunidadaprendizaje() {
        return listaunidad;
    }
    
    public void setListaprofesor(List<Profesor> listaprofesor) {
        this.listaprofesor = listaprofesor;
    }

    public Profesor getProf() {
        return prof;
    }
    public UnidadDeAprendizaje getUnidad() {
        return unidad;
    }

    public void setProf(Profesor prof) {
        this.prof = prof;
    }
    public void setUnidad(UnidadDeAprendizaje unidad) {
        this.unidad = unidad;
    }
    
    public void openNew(){
        this.prof= new Profesor();
    }
     public void openNewU(){
        this.unidad= new UnidadDeAprendizaje();
    }
    
    public void guardarProfesor() {
       profesorhelper.guardarProfesor(prof);
       obtenerProfesDeBD();
    }
    
     public void guardarUnidadaprendizaje() {
    if (unidad.getNombre() == null || unidad.getNombre().isEmpty() ||
        Objects.isNull(unidad.getHorasClase()) || Objects.isNull(unidad.getHorasTaller()) || Objects.isNull(unidad.getHorasLaboratorio())) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Todos los campos de la unidad de aprendizaje son obligatorios.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        return;
    
        }

        // Verificar que las horas no sean negativas
        if (unidad.getHorasClase() < 0 || unidad.getHorasTaller() < 0 || unidad.getHorasLaboratorio() < 0) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Las horas no pueden ser negativas.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return;
        }

        // Agregar la lógica para validar el nombre de la unidad de aprendizaje
        boolean nombreValido = validarNombreUnidad(unidad.getNombre());

        if (!nombreValido) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El nombre de la unidad de aprendizaje es incorrecto.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return;
        }

        unidadhelper.guardarUnidadAprendizaje(unidad);
        obtenerUnidadesDeBD();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "La unidad se ha registrado correctamente.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
     public boolean validarNombreUnidad(String nombreUnidad) {
        // Utiliza una expresión regular para verificar que el nombre contenga solo letras (sin espacios).
        Pattern pattern = Pattern.compile("^[a-zA-Z]*$");
        Matcher matcher = pattern.matcher(nombreUnidad);

        return matcher.matches();
    }

    public ArrayList<UnidadDeAprendizaje> getFiltroUnidadA() {
        return filtroUnidadA;
    }

    public void setFiltroUnidadA(ArrayList<UnidadDeAprendizaje> filtroUnidadA) {
        this.filtroUnidadA = filtroUnidadA;
    }
     
    
}