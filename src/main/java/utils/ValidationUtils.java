package utils;

public class ValidationUtils {

    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 9;

    public static boolean isNum(int num) {
        return num >= MIN_NUM && num <= MAX_NUM;
    }
}
