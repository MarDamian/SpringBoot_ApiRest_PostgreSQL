package org.damian.sapi.entidades;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.damian.sapi.entidades.Programa;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-04-22T16:52:17", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Estudiante.class)
public class Estudiante_ { 

    public static volatile SingularAttribute<Estudiante, Programa> programaId;
    public static volatile SingularAttribute<Estudiante, Integer> id;
    public static volatile SingularAttribute<Estudiante, String> nombre;
    public static volatile SingularAttribute<Estudiante, Integer> edad;

}