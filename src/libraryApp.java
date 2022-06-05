 import java.util.ArrayList;
import java.util.Arrays;

public class libraryApp {

	// global instance of input class
	public static UserInput in = new UserInput();

	public static void main(String[] args) {

		int userMainMenuSelection;
		boolean continueProgram = true;

		// data ArrayList
		ArrayList<Media> catalog = new ArrayList<>();
		// books
		catalog.add(new Book("Fear And Loathing In Las Vegas",new ArrayList<String>(Arrays.asList("Hunter S. Thompson")), "1976", "Fiction", 101));
		catalog.add(new Book("Animal Farm", new ArrayList<String>(Arrays.asList("George Orwell")), "1945","Dystopian Fiction", 102));                                             
		catalog.add(new Book("A Game Of Thrones", new ArrayList<String>(Arrays.asList("George R. R. Martin")), "1996","Fantasy", 103));
		catalog.add(new Book("Grant", new ArrayList<String>(Arrays.asList("Ron Chernow")), "2017", "Biography", 104));
		// movies
		catalog.add(new Movie(new ArrayList<String>(Arrays.asList("Steven Spielberg")), 124, "Jaws", "1975", "Thriller", 201));
		catalog.add(new Movie(new ArrayList<String>(Arrays.asList("George Lucas")), 121, "Star Wars: A New Hope", "1977", "Sci-Fi", 202));
		catalog.add(new Movie(new ArrayList<String>(Arrays.asList("Peter Jackson")), 169, "The Hobbit", "2012", "Fantasy", 203));
		catalog.add(new Movie(new ArrayList<String>(Arrays.asList("Martin Scorsese")), 180, "The Wolf Of Wallstreet", "2013", "Drama", 204));
		// video games
		catalog.add(new Game("Sony", "PlayStation", "Crash Bandicoot", "1996", "Platformer", 301));
		catalog.add(new Game("Microsoft", "Xbox", "Halo", "2001", "First Person Shooter", 302));
		catalog.add(new Game("Nintendo", "N64", "Super Mario 64", "1996", "Platformer", 303));
		catalog.add(new Game("Blizzard", "PC", "World of Warcraft", "2004", "MMO RPG", 304));

		
		while (continueProgram) {
			System.out.println("Welcome to the GC Charity Library!\n");

			printMenu();
			userMainMenuSelection = in.readInteger("Selection: ", "That's not a valid selection!", 1, 7);

			switch (userMainMenuSelection) {

			case 1:
				printCatalogMenu(catalog);
				break;
			case 2:
				searchCatalogMenu(catalog);
				System.out.println();
				break;
			case 3:
				checkOutItemSelector(catalog);
				System.out.println();
				break;
			case 4:
				checkInItemSelector(catalog);
				System.out.println();
				break;
			case 5:
				renewItemSelector(catalog);
				System.out.println();
				break;
			case 6:
				donateMenu(catalog);
				break;
			case 7:
				System.out.println("\nThank you for using our library app!");
				System.exit(0);
			}
		}

	}
	
	public static void printMenu() {
		System.out.println("Please choose from the following options: ");
		System.out.println("1. View Catalog");
		System.out.println("2. Search Catalog");
		System.out.println("3. Check Out Media");
		System.out.println("4. Check In Media");
		System.out.println("5. Renew Media");
		System.out.println("6. Donate Media");
		System.out.println("7. Exit");
	}
	
	public static void printCatalogMenu(ArrayList<Media> catalog) {
		System.out.println("1. View Full Catalog");
		System.out.println("2. View Book Catalog");
		System.out.println("3. View Movie Catalog");
		System.out.println("4. View Game Catalog");
		int input = in.readInteger("Selection: ", "Not a valid choice!", 1, 4);
		switch (input) {
		case 1:
			printCatalog(catalog);
			break;
		case 2:
			printCatalog(formatSeparator(catalog, "book"));
			break;
		case 3:
			printCatalog(formatSeparator(catalog, "movie"));
			break;
		case 4:
			printCatalog(formatSeparator(catalog, "game"));
			break;
		}
		System.out.println();
	}

	public static void searchCatalogMenu(ArrayList<Media> catalog) {

		System.out.println("1. Search Full Catalog");
		System.out.println("2. Search Book Catalog");
		System.out.println("3. Search Movie Catalog");
		System.out.println("4. Search Game Catalog");
		int input = in.readInteger("Selection: ", "That's not a valid selection!", 1, 4);
		switch (input) {
		case 1:
			searchByMenu(catalog);
			break;
		case 2:
			searchByMenu(formatSeparator(catalog, "book"));
			break;
		case 3:
			searchByMenu(formatSeparator(catalog, "movie"));
			break;
		case 4:
			searchByMenu(formatSeparator(catalog, "game"));
			break;
		}
	}
	
