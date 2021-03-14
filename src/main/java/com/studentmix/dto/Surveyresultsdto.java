/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentmix.dto;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean
@ViewScoped
public class Surveyresultsdto implements Dto {
    private Integer id;
    
    private String userchoice;
    
    private String comments;
    private Date datecreated;
    private Integer childid;
    
    private String gender;
    
    private String placeofwork;
    
    private Date dob;
    
    private String degree;
    
    private Participantsdto participantid;
    
    private Questionsdto questionid;
    public Surveyresultsdto() {
    }

    public Surveyresultsdto(Integer id) {
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

    public Participantsdto getParticipantid() {
        return participantid;
    }

    public void setParticipantid(Participantsdto participantid) {
        this.participantid = participantid;
    }

    public Questionsdto getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Questionsdto questionid) {
        this.questionid = questionid;
    }

    
}
