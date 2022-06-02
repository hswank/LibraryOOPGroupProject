import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class libraryApp {
	
	static Scanner scnr = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int userMainMenuSelection;
		boolean continueProgram = true;
		
		//data ArrayList
		ArrayList<Media> catalog = new ArrayList<>();
		//movies
		catalog.add(new Movie(new ArrayList<String>(Arrays.asList("Steven Spielberg")), 124, "Jaws", "1975", "Thriller", 201));
		catalog.add(new Movie(new ArrayList<String>(Arrays.asList("George Lucas")), 121, "Star Wars: A New Hope", "1977", "Sci-Fi", 202));
		catalog.add(new Movie(new ArrayList<String>(Arrays.asList("Peter Jackson")), 169, "The Hobbit", "2012", "Fantasy", 203));
		catalog.add(new Movie(new ArrayList<String>(Arrays.asList("Martin Scorsese")), 180, "The Wolf Of Wallstreet", "2013", "Drama", 204));
		//books
		catalog.add(new Book("Fear And Loathing In Las Vegas", new ArrayList<String>(Arrays.asList("Hunter S. Thompson")), "1976", "Fiction", 101));
		catalog.add(new Book("Animal Farm", new ArrayList<String>(Arrays.asList("George Orwell")), "1945", "Dystopian Fiction", 102));
		catalog.add(new Book("A Game Of Thrones", new ArrayList<String>(Arrays.asList("George R. R. Martin")), "1996", "Fantasy", 103));
		catalog.add(new Book("Grant", new ArrayList<String>(Arrays.asList("Ron Chernow")), "2017", "Biography", 104));
		//video games
		catalog.add(new Game("Sony", "PlayStation", "Crash Bandicoot", "1996","Platformer", 301));
		catalog.add(new Game("Microsoft", "Xbox", "Halo", "2001","First Person Shooter", 302));
		catalog.add(new Game("Nintendo", "N64", "Super Mario 64", "1996","Platformer", 303));
		catalog.add(new Game("Blizzard", "PC", "World of Warcraft", "2004","MMO RPG", 304));
		
		while(continueProgram) {
		System.out.println("Welcome to the Grand Circus Library!");
		
		printMenu();
		userMainMenuSelection = scnr.nextInt();
		
		switch(userMainMenuSelection) {
		
		case 1: printCatalogMenu();
				break;
		case 2: searchCatalogMenu();
				break;
		case 3: checkOutItemSelector(catalog);
				break;
		case 4: checkInItemSelector(catalog);
				break;
		case 5: renewItemSelector(catalog);
				break;
		case 6: donateMenu();
				System.out.print("Selection: ");
				int userSelection = scnr.nextInt();
				switch(userSelection) {
				case 1: catalog.add(donateBook());
						break;
				case 2: catalog.add(donateMovie());
						break;
				case 3: catalog.add(donateGame());
						break;
				}
		case 7: scnr.close();
				System.exit(0);
		}
	}
		
}
	
	public static void donateMenu() {
		
		System.out.println("Please choose what type of media you'd like to donate: ");
		System.out.println("1. Book");
		System.out.println("2. Movie");
		System.out.println("3. Game");	
	}
	
	public static void renewItemSelector(ArrayList<Media> catalog) {
		
		int userRenewSelection;
		
		System.out.println("Please enter the item code for the media you wish to renew: ");
		userRenewSelection = scnr.nextInt();
		
		for(Media content : catalog) {
			if (content.getItemCode() == userRenewSelection) {
				content.renew();
			}
		}
		
	}
	
	public static void checkOutItemSelector(ArrayList<Media> catalog) {
		
		int userCheckOutSelection;
		
		System.out.print("Please enter the item code for the media you wish to check out: ");
		userCheckOutSelection = scnr.nextInt();
		
		for(Media content : catalog) {
			if (content.getItemCode() == userCheckOutSelection) {
				content.checkOut();
			}
		}
		
	}
	
	public static void checkInItemSelector(ArrayList<Media> catalog) {
		
		int userCheckInSelection;
		
		System.out.println("Please enter the item code for the media you wish to check in: ");
		userCheckInSelection = scnr.nextInt();
		
		for(Media content : catalog) {
			if (content.getItemCode() == userCheckInSelection) {
				content.checkIn();
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
		System.out.print("Selection: ");
	}
	
	public static void searchByMenu() {
		System.out.println("1. Search by Title");
		System.out.println("2. Search by Creator");
		System.out.println("3. Search by Genre");
	}
	
	public static void searchCatalogMenu() {
		System.out.println("1. Search Full Catalog");
		System.out.println("2. Search Book Catalog");
		System.out.println("3. Search Movie Catalog");
		System.out.println("4. Search Game Catalog");
	}
	
	public static void printCatalogMenu() {
		System.out.println("1. View Full Catalog");
		System.out.println("2. View Book Catalog");
		System.out.println("3. View Movie Catalog");
		System.out.println("4. View Game Catalog");
	}
	
	public static void printCatalog(ArrayList<Media> catalog) {
		System.out.printf("%-35s%-20s%n", "Title", "Format");
		System.out.println("--------------------------------------------");
		for (Media item : catalog) {
			System.out.printf("%-35s%-20s%n", item.getTitle(), item.getClass().getSimpleName());
		}
	}
	
	public static void searchByGenre (String genre, ArrayList<Media> catalog){
		for(Media content : catalog){
	        if(content.getGenre().equals(genre)){
	        	System.out.println(content);
	        }
	           
	    }
	}
	
	public static void searchByTitle (ArrayList<Media> catalog, String title){
		for(Media content : catalog) {
			if (content.getTitle().equals(title)) {
				System.out.println(content);
			}
		}
	}
	
	public static void searchByCreator(String creator, ArrayList<Media> catalog) {
		System.out.println("\n\nSearch results for \"" + creator + "\":\n");
		for (Media item : catalog) {
			if (item instanceof Movie) {
				Movie movie = (Movie) item;
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
			} else if (item instanceof Game) {
				Game vGame = (Game) item;
				if (vGame.getPublisher().toLowerCase().contains(creator.toLowerCase())) {
					System.out.println(vGame.toString());
				}
			}
		}
	}
	
	public static ArrayList<Media> recycle(ArrayList<Media> catalog) {
		
		for(int i = 0; i < catalog.size(); i++) {
			if(catalog.get(i).getCondition() == 0) {
				catalog.remove(i);
			}
		}
		return catalog;
	}
	
	public static Book donateBook() {
		
		System.out.print("Please enter the title: ");
		String bookTitle = scnr.nextLine();
		scnr.nextLine();
		System.out.print("Please enter the author: ");
		String author = scnr.nextLine();
		scnr.nextLine();
		System.out.print("Please enter the release date (year: 19xx/2xxx): ");
		String releaseDate = scnr.nextLine();
		scnr.nextLine();
		System.out.print("Please enter the genre of the book: ");
		String genre = scnr.nextLine();
		System.out.println("Thank you! " + bookTitle + " has been added to the library catalog!");
		
		ArrayList<String> authors = new ArrayList<>(Arrays.asList(author));
		
		Book b = new Book(bookTitle, authors, releaseDate, genre);
		b.printDetails();
		return b;
	}
	
	public static Game donateGame() {
		
		System.out.print("Please enter the title: ");
		String gameTitle = scnr.nextLine();
		scnr.next();
		System.out.print("Please enter the publisher: ");
		String publisher = scnr.nextLine();
		scnr.next();
		System.out.print("Please enter the release date (year: 19xx/2xxx): ");
		String releaseDate = scnr.nextLine();
		scnr.nextLine();
		System.out.print("Please enter the genre of the game: ");
		String genre = scnr.nextLine();
		System.out.print("Please enter the console: ");
		String console = scnr.nextLine();
		scnr.nextLine();
		
		Game g = new Game(publisher, console, gameTitle, releaseDate, genre);
		return g;
	}
	
	public static Movie donateMovie() {
		
		System.out.print("Please enter the title: ");
		String movieTitle = scnr.nextLine();
		scnr.next();
		System.out.print("Please enter the director: ");
		String director = scnr.nextLine();
		scnr.next();
		System.out.print("Please enter the release date (year: 19xx/2xxx): ");
		String releaseDate = scnr.nextLine();
		scnr.nextLine();
		System.out.print("Please enter the genre of the movie: ");
		String genre = scnr.nextLine();
		System.out.print("Please enter the run time of the movie: ");
		int runTime = scnr.nextInt();
		scnr.nextLine();
		
		ArrayList<String> directors = new ArrayList<>(Arrays.asList(director));
		
		Movie m = new Movie(directors, runTime, movieTitle, releaseDate, genre);
		return m;
	}
}