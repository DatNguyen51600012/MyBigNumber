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
    
    public String sum(final String str1,final String str2) {
        String chuoi1 = str1;// truyền giá trị chuỗi 1
        String chuoi2 = str2;// truyền giá trị chuỗi 2
        
        int l1 = str1.length(); // biến độ dài chuỗi 1
        int l2 = str2.length(); // biến độ dài chuỗi 2
        
        // Nếu chuỗi chưa rỗng "" , " " , null
        // Nếu chuỗi null hoặc có nhiều khoảng trắng thì tính là số 0 
        if ((str1 == null) || (str1.trim().isEmpty())) { 
            chuoi1 = "0";
        }

        if ((str2 == null) || (str2.trim().isEmpty())) {
            chuoi2 = "0";
        }
        
        String buoc = "";// số bước
        String tong = "";// tạo ra biến lưu kết quả
        
       
        int maxLength = (l1 > l2) ? l1 : l2; // tìm max độ dài chuỗi 
        
        int nho = 0;// biến nhớ 
        int numSum = 0; // biến dùng để lưu kết phép cộng của từng kì tự trong chuỗi
        
        int vtri ; // Vị trí các kí tự trong chuỗi
        
        char c1 = '0';
        char c2 = '0';
        
        // Bắt lỗi dữ liệu nhập vào nếu có
        // Nếu số nhập vào là âm thì không tính và báo lỗi
        if (chuoi1.charAt(0) == '-') {
            this.ireceiver.send("Không được nhập số âm : " + chuoi1);
            throw new NumberFormatException("Bạn vui lòng không nhập số âm : " + chuoi1);
        }

        if (chuoi2.charAt(0) == '-') {
            ireceiver.send("Không được nhập số âm : " + chuoi2);
            throw new NumberFormatException("Bạn vui lòng không nhập số âm : " + chuoi2);
        }
        
        Pattern pattern = Pattern.compile("\\D"); // Chuỗi đại diện cho kí tự số từ [0-9]
        final Matcher isError1 = pattern.matcher(chuoi1);// biến để lưu giữ kết quả xét chuỗi s1 
        final Matcher isError2 = pattern.matcher(chuoi2);;// biến để lưu giữ kết quả xét chuỗi s2
        int errorpos;
        
        // Nếu nhập vào kí tự đặc biệt thì không tính và báo lỗi
        if (isError1.find()) {
            errorpos = isError1.start() + 1;
            this.ireceiver.send("Vị trí " + errorpos + " trong chuỗi số " + chuoi1 + " không hợp lệ");
            throw new NumException(errorpos);
        }

        if (isError2.find()) {
            errorpos = isError2.start() + 1;
            this.ireceiver.send("Vị trí " + errorpos + " trong chuỗi số " + chuoi2 + " không hợp lệ");
            throw new NumException(errorpos);

        }
        
        int i = 1;// khởi tạo biến đếm trong vòng lặp
        String p = "";
        
        for (i = 1; i <= maxLength ; i++) { // Vòng lặp xét từng kí tự trong hai chuỗi
          
            c1 = ((l1 - i) >= 0) ? chuoi1.charAt(l1 - i) : '0';// nếu chuổi 1 hết ta sẽ ghi 0 ngược lại lấy kí tự cuối
            c2 = ((l2 - i) >= 0) ? chuoi2.charAt(l2 - i) : '0';//nếu chuổi 2 hết ta sẽ ghi 0 ngược lại lấy kí tự cuối
            
            numSum = (c1 - '0') + (c2 - '0') + nho;// cộng kí tự cuối của chuổi và phần nhớ(nếu có) vào với nhau
            tong = Integer.toString(numSum % 10) + tong; //ghi kết quả cộng vào biến kết quả

            nho = numSum / 10; // lưu vào biến nhớ là 1 nếu hai số cộng lại quá 10

            // xử lý các trường hợp của biến nhớ 
            if (nho == 1) { 
                if (chuoi2.length() - i >= 0) {
                    p = "\n" + "* Bước " + i 
                            + ", lấy " + c1 
                            + " cộng " + c2 
                            + " cộng " + nho 
                            + " được " + numSum 
                            + ", ghi " + numSum % 10 
                            + ", nhớ " + nho 
                            + "\n";
                } else {
                    p = "\n" + "* Bước " + i 
                            + ", lấy " + c1 
                            + " cộng " + nho 
                            + " được " + numSum 
                            + ", ghi " + numSum % 10 
                            + ", nhớ " + nho 
                            + "\n";
                }
            } else { 
                if (chuoi2.length() - i >= 0) {
                    p =  "\n" + "* Bước " + i + ", lấy " + c1 + " cộng " + c2 + " được " 
                        + numSum + ", ghi " + numSum % 10 + "\n";
                } else {
                    p = "\n" + "* Bước " + i + ", lấy " + c1 + " cộng 0" + " được " 
                        + numSum + ", ghi " + numSum % 10 + "\n";
                }
            }

            buoc = buoc + p;
        }

        // ghi phần nhớ 
        
        if (nho == 1) { 
            tong = Integer.toString(nho) + tong;
            buoc = buoc + "\n" + "* Bước " + i + ", lấy " + nho + " ghi trước kết quả" + "\n" ;
        }

        this.ireceiver.send(buoc);
        
        return tong;// trả về kết quả của phép cộng
        
    }
}
