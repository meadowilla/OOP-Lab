package hust.soict.dsai.aims.cart;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = 
			FXCollections.observableArrayList();

	public ObservableList<Media> getItemOrdered() {
		return itemsOrdered;
	}

	public void addMedia(Media media) {
		if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is almost full.");
		} else {
			itemsOrdered.add(media);
			System.out.println("The disc has been added.");
		}
	}
	
	public void addMedia(ArrayList<Media> mediaList) {
		if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is almost full.");
		} else if (itemsOrdered.size() + mediaList.size() > MAX_NUMBERS_ORDERED) {
			System.out.println("The cart would be full, you cannot add this list of DVDs");
		} else {
			for (Media media: mediaList) {
				itemsOrdered.add(media);
			}
			System.out.println("The list of dvds has been added.");
		}
	}
	
	public void addDigitalVideoDisc(Media dvd1, Media dvd2) {
		if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is almost full.");
		} else if (itemsOrdered.size() + 2 > MAX_NUMBERS_ORDERED) {
			System.out.println("The cart would be full, you cannot add this list of DVDs");
		} else {
			itemsOrdered.add(dvd1);
			itemsOrdered.add(dvd2);
			System.out.println("The list of dvds has been added.");
		}
	}
	
	public void removeMedia(Media media) {
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).equals(media)) {
				itemsOrdered.remove(media);
			}
		}
	}
	
	public float totalCost() {
		float total = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i)!= null) {
				total += itemsOrdered.get(i).getCost();
			}
		}
		String t = String.format("%.2f",total);
		total = Float.valueOf(t);
		return total;
	}

	public void placeOrder(){
		itemsOrdered.clear();
		System.out.println("Order placed.");
	}
	
	public void print() {
		System.out.println("********** CART **********");
		String ans = "Ordered Items: \n";
		for (int i=0; i<itemsOrdered.size(); i++) {
			ans += itemsOrdered.get(i).toString();
		}
		ans += ("Total cost: " + this.totalCost() + '\n');
		System.out.println(ans);
	}
	
	public void searchById(int id) {
		for(int i = 0; i<itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getId() == id) {
				System.out.println(itemsOrdered.get(i).toString());
				return;
			}
		}
		System.out.println("No match is found!");
	}
	
	public void searchByTitle(String title) {
		for(int i = 0; i<itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getTitle() == title) {
				System.out.println(itemsOrdered.get(i).toString());
				return;
			}
		}
		System.out.println("No match is found!");
	}
	
	
	
}