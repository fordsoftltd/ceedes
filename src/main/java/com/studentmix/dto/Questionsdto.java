/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentmix.dto;


import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
 
@ManagedBean
@ViewScoped
public class Questionsdto implements Dto {
    private Integer id;
    
    private String description;
    
    private List<Courseratingdto> courseratingList;
    
    private List<Surveyresultsdto> surveyresultsList;

    public Questionsdto() {
    }

    public Questionsdto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    public List<Courseratingdto> getCourseratingList() {
        return courseratingList;
    }

    public void setCourseratingList(List<Courseratingdto> courseratingList) {
        this.courseratingList = courseratingList;
    }

    
    public List<Surveyresultsdto> getSurveyresultsList() {
        return surveyresultsList;
    }

    public void setSurveyresultsList(List<Surveyresultsdto> surveyresultsList) {
        this.surveyresultsList = surveyresultsList;
    }

}
