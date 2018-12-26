package javaapplication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javaapplication.IReceiver;


/**
 * Tác giả:  Nguyễn Thành Đạt.
 * Class MyBigNumber để cộng 2 số.
 * Version v3.0
 * Date Modified 22/12/2018
 */

public class MyBigNumber {

    private IReceiver ireceiver;
    
    
    
    public MyBigNumber(final IReceiver ireceiver) {
        this.ireceiver = ireceiver;
    }
    
    /**
     * Hàm sum dùng để cộng 2 số. 
     * Truyền vào 2 chuỗi số 
     *
     * @param str1 chuỗi số thứ nhất.
     * @param str2 chuỗi số thứ hai.
     */
    
    public String sum(final String str1,final String  str2) {
        
        String s1 = str1 ; // s1 chứa giá trị chuỗi 1
        String s2 = str2 ;// s2 chứa giá trị chuỗi 2
               
        
        // Nếu chuỗi null hoặc có nhiều khoảng trắng thì tính là số 0 
        if (str1 == null || str1.trim().isEmpty()) { 
            s1 = "0";
        }

        if (str1 == null || str2.trim().isEmpty()) {
            s2 = "0";
        }
        
        String buoc = "";// số bước
        String tong = "";// tạo ra biến lưu kết quả
        
        int temp = 0; // bien chứa hàng đơn vị
        int nho = 0;// biến nhớ 
        int numSum = 0; // biến dùng để lưu kết phép cộng của từng kì tự trong chuỗi
                       
        int c1 = 0; // chứa số của chuỗi 1
        int c2 = 0; // chứa số của chuỗi 2
        
        // Bắt lỗi dữ liệu nhập vào nếu có
        // Nếu số nhập vào là âm thì không tính và báo lỗi
        if (s1.charAt(0) == '-') {            
            throw new NumberFormatException("Bạn vui lòng không nhập số âm : " + s1);
        }

        if (s2.charAt(0) == '-') {
            throw new NumberFormatException("Bạn vui lòng không nhập số âm : " + s2);
        }
        
        
        int i;// khởi tạo biến đếm trong vòng lặp
        String p = "";
        
        int l1 = str1.length(); // biến độ dài chuỗi 1
        int l2 = str2.length(); // biến độ dài chuỗi 2
        int maxLength = l1 < l2 ? l1 : l2; // tìm max độ dài chuỗi 
        
        int index1; // kí tự đang xét chuỗi 1
        int index2; // kí tự đang xét chuỗi 2
        char chuoi1 ; // biến lấy từng kí tự chuỗi 1 để ktra
        char chuoi2 ;// biến lấy từng kí tự chuỗi 2 để ktra
        
        
        for (i = 0; i <= maxLength ; i++) { // Vòng lặp xét từng kí tự trong hai chuỗi
            
            chuoi1 = (i < l1) ? s1.charAt(i) : '0';
            chuoi2 = (i < l2) ? s2.charAt(i) : '0';

            if (!(chuoi1 >= '0' && chuoi1 <= '9')) {
                this.ireceiver.send("\nSố thứ 1 có kí tự đặc biệt : " + s1);
                throw new NumException((str1.indexOf(chuoi1) + 1));
            }

            if (!(chuoi2 >= '0' && chuoi2 <= '9')) {
                this.ireceiver.send("\n Số thứ 2 có kí tự đặc biệt : " + s2);
                throw new NumException((str2.indexOf(chuoi2) + 1));
            }
            
            index1 = l1 - i - 1;
            index2 = l2 - i - 1;
            
            c1 = ((i < l1) ? (s1.charAt(index1) - '0') : 0);// nếu chuổi 1 hết ta sẽ ghi 0 ngược lại lấy kí tự cuối
            c2 = ((i < l2) ? (s2.charAt(index2) - '0') : 0);//nếu chuổi 2 hết ta sẽ ghi 0 ngược lại lấy kí tự cuối
            
            numSum = c1  +  c2 + nho ;// cộng kí tự cuối của chuổi  vào với nhau và biến nhớ
            
            temp = numSum % 10 ;
            
            // xử lý các trường hợp của biến nhớ 
            if (nho == 0) {                 
                buoc += "\n" 
                            + "* Bước " + (i + 1) + " : " 
                            + ", lấy " + c1 
                            + " cộng " + c2                             
                            + " được " + numSum 
                            + ", ghi " + temp
                            + ", nhớ " + numSum / 10 
                            + "\n";
            } else {
                buoc += "\n" 
                            + "* Bước " + (i + 1) + " : " 
                            + ", lấy " + c1 
                            + " cộng " + c2
                            + ", nhớ " + nho
                            + " được " + numSum 
                            + ", ghi " + temp
                            + ", nhớ " + nho 
                            + "\n";
            }
                
            nho = numSum / 10; // lưu vào biến nhớ là 1 nếu hai số cộng lại quá 10
            tong = temp + tong; //tinh tong 
            
        }

        // ghi phần nhớ 
        
        if (nho > 0) { 
            tong = nho + tong;
            buoc += "\n" + "* Bước " + (i + 1) + " : "
                    + ", lấy " + 0 
                    + ", cộng " + 0
                    + ", nhớ " + 1
                    + ", bằng " + 1
                    + ", viết" + 1
                    + "\n";
        }

        this.ireceiver.send(buoc); // gửi từng bước ra màn hình
        
        return tong;// trả về kết quả của phép cộng
        
    }
}