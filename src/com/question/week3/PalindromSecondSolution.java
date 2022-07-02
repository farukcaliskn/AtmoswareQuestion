package com.question.week3;

import java.util.Scanner;

public class PalindromSecondSolution {

	/*
	 * Kendisinden sonra ilk gelen palindrom sayıyı bulur ve bizim girdiğimiz sayı
	 * ile arasında olan farkı döndürür. 3 basamaklı sayılar için pek bir performans
	 * kaybı olmaz fakat basamak sayısı büyüdükçe performans azalacağı için 1.
	 * çözümü kullanmak tercih sebebi olabilir.
	 */

	public static void main(String[] args) throws PalindromException {
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				System.out.print("Kontrol etmek istediğiniz bir tamsayı değeri degeri giriniz : ");
				String number = scanner.nextLine();

				int palindromChech = Integer.parseInt(palindromeTamamlayiciSayi(number));
				if (palindromChech == 0) {
					System.out.println("Girilen değer zaten palindromdur.");
				} else
					System.out.println(palindromChech + " Eklemek gerekir.");
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String palindromeTamamlayiciSayi(String sayi) throws PalindromException {
		try {
			int castNumber = Integer.parseInt(sayi);
			int temp = castNumber;

			int r, sum = 0;
			for (int i = 0;; i++) {
				int n = temp;
				while (n > 0) {
					r = n % 10; // getting remainder
					sum = (sum * 10) + r;
					n = n / 10;
				}
				if (temp == sum) {
					return String.valueOf(i);
				}
				sum = 0;
				temp++;
			}

		} catch (Exception e) {
			throw new PalindromException("Girilen değer bir tam sayı değildir.");
		}
	}
}