	public static void checkOutItemSelector(ArrayList<Media> catalog) {

		int userCheckOutSelection;
		boolean found = false;
		while (found == false) {
			System.out.println("Please enter the item code for the media you wish to check out: ");
			userCheckOutSelection = in.readInteger("Selection: ", "That's not a valid selection!", 0, 399);

			for (Media content : catalog) {
				if (content.getItemCode() == userCheckOutSelection) {
					content.checkOut();
					found = true;
				}
			}
			if (found == false) {
				System.out.println("Thats not a valid selection");
			}
		}
	}
	
	public static void checkInItemSelector(ArrayList<Media> catalog) {

		int userCheckInSelection;
		boolean found = false;
		while (found == false) {
			System.out.println("Please enter the item code for the media you wish to check in: ");
			userCheckInSelection = in.readInteger("Selection: ", "That's not a valid selection!", 0, 399);

			for (Media content : catalog) {
				if (content.getItemCode() == userCheckInSelection) {
					content.checkIn();
					found = true;
				}
			}
			if (found == false) {
				System.out.println("Thats not a valid selection");
			}
		}
	}
	
	public static void renewItemSelector(ArrayList<Media> catalog) {

		int userRenewSelection;
		boolean found = false;
		while (found == false) {
			System.out.println("Please enter the item code for the media you wish to renew: ");
			userRenewSelection = in.readInteger("Selection: ", "That's not a valid selection!", 0, 399);
	
			for (Media content : catalog) {
				if (content.getItemCode() == userRenewSelection) {
					content.renew();
					found = true;
				}
			}
			if (found == false) {
				System.out.println("Thats not a valid selection");
			}
		}
	}
	
	public static void donateMenu(ArrayList<Media> catalog) {

		System.out.println("Please choose what type of media you'd like to donate: ");
		System.out.println("1. Book");
		System.out.println("2. Movie");
		System.out.println("3. Game");
		
		int userSelection = in.readInteger("Selection: ", "That's not a valid selection!", 1, 3);
		switch (userSelection) {
		case 1:
			catalog.add(donateBook(catalog));
			System.out.println();
			break;
		case 2:
			catalog.add(donateMovie(catalog));
			System.out.println();
			break;
		case 3:
			catalog.add(donateGame(catalog));
			System.out.println();
			break;
		}
	}

	public static void searchByMenu(ArrayList<Media> catalog) {
		System.out.println("1. Search by Title");
		System.out.println("2. Search by Creator");
		System.out.println("3. Search by Genre");
		
		int input2 = in.readInteger("Selection: ", "That's not a valid selection!", 1, 3);
		switch (input2) {
		case 1:
			String searchTitle = in.readRandom("Enter title to search: ");
			searchByTitle(searchTitle, catalog);
			break;
		case 2:
			String searchCreator = in.readRandom("Enter creator to search: ");
			searchByCreator(searchCreator, catalog);
			break;
		case 3:
			String searchGenre = in.readRandom("Enter genre to search: ");
			searchByGenre(searchGenre, catalog);
			break;
		}
	}

	 public static void printCatalog(ArrayList<Media> catalog) {
		 System.out.printf("%n%-12s%-35s%-20s%n", "Item Code", "Title", "Format");
		 System.out.println("---------   -------------------------------    ------");
		 for (Media item : catalog) {
			 System.out.printf("%-12d%-35s%-20s%n", item.getItemCode(), item.getTitle(), item.getClass().getSimpleName());
		 } 
		 System.out.println();
	 }
	 
	public static void searchByGenre(String genre, ArrayList<Media> catalog) {
		boolean found = false;
		System.out.println("\nResults:\n");
		while (found == false) {
			for (Media content : catalog) {
				if (content.getGenre().toLowerCase().contains(genre.toLowerCase())) {
					System.out.println(content);
					found = true;
				}
			}
			if (found == false) {
				System.out.println("That genre was not found.");
				found = true;
			}
		}
	}

	public static void searchByTitle(String title, ArrayList<Media> catalog) {
		boolean found = false;
		System.out.println("\nResults:\n");
		while (found == false) {
			for (Media content : catalog) {
				if (content.getTitle().toLowerCase().contains(title.toLowerCase())) {
					System.out.println(content);
					found = true;
				}
			}
			if (found == false) {
				System.out.println("That title was not found.");
				found = true;
			}
		}
	}

	public static void searchByCreator(String creator, ArrayList<Media> catalog) {
		boolean found = false;
		System.out.println("\nResults:\n");
		while (found == false) {
			for (Media item : catalog) {
				if (item instanceof Movie) {
					Movie movie = (Movie) item;
					for (String director : movie.getDirector()) {
						if (director.toLowerCase().contains(creator.toLowerCase())) {
							System.out.println(movie.toString());
							found = true;
						}
					}
				} else if (item instanceof Book) {
					Book book = (Book) item;
					for (String author : book.getAuthor()) {
						if (author.toLowerCase().contains(creator.toLowerCase())) {
							System.out.println(book.toString());
							found = true;
						}
					}
				} else if (item instanceof Game) {
					Game vGame = (Game) item;
					if (vGame.getPublisher().toLowerCase().contains(creator.toLowerCase())) {
						System.out.println(vGame.toString());
						found = true;
					}
				}
			}
			if (found == false) {
				System.out.println("That title was not found.");
				found = true;
			}
		}
	}

