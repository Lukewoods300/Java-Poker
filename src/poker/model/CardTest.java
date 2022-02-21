package poker.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CardTest {

	@Test
	void testCard() {
		Card a = new Card(14,'a');
		int b = a.getRank();
		char c = a.getType();
		boolean d = a.isAce();
		assertTrue(b == 14 && c=='a' && d==true);
	}

	@Test
	void testGetType() {
		Card a = new Card(14,'a');
		char b = a.getType();
		assertTrue(b == 'a');
	}

	@Test
	void testGetRank() {
		Card a = new Card(14,'a');
		int b = a.getRank();
		assertTrue(b == 14);
	}

	@Test
	void testIsAce() {
		Card a = new Card(14,'a');
		boolean b = a.isAce();
		assertTrue(b == true);
	}
}
