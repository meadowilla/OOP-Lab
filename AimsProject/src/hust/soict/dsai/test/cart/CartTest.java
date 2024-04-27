package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.cart.Cart;

public class CartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a new cart
		Cart cart = new Cart();
		
		//Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
				"Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
				"Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
				"Animation", 18.99f);
		cart.addDigitalVideoDisc(dvd1);
		cart.addDigitalVideoDisc(dvd2);
		cart.addDigitalVideoDisc(dvd3);
		
		//Text the print method
		cart.print();
		//To-do: Test the search methods here
		cart.searchById(4);
		cart.searchById(0);
		
		
		
	}

}
