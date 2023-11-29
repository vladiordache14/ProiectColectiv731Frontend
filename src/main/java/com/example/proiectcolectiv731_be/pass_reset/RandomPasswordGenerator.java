package com.example.proiectcolectiv731_be.pass_reset;

import java.util.Random;

public class RandomPasswordGenerator {
    final static String letters="qwertyuiopasdfghjklzxcvbnm";
    final static String numbers="1234567890";
    public static String generate(){
        StringBuilder sb=new StringBuilder();
        Random random=new Random();
        for(int i=0;i<8;i++){
            int index=random.nextInt(letters.length());
            char c=letters.charAt(index);
            if (i==0)
                c-='a'-'A';
            sb.append(c);
        }
        for(int i=0;i<4;i++){
            int index=random.nextInt(numbers.length());
            char c=numbers.charAt(index);
            sb.append(c);
        }
        return sb.toString();
    }
}
