
public class Album extends Media /* implementsComparable<Album> */ {
	
	private String songs;
	private String artist;

	public Album() {

	}

	public Album(String title, int numOfCopies, String artist,String songs) {
		super(title, numOfCopies);
		this.artist=artist;
		this.songs = songs;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	
	public String getSongs() {
		return songs;
	}

	public void setSongs(String songs) {
		this.songs = songs;
	}

	public int compareTo(Media o) {
		 int cmp = this.getTitle().compareTo(o.getTitle());
			return cmp;
		}
	public String SongsCuter(int a) {
		String[] token=this.songs.split(",");
		return token[a];
	}
	

}
