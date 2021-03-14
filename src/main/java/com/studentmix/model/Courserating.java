/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentmix.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JIDEX
 */
@Entity
@Table(name = "courserating")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Courserating.findAll", query = "SELECT c FROM Courserating c"),
    @NamedQuery(name = "Courserating.findById", query = "SELECT c FROM Courserating c WHERE c.id = :id"),
    @NamedQuery(name = "Courserating.findByRating", query = "SELECT c FROM Courserating c WHERE c.rating = :rating")})
public class Courserating implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(name = "coursetitle")
    private String coursetitle;
    @Size(max = 20)
    @Column(name = "rating")
    private String rating;
    @JoinColumn(name = "questionid", referencedColumnName = "id")
    @ManyToOne
    private Questions questionid;

    public Courserating() {
    }

    public Courserating(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoursetitle() {
        return coursetitle;
    }

    public void setCoursetitle(String coursetitle) {
        this.coursetitle = coursetitle;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Questions getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Questions questionid) {
        this.questionid = questionid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Courserating)) {
            return false;
        }
        Courserating other = (Courserating) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.studentmix.model.Courserating[ id=" + id + " ]";
    }
    
}
