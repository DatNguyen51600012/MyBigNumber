package test;

import javaapplication.IReceiver;
import javaapplication.MyBigNumber;

/**
 *
 * @author Nguyễn Thành Đạt
 */
public class Case implements IReceiver {

    /**
     * Hàm main dùng để chạy các testcase Trong đó hàm main gọi lại các hàm chứa
     * test case để kiểm tra tính đúng đắng của chương trình
     */
    @Override
    public void send(String msg) {

    }

    // các hàm chứa tescase
    public String TestCase1() {
        Case test = new Case();
        MyBigNumber mybignumber = new MyBigNumber(test);
        return mybignumber.sum("99", "999");
    }

    public String TestCase2() {
        Case test = new Case();
        MyBigNumber mybignumber = new MyBigNumber(test);
        return mybignumber.sum("999", "999");

    }

    public String TestCase3() {
        Case test = new Case();
        MyBigNumber mybignumber = new MyBigNumber(test);
        return mybignumber.sum("999", "99");
    }

    public String TestCase4() {
        Case test = new Case();
        MyBigNumber mybignumber = new MyBigNumber(test);
        return mybignumber.sum("22", "18");
    }

    public String TestCase5() {
        Case test = new Case();
        MyBigNumber mybignumber = new MyBigNumber(test);
        return mybignumber.sum("89", "98");
    }

}
