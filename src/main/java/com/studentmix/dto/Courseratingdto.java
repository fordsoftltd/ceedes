/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentmix.dto;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Courseratingdto implements Dto {
   
    private Integer id;
    
    private String coursetitle;
    
    private String rating;
    
    private Questionsdto questionid;

    public Courseratingdto() {
    }

    public Courseratingdto(Integer id) {
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

    public Questionsdto getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Questionsdto questionid) {
        this.questionid = questionid;
    }

    
}
