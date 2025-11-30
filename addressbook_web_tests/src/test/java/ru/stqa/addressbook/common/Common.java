package ru.stqa.addressbook.common;

import java.util.Random;

public class Common {

    public static String randomString(int n) {
        var random = new Random();
        String result = "";
        for (int i = 0; i < n; i++) {
            result = result + (char)('a' + random.nextInt(26));
        }
        return result;
    }

}
