/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dev
 */
public class Regex {

    //ham kiem tra ngay to chuc theo dinh dang dd/mm/yyyy
    public static boolean check_Date(String data) {
        String regex = "(((([012][1-9])|([123]0)|31)/((0[13578])|(1[02])))|((([012][1-9])|([123]0))/((0[2469])|11))|((([012][1-8])|([12]0)|([01]9))/(02))/([12]\\d{3}))|(((([012][1-9])|([123]0)|31)/((0[13578])|(1[02])))|((([012][1-9])|([123]0))/((0[2469])|11))|((([012][1-8])|([12]0)|([01]9))/(02))/[(\\d{2}[(04)(08)(12)(16)])([(04)(08)(12)(16)]00)])";
        return data.matches(regex);
    }
    //ham kiem tra thoi gian theo dinh dang HH:mm

    public static boolean check_Time(String data) {
        String regex = "\\d{2}:\\d{2}";
        return data.matches(regex);
    }
    //ham kiem tra ten tai khoan theo dinh dang khong chua ki tu dat biet, khong chua so

    public static boolean check_Username(String data) {
        String regex = "[a-zA-Z]+";
        return data.matches(regex);
    }
    //ham kiem tra ma so theo dinh dang, khong chua ki tu dat biet

    public static boolean check_Maso(String data) {
        String regex = "[a-zA-Z0-9]+";
        return data.matches(regex);
    }
    //ham kiem tra ten su kien tho dinh dang, ki tu dau tien phai la chu, va khong chua ki tu dat biet

    public static boolean check_NameEvent(String data) {
        String regex = "^[a-zA-Z][a-zA-Z0-9]*";
        return data.matches(regex);
    }
    //ham kiem tra password theo dinhd dang, it nhat 8 ki tu

    public static boolean check_Password(String data) {
        String regex = ".{8}";
        return data.matches(regex);
    }
    //ham kiem tra password theo dinhd dang, it nhat 8 ki tu,bao gom chu va so

    public static boolean check_Email(String data) {
        String regex = "\\[a-zA-Z0-9]+@ctu.edu.vn";
        return data.matches(regex);
    }

    public static boolean check_txtNULL(String data) {
        return data.matches("''");
    }
}
