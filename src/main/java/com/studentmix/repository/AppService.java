/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentmix.repository;

import com.studentmix.dto.ServiceResult;
import com.studentmix.model.Participants;
import com.studentmix.utils.AppUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

/**
 *
 * @author Abu Moridiyah
 */
@Service
@Transactional
public class AppService {

    @Autowired
    AdminRepo adminRepo;
@Autowired
VwsurveyresultsRepo vwsurveyresultsRepo;
@Autowired
CourseratingRepo courseratingRepo;
@Autowired
QuestionsRepo questionsRepo;
@Autowired
SurveyresultsRepo surveyresultsRepo;

    @Autowired
    ParticipantsRepo participantsRepo;
    @Autowired
    private JavaMailSender sender;
    @Autowired
    private Configuration freemarkerConfig;

    public ServiceResult sendMessage(Participants user) throws Exception {
        ServiceResult results = new ServiceResult();
        String link = AppUtil.RESOURCE_LOCATION + "?userId=" + user.getId() + "&REG_NO=" + user.getSerialno();

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        Map<String, Object> model = new HashMap();
        model.put("user", user.getFirstname() + " " + user.getMiddlename() + " " + user.getLastname());
        model.put("email", user.getEmail());
        model.put("link", link);
        //model.put("logo", image);

        // set loading location to src/main/resources
        // You may want to use a subfolder such as /templates here
        try {
            freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/templates");
            Template t = freemarkerConfig.getTemplate("message.ftl");
            String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
            helper.setTo(user.getEmail());
            helper.setText(text, true); // set to html
            helper.setSubject(AppUtil.SUBJECT);
            helper.setFrom(AppUtil.FROM);
            ClassPathResource file = new ClassPathResource("/WEB-INF/images");
            helper.addInline("logo.jpg", file);
            sender.send(message);
            results.setRespmessage(AppUtil.ACCOUNT_CREATED);
            results.setRespcode("OK");
            results.setResponsestatus("200");
        } catch (IOException | TemplateException | MessagingException | MailException e) {
            results.setRespmessage("Error: " + e.getMessage());
            
        }
        return results;
    }

    public AdminRepo getAdminRepo() {
        return adminRepo;
    }

    public ParticipantsRepo getParticipantsRepo() {
        return participantsRepo;
    }

    public VwsurveyresultsRepo getVwsurveyresultsRepo() {
        return vwsurveyresultsRepo;
    }

    public CourseratingRepo getCourseratingRepo() {
        return courseratingRepo;
    }

    public QuestionsRepo getQuestionsRepo() {
        return questionsRepo;
    }

    public SurveyresultsRepo getSurveyresultsRepo() {
        return surveyresultsRepo;
    }

    public JavaMailSender getSender() {
        return sender;
    }

    public Configuration getFreemarkerConfig() {
        return freemarkerConfig;
    }

}
