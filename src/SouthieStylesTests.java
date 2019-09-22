import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SouthieStylesTests {

	@Test
	void isVowel() {
		assertTrue(SouthieStyles.isVowel('a'));
		assertTrue(SouthieStyles.isVowel('e'));
		assertTrue(SouthieStyles.isVowel('i'));
		assertFalse(SouthieStyles.isVowel('g'));
	}
	@Test
	void risnext() {
		assertTrue(SouthieStyles.risnext("harbor", 1));
	}
/*	 @Test //even when I throw filenotfoundexception this won't work.
	void Southie() throws FileNotFoundException {
		assertEquals(SouthieStyles.Southie("harbor", new Scanner(new File("Jaws.txt"))), "hahboh");
		assertEquals(SouthieStyles.Southie("car", new Scanner(new File("Jaws.txt"))), "cah");
		assertEquals(SouthieStyles.Southie("hooper", new Scanner(new File("Jaws.txt"))), "hoopeh");
		assertEquals(SouthieStyles.Southie("DEER", new Scanner(new File("Jaws.txt"))), "deeyah");
	} */
	@Test
	void wicked() {
		assertEquals(SouthieStyles.wicked("very"), "wicked");
	}
	@Test
	void appendr() {
		assertEquals(SouthieStyles.appendr("tuna"), "tunar");
		assertEquals(SouthieStyles.appendr("tuna."), "tunar.");
		assertEquals(SouthieStyles.appendr("a"), "a");
		assertEquals(SouthieStyles.appendr("bad"), "bad");
	}
	@Test
	void vowelr() {
		assertEquals(SouthieStyles.vowelr("deer."), "deeyah.");
		assertEquals(SouthieStyles.vowelr("deers."), "deehs.");
		assertEquals(SouthieStyles.vowelr("deer"), "deeyah");
		assertEquals(SouthieStyles.vowelr("veneers"), "veneehs");
		assertEquals(SouthieStyles.vowelr("door"), "doowah");
		assertEquals(SouthieStyles.vowelr("door."), "doowah.");
		assertEquals(SouthieStyles.vowelr("doors"), "doohs");
		assertEquals(SouthieStyles.vowelr("doors."), "doohs.");
		assertEquals(SouthieStyles.vowelr("chair"), "chaiyah");
		assertEquals(SouthieStyles.vowelr("razor"), "razoh");
		assertEquals(SouthieStyles.vowelr("or"), "or");
		assertEquals(SouthieStyles.vowelr("reindeer"), "reindeeyah");
	}
}
