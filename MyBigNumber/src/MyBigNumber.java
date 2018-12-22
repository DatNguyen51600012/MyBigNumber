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
     * Trong đó đưa vào 2 chuỗi số chỉ chứ kí tự từ 0-9.
     *
     * @param str1 chuỗi số thứ nhất.
     * @param str2 chuỗi số thứ hai.
     */
    
    public String sum(final String str1, final String str2) {
        String num1 = str1;// chuỗi 1
        String num2 = str2;// chuỗi 2
        
        String buoc = "";// số bước
        String tong = "";// tạo ra biến lưu kết quả
        
       
        int l1 = str1.length(); // biến độ dài chuỗi 1
        int l2 = str2.length(); // biến độ dài chuỗi 2
        final int maxLength = (l1 > l2) ? l1 : l2; // tìm max độ dài chuỗi 
        
        int nho = 0;// biến nhớ 
        int numSum = 0; // biến dùng để lưu kết phép cộng của từng kì tự trong chuỗi
        
        int vtri ; // Vị trí các kí tự trong chuỗi
        
        char c1 = '0';
        char c2 = '0';
        
        Pattern pattern = Pattern.compile("\\D"); // Chuỗi đại diện cho kí tự số từ [0-9]
        final Matcher isError1 = pattern.matcher(num1);// biến để lưu dữ kết quả xét chuỗi s1 
        final Matcher isError2 = pattern.matcher(num2);;// biến để lưu dữ kết quả xét chuỗi s2

        // Bắt lỗi dữ liệu nhập vào nếu có
        // Nếu chuỗi chưa nhập vào thì tính là 0 ( trường hợp Null )
        if (num1.isEmpty()) {
            num1 = "0";
        }

        if (num2.isEmpty()) {
            num2 = "0";        
        }

        // Nếu số nhập vào là âm thì không tính và báo lỗi
        if (num1.charAt(0) == '-') {
            this.ireceiver.send("Không được nhập số âm : " + num1);
            throw new NumberFormatException("Bạn vui lòng không nhập số âm : " + num1);
        }

        if (num2.charAt(0) == '-') {
            ireceiver.send("Không được nhập số âm : " + num2);
            throw new NumberFormatException("Bạn vui lòng không nhập số âm : " + num2);
        }

        // Nếu nhập vào kí tự đặc biệt thì không tính và báo lỗi
        if (isError1.find()) {
            vtri = isError1.start() + 1;
            this.ireceiver.send("Vị trí " + vtri + " trong chuỗi " + num1 + " không phải số");
            throw new NumberFormatException(vtri + "");
        }

        if (isError2.find()) {
            vtri = isError2.start() + 1;
            this.ireceiver.send("Vị trí " + vtri + " trong chuỗi " + num2 + " không phải số");
            throw new NumberFormatException(vtri + "");

        }
        
        int i = 1;// khởi tạo biến đếm trong vòng lặp
        String p = "";
        
        for (i = 1; i <= maxLength ; i++) { // Vòng lặp xét từng kí tự trong hai chuỗi
          
            c1 = ((l1 - i) >= 0) ? num1.charAt(l1 - i) : '0';// nếu chuổi 1 hết ta sẽ ghi 0 ngược lại lấy kí tự cuối
            c2 = ((l2 - i) >= 0) ? num2.charAt(l2 - i) : '0';//nếu chuổi 2 hết ta sẽ ghi 0 ngược lại lấy kí tự cuối
            
            numSum = (c1 - '0') + (c2 - '0') + nho;// cộng kí tự cuối của chuổi và phần nhớ(nếu có) vào với nhau
            tong = Integer.toString(numSum % 10) + tong; //ghi kết quả cộng vào biến kết quả

            nho = numSum / 10; // lưu vào biến nhớ là 1 nếu hai số cộng lại quá 10

            // xử lý các trường hợp của biến nhớ 
            if (nho == 1) { 
                if (num2.length() - i >= 0) {
                    p = "* Bước " + i 
                            + ", lấy " + c1 
                            + " cộng " + c2 
                            + " cộng " + nho 
                            + " được " + numSum 
                            + ", ghi " + numSum % 10 
                            + ", nhớ " + nho 
                            + "\n";
                } else {
                    p = "* Bước " + i 
                            + ", lấy " + c1 
                            + " cộng " + nho 
                            + " được " + numSum 
                            + ", ghi " + numSum % 10 
                            + ", nhớ " + nho 
                            + "\n";
                }
            } else { 
                if (num2.length() - i >= 0) {
                    p =  "\n" + "* Bước " + i + ", lấy " + c1 + " cộng " + c2 + " được " 
                        + numSum + ", ghi " + numSum % 10 + "\n";
                } else {
                    p = "\n" + "* Bước " + i + ", lấy " + c1 + " cộng 0" + " được " 
                        + numSum + ", ghi " + numSum % 10 + "\n";
                }
            }

            buoc = buoc + p;
        }

        // ghi phần nhớ vào nếu phép cộng vượt số
        
        if (nho == 1) { 
            tong = Integer.toString(nho) + tong;
            buoc = buoc + "\n" + "* Bước " + i + ", lấy " + nho + " ghi trước kết quả" + "\n" ;
        }

        this.ireceiver.send(buoc);// gửi các bước đến ireceiver để in ra màn hình
        
        return tong;// trả về kết quả của phép cộng
        
    }
}