/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncc.kiran.laptop_store_managent.views;

/**
 *
 * @author Prashanna
 */
public class Validate {

    public static boolean checkEmpty(String value) {
        boolean isEmpty = false;
        if (value.isEmpty()) {
            isEmpty = true;
        }
        return isEmpty;
    }

    public static boolean checkContactLength(String value) {
        boolean isInValidLength = false;
        if (value.length() != 10) {
            isInValidLength = true;
        }
        return isInValidLength;
    }

    public static boolean checkLengthModel(String value) {
        boolean isInValidLength = false;
        if (value.length() > 20 || value.length() < 4) {
            isInValidLength = true;
        }
        return isInValidLength;
    }

    public static boolean checkLengthBrand(String value) {
        boolean isInValidLength = false;
        if (value.length() > 15 || value.length() < 2) {
            isInValidLength = true;
        }
        return isInValidLength;
    }

    public static boolean checkLength(String value) {
        boolean isInValidLength = false;
        if (value.length() > 50 || value.length() < 3) {
            isInValidLength = true;
        }
        return isInValidLength;
    }

    public static boolean checkAdressLength(String value) {
        boolean isInValidLength = false;
        if (value.length() > 50 || value.length() < 5) {
            isInValidLength = true;
        }
        return isInValidLength;
    }

    public static boolean checkPasswordLength(String value) {
        boolean isInValidLength = false;
        if (value.length() > 15 || value.length() < 5) {
            isInValidLength = true;
        }
        return isInValidLength;
    }

    public static boolean checkEmailLength(String value) {
        boolean isInValidLength = false;
        if (value.length() > 25 || value.length() < 10) {
            isInValidLength = true;
        }
        return isInValidLength;
    }

}
