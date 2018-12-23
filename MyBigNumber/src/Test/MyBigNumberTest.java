/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import javaapplication.MyBigNumber;
import java.lang.NullPointerException;
import static org.hamcrest.CoreMatchers.instanceOf;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nguyễn Thành Đạt
 */
public class MyBigNumberTest implements IReceiver{
    
    public void test1() {
        
            System.out.println("Test 1 :");
            String str1 = "20";
            String str2 = "20";
            String expResult = "40";
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum(str1, str2);
            
        
    }

    @Test
    public void test2() {
        
            System.out.println("Test 2 :");
            String str1 = "99";
            String str2 = "99";
            String expResult = "198";
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum(str1, str2);
            assertEquals(expResult, result);
        
    }

    @Test
    public void test3() {
        
            System.out.println("Test 3 :");
            String str1 = "999";
            String str2 = "99";
            String expResult = "1098";
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum(str1, str2);
            
    }

    @Test
    public void test4() {
        try {
            System.out.println("Test 4 :");
            String str1 = "99";
            String str2 = "999a";            
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum(str1, str2);            
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }

    @Test
    public void test5() {
        
        try {
            System.out.println("Test 5 :");
            String str1 = "132";
            String str2 = "455)";
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum(str1, str2);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
    
    @Test
    public void test6() {
        
        System.out.println("Test 6 :");
        String str1 = "0";
        String str2 = null;
        MyBigNumberTest test = new MyBigNumberTest();
        MyBigNumber mybignumber = new MyBigNumber(test);
        String result = mybignumber.sum(str1, str2);
    }
    
    @Test
    public void test7() {
       
        try {
            System.out.println("Test 7 :");
            String str1 = "12";
            String str2 = "-45";
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum(str1, str2);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
    @Test
    public void test8() {
       
        try {
            System.out.println("Test 8 :");
            String str1 = "-32";
            String str2 = "45";
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum(str1, str2);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
    @Test
    public void test9() {
        
        System.out.println("Test 9 :");
        String str1 = "0";
        String str2 = "";
        MyBigNumberTest test = new MyBigNumberTest();
        MyBigNumber mybignumber = new MyBigNumber(test);
        String result = mybignumber.sum(str1, str2);
    }
    
    @Test
    public void test10() {
        
        System.out.println("Test 10 :");
        String str1 = "";
        String str2 = " ";
        MyBigNumberTest test = new MyBigNumberTest();
        MyBigNumber mybignumber = new MyBigNumber(test);
        String result = mybignumber.sum(str1, str2);
    }
    
    
    @Override
    public void send(String msg) {
        System.out.println(msg + "\n");
    }

    
}
