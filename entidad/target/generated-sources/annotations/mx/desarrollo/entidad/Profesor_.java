package mx.desarrollo.entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.desarrollo.entidad.UnidadDeAprendizaje;
import mx.desarrollo.entidad.Usuario;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-09-17T02:07:13")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-09-17T01:51:41")
>>>>>>> d2ed6ea74b6b2568c40961754618cbbbb7c215af
@StaticMetamodel(Profesor.class)
public class Profesor_ { 

    public static volatile SingularAttribute<Profesor, Integer> idProfesor;
    public static volatile ListAttribute<Profesor, Usuario> usuarioList;
    public static volatile SingularAttribute<Profesor, String> apellido;
    public static volatile ListAttribute<Profesor, UnidadDeAprendizaje> unidadDeAprendizajeList;
    public static volatile SingularAttribute<Profesor, String> nombre;
    public static volatile SingularAttribute<Profesor, String> rfc;

}