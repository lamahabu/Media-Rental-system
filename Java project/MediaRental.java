import java.util.*;

public class MediaRental implements MediaRentalInt {
	ArrayList<Customer> customerList = new ArrayList<>();
	ArrayList<Media> mediaList = new ArrayList<>();
	int plan = 2;

	public MediaRental() {

	}

	public MediaRental(ArrayList<Customer> customerList, ArrayList<Media> mediaList) {
		super();
		this.customerList = customerList;
		this.mediaList = mediaList;

	}

	public ArrayList<Customer> getCustomerList() {

		return customerList;
	}

	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}

	public ArrayList<Media> getMediaList() {
		return mediaList;
	}

	public void setMediaList(ArrayList<Media> mediaList) {
		this.mediaList = mediaList;
	}

	public void addCustomer(String name, String address, String plan) {
		Customer customer = new Customer(name, address, plan);
		customerList.add(customer);
	}

	public void addMovie(String title, int copiesAvailable, String rating) {
		Movie m = new Movie(title, copiesAvailable, rating);
		mediaList.add(m);
	}

	public void addGame(String title, int copiesAvailable, double weight) {
		Game g = new Game(title, copiesAvailable, weight);
		mediaList.add(g);
	}

	@Override
	public void addAlbum(String title, int copiesAvailable, String artist, String songs) {
		Album a = new Album(title, copiesAvailable, artist, songs);
		mediaList.add(a);
	}

	@Override
	public void setLimitedPlanLimit(int value) {
		this.plan = value;

	}

	@Override
	public String getAllCustomersInfo() {
		Collections.sort(customerList);
		String a = "";
		for (int i = 0; i < customerList.size(); i++) {
			a = a + "Customer[" + i + "]\nINFORMATION: " + customerList.get(i).getName() + "\t"
					+ customerList.get(i).getAddress() + "\t" + customerList.get(i).plane + "\n";
		}
		return a;

	}

	@Override
	public String getAllMediaInfo() {
		Collections.sort(mediaList);
//		Media tmp=new Media();
//	for (int i = 0; i <mediaList.size(); i++) {
//		int y=mediaList.get(i).getTitle().compareTo(mediaList.get(i+1).getTitle());
//		if(y==1)
//		{
//		 tmp=mediaList.get(i);
//		 mediaList.get(i)=mediaList.get(i+1);
//		 mediaList.get(i+1)=tmp;
//		 
//		}

//		ArrayList<Game> Gamelist=new ArrayList<>();
//		ArrayList<Movie> Movielist=new ArrayList<>();
//		ArrayList<Album> Albumlist=new ArrayList<>();
		String a = "";
		for (int i = 0; i < mediaList.size(); i++) {
			if (mediaList.get(i) instanceof Game) {
				Game g = new Game();
				g = (Game) mediaList.get(i);
				a = a + "\n[Game Name]: " + g.getTitle() + "\n Copies available:" + g.getNumOfCopies()
						+ "\n Game Weight:" + g.getWeight() + "\n";
				// Gamelist.add(g);
			} else if (mediaList.get(i) instanceof Movie) {
				Movie g = new Movie();
				g = (Movie) mediaList.get(i);
				a = a + "Movie Name: " + g.getTitle() + "\n Copies available:" + g.getNumOfCopies() + "\n Rating:"
						+ g.getRating();
				// Movielist.add(g);

			} else if (mediaList.get(i) instanceof Album) {
				Album g = new Album();
				g = (Album) mediaList.get(i);
				a = a + "[Album Name]: " + g.getTitle() + "\n Copies available:" + g.getNumOfCopies()
						+ "\n Artist Name:" + g.getArtist() + "\n Songs Names:" + g.getSongs() + "\n";
				// Albumlist.add(g);
			}

		}

		return a;

//				
//	 for (int i= 0; i<Gamelist.size(); i++) {
//		 a=a+"Game Name: "+Gamelist.get(i).getTitle()+"\n Copies available:"+Gamelist.get(i).getNumOfCopies()+"\n Game Weight:"+
//	    Gamelist.get(i).getWeight();
//	 }
//	 for (int i = 0; i<Movielist.size(); i++) {
//		 b=b+"Movie Name: "+Movielist.get(i).getTitle()+"\n Copies available:"+Movielist.get(i).getNumOfCopies()+"\n Rating:"
//	 +Movielist.get(i).getRating();
//	 }
//	 for (int i = 0; i<Albumlist.size(); i++) {
//		 c=c+"Album Name: "+Albumlist.get(i).getTitle()+"\n Copies available:"+Albumlist.get(i).getNumOfCopies()+"\n Artist Name:"
//	 +Albumlist.get(i).getArtist()+"\n Songs Names:"+Albumlist.get(i).getSongs();
//	}
//	 

	}

	@Override
	public boolean addToCart(String customerName, String mediaTitle) {
		int y = 0;
		int c = 0;
		boolean flag1 = true;
		boolean flag2 = true;
		boolean mainFlag = false;
		for (int i = 0; i < mediaList.size(); i++) {
			if (mediaList.get(i).getTitle().compareToIgnoreCase(mediaTitle) == 0) {
				c = i;
				flag1 = true;
				break;
			} else {
				flag1 = false;

			}
		}

		for (int j = 0; j < customerList.size(); j++) {

			if (customerName.compareToIgnoreCase(customerList.get(j).getName()) == 0) {
				y = j;
				flag2 = true;
				break;

			} else {

				flag2 = false;
			}
		}

		boolean checkplane = Checkplane(customerList.get(y).getPlane());

		if (searchIn(customerList.get(y).getCustomerCart(), mediaTitle) == false && flag1 == true && flag2 == true
				&& checkplane == true) {
			int x = count(customerList.get(y).getCustomerRented());
			if (x < this.plan) {
				customerList.get(y).addtoCustomerCart(mediaList.get(c));
				mainFlag = true;

			}
		} else if (searchIn(customerList.get(y).getCustomerCart(), mediaTitle) == false && flag1 == true
				&& flag2 == true && checkplane == false) {

			customerList.get(y).addtoCustomerCart(mediaList.get(c));
			mainFlag = true;

		}

		return mainFlag;
	}

	private boolean Checkplane(String plane) {
		boolean flag = false;
		if (plane.compareToIgnoreCase("Limited") == 0) {
			flag = true;
		}
		if (plane.compareToIgnoreCase("UnLimited") == 0) {
			flag = false;
		}
		return flag;

	}

	private boolean searchIn(ArrayList<Media> CustomerCart, String mediaTitle) {
		for (int i = 0; i < CustomerCart.size(); i++) {
			if (CustomerCart.get(i).getTitle().compareTo(mediaTitle) == 0) {
				return true;
			}
		}

		return false;

	}

	private int count(ArrayList<Media> a) {
		int count = 0;
		for (int i = 0; i < a.size(); i++) {
			count++;
		}
		return count;
	}

	@Override
	public boolean removeFromCart(String customerName, String mediaTitle) {
		int y = 0;
		int c = 0;
		boolean flag1 = true;
		boolean flag2 = true;
		boolean mainFlag = false;
		for (int i = 0; i < mediaList.size(); i++) {
			if (mediaList.get(i).getTitle().compareToIgnoreCase(mediaTitle) == 0) {
				c = i;
				System.out.println(c + "\n");
				flag1 = true;
				break;
			} else {
				flag1 = false;
			}
		}

		for (int j = 0; j < customerList.size(); j++) {
			if (customerList.get(j).getName().compareTo(customerName) == 0) {
				y = j;
				break;
			} else {
				flag2 = false;
			}
		}

		if (searchIn(customerList.get(y).getCustomerCart(), mediaTitle) == true && flag1 == true && flag2 == true) {
			customerList.get(y).removeFromCustomerCart(mediaList.get(c));
			mainFlag = true;
		}

		return mainFlag;
	}

	@Override

	public String processRequests() {
		boolean checkplane = false;
		boolean Done = false;
		int x = 0;
		String s = "";
		int d;
		String mediatitle = "";
		Collections.sort(customerList);

		for (int i = 0; i < customerList.size(); i++) {
			checkplane = Checkplane(customerList.get(i).getPlane());
//			System.out.println(checkplane);
			x = count(customerList.get(i).getCustomerRented());
//			System.out.println(x);
			for (int j = 0; j < customerList.get(i).getCustomerCart().size(); j++) {
				while (customerList.get(i).getCustomerCart().size() > 0) {
					d = customerList.get(i).getCustomerCart().get(j).getNumOfCopies();
//					System.out.println(" num of copies is" + d);
					if (customerList.get(i).getCustomerCart().get(j).getNumOfCopies() > 0) {
//						System.out.println("number of copies of the media is>0  entered");
						if (checkplane == true && x < this.plan) {
//							System.out.println("plane is limited");
							customerList.get(i).CustomerRented(customerList.get(i).getCustomerCart().get(j));
							mediaList.get(j).setNumOfCopies(d - 1);
//							System.out.println("num of copies" + mediaList.get(j).getNumOfCopies());
							s = s + ("Sending[" + customerList.get(i).getCustomerCart().get(j).getTitle() + "] to ["
									+ customerList.get(i).getName() + "]\n");
							customerList.get(i).removeFromCustomerCart(customerList.get(i).getCustomerCart().get(j));

						} else if (checkplane == false) {

							customerList.get(i).CustomerRented(customerList.get(i).getCustomerCart().get(j));
							s = s + ("Sending[" + customerList.get(i).getCustomerCart().get(j).getTitle() + "] to ["
									+ customerList.get(i).getName() + "]\n");
							customerList.get(i).removeFromCustomerCart(customerList.get(i).getCustomerCart().get(j));
							mediaList.get(j).setNumOfCopies(d - 1);
//							System.out.println("++++++++++++++++++++");
//							System.out.println(mediaList.get(j).getTitle());
//							System.out.println(mediaList.get(j).getNumOfCopies());

						}
					}
				}
			}
		}

		return s;
	}

	@Override
	public boolean returnMedia(String customerName, String mediaTitle) {
		int y = 0;
		int c = 0;
		boolean flag1 = true;
		boolean flag2 = true;
		boolean mainFlag = false;
		for (int i = 0; i < mediaList.size(); i++) {
			if (mediaList.get(i).getTitle().compareToIgnoreCase(mediaTitle) == 0) {
				c = i;
				flag1 = true;
				break;
			} else {
				flag1 = false;
			}
		}

		for (int j = 0; j < customerList.size(); j++) {
			if (customerList.get(j).getName().compareTo(customerName) == 0) {
				y = j;
				flag2 = true;
				break;
			} else {
				flag2 = false;
			}
		}

		for (int i = 0; i < customerList.get(y).getCustomerRented().size(); i++) {
			if (searchIn(customerList.get(y).getCustomerRented(), mediaTitle) == true && flag1 == true
					&& flag2 == true) {
				int f = mediaList.get(c).getNumOfCopies();
				System.out.println(f);
				customerList.get(y).RemoveFromCustomerRented(mediaTitle);
				mediaList.get(c).setNumOfCopies(f + 1);
				System.out.println(mediaList.get(c).getNumOfCopies());
				mainFlag = true;
				break;
			} else {
				mainFlag = false;
				return mainFlag;
			}
		}

		return mainFlag;

	}

	@Override
	public ArrayList<String> searchMedia(String title, String rating, String artist, String songs) {
		ArrayList<String> MediaNames = new ArrayList<>();
		if (title != null) {
			for (int i = 0; i < this.mediaList.size(); i++) {
				if (this.mediaList.get(i).getTitle().compareToIgnoreCase(title) == 0) {
					MediaNames.add(mediaList.get(i).getTitle());
				}

			}
		}

		if (title == null && rating != null) {
			for (int i = 0; i < this.mediaList.size(); i++) {
				if (this.mediaList.get(i) instanceof Movie) {
					Movie g = (Movie) this.mediaList.get(i);
					if (g.getRating().compareToIgnoreCase(rating) == 0) {
						MediaNames.add(g.getTitle());
					}

				}
			}
		}

		if (title == null && rating == null && artist != null) {
			for (int i = 0; i < this.mediaList.size(); i++) {
				if (this.mediaList.get(i) instanceof Album) {
					Album g = (Album) this.mediaList.get(i);
					if (g.getArtist().compareToIgnoreCase(artist) == 0) {
						MediaNames.add(g.getTitle());

					}
				}
			}
		}
		if (title != null && rating == null && artist != null) {
			for (int i = 0; i < this.mediaList.size(); i++) {
				if (this.mediaList.get(i) instanceof Album) {
					Album g = (Album) this.mediaList.get(i);
					if (g.getArtist().compareToIgnoreCase(artist) == 0
							&& g.getTitle().compareToIgnoreCase(title) == 0) {
						MediaNames.add(g.getTitle());

					}
				}
			}
		}

		if (title == null && rating == null && artist == null && songs != null) {
			for (int i = 0; i < this.mediaList.size(); i++) {
				if (this.mediaList.get(i) instanceof Album) {
					Album g = (Album) this.mediaList.get(i);
					String[] token = g.getSongs().split(",");
					Arrays.asList(token);
					String[] song = songs.split(",");
					for (int j = 0; j < token.length; i++) {
						for (int k = 0; k < song.length; i++) {
							if (token[j].compareToIgnoreCase(song[k]) == 0) {
								MediaNames.add(g.getTitle());
						

							}

						}
					}
				}
			}
		}
		if (title != null && rating == null && artist != null && songs != null) {
			for (int i = 0; i < this.mediaList.size(); i++) {
			
				Album g = (Album) this.mediaList.get(i);
				String[] token = g.getSongs().split(",");
				String[] songSearch = songs.split(",");
				for (int j = 0; j < token.length; i++) {
					
					for (int k = 0; k < songSearch.length; i++) {
						if (token[j].equals(songSearch[k]) && g.getTitle().compareToIgnoreCase(title) == 0
								&& g.getArtist().equals(artist)) {
							
							MediaNames.add(g.getTitle());

						}

					}
				}
			}
		}
		if (title != null && rating != null) {
			for (int i = 0; i < this.mediaList.size(); i++) {
				if (this.mediaList.get(i) instanceof Movie) {
					Movie g = (Movie) this.mediaList.get(i);
					if (g.getRating().compareToIgnoreCase(rating) == 0
							&& g.getTitle().compareToIgnoreCase(title) == 0) {
						MediaNames.add(g.getTitle());
					}

				}
			}
		}

		if (title == null && rating == null && artist == null && songs == null) {
			for (int i = 0; i < this.mediaList.size(); i++) {
				 MediaNames.add(mediaList.get(i).getTitle());
			}
		}
		return MediaNames;

	}
}
