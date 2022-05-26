import java.util.ArrayList;
import java.util.Arrays;

public class libraryApp {

	public static void main(String[] args) {
		// data
		ArrayList<Media> catalog = new ArrayList<>();
		// movies
		catalog.add(
				new Movies(new ArrayList<String>(Arrays.asList("Steven Spielberg")), 124, "Jaws", "1975", "Thriller"));
		catalog.add(new Movies(new ArrayList<String>(Arrays.asList("George Lucas")), 121, "Star Wars: A New Hope",
				"1977", "Sci-Fi"));
		catalog.add(new Movies(new ArrayList<String>(Arrays.asList("Peter Jackson")), 169, "The Hobbit", "2012",
				"Fantasy"));
		catalog.add(new Movies(new ArrayList<String>(Arrays.asList("Martin Scorsese")), 180, "The Wolf Of Wallstreet",
				"2013", "Drama"));
		// books
		catalog.add(new Book("Fear And Loathing In Las Vegas",
				new ArrayList<String>(Arrays.asList("Hunter S. Thompson")), "1976", "Fiction"));
		catalog.add(new Book("Animal Farm", new ArrayList<String>(Arrays.asList("George Orwell")), "1945",
				"Dystopian Fiction"));
		catalog.add(new Book("A Game Of Thrones", new ArrayList<String>(Arrays.asList("George R. R. Martin")), "1996",
				"Fantasy"));
		catalog.add(new Book("Grant", new ArrayList<String>(Arrays.asList("Ron Chernow")), "2017", "Biography"));
		// video games
		catalog.add(new VideoGame("Sony", "PlayStation", "Crash Bandicoot", "1996", "Platformer"));
		catalog.add(new VideoGame("Microsoft", "Xbox", "Halo", "2001", "First Person Shooter"));
		catalog.add(new VideoGame("Nintendo", "N64", "Super Mario 64", "1996", "Platformer"));
		catalog.add(new VideoGame("Blizzard", "PC", "World of Warcraft", "2004", "MMO RPG"));

		printCatalog(catalog);
		
		searchByCreator("peter", catalog);

//		for(Media content : catalog) {
//			if (content.getGenre().equals("Drama")) {
//				System.out.println(content);
//			}
//		}
	}

	public static void printCatalog(ArrayList<Media> catalog) {
		System.out.printf("%-35s%-20s%n", "Title", "Format");
		System.out.println("--------------------------------------------");
		for (Media item : catalog) {
			System.out.printf("%-35s%-20s%n", item.getTitle(), item.getClass().getSimpleName());
		}
	}

	public static void searchByCreator(String creator, ArrayList<Media> catalog) {
		System.out.println("\n\nSearch results for \"" + creator + "\":\n");
		for (Media item : catalog) {
			if (item instanceof Movies) {
				Movies movie = (Movies) item;
				for (String director : movie.getDirector()) {
					if (director.toLowerCase().contains(creator.toLowerCase())) {
						System.out.println(movie.toString());
					}
				}
			} else if (item instanceof Book) {
				Book book = (Book) item;
				for (String author : book.getAuthor()) {
					if (author.toLowerCase().contains(creator.toLowerCase())) {
						System.out.println(book.toString());
					}
				}
			} else if (item instanceof VideoGame) {
				VideoGame vGame = (VideoGame) item;
				if (vGame.getPublisher().toLowerCase().contains(creator.toLowerCase())) {
					System.out.println(vGame.toString());
				}
			}
		}
	}

}