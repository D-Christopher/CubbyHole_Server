package com.CubbyHole.Entite;

import com.CubbyHole.Entite.Plan;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-16T17:01:18")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, Integer> clientID;
    public static volatile SingularAttribute<Client, Integer> quotas;
    public static volatile SingularAttribute<Client, Integer> espace;
    public static volatile SingularAttribute<Client, String> mdp;
    public static volatile SingularAttribute<Client, Date> dateOffreFin;
    public static volatile SingularAttribute<Client, Integer> bandePassante;
    public static volatile SingularAttribute<Client, Date> dateOffreDebut;
    public static volatile SingularAttribute<Client, Plan> planID;
    public static volatile SingularAttribute<Client, String> nom;
    public static volatile SingularAttribute<Client, String> prenom;
    public static volatile SingularAttribute<Client, String> email;

}