package com.CubbyHole.Entite;

import com.CubbyHole.Entite.Client;
import com.CubbyHole.Entite.Permission;
import com.CubbyHole.Entite.Stockage;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-16T17:01:18")
@StaticMetamodel(Stockageclient.class)
public class Stockageclient_ { 

    public static volatile SingularAttribute<Stockageclient, Permission> permissionID;
    public static volatile SingularAttribute<Stockageclient, Integer> stockageClientID;
    public static volatile SingularAttribute<Stockageclient, Client> clientID;
    public static volatile SingularAttribute<Stockageclient, Client> partagerID;
    public static volatile SingularAttribute<Stockageclient, Stockage> stockageID;
    public static volatile SingularAttribute<Stockageclient, Boolean> auteur;

}