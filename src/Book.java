import java.util.ArrayList;

public class Book extends Media {
	private ArrayList<String> author;

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
		setStatus("On Shelf");
		setDueDate(0);
	}

	@Override
	public void checkOut() {
		if (getStatus().equals("On Shelf")) {
			int condition = getCondition();
			condition -= 5;
			setCondition(condition);
			setDueDate(14);
			setStatus("Checked Out");
		} else {
			System.out.println("This item has been checked out already.");
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
		System.out.printf("%s by %s%nReleased: %s%nGenre: %s%nStatus: %s%n", getTitle(),
				authorList, getReleaseDate(), getGenre(), getStatus());
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
		return getTitle() + " by " + authorList;
	}

}