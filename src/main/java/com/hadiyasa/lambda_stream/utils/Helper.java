package com.hadiyasa.lambda_stream.utils;

import java.util.Scanner;
import java.util.function.Predicate;

public class Helper {

    public static String inputString(String text, Predicate<String> validate) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("%s: ", text);
            String input = scanner.nextLine();

            if (validate.test(input)) {
                return input;
            }
        }
    }

    public static Integer inputInteger(String text, Predicate<Integer> validate) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("%s: ", text);
            Integer input = scanner.nextInt();

            if (validate.test(input)) {
                return input;
            }
        }
    }
}
