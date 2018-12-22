/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

/**
 *
 * @author Nguyễn Thành Đạt
 */
public class NumException extends NumberFormatException {

    private int errorpos;
    

    public NumException(int num) {
       errorpos = num ;
    }

    @Override
    public String toString() {
        
        return errorpos + "" ;
    }
}
