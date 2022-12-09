package utils;

import java.util.StringTokenizer;

public class StringUtils {

    public static String[] stringSplit(String input, String delim) {
        StringTokenizer st = new StringTokenizer(input, delim);
        String array[] = new String[st.countTokens()];
        int index = 0;

        while (st.hasMoreTokens()) {
            array[index++] = st.nextToken();
        }

        return array;
    }

    public static String removeFromChar(String input, char c) {
        if(input.indexOf(c) > -1) input = input.substring(input.indexOf(c) + 1);

        return input;
    }

    public static String removeToChar(String input, char c) {
        if(input.indexOf(c) > -1) input = input.substring(0, input.indexOf(c));

        return input;
    }

    public static char getCharByIndex(String input, int index) {
        return input.charAt(index);
    }
}
