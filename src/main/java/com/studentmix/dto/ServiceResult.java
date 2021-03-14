package com.studentmix.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
/**
 *
 * @author Mohammed Sadiq
 */
@JsonRootName("serviceresponse")
public class ServiceResult implements Dto {

   
    private String responsestatus="NA";
    private String respmessage="NA";
    private String respcode="001";

    public ServiceResult() {
    }
    
    

    public ServiceResult(String respcode, String responsestatus, String respmessage) {
        this.responsestatus = responsestatus;
        this.respmessage = respmessage;
        this.respcode = respcode;
    }

    

    
    public String getResponsestatus() {
        return responsestatus;
    }

    public void setResponsestatus(String responsestatus) {
        this.responsestatus = responsestatus;
    }

    public String getRespmessage() {
        return respmessage;
    }

    public void setRespmessage(String respmessage) {
        this.respmessage = respmessage;
    }

    public String getRespcode() {
        return respcode;
    }

    public void setRespcode(String respcode) {
        this.respcode = respcode;
    }


}
