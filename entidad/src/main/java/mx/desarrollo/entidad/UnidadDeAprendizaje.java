/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "unidad_de_aprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadDeAprendizaje.findAll", query = "SELECT u FROM UnidadDeAprendizaje u")
    , @NamedQuery(name = "UnidadDeAprendizaje.findByIdUnidadAprendizaje", query = "SELECT u FROM UnidadDeAprendizaje u WHERE u.idUnidadAprendizaje = :idUnidadAprendizaje")
    , @NamedQuery(name = "UnidadDeAprendizaje.findByNombre", query = "SELECT u FROM UnidadDeAprendizaje u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "UnidadDeAprendizaje.findByHorario", query = "SELECT u FROM UnidadDeAprendizaje u WHERE u.horario = :horario")
    , @NamedQuery(name = "UnidadDeAprendizaje.findByHorasClase", query = "SELECT u FROM UnidadDeAprendizaje u WHERE u.horasClase = :horasClase")
    , @NamedQuery(name = "UnidadDeAprendizaje.findByHorasTaller", query = "SELECT u FROM UnidadDeAprendizaje u WHERE u.horasTaller = :horasTaller")
    , @NamedQuery(name = "UnidadDeAprendizaje.findByHorasLaboratorio", query = "SELECT u FROM UnidadDeAprendizaje u WHERE u.horasLaboratorio = :horasLaboratorio")})
public class UnidadDeAprendizaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUnidadAprendizaje")
    private Integer idUnidadAprendizaje;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "horario")
    private String horario;
    @Basic(optional = false)
    @Column(name = "horasClase")
    private int horasClase;
    @Basic(optional = false)
    @Column(name = "horasTaller")
    private int horasTaller;
    @Basic(optional = false)
    @Column(name = "horasLaboratorio")
    private int horasLaboratorio;
    @ManyToMany(mappedBy = "unidadDeAprendizajeList")
    private List<Profesor> profesorList;

    public UnidadDeAprendizaje() {
    }

    public UnidadDeAprendizaje(Integer idUnidadAprendizaje) {
        this.idUnidadAprendizaje = idUnidadAprendizaje;
    }

    public UnidadDeAprendizaje(Integer idUnidadAprendizaje, String nombre, String horario, int horasClase, int horasTaller, int horasLaboratorio) {
        this.idUnidadAprendizaje = idUnidadAprendizaje;
        this.nombre = nombre;
        this.horario = horario;
        this.horasClase = horasClase;
        this.horasTaller = horasTaller;
        this.horasLaboratorio = horasLaboratorio;
    }

    public Integer getIdUnidadAprendizaje() {
        return idUnidadAprendizaje;
    }

    public void setIdUnidadAprendizaje(Integer idUnidadAprendizaje) {
        this.idUnidadAprendizaje = idUnidadAprendizaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(int horasClase) {
        this.horasClase = horasClase;
    }

    public int getHorasTaller() {
        return horasTaller;
    }

    public void setHorasTaller(int horasTaller) {
        this.horasTaller = horasTaller;
    }

    public int getHorasLaboratorio() {
        return horasLaboratorio;
    }

    public void setHorasLaboratorio(int horasLaboratorio) {
        this.horasLaboratorio = horasLaboratorio;
    }

    @XmlTransient
    public List<Profesor> getProfesorList() {
        return profesorList;
    }

    public void setProfesorList(List<Profesor> profesorList) {
        this.profesorList = profesorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidadAprendizaje != null ? idUnidadAprendizaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadDeAprendizaje)) {
            return false;
        }
        UnidadDeAprendizaje other = (UnidadDeAprendizaje) object;
        if ((this.idUnidadAprendizaje == null && other.idUnidadAprendizaje != null) || (this.idUnidadAprendizaje != null && !this.idUnidadAprendizaje.equals(other.idUnidadAprendizaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.desarrollo.entidad.UnidadDeAprendizaje[ idUnidadAprendizaje=" + idUnidadAprendizaje + " ]";
    }
    
}
