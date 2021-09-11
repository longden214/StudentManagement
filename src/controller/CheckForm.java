/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author admin
 */
public class CheckForm {
    //tên k chứa ký tự đặc biệt
    public static boolean isName(String Value) {
        Pattern pattern = Pattern.compile("^[\\p{L}\\s\\d_]{3,70}$");
        Matcher matcher = pattern.matcher(Value);
        if (!matcher.find()) {
            return false;
        } else {
            return true;
        }
    }
    
    public static boolean checkPassword(String Value) {
        String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{8,20}$";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Value);
        if (!matcher.find()) {
            return false;
        } else {
            return true;
        }
    }
    
    //tối thiểu 1 tối đa 3 chữ số
    public static boolean isNummeric(String value) {
        Pattern pattern = Pattern.compile("\\d{1,3}+");
        Matcher matcher = pattern.matcher(value);
        if (!matcher.find()) {
            return false;
        }
            return true;
    }
    
    public static boolean isYear(String value) {
        Pattern pattern = Pattern.compile("\\d{4}+");
        Matcher matcher = pattern.matcher(value);
        if (!matcher.find()) {
            return false;
        }
            return true;
    }
    
    public static boolean checkIdStudent(String value){
        Pattern pattern = Pattern.compile("B\\d{4}");
        Matcher matcher = pattern.matcher(value);
        if (!matcher.find()) {
            return false;
        }
        return true;
    }
    
    public static boolean checkIdCourse(String value){
        Pattern pattern = Pattern.compile("K\\d{1,3}");
        Matcher matcher = pattern.matcher(value);
        if (!matcher.find()) {
            return false;
        }
        return true;
    }
    
    //C1909I1
    public static boolean checkIdClass(String value){
        Pattern pattern = Pattern.compile("C1\\d{3}I\\d{1}");
        Matcher matcher = pattern.matcher(value);
        if (!matcher.find()) {
            return false;
        }
        return true;
    }
    
    public static boolean checkPhoneNumber(String value) {
        Pattern pattern = Pattern.compile("^0{1}[1-9]{1}[0-9]{8}$");
        Matcher matcher = pattern.matcher(value);
        if (!matcher.find()) {
            return false;
        } else {
            return true;
        }
    }
    
     public static boolean checkEmail(String value) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]+[a-zA-Z0-9]*@{1}[a-zA-Z]+mail.com$");
        Matcher matcher = pattern.matcher(value);
        if (!matcher.find()) {
            return false;
        } else {
            return true;
        }
    }
     
    public static int getAge(Date value) {
        Calendar today = Calendar.getInstance();
        Calendar birthDate = Calendar.getInstance();
        birthDate.setTime(value);
        int todayYear = today.get(Calendar.YEAR);
        int birthDateYear = birthDate.get(Calendar.YEAR);
        int todayDayOfYear = today.get(Calendar.DAY_OF_YEAR);
        int birthDateDayOfYear = birthDate.get(Calendar.DAY_OF_YEAR);
        int todayMonth = today.get(Calendar.MONTH);
        int birthDateMonth = birthDate.get(Calendar.MONTH);
        int todayDayOfMonth = today.get(Calendar.DAY_OF_MONTH);
        int birthDateDayOfMonth = birthDate.get(Calendar.DAY_OF_MONTH);
        int age = todayYear - birthDateYear;

        // If birth date is greater than todays date (after 2 days adjustment of leap year) then decrement age one year
        if ((birthDateDayOfYear - todayDayOfYear > 3) || (birthDateMonth > todayMonth)){
            age--;

        // If birth date and todays date are of same month and birth day of month is greater than todays day of month then decrement age
        } else if ((birthDateMonth == todayMonth) && (birthDateDayOfMonth > todayDayOfMonth)){
            age--;
        }
        return age;
    }

}

