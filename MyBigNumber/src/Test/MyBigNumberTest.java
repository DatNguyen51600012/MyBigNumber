/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import javaapplication.IReceiver;
import javaapplication.MyBigNumber;

/**
 *
 * @author Nguyễn Thành Đạt
 */
public class MyBigNumberTest implements IReceiver {

    /**
     * Hàm main dùng để chạy các testcase Trong đó hàm main gọi lại các hàm chứa
     * test case để kiểm tra tính đúng đắng của chương trình
     */
    public static void main(String[] args) {

        // gọi các hàm chứatestcase
        Test1();
        Test2();
        Test3();
        Test4();
        Test5();
        Test6();
        Test7();
        Test8();
        Test9();
        Test10();
        Test11();
        Test12();
        Test13();
        Test14();
    }

    @Override
    public void send(String msg) {
        System.out.println(msg);
    }

    // các hàm chứa tescase
    public static void Test1() {
        try {
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            System.out.println("Test 1:");
            System.out.println( mybignumber.sum("9", "99") + "\n");
        } catch (NumberFormatException e) {
            System.out.println(e);
            
        }
    }
    
    public static void Test2() {
        try {
             MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            System.out.println("Test 2:");
            System.out.println( mybignumber.sum("99", "9") + "\n");
        } catch (NumberFormatException e) {
            System.out.println(e);
          
        }
    }

    public static void Test3() {
        try {
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            System.out.println("Test 3:");
            System.out.println( mybignumber.sum("99", "90") + "\n");
        } catch (NumberFormatException e) {
            System.out.println(e);
            
        }
    }

    public static void Test4() {
        try {
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            System.out.println("Test 4:");
            System.out.println(mybignumber.sum("999", "99") + "\n");
        } catch (NumberFormatException e) {
            System.out.println(e);
            
        }
    }

    public static void Test5() {
        try {
             MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            System.out.println("Test 5:");
            System.out.println(mybignumber.sum("A", "999") + "\n");
        } catch (NumberFormatException e) {
            System.out.println(e) ;
           
        }
    }
    
    public static void Test6() {
        try {
             MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            System.out.println("Test 7:");
            System.out.println(mybignumber.sum("8978", "9458*") + "\n");
        } catch (NumberFormatException e) {
            System.out.println(e);
            
        }
    }
    // Trường hợp số thứ nhất chứa kí tự đặc biệt
    public static void Test7() {
        try {
             MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            System.out.println("Test 7:");
            System.out.println(mybignumber.sum("8978/", "9458*") + "\n");
        } catch (NumberFormatException e) {
            System.out.println(e);
           
        }
    }
    // Trường hợp số thứ nhất âm
    public static void Test8() {
        try {
             MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            System.out.println("Test 8:");
            System.out.println(mybignumber.sum("-54", "98") + "\n");
        } catch (NumberFormatException e) {
            System.out.println(e);
            
        }
    }
    // Trường hợp Null hai số nhập vào
    public static void Test9() {
        try {
             MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            System.out.println("Test 9:");
            System.out.println(mybignumber.sum("6556"," ") + "\n");
        } catch (NumberFormatException e) {
            System.out.println(e);
            
        }
    }
    // Trường hợp có chữ trong số thứ nhất 
    public static void Test10() {
        try {
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            System.out.println("Test 10:");
            System.out.println(mybignumber.sum("98g4", "99") + "\n");
        } catch (NumberFormatException e) {
            System.out.println(e);
           
        }
    }
    // Trường hợp có chữ trong số thứ 2
    public static void Test11() {
        try {
             MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            System.out.println("Test 11:");
            System.out.println(mybignumber.sum("9887", "897a") + "\n");
        } catch (NumberFormatException e) {
            System.out.println(e);
          
        }
    }
    // TRường hợp Hai số có chứa chữ
    public static void Test12() {
        try {
             MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            System.out.println("Test 12:");
            System.out.println(mybignumber.sum("897a54", "8798a546") + "\n");
        } catch (NumberFormatException e) {
            System.out.println(e);
            
        }
    }
    //TRường hợp khỏang trắng và số 
    public static void Test13() {
        try {
            MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            System.out.println("Test 13:");
            System.out.println( mybignumber.sum(" ", "546") + "\n");
        } catch (NumberFormatException e) {
            System.out.println(e);
           
        }
    }
    // Trường hợp Null và 0
    public static void Test14() {
        try {
             MyBigNumberTest test = new MyBigNumberTest();
            MyBigNumber mybignumber = new MyBigNumber(test);
            System.out.println("Test 14:");
            System.out.println( mybignumber.sum(null, "0") + "\n");
        } catch (NumberFormatException e) {
            System.out.println(e);
           
        }
    }
}
