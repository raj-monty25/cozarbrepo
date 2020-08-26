package com.cozarb.service.util;

import java.security.SecureRandom;

public class RandomCodeGenerator {
	private final static String[] randomChars = { "a", "u", "c", "d", "v", "@", "e", "q", "f", "$", "g", "h", "s",
			"j", "k", "z", "l", "m", "o", "p", "r", "b", "t", "w", "x", "n", "y", "i", "&", "0", "7", "2", "4", "5",
			"9", "6", "1", "8", "3" };

	private final static String[] randomNumbers = { "0", "7", "2", "4", "5", "9", "6", "1", "8", "3" };

	public static String generateRandomAlhpaNumericWithSpecialCharsToken(int length) {
		String randomToken = null;
		SecureRandom random = null;
		StringBuilder buffer = null;
		int index = 0;

		random = new SecureRandom();
		buffer = new StringBuilder();
		for (int i = 0; i < length; i++) {
			index = random.nextInt(38);
			buffer.append(randomChars[index]);
		}
		randomToken = buffer.toString();
		return randomToken;
	}

	public static String generateRandomNumericToken(int length) {
		String randomToken = null;
		SecureRandom random = null;
		StringBuilder buffer = null;
		int index = 0;

		random = new SecureRandom();
		buffer = new StringBuilder();
		for (int i = 0; i < length; i++) {
			index = random.nextInt(10);
			buffer.append(randomNumbers[index]);
		}
		randomToken = buffer.toString();
		return randomToken;
	}

}
