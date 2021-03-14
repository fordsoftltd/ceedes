/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentmix.utils;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import org.springframework.web.context.annotation.SessionScope;

/**
 *
 * @author JIDEX
 */
@ManagedBean
@SessionScope
public class AppHelper implements Serializable {

    private String category;
    private Integer id;
    private Integer issuedby;
    private Integer issuedto;
    private String oldPassword;
    private String password;
    private String confirmPassword;
    private String username;
    private Integer institutionid;
    private Integer assetid;
    private Integer customerid;
    private Double volume;
   private String invoiceno;

    public String getInvoiceno() {
        return invoiceno;
    }

    public void setInvoiceno(String invoiceno) {
        this.invoiceno = invoiceno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getIssuedby() {
        return issuedby;
    }

    public void setIssuedby(Integer issuedby) {
        this.issuedby = issuedby;
    }

    public Integer getIssuedto() {
        return issuedto;
    }

    public void setIssuedto(Integer issuedto) {
        this.issuedto = issuedto;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getInstitutionid() {
        return institutionid;
    }

    public void setInstitutionid(Integer institutionid) {
        this.institutionid = institutionid;
    }

    public Integer getAssetid() {
        return assetid;
    }

    public void setAssetid(Integer assetid) {
        this.assetid = assetid;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

}
