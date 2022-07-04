package com.question.week3;

import java.util.Scanner;

public class Palindrome {
	 public static void main(String[] args) {
        try {
            while (true) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Kontrol etmek istediğiniz bir değer giriniz : ");
                String number = scanner.nextLine();
                String regex = "\\d+";
                if (number.matches(regex) == false) {
                    throw new NumberFormatException("Lütfen sadece sayı giriniz. Girilen değer : " + number);
                } else {
                    System.out.println(palindromeTamamlayiciSayi(number) + " eklemek gerekir.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static String palindromeTamamlayiciSayi(String number) {

        char arr[] = number.toCharArray();
        char cloneArr[] = arr.clone();
        String str = number, nstr = "";
        char ch;
        for (int i = 0; i < number.length(); i++) {
            ch = str.charAt(i); //extracts each character
            nstr = ch + nstr; //adds each character in front of the existing string
        }
        if (number.equals(nstr)) {
            System.out.println("**********Girilen değer zaten palindrome.**********");
        } else {

            for (int i = 0; i < cloneArr.length / 2; i++) {
                if (cloneArr[i] > cloneArr[cloneArr.length - (i + 1)]) {
                    cloneArr[cloneArr.length - (i + 1)] = cloneArr[i];
                } else {
                    cloneArr[i] = cloneArr[cloneArr.length - (i + 1)];
                }
            }

            String numberArr = String.valueOf(arr);
            String newNumberArr = String.valueOf(cloneArr);
            System.out.println("Girilen değer : " + numberArr + "\nEn yakın palindrome değer : " + newNumberArr);
            String difference = findDiff(newNumberArr, numberArr);
            System.out.print("Aralarındaki fark : " + newNumberArr + " - " + numberArr + " = ");
            return difference;
        }

        return str;
    }

    static String findDiff(String str1, String str2) {
        // Before proceeding further, make sure str1
        // is not smaller
        if (isSmaller(str1, str2)) {
            String t = str1;
            str1 = str2;
            str2 = t;
        }

        // Take an empty string for storing result
        String str = "";

        // Calculate length of both string
        int n1 = str1.length(), n2 = str2.length();

        // Reverse both of strings
        str1 = new StringBuilder(str1).reverse().toString();
        str2 = new StringBuilder(str2).reverse().toString();

        int carry = 0;

        // Run loop till small string length
        // and subtract digit of str1 to str2
        for (int i = 0; i < n2; i++) {
            // Do school mathematics, compute difference of
            // current digits
            int sub = ((int) (str1.charAt(i) - '0') - (int) (str2.charAt(i) - '0') - carry);

            // If subtraction is less than zero
            // we add then we add 10 into sub and
            // take carry as 1 for calculating next step
            if (sub < 0) {
                sub = sub + 10;
                carry = 1;
            } else carry = 0;

            str += (char) (sub + '0');
        }

        // subtract remaining digits of larger number
        for (int i = n2; i < n1; i++) {
            int sub = ((int) (str1.charAt(i) - '0') - carry);

            // if the sub value is -ve, then make it
            // positive
            if (sub < 0) {
                sub = sub + 10;
                carry = 1;
            } else carry = 0;

            str += (char) (sub + '0');
        }

        // reverse resultant string
        return new StringBuilder(str).reverse().toString();
    }

    static boolean isSmaller(String str1, String str2) {
        // Calculate lengths of both string
        int n1 = str1.length(), n2 = str2.length();
        if (n1 < n2) return true;
        if (n2 < n1) return false;

        for (int i = 0; i < n1; i++)
            if (str1.charAt(i) < str2.charAt(i)) return true;
            else if (str1.charAt(i) > str2.charAt(i)) return false;

        return false;
    }

}
