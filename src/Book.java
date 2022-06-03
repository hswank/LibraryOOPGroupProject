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

	public void addAuthor(String authorName) {
		author.add(authorName);
	}

	@Override
	public void checkIn() {
		if (getStatus().equals("Checked Out")) {
			setStatus("On Shelf");
			setDueDate(0);
			System.out.println("You've checked in: " + getTitle() + ".");
		} else {
			System.out.println("This book is already checked in.");
		}
	}

	@Override
	public void checkOut() {
		if (getStatus().equals("On Shelf")) {
			int condition = getCondition();
			condition -= 5;
			setCondition(condition);
			setDueDate(14);
			setStatus("Checked Out");
			System.out.println("You've checked out: " + getTitle() + ".");
			System.out.println("This book is due in " + getDueDate() + " days.");
		} else {
			System.out.println("This item has been checked out already.");
		}

	}

	@Override
	public void renew() {
		if (getStatus().equals("Checked Out")) {
			setCondition(getCondition() - 5);
			int dueDate = getDueDate();
			dueDate = dueDate + 14;
			setDueDate(dueDate);
			System.out.println("You've renewed " + getTitle() + ".");
			System.out.println("This book is due in " + getDueDate() + " days.");
		} else {
			System.out.println("This item hasn't been checked out yet.");
		}
	}

	public void printDetails() {
		String authorList = "";
		if (getAuthor().size() == 1) {
			authorList += getAuthor().get(0);
		} else {
			int i = 0;
			while (i < getAuthor().size() - 1) {
				authorList += getAuthor().get(i);
				authorList += ", ";
				i++;
			}
			authorList += getAuthor().get(i);
		}
		System.out.printf("%s by %s%nReleased: %s%nGenre: %s%nStatus: %s%nItem Code: %d%n", getTitle(), authorList,
				getReleaseDate(), getGenre(), getStatus(), getItemCode());
	}

	@Override
	public String toString() {
		String authorList = "";
		if (getAuthor().size() == 1) {
			authorList += getAuthor().get(0);
		} else {
			int i = 0;
			while (i < getAuthor().size() - 1) {
				authorList += getAuthor().get(i);
				authorList += ", ";
				i++;
			}
			authorList += getAuthor().get(i);
		}
		return getItemCode() + ": " + getTitle() + " by " + authorList;
	}

}