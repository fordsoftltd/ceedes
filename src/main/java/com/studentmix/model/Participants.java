/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentmix.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JIDEX
 */
@Entity
@Table(name = "participants")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Participants.findAll", query = "SELECT p FROM Participants p"),
    @NamedQuery(name = "Participants.findById", query = "SELECT p FROM Participants p WHERE p.id = :id"),
    @NamedQuery(name = "Participants.findByFirstname", query = "SELECT p FROM Participants p WHERE p.firstname = :firstname"),
    @NamedQuery(name = "Participants.findByMiddlename", query = "SELECT p FROM Participants p WHERE p.middlename = :middlename"),
    @NamedQuery(name = "Participants.findByLastname", query = "SELECT p FROM Participants p WHERE p.lastname = :lastname"),
    @NamedQuery(name = "Participants.findByTitle", query = "SELECT p FROM Participants p WHERE p.title = :title"),
    @NamedQuery(name = "Participants.findByTelephoneno", query = "SELECT p FROM Participants p WHERE p.telephoneno = :telephoneno"),
    @NamedQuery(name = "Participants.findByEmail", query = "SELECT p FROM Participants p WHERE p.email = :email"),
    @NamedQuery(name = "Participants.findByGender", query = "SELECT p FROM Participants p WHERE p.gender = :gender"),
    @NamedQuery(name = "Participants.findByNationality", query = "SELECT p FROM Participants p WHERE p.nationality = :nationality"),
    @NamedQuery(name = "Participants.findByPaymentmode", query = "SELECT p FROM Participants p WHERE p.paymentmode = :paymentmode"),
    @NamedQuery(name = "Participants.findByAmountpaid", query = "SELECT p FROM Participants p WHERE p.amountpaid = :amountpaid"),
    @NamedQuery(name = "Participants.findByDatecreated", query = "SELECT p FROM Participants p WHERE p.datecreated = :datecreated"),
    @NamedQuery(name = "Participants.findBySerialno", query = "SELECT p FROM Participants p WHERE p.serialno = :serialno"),
    @NamedQuery(name = "Participants.findByPhoto", query = "SELECT p FROM Participants p WHERE p.photo = :photo")})
public class Participants implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "firstname")
    private String firstname;
    @Size(max = 50)
    @Column(name = "middlename")
    private String middlename;
    @Size(max = 50)
    @Column(name = "lastname")
    private String lastname;
    @Size(max = 10)
    @Column(name = "title")
    private String title;
    @Size(max = 30)
    @Column(name = "telephoneno")
    private String telephoneno;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 25)
    @Column(name = "email")
    private String email;
    @Size(max = 10)
    @Column(name = "gender")
    private String gender;
    @Size(max = 20)
    @Column(name = "nationality")
    private String nationality;
    @Lob
    @Size(max = 65535)
    @Column(name = "course")
    private String course;
    @Lob
    @Size(max = 65535)
    @Column(name = "institution")
    private String institution;
    @Size(max = 30)
    @Column(name = "paymentmode")
    private String paymentmode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amountpaid")
    private Double amountpaid;
    @Column(name = "datecreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreated;
    @Size(max = 20)
    @Column(name = "serialno")
    private String serialno;
    @Size(max = 20)
    @Column(name = "photo")
    private String photo;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "participantid")
    private List<Surveyresults> surveyresultsList;

    public Participants() {
    }

    public Participants(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTelephoneno() {
        return telephoneno;
    }

    public void setTelephoneno(String telephoneno) {
        this.telephoneno = telephoneno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getPaymentmode() {
        return paymentmode;
    }

    public void setPaymentmode(String paymentmode) {
        this.paymentmode = paymentmode;
    }

    public Double getAmountpaid() {
        return amountpaid;
    }

    public void setAmountpaid(Double amountpaid) {
        this.amountpaid = amountpaid;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @XmlTransient
    public List<Surveyresults> getSurveyresultsList() {
        return surveyresultsList;
    }

    public void setSurveyresultsList(List<Surveyresults> surveyresultsList) {
        this.surveyresultsList = surveyresultsList;
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
        if (!(object instanceof Participants)) {
            return false;
        }
        Participants other = (Participants) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.studentmix.model.Participants[ id=" + id + " ]";
    }
    
}
