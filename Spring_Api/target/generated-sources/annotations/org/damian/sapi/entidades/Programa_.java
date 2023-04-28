package org.damian.sapi.entidades;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.damian.sapi.entidades.Estudiante;
import org.damian.sapi.entidades.Facultad;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-04-22T16:52:16", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Programa.class)
public class Programa_ { 

    public static volatile ListAttribute<Programa, Estudiante> estudianteList;
    public static volatile SingularAttribute<Programa, Facultad> facultadId;
    public static volatile SingularAttribute<Programa, Integer> id;
    public static volatile SingularAttribute<Programa, String> nombre;

}