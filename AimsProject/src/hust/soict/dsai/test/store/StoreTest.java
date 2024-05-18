package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store store = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(0, "The Lion King", 
			"Animation", 19.95f, 87, "Roger Allers");
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(1, "Star Wars", 
			"Science Fiction",24.95f, 87, "George Lucas");
		DigitalVideoDisc dvd3 = new DigitalVideoDisc(2, "Aladin", 
			"Animation", 18.99f, 100, "Meadow");
		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);
		store.print();
		
		store.removeMedia(dvd3);
		store.print();
	}

}
