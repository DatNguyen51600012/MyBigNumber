package javaapplication;

import javaapplication.IReceiver;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Tác giả:  Nguyễn Thành Đạt.
 * Class MyBigNumber để cộng 2 số.
 * Version v2.0
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
        String step = "";
        String process = "";
        String sum = "";//tao ra biến lưu kết quả
        Pattern pattern = Pattern.compile("\\D"); // Chuỗi đại diện cho kí tự số từ [0-9]
        final Matcher isError1 = pattern.matcher(num1);// biến để lưu dữ kết quả xét chuỗi s1 
        final Matcher isError2 = pattern.matcher(num2);;// biến để lưu dữ kết quả xét chuỗi s2
        
        
        int nho = 0;// biến nhớ 
        int numSum = 0; // biến dùng để lưu kết phép cộng của từng kì tự trong chuỗi
        
        int vtri ; // Vị trí kí tự trong chuỗi
        
        char char1 = '0';
        char char2 = '0';

        // Bắt lỗi dữ liệu nhập vào nếu có
        // Nếu chuỗi chưa nhập vào thì tính là 0 ( trường hợp Null )
        if (num1.isEmpty()) {
            num1 = "0";
        }

        if (num2.isEmpty()) {
            num2 = "0";        
        }

        // Kiểm tra số âm
        if (num1.charAt(0) == '-') {
            this.ireceiver.send("Không được nhập số âm : " + num1);
            throw new NumberFormatException("Vui lòng không nhập số âm : " + num1);
        }

        if (num2.charAt(0) == '-') {
            ireceiver.send("Không được nhập số âm : " + num2);
            throw new NumberFormatException("Vui lòng không nhập số âm : " + num2);
        }

        // Kiểm tra kí tự đặc biệt
        if (isError1.find()) {
            vtri = isError1.start() + 1;
            this.ireceiver.send("Vị trí " + vtri + " trong chuổi " + num1 + " không phải số");
            throw new NumberFormatException(vtri + "");
        }

        if (isError2.find()) {
            vtri = isError2.start() + 1;
            this.ireceiver.send("Vị trí " + vtri + " trong chuổi " + num2 + " không phải số");
            throw new NumberFormatException(vtri + "");

        }

        //So sánh chuỗi
        if (num1.length() < num2.length()) 
        {

            // đảo chuỗi
            String item = num2;
            num2 = num1;
            num1 = item;
        }
        
        int i = 1;//biến đếm
        
        for (i = 1; i <= num1.length(); i++) { // Vòng lặp chạy từng kí tự chuỗi
            char1 = num1.charAt(num1.length() - i);

            //kiểm tra xem đã xét hêt chuỗi thứ 2 đã hết chưa
            if (num2.length() - i >= 0) {
                char2 = num2.charAt(num2.length() - i);
                numSum = char1 - '0' + char2 - '0' + nho; //cộng từng kí tự của hai chuỗi và phần nhớ nếu có
            } else {
                numSum = char1 - '0' + nho; //cộng kí tự chuổi 1 và phần nhớ ki đã xét hết kí tự trong chuỗi 2
            }
            sum = Integer.toString(numSum % 10) + sum; //ghi kết quả cộng vào biến kết quả

            //lưu phần nhớ là 1 nếu kết quả cộng lớn hơn 10 
            nho = numSum / 10;

            // kiểm tra xem có phần nhớ hay không
            if (nho == 1) {
                if (num2.length() - i >= 0) {
                    process = "\n" + "* Bước " + i + ", lấy " + char1 + " cộng " + char2 + " cộng " + nho + " được "
                        + numSum + ", ghi " + numSum % 10 + ", nhớ " + nho + "\n";
                } else {
                    process = "\n" + "* Bước " + i + ", lấy " + char1 + " cộng " + nho + " được " 
                        + numSum + ", ghi " + numSum % 10 + ", nhớ " + nho + "\n";
                }
            } else {
                if (num2.length() - i >= 0) {
                    process =  "\n" + "* Bước " + i + ", lấy " + char1 + " cộng " + char2 + " được " 
                        + numSum + ", ghi " + numSum % 10 + "\n";
                } else {
                    process = "\n" + "* Bước " + i + ", lấy " + char1 + " cộng 0" + " được " 
                        + numSum + ", ghi " + numSum % 10 + "\n";
                }
            }

            step = step + process;
        }

        // ghi phần nhớ vào nếu phép cộng vượt số
        
        if (nho == 1) { 
            sum = Integer.toString(nho) + sum;
            step = step + "\n" + "* Bước " + i + ", lấy " + nho + " ghi trước kết quả" + "\n" ;
        }

        this.ireceiver.send(step);// gửi các bước đến ireceiver để in ra màn hình
        
        return sum;// trả về kết quả của phép cộng
        
    }
}