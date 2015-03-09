/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.Entite;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Christopher
 */
@Entity
@Table(name = "client")
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findMail", query = "SELECT c FROM Client c WHERE c.email = :cMail"),
    @NamedQuery(name = "Client.findMailMdp", query = "SELECT c FROM Client c WHERE c.email = :cMail AND c.mdp = :cMdp"),
    @NamedQuery(name = "Client.findId", query = "SELECT c FROM Client c WHERE c.clientID = :cId")})
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ClientID")
    private Integer clientID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Prenom")
    private String prenom;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Mdp")
    private String mdp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateOffreDebut")
    @Temporal(TemporalType.DATE)
    private Date dateOffreDebut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateOffreFin")
    @Temporal(TemporalType.DATE)
    private Date dateOffreFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BandePassante")
    private int bandePassante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quotas")
    private int quotas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Espace")
    private int espace;
    @JoinColumn(name = "PlanID", referencedColumnName = "PlanID")
    @ManyToOne(optional = false)
    private Plan planID;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "clientID")
    //private Collection<Stockageclient> stockageclientCollection;

    public Client() {
    }

    public Client(Integer clientID) {
        this.clientID = clientID;
    }

    public Client(Integer clientID, String nom, String prenom, String email, String mdp, Date dateOffreDebut, Date dateOffreFin, int bandePassante, int quotas) {
        this.clientID = clientID;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.dateOffreDebut = dateOffreDebut;
        this.dateOffreFin = dateOffreFin;
        this.bandePassante = bandePassante;
        this.quotas = quotas;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Date getDateOffreDebut() {
        return dateOffreDebut;
    }

    public void setDateOffreDebut(Date dateOffreDebut) {
        this.dateOffreDebut = dateOffreDebut;
    }

    public Date getDateOffreFin() {
        return dateOffreFin;
    }

    public void setDateOffreFin(Date dateOffreFin) {
        this.dateOffreFin = dateOffreFin;
    }

    public int getBandePassante() {
        return bandePassante;
    }

    public void setBandePassante(int bandePassante) {
        this.bandePassante = bandePassante;
    }

    public int getQuotas() {
        return quotas;
    }

    public void setQuotas(int quotas) {
        this.quotas = quotas;
    }
    
    public int getEspace() {
        return espace;
    }

    public void setEspace(int espace) {
        this.espace = espace;
    }

    public Plan getPlanID() {
        return planID;
    }

    public void setPlanID(Plan planID) {
        this.planID = planID;
    }

    /*public Collection<Stockageclient> getStockageclientCollection() {
        return stockageclientCollection;
    }

    public void setStockageclientCollection(Collection<Stockageclient> stockageclientCollection) {
        this.stockageclientCollection = stockageclientCollection;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientID != null ? clientID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.clientID == null && other.clientID != null) || (this.clientID != null && !this.clientID.equals(other.clientID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.CubbyHole.Entite.Client[ clientID=" + clientID + " ]";
    }
    
}
