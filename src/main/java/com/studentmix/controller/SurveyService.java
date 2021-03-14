/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentmix.controller;

import com.studentmix.dto.ServiceResult;
import com.studentmix.model.Participants;
import com.studentmix.repository.AppService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JIDEX
 */
@RestController
@RequestMapping(value = "/api", headers = "Accept=application/json")
public class SurveyService {
    @Autowired
    AppService service;
    @Autowired
    private JavaMailSender sender;
    @GetMapping("/send")
    public String sendMessage() throws MessagingException{
        MimeMessage message = sender.createMimeMessage();

	        MimeMessageHelper helper = new MimeMessageHelper(message,true);
	        helper.setTo("odofintimothy@gmail.com");
	        helper.setText("How are you?");
	        helper.setSubject("Hi");
	        ClassPathResource file = new ClassPathResource("/images/logo.jpg");
	        helper.addAttachment("logo.jpg", file);
	        sender.send(message);
                return "Message Sent.........";
    }
    @GetMapping("/survey")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException{
     HttpSession session = request.getSession(true);
      String userId =request.getParameter("userId");
      Integer id = Integer.valueOf(userId);
      session.setAttribute("userid", id);
      response.sendRedirect("./../index.html");
    }
    
    @GetMapping("/sendmessage")
    public List<ServiceResult> sendMail() throws IOException, Exception{
        List<ServiceResult> results = new ArrayList<>();
     for(Participants  rs: service.getParticipantsRepo().findAll()){
         ServiceResult result =service.sendMessage(rs);
         results.add(result);
     }
       
     return results;
    }
    
}
