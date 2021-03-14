/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentmix.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JIDEX
 */
@Entity
@Table(name = "surveyresults")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Surveyresults.findAll", query = "SELECT s FROM Surveyresults s"),
    @NamedQuery(name = "Surveyresults.findById", query = "SELECT s FROM Surveyresults s WHERE s.id = :id"),
    @NamedQuery(name = "Surveyresults.findByUserchoice", query = "SELECT s FROM Surveyresults s WHERE s.userchoice = :userchoice"),
    @NamedQuery(name = "Surveyresults.findByDatecreated", query = "SELECT s FROM Surveyresults s WHERE s.datecreated = :datecreated"),
    @NamedQuery(name = "Surveyresults.findByChildid", query = "SELECT s FROM Surveyresults s WHERE s.childid = :childid"),
    @NamedQuery(name = "Surveyresults.findByGender", query = "SELECT s FROM Surveyresults s WHERE s.gender = :gender"),
    @NamedQuery(name = "Surveyresults.findByDob", query = "SELECT s FROM Surveyresults s WHERE s.dob = :dob")})
public class Surveyresults implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 70)
    @Column(name = "userchoice")
    private String userchoice;
    @Lob
    @Size(max = 65535)
    @Column(name = "comments")
    private String comments;
    @Column(name = "datecreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreated;
    @Column(name = "childid")
    private Integer childid;
    @Size(max = 10)
    @Column(name = "gender")
    private String gender;
    @Lob
    @Size(max = 65535)
    @Column(name = "placeofwork")
    private String placeofwork;
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Lob
    @Size(max = 65535)
    @Column(name = "degree")
    private String degree;
    @JoinColumn(name = "participantid", referencedColumnName = "id")
    @ManyToOne
    private Participants participantid;
    @JoinColumn(name = "questionid", referencedColumnName = "id")
    @ManyToOne
    private Questions questionid;

    public Surveyresults() {
    }

    public Surveyresults(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserchoice() {
        return userchoice;
    }

    public void setUserchoice(String userchoice) {
        this.userchoice = userchoice;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public Integer getChildid() {
        return childid;
    }

    public void setChildid(Integer childid) {
        this.childid = childid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPlaceofwork() {
        return placeofwork;
    }

    public void setPlaceofwork(String placeofwork) {
        this.placeofwork = placeofwork;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Participants getParticipantid() {
        return participantid;
    }

    public void setParticipantid(Participants participantid) {
        this.participantid = participantid;
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
        if (!(object instanceof Surveyresults)) {
            return false;
        }
        Surveyresults other = (Surveyresults) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.studentmix.model.Surveyresults[ id=" + id + " ]";
    }
    
}
