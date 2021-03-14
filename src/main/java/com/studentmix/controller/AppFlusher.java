/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentmix.controller;

import com.studentmix.utils.AppUtil;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author JIDEX
 */
@Controller
@RequestMapping(value = "/resource", headers = "Accept=application/json")
public class AppFlusher {
	@Autowired
	ServletContext context;
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException{
      HttpSession session = request.getSession(false);
      
      session.invalidate();
      return "end";
    }
    
}
