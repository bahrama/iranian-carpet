package com.iranian.carpet.util;

import java.util.Random;

public class CodeGenerator {
    public static String carpetCodeGenerator(){
        Random random = new Random();
        long carpRnd = random.nextLong(999999);
        return String.valueOf(1000000+carpRnd);
    }
}
