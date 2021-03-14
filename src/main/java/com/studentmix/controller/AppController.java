package com.studentmix.controller;

import com.studentmix.dto.Participantsdto;
import com.studentmix.dto.Vwsurveyresultsdto;
import com.studentmix.mapper.DtoMapper;
import com.studentmix.repository.AppService;
import com.studentmix.utils.AppUtil;
import com.studentmix.utils.FacesUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.primefaces.event.CaptureEvent;

import org.primefaces.event.FileUploadEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Scope("session")
@Component
@ManagedBean
public class AppController implements Serializable {

	@Autowired
	ServletContext context;
	@Autowired
	AppService service;
	private List<Participantsdto> participantList;
	private String photo;
private List<Vwsurveyresultsdto> surveyList;
	@PostConstruct
	public void init() {
		participantList = DtoMapper.maptoParticipantsList(service
				.getParticipantsRepo().findAll());
		photo = "default.png";
                surveyList = DtoMapper.maptoVwsurveyresultsList(service.getVwsurveyresultsRepo().findAll());
	}
        public void reloadSurvey(ActionEvent e){
            surveyList = DtoMapper.maptoVwsurveyresultsList(service.getVwsurveyresultsRepo().findAll());
        }

	public void reload(ActionEvent e) {
		participantList = DtoMapper.maptoParticipantsList(service
				.getParticipantsRepo().findAll());
		photo = "default.png";
	}

	public void registerParticipant(ActionEvent e) {
		Participantsdto record = (Participantsdto) FacesUtils
				.getManagedBean("participantsdto");
		record.setDatecreated(new Date());
			record.setSerialno((record.getSerialno()==null|| record.getSerialno().isEmpty())?getSerialNo():record.getSerialno());
			record.setPhoto(photo);
		
		service.getParticipantsRepo().save(DtoMapper.maptoParticipants(record));
		reload(e);
		printMessage(AppUtil.SAVED, AppUtil.SUCCESS, AppUtil.SUCCESS_TAG);
		reset("participantsdto");

	}

	String getSerialNo() {
		String data = "CEADESE";
		int no = participantList.isEmpty() ? 0 : participantList.size();
		no++;
		data += String.format("%04d", no);
		return data;
	}

	public void oncapture(CaptureEvent captureEvent) {
		byte[] data = captureEvent.getData();
		String parent = getFileFolder();
		File file = new File(parent + generateDocumentId() + ".jpeg");
		FileImageOutputStream imageOutput;
		try {
			imageOutput = new FileImageOutputStream(file);
			imageOutput.write(data, 0, data.length);
			imageOutput.close();
			setPhoto(file.getName());
			printMessage("Photo Captured", AppUtil.SUCCESS, AppUtil.SUCCESS_TAG);
		} catch (IOException e) {
			printMessage("Error in writing captured image", AppUtil.ERROR,
					AppUtil.ERROR_TAG);
			throw new FacesException("Error in writing captured image.", e);

		}
	}

	public void printMessage(String message, String title, Severity messageType) {
		FacesContext contexts = FacesContext.getCurrentInstance();
		contexts.addMessage(null, new FacesMessage(messageType, title, message));
	}

	public void reset(String beanname) {
		FacesUtils.resetManagedBean(beanname);
	}

	public void storeToSession(String name, Object t) {
		HttpSession session = FacesUtils.getHttpSession(false);
		session.setAttribute(name, t);
	}

	// ///////////////////////////////////////////working with file
	public String getFileFolder() {
		String parent = FacesContext.getCurrentInstance().getExternalContext()
				.getRealPath("")
				+ "/resources/photos/";
		return parent;
	}

	public void uploadDocuments(FileUploadEvent event) {
		try {
			String parent = getFileFolder();
			File file = new File(parent
					+ generateDocumentId()
					+ event.getFile().getFileName()
							.replaceAll("[\\\\/><\\|\\s\"'{}()\\[\\]]+", "_"));
			InputStream inputStream = event.getFile().getInputstream();
			OutputStream out = new FileOutputStream(file);
			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = inputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			inputStream.close();
			out.flush();
			out.close();

		} catch (IOException e) {
			printMessage(AppUtil.SERVER_ERROR, AppUtil.ERROR, AppUtil.ERROR_TAG);
		}
	}

	public String generateDocumentId() {

		String value = "";
		for (int i = 1; i < 5; i++) {

			value += "" + getRandomDigitCharacter();
		}
		return value;

	}

	public char getRandomCharacter(char ch1, char ch2) {
		return (char) (ch1 + Math.random() * (ch2 - ch1 + 1));
	}

	public char getRandomDigitCharacter() {
		return getRandomCharacter('0', '9');
	}

	public List<Participantsdto> getParticipantList() {
		return participantList;
	}

	public void setParticipantList(List<Participantsdto> participantList) {
		this.participantList = participantList;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

    public ServletContext getContext() {
        return context;
    }

    public void setContext(ServletContext context) {
        this.context = context;
    }

    public AppService getService() {
        return service;
    }

    public void setService(AppService service) {
        this.service = service;
    }

    public List<Vwsurveyresultsdto> getSurveyList() {
        return surveyList;
    }

    public void setSurveyList(List<Vwsurveyresultsdto> surveyList) {
        this.surveyList = surveyList;
    }

}
