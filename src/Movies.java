
public class Movies extends Media{
	
	//fields
	private String director;
	private int runTime;
	
	//getters/setters
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getRunTime() {
		return runTime;
	}
	public void setRunTime(int runTime) {
		this.runTime = runTime;
	}
	
	//constructors
	public void Movie (String director, int runTime, String title, String releaseDate, String genre, String status, int dueDate) {
		this.director = director;
		this.runTime = runTime;
		setTitle(title);
		setReleaseDate(releaseDate);
		setGenre(genre);
		setStatus(status);
		setCondition(100);
		setDueDate(dueDate);
	}
	
	//methods
	@Override
	public void checkOut() {
		//get variable condition from super class so i can decrement it later
		int condition = getCondition();
		//false means on shelf
		if (getStatus().equals("On Shelf")) {
			setStatus("Checked Out");
			//Decrement condition
			setCondition(condition --);
			//set due date
			setDueDate(14);
			//message
			System.out.println("You've checked out: " + getTitle()
					+ "\nIt is due in " + getDueDate() + " days");
		} else if (getStatus().equals("Checked Out")) {
			//message
			System.out.println("This item is checked out, would you like to place a hold?");
		}
		else {
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
		int condition = getCondition();
		int dueDate = getDueDate();
		//add 14 to dueDate and increment condition
		setCondition(condition ++);
		setDueDate(dueDate + 14);
	}
}
