
public abstract  class Media implements Comparable<Media>  {
 private String title;
 private int numOfCopies;

 public Media() {
	 
 }
 
	public Media(String title, int numOfCopies) {
	super();
	this.title = title;
	this.numOfCopies = numOfCopies;
}
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumOfCopies() {
		return numOfCopies;
	}

	public void setNumOfCopies(int numOfCopies) {
		this.numOfCopies = numOfCopies;
	}

	@Override
	public int compareTo(Media o) {
			 int cmp = this.getTitle().compareTo(o.getTitle());
				return cmp;
			}
		
	}



