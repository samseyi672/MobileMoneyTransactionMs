package com.fintect.MobileMoneyTransactionMs.utlis;


import java.security.SecureRandom;

public class AppUtils {
    public static String generateRequestID(int length) {
        String characters = "0123456789";
        StringBuilder randomString = new StringBuilder(length);
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(characters.length());
            randomString.append(characters.charAt(randomIndex));
        }
        return randomString.toString();
    }
}
