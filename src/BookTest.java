import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class BookTest {

	//testing getters
	@Test
	void testGetTitle() {
		Book book = new Book("Silence of the Lambs", new ArrayList<String>(Arrays.asList("Thomas Harris")), "1988", "Thriller");
		String expected = "Silence of the Lambs";
		String actual = book.getTitle();
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetAuthor() {
		Book book = new Book("Silence of the Lambs", new ArrayList<String>(Arrays.asList("Thomas Harris")), "1988", "Thriller");
		ArrayList<String> expected = new ArrayList<String>(Arrays.asList("Thomas Harris"));
		ArrayList<String> actual = book.getAuthor();
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetReleaseDate() {
		Book book = new Book("Silence of the Lambs", new ArrayList<String>(Arrays.asList("Thomas Harris")), "1988", "Thriller");
		String expected = "1988";
		String actual = book.getReleaseDate();
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetGenre() {
		Book book = new Book("Silence of the Lambs", new ArrayList<String>(Arrays.asList("Thomas Harris")), "1988", "Thriller");
		String expected = "Thriller";
		String actual = book.getGenre();
		assertEquals(expected, actual);
	}
	
	@Test
	void getCondition() {
		Book book = new Book("Silence of the Lambs", new ArrayList<String>(Arrays.asList("Thomas Harris")), "1988", "Thriller");
		int expected = 100;
		int actual = book.getCondition();
		assertEquals(expected, actual);
	}
	
	@Test
	void getStatus() {
		Book book = new Book("Silence of the Lambs", new ArrayList<String>(Arrays.asList("Thomas Harris")), "1988", "Thriller");
		String expected = "On Shelf";
		String actual = book.getStatus();
		assertEquals(expected, actual);
	}
	
	//testing setters
	
	@Test
	void testSetTitle() {
		Book book = new Book("Silence of the Lambs", new ArrayList<String>(Arrays.asList("Thomas Harris")), "1988", "Thriller");
		book.setTitle("The Adventures of Huckleberry Finn");
		String expected = "The Adventures of Huckleberry Finn";
		String actual = book.getTitle();
		assertEquals(expected, actual);
	}
	
	@Test
	void testSetAuthor() {
		Book book = new Book("The Adventures of Huckleberry Finn", new ArrayList<String>(Arrays.asList("Thomas Harris")), "1988", "Thriller");
		book.setAuthor(new ArrayList<String>(Arrays.asList("Mark Twain")));
		ArrayList<String> expected = new ArrayList<String>(Arrays.asList("Mark Twain"));
		ArrayList<String> actual = book.getAuthor();
		assertEquals(expected, actual);
	}
	
	@Test
	void testSetReleaseDate() {
		Book book = new Book("The Adventures of Huckleberry Finn", new ArrayList<String>(Arrays.asList("Mark Twain")), "1988", "Thriller");
		book.setReleaseDate("1884");
		String expected = "1884";
		String actual = book.getReleaseDate();
		assertEquals(expected, actual);
	}
	
	@Test
	void testSetGenre() {
		Book book = new Book("The Adventures of Huckleberry Finn", new ArrayList<String>(Arrays.asList("Mark Twain")), "1884", "Thriller");
		book.setGenre("Adventure");
		String expected = "Adventure";
		String actual = book.getGenre();
		assertEquals(expected, actual);
	}

	@Test
	void testSetCondition() {
		Book book = new Book("The Adventures of Huckleberry Finn", new ArrayList<String>(Arrays.asList("Mark Twain")), "1884", "Adventure");
		book.setCondition(45);
		int expected = 45;
		int actual = book.getCondition();
		assertEquals(expected, actual);
	}
	
	@Test
	void testSetStatus() {
		Book book = new Book("The Adventures of Huckleberry Finn", new ArrayList<String>(Arrays.asList("Mark Twain")), "1884", "Adventure");
		book.setStatus("Checked Out");
		String expected = "Checked Out";
		String actual = book.getStatus();
		assertEquals(expected, actual);
	}
	
	//testing other methods
	@Test
	void testAddAuthor() {
		Book book = new Book("A Trick of Light", new ArrayList<String>(Arrays.asList("Stan Lee")), "2019", "Sci-fi");
		book.addAuthor("Kat Rosenfield");
		ArrayList<String> expected = new ArrayList<String>(Arrays.asList("Stan Lee", "Kat Rosenfield"));
		ArrayList<String> actual = book.getAuthor();
		assertEquals(expected, actual);
	}
	
	@Test
	void testCheckOut() {
		Book book = new Book("A Trick of Light", new ArrayList<String>(Arrays.asList("Stan Lee", "Kat Rosenfield")), "2019", "Sci-fi");
		book.checkOut();
		String expected = "Checked Out";
		String actual = book.getStatus();
		assertEquals(expected, actual);
	}
	
	@Test
	void testCheckOut2() {
		Book book = new Book("A Trick of Light", new ArrayList<String>(Arrays.asList("Stan Lee", "Kat Rosenfield")), "2019", "Sci-fi");
		book.checkOut();
		int expected = 95;
		int actual = book.getCondition();
		assertEquals(expected, actual);
	}
	
	@Test
	void testCheckOut3() {
		Book book = new Book("A Trick of Light", new ArrayList<String>(Arrays.asList("Stan Lee", "Kat Rosenfield")), "2019", "Sci-fi");
		book.checkOut();
		int expected = 14;
		int actual = book.getDueDate();
		assertEquals(expected, actual);
	}
	
	@Test
	void testCheckIn() {
		Book book = new Book("A Trick of Light", new ArrayList<String>(Arrays.asList("Stan Lee", "Kat Rosenfield")), "2019", "Sci-fi");
		book.checkOut();
		book.checkIn();
		String expected = "On Shelf";
		String actual = book.getStatus();
		assertEquals(expected, actual);
	}
	
	@Test	
	void testRenew() {
		Book book = new Book("A Trick of Light", new ArrayList<String>(Arrays.asList("Stan Lee", "Kat Rosenfield")), "2019", "Sci-fi");
		book.checkOut();
		book.renew();
		int expected = 90;
		int actual = book.getCondition();
		assertEquals(expected, actual);
	}
	
	@Test	
	void testRenew2() {
		Book book = new Book("A Trick of Light", new ArrayList<String>(Arrays.asList("Stan Lee", "Kat Rosenfield")), "2019", "Sci-fi");
		book.checkOut();
		book.renew();
		int expected = 28;
		int actual = book.getDueDate();
		assertEquals(expected, actual);
	}
	
	@Test	
	void testToString() {
		Book book = new Book("A Trick of Light", new ArrayList<String>(Arrays.asList("Stan Lee", "Kat Rosenfield")), "2019", "Sci-fi");
		String expected = "A Trick of Light by Stan Lee, Kat Rosenfield";
		String actual = book.toString();
		assertEquals(expected, actual);
	}
	
}
