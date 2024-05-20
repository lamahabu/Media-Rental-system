
public class Movie extends Media /* implementsComparable<Movie > */ {
	private String Rating;

	public Movie() {

	}

	public Movie(String title, int numOfCopies, String rating) {
		super(title,numOfCopies);
	
		this.Rating = rating;

	}

	

	public String getRating() {
		return Rating;
	}

	public void setRating(String rating) {
		Rating = rating;
	}
	public int compareTo(Media o) {
		 int cmp = this.getTitle().compareTo(o.getTitle());
			return cmp;
		}
}
