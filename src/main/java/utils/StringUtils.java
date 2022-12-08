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
}
