/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.Entite;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Christopher
 */
@Entity
@Table(name = "stockageclient")
@NamedQueries({
    @NamedQuery(name = "Stockageclient.findAll", query = "SELECT s FROM Stockageclient s"),
    @NamedQuery(name = "Stockageclient.suprBy2Id", query = "SELECT s FROM Stockageclient s WHERE s.clientID=:sClient AND s.stockageID=:sStockage"),
    @NamedQuery(name = "Stockageclient.findByClient", query = "SELECT s FROM Stockageclient s WHERE s.clientID=:sClient"),
    @NamedQuery(name = "Stockageclient.findByClientAuteur", query = "SELECT s FROM Stockageclient s WHERE s.clientID=:sClient AND s.auteur = true"),
    @NamedQuery(name = "Stockageclient.findByPartage", query = "SELECT s FROM Stockageclient s WHERE s.stockageID=:sFichier AND s.clientID=:sClient AND s.auteur=FALSE"),
    @NamedQuery(name = "Stockageclient.findByPartagePublic", query = "SELECT s FROM Stockageclient s WHERE s.stockageID=:sFichier AND s.clientID=:sClient AND s.auteur=true"),
    @NamedQuery(name = "Stockageclient.findByVerif", query = "SELECT s FROM Stockageclient s WHERE s.stockageID=:sFichier AND s.clientID=:sClient AND s.partagerID=:sPartager"),
    @NamedQuery(name = "Stockageclient.findByClientNotAuteur", query = "SELECT s FROM Stockageclient s WHERE s.auteur = false AND s.partagerID =:sPartage")})
public class Stockageclient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "StockageClientID")
    private Integer stockageClientID;
    @JoinColumn(name = "ClientID", referencedColumnName = "ClientID")
    @ManyToOne(optional = false)
    private Client clientID;
    @JoinColumn(name = "PartagerID", referencedColumnName = "ClientID")
    @ManyToOne(optional = false)
    private Client partagerID;
    @JoinColumn(name = "StockageID", referencedColumnName = "StockageID")
    @ManyToOne(optional = false)
    private Stockage stockageID;
    @JoinColumn(name = "PermissionID", referencedColumnName = "PermissionID")
    @ManyToOne(optional = false)
    private Permission permissionID;
    @Column(name = "Auteur")
    private Boolean auteur;

    public Stockageclient() {
    }

    public Stockageclient(Integer stockageClientID) {
        this.stockageClientID = stockageClientID;
    }

    public Integer getStockageClientID() {
        return stockageClientID;
    }

    public void setStockageClientID(Integer stockageClientID) {
        this.stockageClientID = stockageClientID;
    }

    public Client getClientID() {
        return clientID;
    }

    public void setClientID(Client clientID) {
        this.clientID = clientID;
    }
    
    public Client getPartagerID() {
        return partagerID;
    }

    public void setPartagerID(Client partagerID) {
        this.partagerID = partagerID;
    }

    public Stockage getStockageID() {
        return stockageID;
    }

    public void setStockageID(Stockage stockageID) {
        this.stockageID = stockageID;
    }

    public Permission getPermissionID() {
        return permissionID;
    }

    public void setPermissionID(Permission permissionID) {
        this.permissionID = permissionID;
    }
    
    public Boolean getAuteur(){
        return auteur;
    }
    
    public void setAuteur(Boolean auteur){
        this.auteur = auteur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stockageClientID != null ? stockageClientID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stockageclient)) {
            return false;
        }
        Stockageclient other = (Stockageclient) object;
        if ((this.stockageClientID == null && other.stockageClientID != null) || (this.stockageClientID != null && !this.stockageClientID.equals(other.stockageClientID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.CubbyHole.Entite.Stockageclient[ stockageClientID=" + stockageClientID + " ]";
    }
    
}
