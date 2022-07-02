package com.question.week3;

import java.util.Scanner;

public class PalindromFirstSolution {

	/*
	 * Ulaşmak istediğimiz palindrom sayı için şart sadece sayının palindrom olması
	 * ise en kolay bu şekilde ulaşabileceğimizi düşündüm. Çözüm sayıyı bir char
	 * dizisine atıyor ve daha sonra ortadan ikiye bölerek elemanları birbirine
	 * eşitliyor. Sonrasında aradaki olan farkı döndürüyor. Çözüm içerisinde
	 * istersek sayının büyük kısmını diğer tarafa benzeterek sadece her defasında
	 * eklenerek ulaşılacak olan sonucu bize döndürecektir. Diğer bir çözüm
	 * PalindromSecondSolution class'ın içerisindedir.
	 */

	public static void main(String[] args) throws PalindromException {
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				System.out.print("Kontrol etmek istediğiniz bir tamsayı değeri degeri giriniz : ");
				String number = scanner.nextLine();
				int palindromeCheckNumber = Integer.parseInt(palindromeTamamlayiciSayi(number));
				System.out.println("*********" + palindromeCheckNumber + "*********");
			}
		}
	}

	public static String palindromeTamamlayiciSayi(String sayi) throws PalindromException {
		try {
			int castNumber = Integer.parseInt(sayi);
			char arr[] = String.valueOf(castNumber).toCharArray();
			char cloneArr[] = arr.clone();
			for (int i = 0; i < cloneArr.length / 2; i++) {
				if (cloneArr[i] == cloneArr[cloneArr.length - (i + 1)]) {
					continue;
				} else {
					cloneArr[cloneArr.length - (i + 1)] = cloneArr[i];
				}
			}
			int newNumber = Integer.parseInt(String.valueOf(cloneArr));
			if (castNumber > newNumber) {
				System.out.println("Bu sayı çıkarılmalı => " + (castNumber - newNumber));
				System.out.println(castNumber + " - " + (castNumber - newNumber) + " = " + newNumber);
				return String.valueOf(castNumber - newNumber);
			} else {
				System.out.println("Bu sayı eklenmeli => " + (newNumber - castNumber));
				System.out.println(castNumber + " + " + (newNumber - castNumber) + " = " + newNumber);
				return String.valueOf(newNumber - castNumber);
			}

		} catch (Exception e) {
			throw new PalindromException("Girilen değer bir tam sayı değildir.");
		}
	}
}
