import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class MovieTest {

	//testing getters
	@Test
	void testGetTitle() {
		Movie movie = new Movie(new ArrayList<String>(Arrays.asList("Steven Spielberg")), 105,"Indiana Jones: Raiders Of The Lost Ark", "1981", "Adventure", 205);
		String expected = "Indiana Jones: Raiders Of The Lost Ark";
		String actual = movie.getTitle();
		assertEquals(expected, actual);
	}
	@Test
	void testGetDirector() {
		Movie movie = new Movie(new ArrayList<String>(Arrays.asList("Steven Spielberg")), 105,"Indiana Jones: Raiders Of The Lost Ark", "1981", "Adventure", 205);
		ArrayList<String> expected = new ArrayList<String>(Arrays.asList("Steven Spielberg"));
		ArrayList<String> actual = movie.getDirector();
		assertEquals(expected, actual);
	}
	@Test
	void testGetReleaseDate() {
		Movie movie = new Movie(new ArrayList<String>(Arrays.asList("Steven Spielberg")), 105,"Indiana Jones: Raiders Of The Lost Ark", "1981", "Adventure", 205);
		String expected = "1981";
		String actual = movie.getReleaseDate();
		assertEquals(expected, actual);
	}
	@Test
	void testGetGenre() {
		Movie movie = new Movie(new ArrayList<String>(Arrays.asList("Steven Spielberg")), 105,"Indiana Jones: Raiders Of The Lost Ark", "1981", "Adventure", 205);
		String expected = "Adventure";
		String actual = movie.getGenre();
		assertEquals(expected, actual);
	}
	@Test
	void testGetCondition() {
		Movie movie = new Movie(new ArrayList<String>(Arrays.asList("Steven Spielberg")), 105,"Indiana Jones: Raiders Of The Lost Ark", "1981", "Adventure", 205);
		int expected = 100;
		int actual = movie.getCondition();
		assertEquals(expected, actual);
	}
	@Test
	void testGetStatus() {
		Movie movie = new Movie(new ArrayList<String>(Arrays.asList("Steven Spielberg")), 105,"Indiana Jones: Raiders Of The Lost Ark", "1981", "Adventure", 205);
		String expected = "On Shelf";
		String actual = movie.getStatus();
		assertEquals(expected, actual);
	}
	
	//test setters
	@Test
	void testSetTitle() {
		Movie movie = new Movie(new ArrayList<String>(Arrays.asList("Steven Spielberg")), 105,"Indiana Jones: Raiders Of The Lost Ark", "1981", "Adventure", 205);
		movie.setTitle("Star Wars");
		String expected = "Star Wars";
		String actual = movie.getTitle();
		assertEquals(expected, actual);
	}
	@Test
	void testSetDirector() {
		Movie movie = new Movie(new ArrayList<String>(Arrays.asList("Steven Spielberg")), 105,"Indiana Jones: Raiders Of The Lost Ark", "1981", "Adventure", 205);
		movie.setDirector(new ArrayList<String>(Arrays.asList("Hitchcock")));
		ArrayList<String> expected = new ArrayList<String>(Arrays.asList("Hitchcock"));
		ArrayList<String> actual = movie.getDirector();
		assertEquals(expected, actual);
	}
	@Test
	void testSetReleaseDate() {
		Movie movie = new Movie(new ArrayList<String>(Arrays.asList("Steven Spielberg")), 105,"Indiana Jones: Raiders Of The Lost Ark", "1981", "Adventure", 205);
		movie.setReleaseDate("2000");
		String expected = "2000";
		String actual = movie.getReleaseDate();
		assertEquals(expected, actual);
	}
	@Test
	void testSetGenre() {
		Movie movie = new Movie(new ArrayList<String>(Arrays.asList("Steven Spielberg")), 105,"Indiana Jones: Raiders Of The Lost Ark", "1981", "Adventure", 205);
		movie.setGenre("Drama");
		String expected = "Drama";
		String actual = movie.getGenre();
		assertEquals(expected, actual);
	}
	@Test
	void testSetCondition() {
		Movie movie = new Movie(new ArrayList<String>(Arrays.asList("Steven Spielberg")), 105,"Indiana Jones: Raiders Of The Lost Ark", "1981", "Adventure", 205);
		movie.setCondition(50);
		int expected = 50;
		int actual = movie.getCondition();
		assertEquals(expected, actual);
	}
	@Test
	void testSetStatus() {
		Movie movie = new Movie(new ArrayList<String>(Arrays.asList("Steven Spielberg")), 105,"Indiana Jones: Raiders Of The Lost Ark", "1981", "Adventure", 205);
		movie.setStatus("Checked Out");
		String expected = "Checked Out";
		String actual = movie.getStatus();
		assertEquals(expected, actual);
	}
	
	//test various other things and other methods
	@Test
	void testCheckOut1() {
		Movie movie = new Movie(new ArrayList<String>(Arrays.asList("Steven Spielberg")), 105,"Indiana Jones: Raiders Of The Lost Ark", "1981", "Adventure", 205);
		movie.checkOut();
		String expected = "Checked Out";
		String actual = movie.getStatus();
		assertEquals(expected, actual);
	}	
	@Test
	void testCheckOut2() {
		Movie movie = new Movie(new ArrayList<String>(Arrays.asList("Steven Spielberg")), 105,"Indiana Jones: Raiders Of The Lost Ark", "1981", "Adventure", 205);
		movie.checkOut();
		int expected = 99;
		int actual = movie.getCondition();
		assertEquals(expected, actual);
	}
	@Test
	void testCheckOut3() {
		Movie movie = new Movie(new ArrayList<String>(Arrays.asList("Steven Spielberg")), 105,"Indiana Jones: Raiders Of The Lost Ark", "1981", "Adventure", 205);
		movie.checkOut();
		int expected = 14;
		int actual = movie.getDueDate();
		assertEquals(expected, actual);
	}
	@Test
	void testCheckIn1() {
		Movie movie = new Movie(new ArrayList<String>(Arrays.asList("Steven Spielberg")), 105,"Indiana Jones: Raiders Of The Lost Ark", "1981", "Adventure", 205);
		movie.checkOut();
		movie.checkIn();
		String expected = "On Shelf";
		String actual = movie.getStatus();
		assertEquals(expected, actual);
	}
	@Test
	void testCheckIn2() {
		Movie movie = new Movie(new ArrayList<String>(Arrays.asList("Steven Spielberg")), 105,"Indiana Jones: Raiders Of The Lost Ark", "1981", "Adventure", 205);
		movie.checkOut();
		movie.checkIn();
		int expected = 0;
		int actual = movie.getDueDate();
		assertEquals(expected, actual);
	}
	@Test
	void testAddDirector() {
		Movie movie = new Movie(new ArrayList<String>(Arrays.asList("Steven Spielberg")), 105,"Indiana Jones: Raiders Of The Lost Ark", "1981", "Adventure", 205);
		movie.addDirector("Hitchcock");
		ArrayList<String> expected = new ArrayList<String>(Arrays.asList("Steven Spielberg", "Hitchcock"));
		ArrayList<String> actual = movie.getDirector();
		assertEquals(expected, actual);
	}
	@Test	
	void testRenew1() {
		Movie movie = new Movie(new ArrayList<String>(Arrays.asList("Steven Spielberg")), 105,"Indiana Jones: Raiders Of The Lost Ark", "1981", "Adventure", 205);
		movie.checkOut();
		movie.renew();
		int expected = 98;
		int actual = movie.getCondition();
		assertEquals(expected, actual);
	}
	@Test	
	void testRenew2() {
		Movie movie = new Movie(new ArrayList<String>(Arrays.asList("Steven Spielberg")), 105,"Indiana Jones: Raiders Of The Lost Ark", "1981", "Adventure", 205);
		movie.checkOut();
		movie.renew();
		int expected = 28;
		int actual = movie.getDueDate();
		assertEquals(expected, actual);
	}
	@Test	
	void testToString() {
		Movie movie = new Movie(new ArrayList<String>(Arrays.asList("Lucas")), 121,"Star Wars", "1977", "Sci-Fi", 206);
		String expected ="206: Star Wars by Lucas ";
		String actual = movie.toString();
		assertEquals(expected, actual);
	}
}
