import java.util.ArrayList;
import java.io.File; // Import the File class
import java.io.FileInputStream;
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.stylesheets.MediaList;

public class Driver {
	public static void main(String args[]) throws IOException  {
		MediaRental mediaRentalManager = new MediaRental();
  
		System.out.println(
				"1-ADD CUSTOMER\n2-ADD MEDIA\n3-ADD TO CART\n4-REMOVE FROM CART\n5-PROCESSING REQUEST\n6-RETURN MEDIA\n");
		System.out.println("Enter -1 to stop");
		Scanner scan = new Scanner(System.in);
		int inter = scan.nextInt();
		while (inter != -1) {
			switch (inter) {
			case 1:
				try {

					System.out.println("Enter Customer information to add:");
					Scanner scan1 = new Scanner(System.in);
					System.out.print("Customer Name:");
					String name = scan1.next();
					System.out.print("Customer Address:");
					String address = scan1.next();
					System.out.print("Customer Plan:");
					String plane = scan1.next();
					testAddingCustomers(mediaRentalManager, plane, plane, plane);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
			case 2:
				System.out.println("Enter media information to add :");
				try {
					String title;
					int l;
					int w;
					Scanner scan1 = new Scanner(System.in);
					System.out.println("Choose media type");
					System.out.println("1) Game");
					System.out.println("2) Movie");
					System.out.println("3) Album");
					int a = scan1.nextInt();
					switch (a) {
					case 1:
						System.out.print("Enter media title:");
						title = scan1.next();
						System.out.print("Enter number of copies:");
						l = scan1.nextInt();
						System.out.print("Enter weight;");
						w = scan1.nextInt();
						Game g = new Game(title, l, w);
						testAddingMedia(mediaRentalManager, g);
						break;
					case 2:
						System.out.print("Enter media title:");
						title = scan1.next();
						System.out.print("Enter number of copies:");
						l = scan1.nextInt();
						System.out.print("Rating:");
						String rating = scan1.next();
						Movie m = new Movie(title, l, rating);
						testAddingMedia(mediaRentalManager, m);
						break;
					case 3:
						System.out.print("Enter media title:");
						title = scan1.next();
						System.out.print("Enter number of copies:");
						l = scan1.nextInt();
						System.out.print("Artist:");
						String Artist = scan1.next();
						System.out.println("Songs:");
						System.out.println("Note:Use comma(,) between songs if there is more than one:");
						String Songs = scan1.next();
						Album b = new Album(title, l, Artist, Songs);
						testAddingMedia(mediaRentalManager, b);
						break;

					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			case 3:
				try {

					System.out.print("Enter Customer name:");
					String customername = scan.next();
					System.out.print("Enter media title:");
					String mediatitle = scan.next();
					testingAddingToCart(mediaRentalManager, customername, mediatitle);

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			case 4:
				try {

					System.out.print("Enter Customer name:");
					String customername = scan.next();
					System.out.print("Enter media title:");
					String mediatitle = scan.next();
					testingRemovingFromCart(mediaRentalManager, customername, mediatitle);

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			case 5:
				try {
					System.out.print("Enter Customer name:");
					String customername = scan.next();
					System.out.print("Enter media title:");
					String mediatitle = scan.next();
					testProcessingRequestsOne(mediaRentalManager);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			case 6:
				
                System.out.println("Enter Media information to search:");
                System.out.println("Enter title ,NO if theres no title");
                String title=scan.next();
                System.out.println("Enter rating ,NO if theres no rating");
                String rating=scan.next();
                System.out.println("Enter artist ,NO if theres no artist");
                String artist=scan.next();
                System.out.println("Enter songs ,NO if theres no songs");
                String song=scan.next();
                int x=0;
                int y=0;
                int z=0;
                int w=0;
                if(title.compareToIgnoreCase("NO")==0) {
                	x=1;
                }
                if(rating.compareToIgnoreCase("NO")==0) {
                	y=1;
                }
                if(artist.compareToIgnoreCase("NO")==0) {
                	z=1;
                }
                if(song.compareToIgnoreCase("NO")==0) {
                	w=1;
                }
                if(x!=1 && y!=1 && w!=1 && z!=1) {
                	 {
                		 testSearchMedia( mediaRentalManager, title, rating,  artist ,song) ;
                	}
                 if(x!=1 && y==1 && w==1 && z==1) {
                	 testSearchMedia( mediaRentalManager, title, null,  null ,null) ;
             	}
                 if(x!=1 && y!=1 && w==1 && z==1) {
                	 testSearchMedia( mediaRentalManager, title, rating,  null ,null) ;
             	}
                 
                 if(x!=1 && y!=1 && w!=1 && z==1) {
                	 testSearchMedia( mediaRentalManager, title, rating,  artist ,null) ;
             	}
                 if(x!=1 && y==1 && w==1 && z==1) {
                	 testSearchMedia( mediaRentalManager, null, null,  null ,null) ;
             	}
                 if(x!=1 && y==1 && w!=1 && z==1) {
                	 testSearchMedia( mediaRentalManager, title, null,  artist ,null) ;
             	}
                 if(x!=1 && y!=1 && w==1 && z==1) {
                	 testSearchMedia( mediaRentalManager, title, rating,  null ,null) ;
             	}
                 if(x==1 && y==1 && w!=1 && z!=1) {
                	 testSearchMedia( mediaRentalManager, null, null,  artist ,song) ;
             	}
                 if(x!=1 && y==1 && w==1 && z!=1) {
                	 testSearchMedia( mediaRentalManager, title, null,  null ,song) ;
             	}
                 if(x!=1 && y!=1 && w==1 && z==1) {
                	 testSearchMedia( mediaRentalManager, title, rating,  null ,null) ;
             	}
                 if(x==1 && y==1 && w!=1 && z==1) {
                	 testSearchMedia( mediaRentalManager, null, null,  artist ,null) ;
             	}
                 if(x==1 && y==1 && w==1 && z!=1) {
                	 testSearchMedia( mediaRentalManager, null, null,  null ,song) ;
             	} 
                 if(x==1 && y!=1 && w==1 && z==1) {
                	 testSearchMedia( mediaRentalManager, null, rating,  null ,null) ;
             	}
                 if(x!=1 && y!=1 && w==1 && z!=1) {
                	 testSearchMedia( mediaRentalManager, title, null,  artist ,song) ;
             	}
                }
                
             

                

                
            	 
        
             
			
		}
	}
		if(inter==-1) {
			System.exit(0);
		}
	}

//		try {
//			File file=new File("data.txt");
//			ObjectInputStream o = new ObjectInputStream( new FileInputStream(file));
//			MediaRental mediaRentalManager = new MediaRental();
//			mediaRentalManager=(MediaRental)o.readObject();
//			
//			
//		}
//		String name;
//    	String address;
//    	String plane;
//		try {
//		      File Customerfile = new File("filename.txt");
//		      Scanner scan1 = new Scanner(Customerfile);
//		      while (scan1.hasNextLine()) {
//		        String data = scan1.nextLine();
//		        String[] DataCuter=data.split(",");
//		        for(int i=0;i<3;i++) {
//		       name=DataCuter[i];
//		       address=DataCuter[i+1];
//		       plane=DataCuter[i+2];
//		       mediaRentalManager.customerList.add(new Customer(name,address,plane));  
//		      }
//		      scan1.close();
//		    } 
//		}catch (FileNotFoundException e) {
//		      System.out.println("An error occurred.");
//		      e.printStackTrace();
//		    }
//		  }
//		        System.out.println(data);
//		      }
//		      myReader.close();
//		    } catch (FileNotFoundException e) {
//		      System.out.println("An error occurred.");
//		      e.printStackTrace();
//		    }
//		}
//		mediaRentalManager.addCustomer("asad","nablus","Unlimited");

	public static void testAddingCustomers(MediaRental mediaRentalManager, String name, String Address, String plane) {
		Customer x = new Customer(name, Address, plane);
		mediaRentalManager.customerList.add(x);
		try {
			FileOutputStream file = new FileOutputStream("file.txt");
			ObjectOutputStream o = new ObjectOutputStream(file);
			o.writeObject(mediaRentalManager.customerList);
			o.close();
		} catch (FileNotFoundException e1) {
			System.out.println(e1.getMessage());
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		}
	}

	public static void testAddingMedia(MediaRental mediaRentalManager, Media e) {
		mediaRentalManager.mediaList.add(e);
		FileWriter fw = null;
		try {
			File file = new File("data.txt");
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(file, true));
			o.writeObject(mediaRentalManager.mediaList);
			o.close();
		} catch (FileNotFoundException e1) {
			System.out.println(e1.getMessage());
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		}
	}

	public static void testingAddingToCart(MediaRental mediaRentalManager, String Customername, String Mediatitle) {
		mediaRentalManager.addToCart(Customername, Mediatitle);
	}

	public static void testingRemovingFromCart(MediaRental mediaRentalManager, String Customername, String Mediatitle) {
		mediaRentalManager.removeFromCart(Customername, Mediatitle);
	}

	public static void testProcessingRequestsOne(MediaRental mediaRentalManager) {
		mediaRentalManager.processRequests();
	}

	public void testProcessingRequestsTwo(MediaRental mediaRentalManager) {
		mediaRentalManager.processRequests();
	}

	public static void testReturnMedia(MediaRental mediaRentalManager, String customerName, String mediaTitle) {
		mediaRentalManager.returnMedia(customerName, mediaTitle);
	}

	public static void testSearchMedia(MediaRental mediaRentalManager, String title, String rating, String artist,
			String songs) {
		mediaRentalManager.searchMedia(title, rating, artist, songs);
	}

}
