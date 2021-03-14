/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentmix.mapper;

import com.studentmix.dto.Admindto;
import com.studentmix.dto.Courseratingdto;
import com.studentmix.dto.Participantsdto;
import com.studentmix.dto.Questionsdto;
import com.studentmix.dto.Surveyresultsdto;
import com.studentmix.dto.Vwsurveyresultsdto;
import com.studentmix.model.Admin;
import com.studentmix.model.Courserating;
import com.studentmix.model.Participants;
import com.studentmix.model.Questions;
import com.studentmix.model.Surveyresults;
import com.studentmix.model.Vwsurveyresults;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 */
public class DtoMapper {
    public static Vwsurveyresults maptoVwsurveyresults(Vwsurveyresultsdto mapfrom){
        if(mapfrom ==null){
            return null;
        }
        Vwsurveyresults mapto = new Vwsurveyresults();
        mapto.setComments(mapfrom.getComments());
        mapto.setFrequency(mapfrom.getFrequency());
        mapto.setId(mapfrom.getId());
        mapto.setQuestion(mapfrom.getQuestion());
        mapto.setQuestionid(mapfrom.getQuestionid());
        mapto.setUserchoice(mapfrom.getUserchoice());
        return mapto;
    }
    public static Vwsurveyresultsdto maptoVwsurveyresultsdto(Vwsurveyresults mapfrom){
        if(mapfrom ==null){
            return null;
        }
        Vwsurveyresultsdto mapto = new Vwsurveyresultsdto();
        mapto.setComments(mapfrom.getComments());
        mapto.setFrequency(mapfrom.getFrequency());
        mapto.setId(mapfrom.getId());
        mapto.setQuestion(mapfrom.getQuestion());
        mapto.setQuestionid(mapfrom.getQuestionid());
        mapto.setUserchoice(mapfrom.getUserchoice());
        return mapto;
    }
    public static List<Vwsurveyresultsdto> maptoVwsurveyresultsList(List<Vwsurveyresults> mapfrom){
        if(mapfrom ==null){
            return null;
        }
        List<Vwsurveyresultsdto> list = new ArrayList<>();
        for(Vwsurveyresults rs: mapfrom){
            list.add(maptoVwsurveyresultsdto(rs));
        }
        return list;
    }
    public static Surveyresults maptoSurveyresults(Surveyresultsdto mapfrom){
        if(mapfrom ==null){
            return null;
        }
        Surveyresults mapto = new Surveyresults();
        mapto.setChildid(mapfrom.getChildid());
        mapto.setComments(mapfrom.getComments());
        mapto.setDatecreated(mapfrom.getDatecreated());
        mapto.setDegree(mapfrom.getDegree());
        mapto.setDob(mapfrom.getDob());
        mapto.setGender(mapfrom.getGender());
        mapto.setId(mapfrom.getId());
        mapto.setParticipantid(maptoParticipants(mapfrom.getParticipantid()));
        mapto.setPlaceofwork(mapfrom.getPlaceofwork());
        mapto.setQuestionid(maptoQuestions(mapfrom.getQuestionid()));
        mapto.setUserchoice(mapfrom.getUserchoice());
        return mapto;
    }
    public static Surveyresultsdto maptoSurveyresultsdto(Surveyresults mapfrom){
        if(mapfrom ==null){
            return null;
        }
        Surveyresultsdto mapto = new Surveyresultsdto();
        mapto.setChildid(mapfrom.getChildid());
        mapto.setComments(mapfrom.getComments());
        mapto.setDatecreated(mapfrom.getDatecreated());
        mapto.setDegree(mapfrom.getDegree());
        mapto.setDob(mapfrom.getDob());
        mapto.setGender(mapfrom.getGender());
        mapto.setId(mapfrom.getId());
        mapto.setParticipantid(maptoParticipantsdto(mapfrom.getParticipantid()));
        mapto.setPlaceofwork(mapfrom.getPlaceofwork());
        mapto.setQuestionid(maptoQuestionsdto(mapfrom.getQuestionid()));
        mapto.setUserchoice(mapfrom.getUserchoice());
        return mapto;
    }
    public static List<Surveyresultsdto> maptoSurveyresultsList(List<Surveyresults> mapfrom){
        if(mapfrom ==null){
            return null;
        }
        List<Surveyresultsdto> list = new ArrayList<>();
        for(Surveyresults rs:mapfrom){
            list.add(maptoSurveyresultsdto(rs));
        }
        return list;
    }
    public static Questions maptoQuestions(Questionsdto mapfrom){
        if(mapfrom ==null){
            return null;
        }
        Questions mapto =new Questions();
        mapto.setDescription(mapfrom.getDescription());
        mapto.setId(mapfrom.getId());
        return mapto;
    }
    public static Questionsdto maptoQuestionsdto(Questions mapfrom){
        if(mapfrom ==null){
            return null;
        }
        Questionsdto mapto =new Questionsdto();
        mapto.setDescription(mapfrom.getDescription());
        mapto.setId(mapfrom.getId());
        return mapto;
    }
    public static List<Questionsdto> maptoQuestionList(List<Questions> mapfrom){
        if(mapfrom ==null){
            return null;
        }
        List<Questionsdto> list= new ArrayList<>();
        for(Questions rs: mapfrom){
             list.add(maptoQuestionsdto(rs));
        }
        return list;
    }
    public static Courseratingdto maptoCourseratingdto(Courserating mapfrom){
        if(mapfrom ==null){
            return null;
        }
        Courseratingdto mapto = new Courseratingdto();
        mapto.setCoursetitle(mapfrom.getCoursetitle());
        mapto.setId(mapfrom.getId());
        mapto.setQuestionid(maptoQuestionsdto(mapfrom.getQuestionid()));
        mapto.setRating(mapfrom.getRating());
        return mapto;
    }
    public static Courserating maptoCourserating(Courseratingdto mapfrom){
        if(mapfrom ==null){
            return null;
        }
        Courserating mapto = new Courserating();
        mapto.setCoursetitle(mapfrom.getCoursetitle());
        mapto.setId(mapfrom.getId());
        mapto.setQuestionid(maptoQuestions(mapfrom.getQuestionid()));
        mapto.setRating(mapfrom.getRating());
        return mapto;
    }
    public static List<Courseratingdto> maptoCourseratingList(List<Courserating> mapfrom){
        if(mapfrom ==null){
            return null;
        }
        List<Courseratingdto> list = new ArrayList<>();
        for(Courserating rs: mapfrom){
            list.add(maptoCourseratingdto(rs));
        }
        return list;
    }
   public static Participants maptoParticipants(Participantsdto mapfrom){
       if(mapfrom==null){
           return null;
       }
       Participants mapto = new Participants();
       mapto.setAmountpaid(mapfrom.getAmountpaid());
       mapto.setCourse(mapfrom.getCourse());
       mapto.setEmail(mapfrom.getEmail());
       mapto.setFirstname(mapfrom.getFirstname());
       mapto.setGender(mapfrom.getGender());
       mapto.setId(mapfrom.getId());
       mapto.setInstitution(mapfrom.getInstitution());
       mapto.setLastname(mapfrom.getLastname());
       mapto.setMiddlename(mapfrom.getMiddlename());
       mapto.setNationality(mapfrom.getNationality());
       mapto.setPaymentmode(mapfrom.getPaymentmode());
       mapto.setTelephoneno(mapfrom.getTelephoneno());
       mapto.setTitle(mapfrom.getTitle());
       mapto.setPhoto(mapfrom.getPhoto());
       mapto.setSerialno(mapfrom.getSerialno());
       mapto.setDatecreated(mapfrom.getDatecreated());
       return mapto;
   }
   public static Participantsdto maptoParticipantsdto(Participants mapfrom){
       if(mapfrom==null){
           return null;
       }
       Participantsdto mapto = new Participantsdto();
       mapto.setAmountpaid(mapfrom.getAmountpaid());
       mapto.setCourse(mapfrom.getCourse());
       mapto.setEmail(mapfrom.getEmail());
       mapto.setFirstname(mapfrom.getFirstname());
       mapto.setGender(mapfrom.getGender());
       mapto.setId(mapfrom.getId());
       mapto.setInstitution(mapfrom.getInstitution());
       mapto.setLastname(mapfrom.getLastname());
       mapto.setMiddlename(mapfrom.getMiddlename());
       mapto.setNationality(mapfrom.getNationality());
       mapto.setPaymentmode(mapfrom.getPaymentmode());
       mapto.setTelephoneno(mapfrom.getTelephoneno());
       mapto.setTitle(mapfrom.getTitle());
       mapto.setPhoto(mapfrom.getPhoto());
       mapto.setSerialno(mapfrom.getSerialno());
       mapto.setDatecreated(mapfrom.getDatecreated());
       return mapto;
   }
   public static List<Participantsdto> maptoParticipantsList(List<Participants> mapfrom){
       if(mapfrom==null){
           return null;
       }
       List<Participantsdto> list = new ArrayList<>();
       for(Participants rs:mapfrom){
           list.add(maptoParticipantsdto(rs));
       }
       return list;
   }
   public static Admin maptoAdmin(Admindto mapfrom){
       if(mapfrom ==null){
           return null;
       }
       Admin mapto = new Admin();
       mapto.setDatecreated(mapfrom.getDatecreated());
       mapto.setId(mapfrom.getId());
       mapto.setPassword(mapfrom.getPassword());
       mapto.setUsername(mapfrom.getUsername());
       return mapto;
   }
    public static Admindto maptoAdmindto(Admin mapfrom){
       if(mapfrom ==null){
           return null;
       }
       Admindto mapto = new Admindto();
       mapto.setDatecreated(mapfrom.getDatecreated());
       mapto.setId(mapfrom.getId());
       mapto.setPassword(mapfrom.getPassword());
       mapto.setUsername(mapfrom.getUsername());
       return mapto;
   }
    public static List<Admindto> maptoAdminList(List<Admin> mapfrom){
        if(mapfrom ==null){
            return null;
        }
        List<Admindto> list = new ArrayList<>();
        for(Admin rs:mapfrom){
            list.add(maptoAdmindto(rs));
        }
        return list;
    }
    
}