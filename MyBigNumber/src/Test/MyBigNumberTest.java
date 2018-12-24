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
    // Trường hợp cộng bình thường
    public void test1() {       
            System.out.println("Test 1 :");            
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum("20", "20");
            assertEquals("40",result);                    
    }
    // Trường hợp cộng có nhớ
    @Test
    public void test2() {        
            System.out.println("Test 2 :");
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum("99", "99");
            assertEquals("198",result);       
    }
    // Trường hợp số thứ nhất nhiều hơn
    @Test
    public void test3() {
            String t = "1098";
            System.out.println("Test 3:"); 
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum("999", "99");
            assertEquals(t,result);            
    }
    // Trường hợp có chữ trong số
    @Test
    public void test4() {
        try {
            System.out.println("Test 4 :");           
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum("99a","99");         
        } catch (NumberFormatException e) {
            assertEquals(" Ở vị trí số : 3",e.getMessage());
        }
    }
    // Trường hợp có kí tự không phải số
    @Test
    public void test5() {   
        try {
            System.out.println("Test 5 :");
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum( "482","455%");  
        } catch (NumberFormatException e) {
            assertEquals(" Ở vị trí số : 4",e.getMessage());
        }
    }
    // Trường hợp dữ liệu null
    @Test
    public void test6() {
        System.out.println("Test 6 :");
        String str1 = "0";
        String str2 = null;
        MyBigNumberTest test = new MyBigNumberTest();
        MyBigNumber mybignumber = new MyBigNumber(test);
        String result = mybignumber.sum(str1, str2);
        assertEquals("0",result);
        
    }
    // Trường hợp số âm
    @Test
    public void test7() {       
        try {
            System.out.println("Test 7 :");
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum("1254", "-4554");
        } catch (NumberFormatException e) {
            assertEquals("Bạn vui lòng không nhập số âm : -4554",e.getMessage());
        }
    }
    // Trường hợp số âm
    @Test
    public void test8() {      
        try {
            System.out.println("Test 8 :");
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            String result = mybignumber.sum("-882", "45465");
        } catch (NumberFormatException e) {
            assertEquals("Bạn vui lòng không nhập số âm : -882",e.getMessage());   
        }
    }
    // Trường hợp 0 và rỗng
    @Test
    public void test9() {        
        System.out.println("Test 9 :");       
        MyBigNumberTest test = new MyBigNumberTest();
        MyBigNumber mybignumber = new MyBigNumber(test);
        String result = mybignumber.sum("0", "");
        assertEquals("0",result);
    }
    // Trường hop chua nhập liệu và khoảng trống 
    @Test
    public void test10() {        
        System.out.println("Test 10 :");       
        MyBigNumberTest test = new MyBigNumberTest();
        MyBigNumber mybignumber = new MyBigNumber(test);
        String result = mybignumber.sum(""," ");
        assertEquals("0",result);
    }
    // Trường hợp chưa nhập 
    @Test
    public void test11() {       
        System.out.println("Test 11 :");       
        MyBigNumberTest test = new MyBigNumberTest();
        MyBigNumber mybignumber = new MyBigNumber(test);
        String result = mybignumber.sum("","0");
        assertEquals("0",result);
    }
    
    
    @Override
    public void send(String msg) {
        System.out.println(msg + "\n");
    }

    
}
