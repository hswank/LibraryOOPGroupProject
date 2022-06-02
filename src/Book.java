import java.util.ArrayList;

public class Book extends Media {
	private ArrayList<String> author;

	public Book(String title, ArrayList<String> author, String releaseDate, String genre, int itemCode) {
		setTitle(title);
		setAuthor(author);
		setReleaseDate(releaseDate);
		setGenre(genre);
		setCondition(100);
		setStatus("On Shelf");
		setItemCode(itemCode);
	}
	
	public Book(String title, ArrayList<String> author, String releaseDate, String genre) {
		setTitle(title);
		setAuthor(author);
		setReleaseDate(releaseDate);
		setGenre(genre);
		setCondition(100);
		setStatus("On Shelf");
	}

	public ArrayList<String> getAuthor() {
		return author;
	}

	public void setAuthor(ArrayList<String> author) {
		this.author = author;
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
		String authorList = "";
		for (String author : getAuthor()) {authorList += author; authorList += " ";}
		System.out.printf("%s by %s%nReleased: %s%nGenre: %s%nStatus: %s%nItem Code: %d", getTitle(),
				authorList, getReleaseDate(), getGenre(), getStatus(), getItemCode());
	}

	@Override
	public String toString() {
		String authorList = "";
		for (String author : getAuthor()) {authorList += author; authorList += " ";}
		return getItemCode() + ": " + getTitle() + " by " + authorList;
	}

}