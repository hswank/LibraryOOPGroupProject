import java.util.ArrayList;

public class libraryApp {

	public static void main(String[] args) {
		//data
		ArrayList<Media> catalog = new ArrayList<>();
		//movies
		catalog.add(new Movies("Steven Spielberg", 124, "Jaws", "1975", "Thriller"));
		catalog.add(new Movies("George Lucas", 121, "Star Wars: A New Hope", "1977", "Sci-Fi"));
		catalog.add(new Movies("Peter Jackson", 169, "The Hobbit", "2012", "Fantasy"));
		catalog.add(new Movies("Martin Scorsese", 180, "The Wolf Of Wallstreet", "2013", "Drama"));
		//books
		catalog.add(new Book("Fear And Loathing In Las Vegas", "Hunter S. Thompson", "1976", "Fiction"));
		catalog.add(new Book("Animal Farm", "George Orwell", "1945", "Dystopian Fiction"));
		catalog.add(new Book("A Game Of Thrones", "George R. R. Martin", "1996", "Fantasy"));
		catalog.add(new Book("Grant", "Ron Chernow", "2017", "Biography"));
		//video games
		catalog.add(new VideoGame("Sony", "PlayStation", "Crash Bandicoot", "1996","Platformer"));
		catalog.add(new VideoGame("Microsoft", "Xbox", "Halo", "2001","First Person Shooter"));
		catalog.add(new VideoGame("Nintendo", "N64", "Super Mario 64", "1996","Platformer"));
		catalog.add(new VideoGame("Blizzard", "PC", "World of Warcraft", "2004","MMO RPG"));
	}
	
	

	
}