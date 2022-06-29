package com.question.week2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _1_ {
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
		words.add("aksu");
		words.add("aksi");
		words.add("karadeniz");
		words.add("onurcan");
		words.add("pehlil");
		words.add("sargın");
		words.add("şemsettin");

		control(str, words.stream().map(String::toLowerCase).collect(Collectors.toList()));
	}

	// Oluşturulan clone üzerinde yapılan işlemlerden sonra dizinin ilk hali ile
	// kontrol edilmesi.
	public static boolean control(String str, List<String> words) {
		List<Character> alphabet = new ArrayList<>();
		alphabet(str, alphabet);
		List<String> cloned_list = new ArrayList<String>(words);
		returSortedList(alphabet, cloned_list);
		System.out.println(words);
		System.out.println(cloned_list);
		boolean control = false;
		if (words.equals(cloned_list)) {
			System.out.println("İletilen Kelimeler sıralıdır");
			control = true;
		} else {
			System.out.println("İletilen kelimeler sıralı değildir.");
		}
		return control;
	}

	// String olarak girilen alfabe listeye eleman olarak ekleniyor.
	public static List<Character> alphabet(String str, List<Character> alphabet) {

		for (char ch : str.toCharArray()) {
			alphabet.add(ch);
		}
		return alphabet;

	}

	// Kelimelerin Sıralanması
	public static List<String> returSortedList(List<Character> alphabet, List<String> words) {

		for (int i = 0; i < words.size(); i++) {
			for (int j = i; j < words.size(); j++) {
				if (alphabet.indexOf(words.get(i).charAt(0)) < alphabet.indexOf(words.get(j).charAt(0))) {

				}

				else if (alphabet.indexOf(words.get(i).charAt(0)) > alphabet.indexOf(words.get(j).charAt(0))) {
					String deger = words.get(i);
					words.set(i, words.get(j));
					words.set(j, deger);
				} else {
					// sortListWordsControl o durumdaki i ve j konumu hangi kelimeye bakıldığını
					// anlamak için gönderiliyor ve fonksiyon hangisinin öncelikli olduğunu kontrol
					// ediyor
					sortListWordsControl(alphabet, words, i, j);
				}
			}

		}

		return words;
	}

	// Kelimeler sıralanırken aynı harf düzeninde olan kelimelerden hangisinin önce
	// geleceğine karar vermek için returSortedList metodunda çağırılan fonksiyon
	public static List<String> sortListWordsControl(List<Character> alphabet, List<String> words, int i, int j) {

		String firstWord = "";
		int loopSize = Math.max(words.get(i).length(), words.get(j).length());
		for (int k = 0; k < loopSize; k++) {
			if (alphabet.indexOf(words.get(i).charAt(k)) > alphabet.indexOf(words.get(j).charAt(k))) {
				firstWord = words.get(j);
				break;
			} else if (alphabet.indexOf(words.get(i).charAt(k)) < alphabet.indexOf(words.get(j).charAt(k))) {
				firstWord = words.get(i);
				break;
			} else {
			}
		}
		if (words.get(i).equals(firstWord)) {

		} else {
			String temp = words.get(i);
			words.set(i, words.get(j));
			words.set(j, temp);
		}

		return words;

	}
}
