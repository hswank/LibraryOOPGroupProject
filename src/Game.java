
public class Game extends Media {

	String publisher;
	String console;

	public Game(String publisher, String console, String title, String releaseDate, String genre) {
		
		this.publisher = publisher;
		this.console = console;
		setTitle(title);
		setReleaseDate(releaseDate);
		setGenre(genre);
		setStatus("On Shelf");
		setCondition(100);
		setDueDate(0);
	
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}

	@Override
	public void checkIn() {
		
		setStatus("On Shelf");
		setDueDate(0);			

	}

	@Override
	public void checkOut() {

		if (getStatus().equals("On Shelf")) {
			setStatus("Checked Out");
			setCondition(getCondition() - 2);
			setDueDate(14);
			
		System.out.println("You've checked out: " + getDueDate() + ".");
		System.out.println("This videogame is due in " + getDueDate() + " days.");
		} else if(getStatus().equals("Checked Out")) {
			System.out.println("This video game is checked out, would you like to place a hold?");
		} else {
			System.out.println("This video game is currently checked out");
		}
		
	}

	@Override
	public void renew() {
		
		setCondition(getCondition() - 2);
		setDueDate(getDueDate() + 14);
		
	}
	
	public void printDetails() {
		//print details
		System.out.printf("%s on %s by %s%nReleased: %d%nGenre: %s%nStatus: %s%n", getTitle(),
				getConsole(), getPublisher(),getReleaseDate(), getGenre(), getStatus());
	}
	
	@Override
	public String toString() {
		return getTitle() + " for " + getConsole() + ".";
	}
	
}
