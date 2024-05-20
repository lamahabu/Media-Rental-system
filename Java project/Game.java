
public class Game extends Media {
	private double weight;

	public Game() {
		
	}
	public Game(String title, int numOfCopies, double weight) {
		super(title,numOfCopies);
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public int compareTo(Media o) {
		 int cmp = this.getTitle().compareTo(o.getTitle());
			return cmp;
		}
}
