package hust.soict.dsai.aims.store;
import java.util.ArrayList;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	private ArrayList<DigitalVideoDisc> itemsInStore;
	
	public Store() {
		itemsInStore = new ArrayList<DigitalVideoDisc>();
	}
	
	public void addDVD(DigitalVideoDisc dvd) {
		itemsInStore.add(dvd);
	}
	public void removeDVD(DigitalVideoDisc dvd) {
		for(int i=0;i<itemsInStore.size();i++) {
			if (itemsInStore.get(i).getId() == dvd.getId()) {
				itemsInStore.remove(i);
			}
		}
	}
	
	public void print() {
		System.out.println("********** STORE **********");
		String ans = "Items: \n";
		for (DigitalVideoDisc dvd: itemsInStore) {
			ans += dvd.toString();
		}
		System.out.println(ans);
	}
}
