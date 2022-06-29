package com.question.week2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _2_ {
	public static void main(String[] args) {
		dataInput();
	}

	// Alfabenin ve kelimelerin belirlenmesi control metodunun çağırılması
	public static void dataInput() {

		// Kontrol edilmesinin kolaylığı açısından veri girişini manuel olarak
		// bıraıktım.

		String str = "iabcçdefgğhıjklmnoöprsştuvyz";
		List<String> words = new ArrayList<>();
		words.add("İsmet");
		words.add("abdulsemet");
		words.add("aksi");
		words.add("aksu");
		words.add("karadeniz");
		words.add("onurcan");
		words.add("pehlil");
		words.add("sargın");
		words.add("şemsettin");

		// words.add("irfan");

		System.out.println();
		Boolean result = control(str, words.stream().map(String::toLowerCase).collect(Collectors.toList()));
		String sorted = (result == true ? "Liste sıralıdır" : "Liste sıralı değildir");
		System.out.println(sorted);
	}

	// Kontrol için gerekli fonksiyonlara parametrelerin geçilmsei ve sonucun
	// döndürülmesi
	public static boolean control(String str, List<String> words) {
		List<Character> alphabet = new ArrayList<>();
		alphabet(str, alphabet);

		return returnSortedListControl(alphabet, words);
	}

	// String olarak girilen alfabe listeye eleman olarak ekleniyor.
	public static List<Character> alphabet(String str, List<Character> alphabet) {

		for (char ch : str.toCharArray()) {
			alphabet.add(ch);
		}
		return alphabet;

	}

	/*
	 * Kelimelerin öncelik sırasının kontrol edilip ilk hatada false olarak
	 * döndürülmesi ve harf sıralaması aynı ilerleyen kelimelerde kontrol için
	 * kelime önceliğine bakılacak fonksiyonun çağrılmasından sonra false dönülmesi
	 */
	public static boolean returnSortedListControl(List<Character> alphabet, List<String> words) {

		for (int i = 0; i < words.size(); i++) {
			for (int j = i; j < words.size(); j++) {
				if (alphabet.indexOf(words.get(i).charAt(0)) < alphabet.indexOf(words.get(j).charAt(0))) {

				} else if (alphabet.indexOf(words.get(i).charAt(0)) > alphabet.indexOf(words.get(j).charAt(0))) {
					return false;
				} else {
					boolean result = WordsControl(alphabet, words.get(i), words.get(j));
					if (result == false) {
						return false;
					}
				}
			}

		}

		return true;
	}

	/*
	 * Kelimeler sıralanırken aynı harf düzeninde olan kelimelerden hangisinin önce
	 * geleceğine karar vermek için returSortedList metodunda çağırılan fonksiyon
	 */
	public static boolean WordsControl(List<Character> alphabet, String w1, String w2) {
		int loopSize = Math.max(w1.length(), w2.length());
		for (int k = 0; k < loopSize; k++) {
			if (alphabet.indexOf(w1.charAt(k)) > alphabet.indexOf(w2.charAt(k))) {
				return false;
			} else if (alphabet.indexOf(w1.charAt(k)) < alphabet.indexOf(w2.charAt(k))) {
				return true;
			}
		}
		return true;

	}
}
