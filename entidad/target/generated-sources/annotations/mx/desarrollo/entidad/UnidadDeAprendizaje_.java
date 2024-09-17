package mx.desarrollo.entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.desarrollo.entidad.Profesor;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-09-17T02:07:13")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-09-17T01:51:41")
>>>>>>> d2ed6ea74b6b2568c40961754618cbbbb7c215af
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