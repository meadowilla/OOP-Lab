package hust.soict.dsai.aims.cart;
//import java.util.ArrayList;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = -1;

	public DigitalVideoDisc[] getItemOrdered() {
		return itemOrdered;
	}

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered >= 20) {
			System.out.println("The cart is almost full.");
		} else {
			itemOrdered[qtyOrdered + 1] = disc;
			disc.setId(qtyOrdered + 1);
			qtyOrdered += 1;
			System.out.println("The disc has been added.");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		if (qtyOrdered >= 20) {
			System.out.println("The cart is almost full.");
		} else if (qtyOrdered + dvdList.length > 20) {
			System.out.println("The cart would be full, you cannot add this list of DVDs");
		} else {
			for (DigitalVideoDisc dvd: dvdList) {
				itemOrdered[qtyOrdered + 1] = dvd;
				qtyOrdered += 1;
			}
			System.out.println("The list of dvds has been added.");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (qtyOrdered >= 20) {
			System.out.println("The cart is almost full.");
		} else if (qtyOrdered + 2 > 20) {
			System.out.println("The cart would be full, you cannot add this list of DVDs");
		} else {
			itemOrdered[qtyOrdered + 1] = dvd1;
			qtyOrdered += 1;
			itemOrdered[qtyOrdered + 1] = dvd2;
			qtyOrdered += 1;
			System.out.println("The list of dvds has been added.");
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemOrdered[i] == disc) {
				itemOrdered[i] = null;
				qtyOrdered -= 1;
			}
		}
	}
	
	public float getTotalCost() {
		float total = 0;
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
			if (itemOrdered[i] != null) {
				total += itemOrdered[i].getCost();
			}
		}
		String t = String.format("%.2f",total);
		total = Float.valueOf(t);
		return total;
	}
	
	public void print() {
		System.out.println("********** CART **********");
		String ans = "Ordered Items: \n";
		for (int i=0; i<=qtyOrdered; i++) {
			ans += itemOrdered[i].toString();
		}
		ans += ("Total cost: " + this.getTotalCost());
		System.out.println(ans);
	}
	
	public void searchById(int id) {
		for(int i = 0; i<qtyOrdered; i++) {
			if (itemOrdered[i].getId() == id) {
				System.out.println(itemOrdered[i].toString());
				return;
			}
		}
		System.out.println("No match is found!");
	}
	
	public void searchByTitle(String title) {
		for(int i = 0; i<qtyOrdered; i++) {
			if (itemOrdered[i].getTitle() == title) {
				System.out.println(itemOrdered[i].toString());
				return;
			}
		}
		System.out.println("No match is found!");
	}
	
	
	
}