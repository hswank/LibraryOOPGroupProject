import java.util.ArrayList;
import java.util.Arrays;

public class libraryApp {
	
	public static void main(String[] args) {
		//data ArrayList
		ArrayList<Media> catalog = new ArrayList<>();
		//movies
		catalog.add(new Movie(new ArrayList<String>(Arrays.asList("Steven Spielberg")), 124, "Jaws", "1975", "Thriller"));
		catalog.add(new Movie(new ArrayList<String>(Arrays.asList("George Lucas")), 121, "Star Wars: A New Hope", "1977", "Sci-Fi"));
		catalog.add(new Movie(new ArrayList<String>(Arrays.asList("Peter Jackson")), 169, "The Hobbit", "2012", "Fantasy"));
		catalog.add(new Movie(new ArrayList<String>(Arrays.asList("Martin Scorsese")), 180, "The Wolf Of Wallstreet", "2013", "Drama"));
		//books
		catalog.add(new Book("Fear And Loathing In Las Vegas", new ArrayList<String>(Arrays.asList("Hunter S. Thompson")), "1976", "Fiction"));
		catalog.add(new Book("Animal Farm", new ArrayList<String>(Arrays.asList("George Orwell")), "1945", "Dystopian Fiction"));
		catalog.add(new Book("A Game Of Thrones", new ArrayList<String>(Arrays.asList("George R. R. Martin")), "1996", "Fantasy"));
		catalog.add(new Book("Grant", new ArrayList<String>(Arrays.asList("Ron Chernow")), "2017", "Biography"));
		//video games
		catalog.add(new Game("Sony", "PlayStation", "Crash Bandicoot", "1996","Platformer"));
		catalog.add(new Game("Microsoft", "Xbox", "Halo", "2001","First Person Shooter"));
		catalog.add(new Game("Nintendo", "N64", "Super Mario 64", "1996","Platformer"));
		catalog.add(new Game("Blizzard", "PC", "World of Warcraft", "2004","MMO RPG"));
		
	}
	public static void searchByGenre (String genre, ArrayList<Media> catalog){
		for(Media content : catalog){
	        if(content.getGenre().equals(genre)){
	        	System.out.println(content);
	        }
	           
	    }
	}
	
	public static Book donateBook(String title, ArrayList<String> author, String releaseDate, String genre) {
		Book b = new Book(title, author, releaseDate, genre);
		return b;
	}
	
	public static Game donateGame(String pub, String console, String title, String releaseDate, String genre) {
		Game g = new Game(pub, console, title, releaseDate, genre);
		return g;
	}
	
	public static Movie donateMovie(ArrayList<String> director, int runTime, String title, String releaseDate, String genre) {
		Movie m = new Movie(director, runTime, title, releaseDate, genre);
		return m;
	}

	public static void printCatalog(ArrayList<Media> catalog) {
		System.out.printf("%-35s%-20s%n", "Title", "Format");
		System.out.println("--------------------------------------------");
		for (Media item : catalog) {
			System.out.printf("%-35s%-20s%n", item.getTitle(), item.getClass().getSimpleName());
		}
	}
}