	public static ArrayList<Media> recycle(ArrayList<Media> catalog) {

		for (int i = 0; i < catalog.size(); i++) {
			if (catalog.get(i).getCondition() == 0) {
				catalog.remove(i);
			}
		}
		return catalog;
	}

	public static Book donateBook(ArrayList<Media> catalog) {

		String bookTitle = in.readRandom("Please enter the title: ");
		String author = in.readRandom("Please enter the author: ");
		String releaseDate = in.readRandom("Please enter the release date (year: 19xx/2xxx): ");
		String genre = in.readRandom("Please enter the genre of the book: ");
		System.out.println("Thank you! " + bookTitle + " has been added to the library catalog!");

		ArrayList<String> authors = new ArrayList<>(Arrays.asList(author));

		Book b = new Book(bookTitle, authors, releaseDate, genre);
		int item = addItemCode(b, catalog);
		b.setItemCode(item);
		b.printDetails();
		return b;
	}

	public static Game donateGame(ArrayList<Media> catalog) {

		String gameTitle = in.readRandom("Please enter the title: ");
		String publisher = in.readRandom("Please enter the publisher: ");
		String releaseDate = in.readRandom("Please enter the release date (year: 19xx/2xxx): ");
		String genre = in.readRandom("Please enter the genre of the game: ");
		String console = in.readRandom("Please enter the console: ");
		System.out.println("Thank you! " + gameTitle + " has been added to the library catalog!");

		Game g = new Game(publisher, console, gameTitle, releaseDate, genre);
		int item = addItemCode(g, catalog);
		g.setItemCode(item);
		g.printDetails();
		return g;
	}

	public static Movie donateMovie(ArrayList<Media> catalog) {

		String movieTitle = in.readRandom("Please enter the title: ");
		String director = in.readRandom("Please enter the director: ");
		String releaseDate = in.readRandom("Please enter the release date (year: 19xx/2xxx): ");
		String genre = in.readRandom("Please enter the genre of the movie: ");
		int runTime = in.readInteger("Please enter the run time of the movie: ", "Thats not a valid input!");
		System.out.println("Thank you! " + movieTitle + " has been added to the library catalog!");

		ArrayList<String> directors = new ArrayList<>(Arrays.asList(director));

		Movie m = new Movie(directors, runTime, movieTitle, releaseDate, genre);
		int item = addItemCode(m, catalog);
		m.setItemCode(item);
		m.printDetails();
		return m;
	}

	public static int addItemCode(Media newMedia, ArrayList<Media> catalog) {
		int itemCodeHolder = 0;
		if (newMedia.getClass().getSimpleName().equals("Book")) {
			itemCodeHolder = findNewItemCode(catalog, "book");
		} else if (newMedia.getClass().getSimpleName().equals("Movie")) {
			itemCodeHolder = findNewItemCode(catalog, "movie");
		} else if (newMedia.getClass().getSimpleName().equals("Game")) {
			itemCodeHolder = findNewItemCode(catalog, "game");
		}
		return itemCodeHolder;
	}
	
	public static int findNewItemCode(ArrayList<Media> catalog, String format) {
		int itemCodeHolder = 0;
		for (int i = 0; i < catalog.size(); i++) {
			if (catalog.get(i).getClass().getSimpleName().equalsIgnoreCase(format)) {
				itemCodeHolder = catalog.get(i).getItemCode();
			}
		}
		itemCodeHolder++;
		return itemCodeHolder;
	}

	public static ArrayList<Media> formatSeparator(ArrayList<Media> catalog, String format) {
		if (format.equalsIgnoreCase("book")) {
		ArrayList<Media> books = new ArrayList<Media>();
		for (int i = 0; i < catalog.size(); i++) {
			if (catalog.get(i).getItemCode() > 100 && catalog.get(i).getItemCode() < 200) {
				books.add(catalog.get(i));
			}
		}
		return books;
		} else if (format.equalsIgnoreCase("movie")) {
		ArrayList<Media> movies = new ArrayList<Media>();
		for (int i = 0; i < catalog.size(); i++) {
			if (catalog.get(i).getItemCode() > 200 && catalog.get(i).getItemCode() < 300) {
				movies.add(catalog.get(i));
			}
		}
		return movies;
		} else {
		
		ArrayList<Media> games = new ArrayList<Media>();
		for (int i = 0; i < catalog.size(); i++) {
			if (catalog.get(i).getItemCode() > 300 && catalog.get(i).getItemCode() < 400) {
				games.add(catalog.get(i));
			}
		}
		return games;
		}
	}
}