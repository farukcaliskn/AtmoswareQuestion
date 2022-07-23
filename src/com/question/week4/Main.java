/*
1-)Dizi elemanlarının belirlenmesi. 
2-)Altkümeler toplamında aranacak sayının belirlenmesi.
3-)Altkümelerde aranan sayının bulunması için, sayının ve dizinin bir metot'a yönlendirilmesi.
4-)Metot içerisinde 1.for döngüsü dizi elemanlarını 0.indisten başlayarak dönüyor.
5-)2. for döngüsü, 1. for döngüsünün o an bulunduğu indisten başlayıp, dizi elemanları kadar dönüyor. Bunun sebebi 1. for döngüsünde bulunulan
   indis değerinden sonraki yanyana bulunan elemanların toplamları arasında eşleştirme yapabilmektir.
6-)Sonrasında bir toplam değişkeni tanımladık ve 2. for döngüsü içerisinde her defasından bir sonraki eleman ile olan toplam değerini üzerine
   ekleyerek aranan sayi ile karşılaştırdık. 
7-)Sonuç birbirine eşit çıktığı takdirde metot true olarak sonlandırılır, aksi takdirde for döngüsü son elemana kadar devam eder eşleşme 
   sağlanamazsa for döngüsü sona erer ve metot false döner.
 */
package com.question.week4;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] sayilar = { 1, 3, 1, 4, 23 };
		int sayi = 8;
		System.out.println(siraliAltKumeVarmi(sayilar, sayi));
	}

	public static boolean siraliAltKumeVarmi(int[] sayilar, int ulasilacakToplam) {
		System.out.println("Sayi dizesi : " + Arrays.toString(sayilar) + "\nAranan sayi : " + ulasilacakToplam);
		for (int i = 0; i < sayilar.length; i++) {
			int toplam = 0;
			for (int j = i; j < sayilar.length; j++) {
				toplam += sayilar[j];
				if (toplam == ulasilacakToplam) {
					System.out.println(i + ". elemandan sonraki " + (j - i + 1) + " sayinin toplami ulasilacak toplama esittir.");
					return true;
				}
			}
		}
		return false;
	}
}
