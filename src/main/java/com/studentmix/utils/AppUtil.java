/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentmix.utils;

import java.io.FileInputStream;
import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author JIDEX
 */
public class AppUtil {
public final static String SAVED = "Registration Completed Successfully";
    public final static String ERROR = "Error";
    public final static String SUCCESS = "Success";
    public final static Severity SUCCESS_TAG = FacesMessage.SEVERITY_INFO;
    public final static Severity ERROR_TAG = FacesMessage.SEVERITY_ERROR;
    public final static Severity WARNING_TAG = FacesMessage.SEVERITY_WARN;
    public final static Severity FATAL_TAG = FacesMessage.SEVERITY_FATAL;
    public final static String SERVER_ERROR = "An Error Occur Please Contact Administrator";
    public final static String RESOURCE_LOCATION = "http:/www.electricitydata.com.ng/ceadese/api/survey";
    public final static String SUBJECT = "CEADESE ONLINE SURVEY";
    public final static String FROM = "ceadesetraining@funaab.edu.ng";
    public final static String ACCOUNT_CREATED = "Registration Complete Please check your email for the Survey Monkey Question Link. Thank you";

    private static Workbook getWorkbook(FileInputStream inputStream, String excelFilePath)
            throws IOException {
        Workbook workbook = null;

        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }

        return workbook;
    }

    static String getCoursecode(Row row) {
        Cell clt = row.getCell(1);
        return String.valueOf(clt.getStringCellValue());
    }

    public static String generateBarcode(String name) {
        String result = name.substring(0, 2);
        result = result.toUpperCase() + generateDigit();
        return result;
    }

    public static String generateDigit() {

        String value = "";
        for (int i = 1; i < 7; i++) {

            value += "" + getRandomDigitCharacter();
        }
        return value;

    }

    public static String generateInvoice() {

        String value = "";
        for (int i = 1; i < 6; i++) {

            value += "" + getRandomDigitCharacter();
        }
        return "#" + value;

    }

    public static char getRandomCharacter(char ch1, char ch2) {
        return (char) (ch1 + Math.random() * (ch2 - ch1 + 1));
    }

    public static char getRandomDigitCharacter() {
        return getRandomCharacter('0', '9');
    }

    public static Double getValue(Double result) {
        return result == null ? 0.0 : result;
    }

}
