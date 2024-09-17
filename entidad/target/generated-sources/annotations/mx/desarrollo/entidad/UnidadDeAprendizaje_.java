package mx.desarrollo.entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.desarrollo.entidad.Profesor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-09-16T17:33:38")
@StaticMetamodel(UnidadDeAprendizaje.class)
public class UnidadDeAprendizaje_ { 

    public static volatile SingularAttribute<UnidadDeAprendizaje, Integer> idUnidadAprendizaje;
    public static volatile SingularAttribute<UnidadDeAprendizaje, Integer> horasLaboratorio;
    public static volatile SingularAttribute<UnidadDeAprendizaje, String> horario;
    public static volatile SingularAttribute<UnidadDeAprendizaje, Integer> horasClase;
    public static volatile ListAttribute<UnidadDeAprendizaje, Profesor> profesorList;
    public static volatile SingularAttribute<UnidadDeAprendizaje, String> nombre;
    public static volatile SingularAttribute<UnidadDeAprendizaje, Integer> horasTaller;

}