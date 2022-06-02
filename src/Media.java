public abstract class Media {
	
	//fields
	private String title;
	private String releaseDate;
	private String genre;
	private String status;
	private int condition;
	private int dueDate;
	private int itemCode;
	
	//getters/setters
	public int getItemCode() {
		return itemCode;
	}
	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
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
