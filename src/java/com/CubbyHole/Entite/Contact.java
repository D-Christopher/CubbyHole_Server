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
import javax.validation.constraints.NotNull;

/**
 *
 * @author Christopher
 */
@Entity
@Table(name = "contact")
@NamedQueries({
    @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c"),
    @NamedQuery(name = "Contact.findById", query = "SELECT c FROM Contact c WHERE c.contactID = :cId"),
    @NamedQuery(name = "Contact.findByClientId", query = "SELECT c FROM Contact c WHERE c.clientContact = :cId"),
    @NamedQuery(name = "Contact.findBy2Id", query = "SELECT c FROM Contact c WHERE c.clientContact = :clientContact AND c.clientID=:clientID")})
public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ContactID")
    private Integer contactID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ClientContact")
    private int clientContact;
    @JoinColumn(name = "ClientID", referencedColumnName = "ClientID")
    @ManyToOne(optional = false)
    private Client clientID;

    public Contact() {
    }

    public Contact(Integer contactID) {
        this.contactID = contactID;
    }

    public Contact(Integer contactID, int clientContact) {
        this.contactID = contactID;
        this.clientContact = clientContact;
    }

    public Integer getContactID() {
        return contactID;
    }

    public void setContactID(Integer contactID) {
        this.contactID = contactID;
    }

    public int getClientContact() {
        return clientContact;
    }

    public void setClientContact(int clientContact) {
        this.clientContact = clientContact;
    }

    public Client getClientID() {
        return clientID;
    }

    public void setClientID(Client clientID) {
        this.clientID = clientID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactID != null ? contactID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) object;
        if ((this.contactID == null && other.contactID != null) || (this.contactID != null && !this.contactID.equals(other.contactID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.CubbyHole.Entite.Contact[ contactID=" + contactID + " ]";
    }
    
}
