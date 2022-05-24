import java.util.ArrayList;

public abstract class Media {
	
	//fields
	private String title;
	private String releaseDate;
	private String genre;
	private boolean status;
	private int condition;
	private int dueDate;
	
	//getters/setters
	public String getTitle() {
		return title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getCondition() {
		return condition;
	}
	public void setCondition(int condition) {
		this.condition = condition;
	}
	public int getDueDate() {
		return dueDate;
	}
	public void setDueDate(int dueDate) {
		this.dueDate = dueDate;
	}
	
	//methods
	public abstract void checkIn ();
	
	public abstract void checkOut();
	
	public abstract void renew();
		
}