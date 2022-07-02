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

				int palindromCheckResult = Integer.parseInt(palindromeTamamlayiciSayi(number));
				if (palindromCheckResult == 0) {
					System.out.println("Girilen değer zaten palindromdur.");
				} else {
					System.out.println(palindromCheckResult + " Eklemek gerekir.");
					System.out.println(Integer.parseInt(number) + " + " + palindromCheckResult + " = "
							+ (Integer.parseInt(number) + palindromCheckResult) + " Sayısı bir palindrom sayıdır");
				}

			}
		} catch (Exception e) {
			throw new PalindromException("Girilen değer bir tam sayı değildir.");
		}

	}

	public static String palindromeTamamlayiciSayi(String sayi) throws PalindromException {

		int castNumber = Integer.parseInt(sayi);
		int temp = castNumber;

		int r, sum = 0;
		for (int i = 0;; i++) {
			int n = temp; // Sürekli olarak güncel geçici temp degişkeninin değerini alacak olan değişken
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

	}
}
