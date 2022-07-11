import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	GradeBook book, book2;

	// did not let me access book from other methods even after calling
	// setup or having @before run it
	@BeforeEach
	void setUp() {
		book = new GradeBook(5);
		book2 = new GradeBook(5);
		book.addScore(1.0);
		book.addScore(2.0);
		book2.addScore(23.0);
		book2.addScore(5.0);

	}

	@AfterEach
	void tearDown() {
		book = null;
		book2 = null;
	}

	@Test
	void testAddScore() {

		assertEquals(2, book.getScoreSize());
		assertEquals(2, book2.getScoreSize());
	
	}

	@Test
	void testSum() {
		assertEquals(3.0, book.sum(), .0001);
		assertEquals(28.0, book2.sum(), .0001);


	
	}

	@Test
	void testMinimum() {
	
		assertEquals(1.0, book.minimum(), .001);
		assertEquals(5.0, book2.minimum(), .001);

	}

	@Test
	void testFinalScore() {


		assertEquals(2.0, book.finalScore(), .001);
		assertEquals(23.0, book2.finalScore(), .001);
	}

	@Test
	void testGetScoreSize() {
	
		assertEquals(2, book.getScoreSize());
		assertEquals(2, book2.getScoreSize());
	}

}
