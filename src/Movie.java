import java.util.ArrayList;

public class Movie extends Media{
	
	//fields
	private ArrayList<String> director;
	private int runTime;
	
	//getters/setters
	public ArrayList<String> getDirector() {
		return director;
	}
	public void setDirector(ArrayList<String> director) {
		this.director = director;
	}
	public int getRunTime() {
		return runTime;
	}
	public void setRunTime(int runTime) {
		this.runTime = runTime;
	}
	
	//constructors
	public Movie (ArrayList<String> director, int runTime, String title, String releaseDate, String genre, int itemCode) {
		this.director = director;
		this.runTime = runTime;
		setTitle(title);
		setReleaseDate(releaseDate);
		setGenre(genre);
		setStatus("On Shelf");
		setCondition(100);
		setDueDate(0);
		setItemCode(itemCode);
	}

	public Movie (ArrayList<String> director, int runTime, String title, String releaseDate, String genre) {
		this.director = director;
		this.runTime = runTime;
		setTitle(title);
		setReleaseDate(releaseDate);
		setGenre(genre);
		setStatus("On Shelf");
		setCondition(100);
		setDueDate(0);
		
	}
	//methods
	@Override
	public void checkOut() {
		//get variable condition from super class so i can decrement it later
		int cond = getCondition();
		//false means on shelf
		if (getStatus().equals("On Shelf")) {
			setStatus("Checked Out");
			//Decrement condition
			setCondition(cond - 1);
			//set due date
			setDueDate(14);
			//message
			System.out.println("You've checked out: " + getTitle()
					+ "\nIt is due in " + getDueDate() + " days");
		}else {
			//message
			System.out.println("That movie is currently checked out");
		}
	}
	@Override
	public void checkIn() {
		//set status back to on shelf and due date null
		setStatus("On Shelf");
		setDueDate(0);
	}
	@Override
	public void renew() {
		//get variables
		int cond = getCondition();
		//add 14 to dueDate and increment condition
		setCondition(cond - 1);
		setDueDate(getDueDate() + 14);
	}
	public void printDetails() {
		//print details
		String directorList = "";
		if (getDirector().size() == 1) {
			directorList += getDirector().get(0);
		} else {
			int i = 0;
			while (i < getDirector().size() - 1) {
				directorList += getDirector().get(i);
				directorList += ", ";
				i++;
			}
			directorList += getDirector().get(i);
		}
		System.out.printf("%s directed by %s%nReleased: %s%nGenre: %s%nStatus: %s%nItem Code: %d", getTitle(),
				directorList, getReleaseDate(), getGenre(), getStatus(), getItemCode());
	}

	@Override
	public String toString() {
		String directorList = "";
		if (getDirector().size() == 1) {
			directorList += getDirector().get(0);
		} else {
			int i = 0;
			while (i < getDirector().size() - 1) {
				directorList += getDirector().get(i);
				directorList += ", ";
				i++;
			}
			directorList += getDirector().get(i);
		}
		return getItemCode() + ": " + getTitle() + " by " + directorList;	
	}

	
	public void addDirector(String dir) {
		director.add(dir);
	}
}