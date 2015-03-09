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
@Table(name = "stockage")
@NamedQueries({
    @NamedQuery(name = "Stockage.findAll", query = "SELECT s FROM Stockage s")})
public class Stockage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "StockageID")
    private Integer stockageID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "Nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Adresse")
    private String adresse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    ///@OneToMany(cascade = CascadeType.ALL, mappedBy = "stockageID")
    //private Collection<Stockageclient> stockageclientCollection;

    public Stockage() {
    }

    public Stockage(Integer stockageID) {
        this.stockageID = stockageID;
    }

    public Stockage(Integer stockageID, String adresse, Date date) {
        this.stockageID = stockageID;
        this.adresse = adresse;
        this.date = date;
    }

    public Integer getStockageID() {
        return stockageID;
    }

    public void setStockageID(Integer stockageID) {
        this.stockageID = stockageID;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        hash += (stockageID != null ? stockageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stockage)) {
            return false;
        }
        Stockage other = (Stockage) object;
        if ((this.stockageID == null && other.stockageID != null) || (this.stockageID != null && !this.stockageID.equals(other.stockageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.CubbyHole.Entite.Stockage[ stockageID=" + stockageID + " ]";
    }
    
}
