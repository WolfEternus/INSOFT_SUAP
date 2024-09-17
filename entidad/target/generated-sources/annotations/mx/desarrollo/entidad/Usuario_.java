package mx.desarrollo.entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.desarrollo.entidad.Profesor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-09-16T17:33:38")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> tipo;
    public static volatile SingularAttribute<Usuario, Profesor> idProfesor;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile SingularAttribute<Usuario, String> correo;
    public static volatile SingularAttribute<Usuario, String> contraseña;

}