import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameClassTesting {

	@Test
	void testGameInstanceCreation() {
		
		Game game1 = new Game("Sony", "Playstation 3", "Uncharted 3", "2011", "Action-Adventure", 305);
		
		assertEquals("305: Uncharted 3 for Playstation 3.", game1.toString());
		
	}
	
	@Test
	void testGameSetandGetConditionMethods() {
		
		Game game1 = new Game("Sony", "Playstation 3", "Uncharted 3", "2011", "Action-Adventure", 305);
		
		game1.setCondition(96);
		
		assertEquals(96, game1.getCondition());
		
	}
	
	@Test
	void testGameRenewMethod1() {
		
		Game game1 = new Game("Sony", "Playstation 3", "Uncharted 3", "2011", "Action-Adventure", 305);
		
		game1.setCondition(96);
		game1.renew();
		
		assertEquals(94, game1.getCondition());
		
	}
	
	@Test
	void testGameRenewMethod2() {
		
		Game game1 = new Game("Sony", "Playstation 3", "Uncharted 3", "2011", "Action-Adventure", 305);
		
		game1.setCondition(96);
		game1.renew();
		
		assertEquals(14, game1.getDueDate());
		
	}
	
	@Test
	void testGameCheckOutMethod1() {
		
		Game game1 = new Game("Sony", "Playstation 3", "Uncharted 3", "2011", "Action-Adventure", 305);
		
		game1.setCondition(96);
		game1.checkOut();
		
		assertEquals(14, game1.getDueDate());
		
	}
	
	@Test
	void testGameCheckOutMethod2() {
		
		Game game1 = new Game("Sony", "Playstation 3", "Uncharted 3", "2011", "Action-Adventure", 305);
		
		game1.setCondition(96);
		game1.checkOut();
		
		assertEquals(94, game1.getCondition());
		
	}
	
	@Test
	void testGameCheckOutMethod3() {
		
		Game game1 = new Game("Sony", "Playstation 3", "Uncharted 3", "2011", "Action-Adventure", 305);
		
		game1.setCondition(96);
		game1.checkOut();
		
		assertEquals("Checked Out", game1.getStatus());
		
	}
	
	@Test
	void testGameCheckInMethod1() {
		
		Game game1 = new Game("Sony", "Playstation 3", "Uncharted 3", "2011", "Action-Adventure", 305);
		
		game1.checkOut();
		game1.checkIn();
		
		assertEquals("On Shelf", game1.getStatus());
		
	}
	
	@Test
	void testGameCheckInMethod2() {
		
		Game game1 = new Game("Sony", "Playstation 3", "Uncharted 3", "2011", "Action-Adventure", 305);
		
		game1.checkOut();
		game1.checkIn();
		
		assertEquals(0, game1.getDueDate());
		
	}
	
	@Test
	void testGameSetandGetPublisherMethods() {
		
		Game game1 = new Game("Sony", "Playstation 3", "Uncharted 3", "2011", "Action-Adventure", 305);
		
		game1.setPublisher("Nintendo");
		
		assertEquals("Nintendo", game1.getPublisher());
		
	}
	
	@Test
	void testGameSetandGetConsoleMethods() {
		
		Game game1 = new Game("Sony", "Playstation 3", "Uncharted 3", "2011", "Action-Adventure", 305);
		
		game1.setConsole("Nintendo 64");
		
		assertEquals("Nintendo 64", game1.getConsole());
		
	}

}
