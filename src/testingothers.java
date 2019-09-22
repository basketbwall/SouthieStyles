import java.util.Scanner;
import java.io.*;

public class testingothers {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner in = new Scanner(new File("Jaws.txt"));
		PrintStream out = new PrintStream(new File("Jawsinsouthie.txt"));

		while (in.hasNext()) {
			String word = in.next();
			if (word.equals("'")) // ignore lone apostrophes
				continue;
			if (word.equalsIgnoreCase("very")) {
				word = "wicked";
			}

			if (word.endsWith("a")) {
				word = word + "r";
			}
			if (word.endsWith("A")) {
				word = word + "R";
			}

			if (word.endsWith("ir")) {
				word = word.substring(0, word.length() - 2);
				word = word + "iyah";
			}
			if (word.endsWith("Ir")) {
				word = word.substring(0, word.length() - 2);
				word = word + "Iyah";
			}
			if (word.endsWith("iR")) {
				word = word.substring(0, word.length() - 2);
				word = word + "iYah";
			}
			if (word.endsWith("IR")) {
				word = word.substring(0, word.length() - 2);
				word = word + "IYah";
			}

			if (word.endsWith("eer")) {
				word = word.replaceAll("eer", "eeyah");
			}
			if (word.endsWith("eEr")) {
				word = word.replaceAll("eEr", "eEyah");
			}
			if (word.endsWith("eeR")) {
				word = word.replaceAll("eeR", "eeYah");
			}
			if (word.endsWith("eER")) {
				word = word.replaceAll("eER", "eEYah");
			}
			if (word.endsWith("EEr")) {
				word = word.replaceAll("EEr", "EEyah");
			}
			if (word.endsWith("EeR")) {
				word = word.replaceAll("EeR", "EeYah");
			}

			if (word.endsWith("oor")) {
				word = word.replaceAll("oor", "oowahs");
			}
			if (word.endsWith("Oor")) {
				word = word.replaceAll("Oor", "Oowahs");
			}
			if (word.endsWith("oOr")) {
				word = word.replaceAll("oOr", "oOwahs");
			}
			if (word.endsWith("ooR")) {
				word = word.replaceAll("ooR", "ooWahs");
			}
			if (word.endsWith("OOR")) {
				word = word.replaceAll("OOR", "OOWahs");
			}
			if (word.endsWith("OoR")) {
				word = word.replaceAll("OoR", "OoWahs");
			}

			word = word.replace("ar", "ah");
			word = word.replace("er", "eh");
			word = word.replace("ir", "ih");
			word = word.replace("or", "oh");
			word = word.replace("ur", "uh");

			word = word.replace("Ar", "Ah");
			word = word.replace("Er", "Eh");
			word = word.replace("Ir", "Ih");
			word = word.replace("Or", "Oh");
			word = word.replace("Ur", "Uh");

			word = word.replace("aR", "aH");
			word = word.replace("eR", "eH");
			word = word.replace("iR", "iH");
			word = word.replace("oR", "oH");
			word = word.replace("uR", "uH");

			word = word.replace("AR", "AH");
			word = word.replace("ER", "EH");
			word = word.replace("IR", "IH");
			word = word.replace("OR", "OH");
			word = word.replace("UR", "UH");
			out.println(word + " ");

		}
		in.close();
	}
}