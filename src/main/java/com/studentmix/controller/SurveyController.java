/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentmix.controller;

import com.studentmix.dto.Results;
import com.studentmix.dto.Surveyresultsdto;
import com.studentmix.model.Participants;
import com.studentmix.model.Questions;
import com.studentmix.model.Surveyresults;
import com.studentmix.repository.AppService;
import com.studentmix.utils.AppUtil;
import com.studentmix.utils.FacesUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author JIDEX
 */
@SuppressWarnings("serial")
@Scope("session")
@Component
@ManagedBean
public class SurveyController implements Serializable{
    @Autowired
	AppService service;
    private List<Surveyresultsdto> questionList;
    @Autowired
    AppController app;
    @PostConstruct
    public void init(){
        questionList = new ArrayList<>();
    }
    public void sendSuvery(ActionEvent e){
        HttpSession session=FacesUtils.getHttpSession(false);
        Integer userid =(Integer)session.getAttribute("userid");
        Results rs =(Results)FacesUtils.getManagedBean("results");
        List<Surveyresults> list = new ArrayList<>();
        Surveyresults record = new Surveyresults();
        record.setChildid(4);
        record.setQuestionid(new Questions(4));
        record.setComments(rs.getC4());
        record.setParticipantid(new Participants(userid==null?1:userid));
        record.setUserchoice(rs.getA4());
        list.add(record);
        
        record = new Surveyresults();
        record.setChildid(5);
        record.setQuestionid(new Questions(5));
        record.setComments(rs.getC5());
        record.setParticipantid(new Participants(userid==null?1:userid));
        record.setUserchoice(rs.getA5());
        list.add(record);
        
        record = new Surveyresults();
        record.setChildid(6);
        record.setQuestionid(new Questions(6));
        record.setComments(rs.getC6());
        record.setParticipantid(new Participants(userid==null?1:userid));
        record.setUserchoice(rs.getA6());
        list.add(record);
        
        record = new Surveyresults();
        record.setChildid(7);
        record.setQuestionid(new Questions(7));
        record.setComments(rs.getC7());
        record.setParticipantid(new Participants(userid==null?1:userid));
        record.setUserchoice(rs.getA7());
        list.add(record);
        
        record = new Surveyresults();
        record.setChildid(8);
        record.setQuestionid(new Questions(8));
        record.setComments(rs.getC8());
        record.setParticipantid(new Participants(userid==null?1:userid));
        record.setUserchoice(rs.getA8());
        list.add(record);
        record = new Surveyresults();
        record.setChildid(9);
        record.setQuestionid(new Questions(9));
        record.setComments(rs.getC9());
        record.setParticipantid(new Participants(userid==null?1:userid));
        record.setUserchoice(rs.getA9());
        list.add(record);
        
        record = new Surveyresults();
        record.setChildid(10);
        record.setQuestionid(new Questions(10));
        record.setComments(rs.getC10());
        record.setParticipantid(new Participants(userid==null?1:userid));
        record.setUserchoice(rs.getA10());
        list.add(record);
        record = new Surveyresults();
        record.setChildid(11);
        record.setQuestionid(new Questions(11));
        record.setComments(rs.getC11());
        record.setParticipantid(new Participants(userid==null?1:userid));
        record.setUserchoice(rs.getA11());
        list.add(record);
        
        record = new Surveyresults();
        record.setChildid(12);
        record.setQuestionid(new Questions(12));
        record.setComments(rs.getC12());
        record.setParticipantid(new Participants(userid==null?1:userid));
        record.setUserchoice(rs.getA12());
        list.add(record);
        
        record = new Surveyresults();
        record.setChildid(14);
        record.setQuestionid(new Questions(14));
        record.setComments(rs.getC14());
        record.setParticipantid(new Participants(userid==null?1:userid));
        record.setUserchoice(rs.getA14());
        list.add(record);
        
        record = new Surveyresults();
        record.setChildid(15);
        record.setQuestionid(new Questions(15));
        record.setComments(rs.getC15());
        record.setParticipantid(new Participants(userid==null?1:userid));
        record.setUserchoice(rs.getA15());
        list.add(record);
        
        record = new Surveyresults();
        record.setChildid(16);
        record.setQuestionid(new Questions(16));
        record.setComments(rs.getC16());
        record.setParticipantid(new Participants(userid==null?1:userid));
        record.setUserchoice(rs.getA16());
        list.add(record);
        
        record = new Surveyresults();
        record.setChildid(1);
        record.setQuestionid(new Questions(13));
        record.setParticipantid(new Participants(userid==null?1:userid));
        record.setUserchoice(rs.getA17());
        record.setComments("Course design");
        list.add(record);
        
        record = new Surveyresults();
        record.setChildid(2);
        record.setQuestionid(new Questions(13));
        record.setParticipantid(new Participants(userid==null?1:userid));
        record.setUserchoice(rs.getA18());
        record.setComments("Instruction methodologies");
        list.add(record);
        
        record = new Surveyresults();
        record.setChildid(3);
        record.setQuestionid(new Questions(13));
        record.setParticipantid(new Participants(userid==null?1:userid));
        record.setUserchoice(rs.getA19());
        record.setComments("Quality of the resource person");
        list.add(record);
        
        record = new Surveyresults();
        record.setChildid(4);
        record.setQuestionid(new Questions(13));
        record.setParticipantid(new Participants(userid==null?1:userid));
        record.setUserchoice(rs.getA20());
          record.setComments("Quality of interaction with the resource person");
        list.add(record);
        
        record = new Surveyresults();
        record.setChildid(5);
        record.setQuestionid(new Questions(13));
        record.setParticipantid(new Participants(userid==null?1:userid));
        record.setUserchoice(rs.getA21());
          record.setComments("Quality of interaction with the other participants");
        list.add(record);
        
        record = new Surveyresults();
        record.setChildid(6);
        record.setQuestionid(new Questions(13));
        record.setParticipantid(new Participants(userid==null?1:userid));
        record.setUserchoice(rs.getA22());
          record.setComments("Relevance of the courses");
        list.add(record);
        record = new Surveyresults();
        record.setChildid(7);
        record.setQuestionid(new Questions(13));
        record.setParticipantid(new Participants(userid==null?1:userid));
        record.setUserchoice(rs.getA23());
          record.setComments("Value-for-money of the program");
        list.add(record);
        
        record = new Surveyresults();
        record.setChildid(8);
        record.setQuestionid(new Questions(13));
        record.setParticipantid(new Participants(userid==null?1:userid));
        record.setUserchoice(rs.getA24());
          record.setComments("Usefulness of skills acquired during the workshop");
        list.add(record);
        
        record = new Surveyresults();
        record.setChildid(9);
        record.setQuestionid(new Questions(13));
        record.setComments("Quality of communication during the workshop.");
        record.setParticipantid(new Participants(userid==null?1:userid));
        record.setUserchoice(rs.getA25());
        list.add(record);
        
        record = new Surveyresults();
        record.setChildid(10);
          record.setComments("Overall Experience");
        record.setQuestionid(new Questions(13));
        record.setParticipantid(new Participants(userid==null?1:userid));
        record.setUserchoice(rs.getA26());
        list.add(record);
        service.getSurveyresultsRepo().save(list);
        app.printMessage("Record Successfully Submitted", AppUtil.SUCCESS, AppUtil.SUCCESS_TAG);
        app.reset("results");
        list.clear();
        
    }
    public AppService getService() {
        return service;
    }

    public void setService(AppService service) {
        this.service = service;
    }

    public List<Surveyresultsdto> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Surveyresultsdto> questionList) {
        this.questionList = questionList;
    }
    
}
