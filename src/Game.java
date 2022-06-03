public class Game extends Media {

	String publisher;
	String console;

	public Game(String publisher, String console, String title, String releaseDate, String genre, int itemCode) {

		this.publisher = publisher;
		this.console = console;
		setTitle(title);
		setReleaseDate(releaseDate);
		setGenre(genre);
		setStatus("On Shelf");
		setCondition(100);
		setDueDate(0);
		setItemCode(itemCode);

	}

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
		if (getStatus().equals("Checked Out")) {
			setStatus("On Shelf");
			setDueDate(0);
			System.out.println("You've checked in: " + getTitle() + ".");
		} else {
			System.out.println("This video game is already checked in.");
		}
	}

	@Override
	public void checkOut() {

		if (getStatus().equals("On Shelf")) {
			setStatus("Checked Out");
			setCondition(getCondition() - 2);
			setDueDate(14);

			System.out.println("You've checked out: " + getTitle() + ".");
			System.out.println("This videogame is due in " + getDueDate() + " days.");
		} else {
			System.out.println("This video game is already checked out.");
		}

	}

	@Override
	public void renew() {
		if (getStatus().equals("Checked Out")) {
			setCondition(getCondition() - 2);
			int dueDate = getDueDate();
			dueDate = dueDate + 14;
			setDueDate(dueDate);
			System.out.println("You've renewed " + getTitle() + ".");
			System.out.println("This video game is due in " + getDueDate() + " days.");
		} else {
			System.out.println("This item hasn't been checked out yet.");
		}
	}

	public void printDetails() {
		// print details
		System.out.printf("%s on %s by %s%nReleased: %s%nGenre: %s%nStatus: %s%nItem Code: %d%n", getTitle(),
				getConsole(), getPublisher(), getReleaseDate(), getGenre(), getStatus(), getItemCode());

	}

	@Override
	public String toString() {
		return getItemCode() + ": " + getTitle() + " for " + getConsole() + ".";
	}

}