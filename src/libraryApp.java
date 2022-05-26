import java.util.ArrayList;
import java.util.Arrays;

public class libraryApp {

	public static void main(String[] args) {
		//data
		ArrayList<Media> catalog = new ArrayList<>();
		//movies
		catalog.add(new Movies(new ArrayList<String>(Arrays.asList("Steven Spielberg")), 124, "Jaws", "1975", "Thriller"));
		catalog.add(new Movies(new ArrayList<String>(Arrays.asList("George Lucas")), 121, "Star Wars: A New Hope", "1977", "Sci-Fi"));
		catalog.add(new Movies(new ArrayList<String>(Arrays.asList("Peter Jackson")), 169, "The Hobbit", "2012", "Fantasy"));
		catalog.add(new Movies(new ArrayList<String>(Arrays.asList("Martin Scorsese")), 180, "The Wolf Of Wallstreet", "2013", "Drama"));
		//books
		catalog.add(new Book("Fear And Loathing In Las Vegas", new ArrayList<String>(Arrays.asList("Hunter S. Thompson")), "1976", "Fiction"));
		catalog.add(new Book("Animal Farm", new ArrayList<String>(Arrays.asList("George Orwell")), "1945", "Dystopian Fiction"));
		catalog.add(new Book("A Game Of Thrones", new ArrayList<String>(Arrays.asList("George R. R. Martin")), "1996", "Fantasy"));
		catalog.add(new Book("Grant", new ArrayList<String>(Arrays.asList("Ron Chernow")), "2017", "Biography"));
		//video games
		catalog.add(new VideoGame("Sony", "PlayStation", "Crash Bandicoot", "1996","Platformer"));
		catalog.add(new VideoGame("Microsoft", "Xbox", "Halo", "2001","First Person Shooter"));
		catalog.add(new VideoGame("Nintendo", "N64", "Super Mario 64", "1996","Platformer"));
		catalog.add(new VideoGame("Blizzard", "PC", "World of Warcraft", "2004","MMO RPG"));
	}
	
	public static void searchByTitle (ArrayList<Media> catalog, String title){
			for(Media content : catalog) {
				if (content.getTitle().equals(title)) {
					System.out.println(content);
				}
			}
	}
	
	

	
}