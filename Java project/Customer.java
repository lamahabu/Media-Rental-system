import java.util.*;

public class Customer implements Comparable<Customer> {
	private String Name;
	private String Address;
	String plane;
	private ArrayList<Media> CustomerInteretsted = new ArrayList<>();
	private ArrayList<Media> CustomerRented = new ArrayList<>();
	private ArrayList<Media> CustomerCart = new ArrayList<>();

	public Customer() {

	}

	public Customer(String name, String address, String plane) {
		super();
		this.plane = plane;
		Name = name;
		Address = address;
	}

	public String getPlane() {
		return plane;
	}

	public void setPlane(String plane) {

	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public void CustomerInterestedlist(Media x) {
		ArrayList<ArrayList<Customer>> CustomerInterList = new ArrayList<ArrayList<Customer>>();
//	for(int i=0;i<CustomerInterList.size();i++) {
//			CustomerInterList.add(new ArrayList<Media>());
//			CustomerInterList.get(i)=new ArrayList<Media>();
//		
		String a = "";

		this.CustomerInteretsted.add(x);

		for (int i = 0; i < CustomerInteretsted.size(); i++) {
			for (i = 0; i < CustomerInteretsted.size(); i++) {
				if (CustomerInteretsted.get(i) instanceof Game) {
					Game g = new Game();
					g = (Game) CustomerInteretsted.get(i);
					a = a + "\n[Game Name]: " + g.getTitle() + "\n Copies available:" + g.getNumOfCopies()
							+ "\n Game Weight:" + g.getWeight() + "\n";
					// Gamelist.add(g);
				} else if (CustomerInteretsted.get(i) instanceof Movie) {
					Movie g = new Movie();
					g = (Movie) CustomerInteretsted.get(i);
					a = a + "[Movie Name]: " + g.getTitle() + "\n Copies available:" + g.getNumOfCopies() + "\n Rating:"
							+ g.getRating();
					// Movielist.add(g);

				} else if (CustomerInteretsted.get(i) instanceof Album) {
					Album g = new Album();
					g = (Album) CustomerInteretsted.get(i);
					a = a + "[Album Name]: " + g.getTitle() + "\n Copies available:" + g.getNumOfCopies()
							+ "\n Artist Name:" + g.getArtist() + "\n Songs Names:" + g.getSongs() + "\n";
					// Albumlist.add(g);
				}

			}
		}

		System.out.println(
				"CustomerInterestedlist[]\nINFORMATION: " + this.Name + "\t" + this.Address + "\t" + this.plane + "\n");

		System.out.println(a);

	}

	public ArrayList<Media> getCustomerInteretsted() {
		return CustomerInteretsted;
	}

	public void CustomerRented(Media x) {
		String a = "";
		// int counter =0;
		// if(this.plane.compareToIgnoreCase("Limited")==0 &&counter<2)
		this.CustomerRented.add(x);
		// counter++;

//		else if(this.plane.compareToIgnoreCase("Unlimited")==0) {
//			this.CustomerRented.add(x);

//		for (int i = 0; i < CustomerRented.size(); i++) {
//			for (i = 0; i < CustomerRented.size(); i++) {
//				if (CustomerRented.get(i) instanceof Game) {
//					Game g = new Game();
//					g = (Game) CustomerRented.get(i);
//					a = a + "\n[Game Name]: " + g.getTitle() + "\n Copies available:" + g.getNumOfCopies()
//							+ "\n Game Weight:" + g.getWeight() + "\n";
//					// Gamelist.add(g);
//				} else if (CustomerRented.get(i) instanceof Movie) {
//					Movie g = new Movie();
//					g = (Movie) CustomerRented.get(i);
//					a = a + "[Movie Name]: " + g.getTitle() + "\n Copies available:" + g.getNumOfCopies() + "\n Rating:"
//							+ g.getRating();
					// Movielist.add(g);

//				} else if (CustomerRented.get(i) instanceof Album) {
//					Album g = new Album();
//					g = (Album) CustomerRented.get(i);
//					a = a + "[Album Name]: " + g.getTitle() + "\n Copies available:" + g.getNumOfCopies()
//							+ "\n Artist Name:" + g.getArtist() + "\n Songs Names:" + g.getSongs() + "\n";
//					// Albumlist.add(g);
//				}
//
//			}
//
//		}
	}

	

	public ArrayList<Media> getCustomerRented() {
		return CustomerRented;
	}

	public ArrayList<Media> getCustomerCart() {
		return CustomerCart;
	}

	public void addtoCustomerCart(Media e) {
		if (e instanceof Game) {
			Game g = new Game();
			g = (Game) e;
			CustomerCart.add(g);
		} else if (e instanceof Movie) {
			Movie g = new Movie();
			g = (Movie) e;
			CustomerCart.add(g);

		} else if (e instanceof Album) {
			Album g = new Album();
			g = (Album) e;
			CustomerCart.add(g);

		}

	}

	public void removeFromCustomerCart(Media e) {
		CustomerCart.remove(e);
	}

	public void RemoveFromCustomerRented(String mediaTitle) {
		this.CustomerRented.remove(mediaTitle);
	}
	

	@Override
	public int compareTo(Customer o) {
		int cmp = this.getName().compareTo(o.getName());
		return cmp;
	}

}
