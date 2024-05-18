package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) {

		// Create a new cart
		Cart cart = new Cart();
		
		//Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(0, "The Lion King", 
				"Animation", 19.95f, 87, "Roger Allers");
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(1, "Star Wars", 
				"Science Fiction",24.95f, 87, "George Lucas");
		DigitalVideoDisc dvd3 = new DigitalVideoDisc(2, "Aladin", 
				"Animation", 18.99f, 100, "Meadow");
		cart.addMedia(dvd1);
		cart.addMedia(dvd2);
		cart.addMedia(dvd3);
		
		System.out.println("Cart size: " + String.valueOf(cart.getItemOrdered().size()));
		
		//Test the print method
		cart.print();
		//To-do: Test the search methods here
		cart.searchById(1);
		cart.searchById(2);

	}

}
