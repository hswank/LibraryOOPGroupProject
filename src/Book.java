import java.util.ArrayList;

public class Book extends Media {
	private ArrayList<String> author;

	public Book(String title, String author, String releaseDate, String genre) {
		setTitle(title);
		this.author.add(author);
		setReleaseDate(releaseDate);
		setGenre(genre);
		setCondition(100);
		setStatus("On Shelf");
	}

	public ArrayList<String> getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author.add(author);
	}

	@Override
	public void checkIn() {
		setStatus("On shelf");
		setDueDate(0);
	}

	@Override
	public void checkOut() {
		if (getStatus().equals("On shelf")) {
			int condition = getCondition();
			condition -= 5;
			setCondition(condition);
			setDueDate(14);
			setStatus("Checked out");
		} else if (getStatus().equals("Checked out")) {
			System.out.println("This item has been checked out already.  Would you like to place a hold?");
		}


	}

	@Override
	public void renew() {
		setCondition(getCondition() - 5);
		int dueDate = getDueDate();
		dueDate = dueDate + 14;
		setDueDate(dueDate);
	}

	public void printDetails() {
		System.out.printf("%s by %s%nReleased: %d%nGenre: %s%nStatus: %s%nThis book is due in %d days", getTitle(),
				getAuthor(), getReleaseDate(), getGenre(), getStatus(), getDueDate());
	}

	@Override
	public String toString() {
		return getTitle() + " by " + getAuthor();
	}

}
