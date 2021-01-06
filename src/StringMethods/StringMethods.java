package StringMethods;

import java.util.Arrays;
import java.util.Base64;

/*
Visit the JavaDocs for the String class to view everything you can do with a String.  


HINT:  Here are some String methods you might find useful 
contains
replace
trim
length
getBytes
endsWith
split 
indexOf
lastIndexOf
compareTo(IgnoreCase)
substring


Here are some Character methods you might find useful:
Character.toLowerCase(char c);
Character.isLetter(char c);
Character.isDigit(char c);
Character.getNumericValue(char c);
 */

public class StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return s1;
		} else {
			return s2;
		}
	}

	// if String s contains the word "underscores", change all of the spaces to
	// underscores
	public static String formatSpaces(String s) {
		String r = "";
		if (s.contains("underscores")) {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == ' ') {
					r = s.replace(s.charAt(i), '_');
				}
			}
			return r;
		}
		return s;
	}

	// Return the name of the person whose LAST name would appear first if they were
	// in alphabetical order
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		String a = "";
		String b = "";
		String c = "";
		int x = 0;
		int y = 0;
		int z = 0;
		for (int i = s1.length() - 1; i >= 0; i--) {
			if (i != 0) {

				if (s1.charAt(i) == ' ') {
					a = s1.charAt(i - 1) + "";
				}
			}
		}
		for (int i = s2.length() - 1; i >= 0; i--) {
			if (i != 0) {

				if (s2.charAt(i) == ' ') {
					b = s2.charAt(i - 1) + "";
				}
			}
		}
		for (int i = s3.length() - 1; i >= 0; i--) {
			if (i != 0) {
				if (s3.charAt(i) == ' ') {
					c = s3.charAt(i - 1) + "";
				}
			}
		}
		if (a.compareToIgnoreCase(b) == -1 && a.compareToIgnoreCase(c) == -1) {

			return s1;
		} else if (b.compareToIgnoreCase(a) == -1 && b.compareToIgnoreCase(c) == -1) {
			return s2;
		} else {
			return s3;
		}
	}

	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int one = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				one = one + Integer.parseInt(s.charAt(i) + "");
			}
		}
		return one;
	}

	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		int second = 0;
		int total = 0;
		for (int i = 0; i <= s.length() - substring.length(); i++) {
			second = 0;
			for (int j = 0; j < substring.length(); j++) {
				if (s.charAt(i + j) == substring.charAt(j)) {
					second++;
				}

			}
			if (second == substring.length()) {
				total++;
			}
		}

		return total;
	}

	// Call Utitilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {
		String key1 = key + "";

		return Utilities.encrypt(s.getBytes(), key1.getBytes()[0]);

	}

	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {
		String key1 = key + "";

		return Utilities.decrypt(s, key1.getBytes()[0]);
	}

	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		int sb = 0;
		int times = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ' || i == s.length() - 1) {
				sb = 0;
				for (int j = 0; j < substring.length(); j++) {
					if (i >= substring.length() && s.charAt(i - substring.length() + j) == substring.charAt(j)) {
						sb++;
					}
					if (sb == substring.length()) {
						times++;

					}
				}
			}
		}

		return times;
	}

	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		int first = 0;
		int last=0;
		int pos1=0;
		int pos2=0;
		for (int i = 0; i < s.length(); i++) {
			if (i <= substring.length() && s.charAt(i) == substring.charAt(i)) {
				first++;
				if (first == substring.length()) {
pos1=i;
				}
			}

		}
		for (int j = s.length() - 1; j >= 0; j--) {
			if (j >= substring.length() && s.charAt(j) == substring.charAt(j)) {
				last++;
				if (last == substring.length()) {
pos2=j;
				}
			}

		}
		
		return pos2-pos1;
	}

	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		return true;
	}

}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
