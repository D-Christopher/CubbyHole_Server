/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.Entite;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Christopher
 */
@Entity
@Table(name = "plan")
@NamedQueries({
    @NamedQuery(name = "Plan.findAll", query = "SELECT p FROM Plan p")})
public class Plan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PlanID")
    private Integer planID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Titre")
    private String titre;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Prix")
    private int prix;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Duree")
    private int duree;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EspaceStockage")
    private int espaceStockage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QuotasQuotidient")
    private int quotasQuotidient;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BandePassante")
    private int bandePassante;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "planID")
    //private Collection<Client> clientCollection;

    public Plan() {
    }

    public Plan(Integer planID) {
        this.planID = planID;
    }

    public Plan(Integer planID, String titre, String description, int prix, int duree, int espaceStockage, int quotasQuotidient, int bandePassante) {
        this.planID = planID;
        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.duree = duree;
        this.espaceStockage = espaceStockage;
        this.quotasQuotidient = quotasQuotidient;
        this.bandePassante = bandePassante;
    }

    public Integer getPlanID() {
        return planID;
    }

    public void setPlanID(Integer planID) {
        this.planID = planID;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getEspaceStockage() {
        return espaceStockage;
    }

    public void setEspaceStockage(int espaceStockage) {
        this.espaceStockage = espaceStockage;
    }

    public int getQuotasQuotidient() {
        return quotasQuotidient;
    }

    public void setQuotasQuotidient(int quotasQuotidient) {
        this.quotasQuotidient = quotasQuotidient;
    }

    public int getBandePassante() {
        return bandePassante;
    }

    public void setBandePassante(int bandePassante) {
        this.bandePassante = bandePassante;
    }

    /*public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planID != null ? planID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plan)) {
            return false;
        }
        Plan other = (Plan) object;
        if ((this.planID == null && other.planID != null) || (this.planID != null && !this.planID.equals(other.planID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.CubbyHole.Entite.Plan[ planID=" + planID + " ]";
    }
    
}
