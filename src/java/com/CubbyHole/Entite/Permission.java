/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.Entite;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Christopher
 */
@Entity
@Table(name = "permission")
@NamedQueries({
    @NamedQuery(name = "Permission.findAll", query = "SELECT p FROM Permission p")})
public class Permission implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PermissionID")
    private Integer permissionID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Titre")
    private String titre;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "permissionID")
    //private Collection<Stockageclient> stockageclientCollection;

    public Permission() {
    }

    public Permission(Integer permissionID) {
        this.permissionID = permissionID;
    }

    public Permission(Integer permissionID, String titre) {
        this.permissionID = permissionID;
        this.titre = titre;
    }

    public Integer getPermissionID() {
        return permissionID;
    }

    public void setPermissionID(Integer permissionID) {
        this.permissionID = permissionID;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
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
        hash += (permissionID != null ? permissionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permission)) {
            return false;
        }
        Permission other = (Permission) object;
        if ((this.permissionID == null && other.permissionID != null) || (this.permissionID != null && !this.permissionID.equals(other.permissionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.CubbyHole.Entite.Permission[ permissionID=" + permissionID + " ]";
    }
    
}
