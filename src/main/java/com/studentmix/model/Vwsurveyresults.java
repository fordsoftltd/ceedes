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
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JIDEX
 */
@Entity
@Table(name = "vwsurveyresults")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vwsurveyresults.findAll", query = "SELECT v FROM Vwsurveyresults v"),
    @NamedQuery(name = "Vwsurveyresults.findById", query = "SELECT v FROM Vwsurveyresults v WHERE v.id = :id"),
    @NamedQuery(name = "Vwsurveyresults.findByQuestionid", query = "SELECT v FROM Vwsurveyresults v WHERE v.questionid = :questionid"),
    @NamedQuery(name = "Vwsurveyresults.findByFrequency", query = "SELECT v FROM Vwsurveyresults v WHERE v.frequency = :frequency")})
public class Vwsurveyresults implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    @Id
    private int id;
    @Column(name = "questionid")
    private Integer questionid;
    @Lob
    @Size(max = 65535)
    private String userchoice;
    @Lob
    @Size(max = 65535)
    @Column(name = "question")
    private String question;
    @Lob
    @Size(max = 65535)
    @Column(name = "comments")
    private String comments;
    @Basic(optional = false)
    @NotNull
    @Column(name = "frequency")
    private long frequency;

    public Vwsurveyresults() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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

    public long getFrequency() {
        return frequency;
    }

    public void setFrequency(long frequency) {
        this.frequency = frequency;
    }
    
}
