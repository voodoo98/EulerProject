package com.voodoo98.eulerproject.solutions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.voodoo98.eulerproject.utils.NumberUtils;

public class solution059 {

	private static final String DELIMITER = ",";

	public static void main(final String[] args) throws IOException {
		final long time = System.currentTimeMillis();

		System.err.println("Result: " + count());
		System.err.println("Time: " + (System.currentTimeMillis() - time));
	}

	private static long count() throws IOException {
		final List<String> readAllLines = Files.readAllLines(Paths.get("resources/p059_cipher.txt"));
		final String[] chars = readAllLines.get(0).split(DELIMITER);
		final byte[] encodedByteArray = new byte[chars.length];
		for (int i = 0; i < encodedByteArray.length; i++) {
			encodedByteArray[i] = Byte.valueOf(chars[i]);
		}

		byte[] resultByteArray = null;
		for (byte c1 = 'a'; c1 <= 'z'; c1++) {
			for (byte c2 = 'a'; c2 <= 'z'; c2++) {
				for (byte c3 = 'a'; c3 <= 'z'; c3++) {
					final byte[] key = { c1, c2, c3 };
					final byte[] decrypt = decrypt(encodedByteArray, key);
					if (checkEnglishText(decrypt)) {
						resultByteArray = decrypt;
					}
				}
			}
		}

		System.err.println(new String(resultByteArray));
		return NumberUtils.sumDigits(resultByteArray);
	}

	private static boolean checkEnglishText(final byte[] decrypt) {
		boolean result = true;
		for (final byte b : decrypt) {
			if (!(31 < b && b < 126) || b == '_' || b == '`') {
				result = false;
				break;
			}
		}
		return result;
	}

	private static byte[] decrypt(final byte[] encodedText, final byte[] key) {
		final byte[] plaintext = new byte[encodedText.length];
		for (int i = 0; i < encodedText.length; i++) {
			plaintext[i] = (byte) (encodedText[i] ^ key[i % key.length]);
		}
		return plaintext;
	}

}
