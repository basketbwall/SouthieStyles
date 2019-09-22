import java.io.*;
//William Huang
//March 15 2019
//Assignment 6. SouthieStyles
//
//This program creates a new file that converts the original jaws script to a booston accent
//I was unable to get capitalization to work, but the output does maintain spacing and punctuation
//
//

import java.util.Scanner;
public class SouthieStyles {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner reading = new Scanner(new File("Jaws.txt"));
		PrintStream output = new PrintStream(new File("Jawsconverted.txt"));
		while (reading.hasNextLine()) {
			String currentline = reading.nextLine();
			String oldspacing = spaces(currentline);
			output.println(oldspacing + Southie(currentline, reading).trim());
		}
		reading.close();
	}
	public static String Southie(String sentence, Scanner i) {
		Scanner oldsentence = new Scanner(sentence);
		String newsentence = "";
		while (oldsentence.hasNext()) {
			String word = "";
			word = oldsentence.next();
//			String oldword = "";
//			oldword = word;
//			boolean oldcasing[] = caseArray(word);
//			String rememberuppercases = uppercases2(word);
			word = word.toLowerCase();
			word = wicked(word);
			word = vowelr(word);
			word = appendr(word);
//			oldword = equalizelength(oldword, word);
//			word = caseify(word, oldword);
//			word = restorecasing(word, rememberuppercases);
			newsentence += word + " ";
		}
		oldsentence.close();
		return newsentence;
	}
	public static boolean isVowel(char a) {
		// remove this stuff if i choose not to capitalize it all
		if (a == 'a') {
			return true;
		} else if (a == 'e') {
			return true;
		} else if (a == 'i') {
			return true;
		} else if (a == 'o') {
			return true;
		} else if (a == 'u') {
			return true;
		} else {
			return false;
		}
	}
	
	//if a vowel is at the end there shouldn't be an r next to it. it's the last word.
	//that's what the first part of the if statement tests
	//if it passes first half of the 'and' expression, then it checks for an r to the right
	
	public static boolean risnext(String word, int i) {
		if ((i != word.length()-1) && (word.charAt(i+1) == 'r' || word.charAt(i+1) == 'R')) {
			return true;
		} else {
			return false;
		}
	}

	public static String vowelr(String word) {
		//modifies any eer occurence at end of word
		if (word.endsWith("eer")) {
			word = word.substring(0, word.length()-1) + "yah";
		}
		if (word.indexOf("eer") > -1 && ispunctuation(word.charAt(word.length()-1))) {
			if (word.charAt(word.length()-2) != 's') {
				word = word.substring(0, word.indexOf("eer")+2) + "yah" + word.substring(word.length()-1);
			}
		}
		//modifies any oor occurence at end of word
		if (word.endsWith("oor")) {
			word = word.substring(0, word.length()-1) + "wah";
		}
		if (word.indexOf("oor") > -1 && ispunctuation(word.charAt(word.length()-1))) {
			if (word.charAt(word.length()-2) != 's') {
				word = word.substring(0, word.indexOf("oor")+2) + "wah" + word.substring(word.length()-1);
			}
		}
		//modifies any ir occurence at end of word.
		if (word.endsWith("ir")) {
			word = word.substring(0, word.length()-1) + "yah";
		}
		if (word.indexOf("ir") > -1 && ispunctuation(word.charAt(word.length()-1))) {
			if (word.charAt(word.length()-2) != 's') {
				word = word.substring(0, word.indexOf("ir")+2) + "yah" + word.substring(word.length()-1);
			}
		}
		// once those exceptions have been made, any vowel + r combination left must be replaced with h
		for (int i = 0; i < word.length(); i++) {  // possibly do this for the others
			if (word.length() > 3 && isVowel(word.charAt(i)) && risnext(word, i)) { // checks if vowel and r follows it
				word = word.substring(0, i+1) + "h" + word.substring(i+2);
			}
		}
		return word;
	}
	public static String wicked(String word) {
		if (word.equals("very")) {
			return "wicked";
		} else {
			return word;
		}
	}
	public static String appendr(String word) {
		if (word.contentEquals("aka:")) { // this an exception
			return "aka:";
		} else if (word.substring(0, word.length()-1).endsWith("a") && ispunctuation(word.charAt(word.length()-1)) == true) {
			word = word.substring(0, word.length()-1) + "r" + word.substring(word.length()-1);
			return word;
		} else if (word.length() > 1 && word.endsWith("a")) {
			return word + "r";
		} else {
			return word;
		}
	}
	public static boolean ispunctuation(char character) {
		String allpuncs = "\"'][{}()_!,.?:;";
		for (int i = 0; i < allpuncs.length(); i++) {
			if (allpuncs.charAt(i) == character) {
				return true;
			}
		}
		return false;
	}
	public static String spaces(String sentence) {
		String numspaces = "";
		for (int x = 0; x < sentence.length(); x++) {
			if (sentence.charAt(x) == ' ') {
				numspaces += " ";
			} else {
				return numspaces;
			}
		}
		return numspaces;
	}
	//ignore this please. couldn't get this to work
	public static String uppercases1(String word) {
		String indexofhighers = "";
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) >= 65 && word.charAt(i) <= 90) {
				indexofhighers +=i;
			}
		}
		return indexofhighers;
	}
	//ignore this please. couldn't get this to work
	public static String uppercases2(String word) {
		String indexofhighers = "";
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
				indexofhighers +=i;
			} else {
				indexofhighers += " ";
			}
		}
		return indexofhighers;
	}
	//ignore this please. couldn't get this to work
	public static boolean[] caseArray(String s) {
		boolean cases[] = new boolean[s.length()];
		for (int i=0; i<s.length(); i++) {
			if (Character.isUpperCase(s.charAt(i))) {
				cases[i]=true;
			} else {
				cases[i]=false;
			}
		}
		return cases;
	}
	//ignore this please. couldn't get this to work
	public static String caseify(String s, String original) {
		String r="";
		for (int i=0; i<s.length(); i++) {
			if (Character.toUpperCase(s.charAt(i)) == original.charAt(i)) {
		//		r+=Character.toUpperCase(indexofhighers.charAt(i));
				r+=Character.toUpperCase(s.charAt(i));
			} else {
				r+=Character.toLowerCase(s.charAt(i));
			}
		}
		return r;
	}
	//ignore this please. couldn't get this to work
	public static String equalizelength(String shorter, String longer) {
		String spaces = "";
		int diff = longer.length() - shorter.length();
		for (int i = diff; i > 0; diff--) {
			spaces += " ";
		}
		return shorter+spaces;
	}
	//ignore this please. couldn't get this to work
	public static String restorecasing(String word, String high) {
		// some other character = Character.toUpperCase( a character);
		for (int i = 0; i < high.length(); i++) {
			int index = high.charAt(i);
			word = word.substring(0, index) + (Character.toUpperCase(word.charAt(index))) + word.substring(index);
		}
		return word;
	}
}
