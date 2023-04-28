package org.damian.sapi.entidades;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.damian.sapi.entidades.Programa;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-04-22T16:52:16", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Facultad.class)
public class Facultad_ { 

    public static volatile ListAttribute<Facultad, Programa> programaList;
    public static volatile SingularAttribute<Facultad, Integer> id;
    public static volatile SingularAttribute<Facultad, String> nombre;

}