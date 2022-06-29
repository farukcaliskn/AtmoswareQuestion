package com.question;

import java.util.Arrays;

public class _3_Comparable {
	public static void main(String[] args) {

		String order = "abcçdefgĞhıijklmnoöprsştuvyz";
		String[] words = { "sait", "bayhan", "samt", "irfan", "ayten", "aydın", "irfin", "aysun" };

		Arrays.sort(words, (o1, o2) -> {
			int posOne = 0;
			int posTwo = 0;
			for (int i = 0; i < Math.min(o1.length(), o2.length()) && posOne == posTwo; i++) {
				posOne = order.indexOf(o1.charAt(i));
				posTwo = order.indexOf(o2.charAt(i));
			}

			if (posOne == posTwo && o1.length() != o2.length()) {
				return o1.length() - o2.length();
			}

			return posOne - posTwo;
		});
		System.out.println(Arrays.toString(words));
	}
}
