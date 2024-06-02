package hust.soict.dsai.aims;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.*;

public class Aims {
	
	private static final Store mainStore = new Store();
	private static final Cart mainCart = new Cart();
	
	public static Cart getCart() {
		return mainCart;
	}
	
	public static void main(String [] args) {
		showMenu();
	}
	
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");

		int option = chooseOption("Input your option: ");
		switch(option) {
			case 1:
				viewStore();
				break;
			case 2:
				updateStore();
				break;
			case 3:
				seeCurrentCart();
				break;
			case 0: 
				System.out.println("Exit");
			default:
				System.out.println("Invalid input. Try again!");
		}
	}
	
	public static int chooseOption(String message) {
		try (Scanner scanner = new Scanner(System.in)) {
			int option = 0;
			boolean validInput = false;
			
			while (!validInput) {
				System.out.print(message);
				if (scanner.hasNextInt()) {
					option = scanner.nextInt();
					validInput = true;
				} else {
					System.out.println("Invalid input. Try again!");
					scanner.next();
				}
			}
			return option;
		}
	}
	
	public static void viewStore() {
		while (true) {
			mainStore.print();
			storeMenu();
			int option = chooseOption("Input your option: ");
			switch(option){
				case 1: 
					seeMediaDetail();
					break;
				case 2:
					addMediaToCart();
					break;
				case 3:
					playMedia();
					break;
				case 4:
					seeCurrentCart();
					break;
				case 0:
					return;
				default:
					System.out.println("Invalid input. Try again!");
			}
		}
	}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		}

	public static String getTitle(String message){
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(message);
			return scanner.nextLine();
		} 
	}

	public static void updateStore(){
		System.out.println("1. Add media");
        System.out.println("2. Remove media");
		while (true) {
			int option = chooseOption("Input your option: ");
			switch(option){
				case 1: 
					// code to add Media to Store
					break;
				case 2:
					String title = getTitle("Enter title to remove: ");
					mainStore.removeMedia(mainStore.getMedia(title));
					System.out.println("Removed from store.");
					break;
				default:
					System.out.println("Invalid input. Try again!");
			}
		}
	}

	public static void seeCurrentCart(){
		mainCart.print();
		cartMenu();
	}

	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");

		int option = chooseOption("Input your option: ");
		switch(option) {
			case 1:
				filterMediaInCart();
				break;
			case 2:
				sortMediaInCart();
				break;
			case 3:
				removeMediaFromCart();
				break;
			case 4:
				playMedia();
				break;
			case 5:
				mainCart.placeOrder();
				break;
			case 0: 
				System.out.println("Back");
				break;
			default:
				System.out.println("Invalid input. Try again!");
		}
	}
	
	public static void mediaDetailsMenu(Media media) {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		if (media instanceof Playable){
			System.out.println("2. Play");
		} 
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1(-2)");
		}

	public static void seeMediaDetail(){
		String title = getTitle("Enter title to display: ");
		Media media = mainStore.getMedia(title);
		media.toString();
		mediaDetailsMenu(media);
	}

	public static void addMediaToCart(){
		String title = getTitle("Enter title to add (available in store): ");
		Media media = mainStore.getMedia(title);
		if (media instanceof DigitalVideoDisc){
			int count = 0;
			for (Media m: mainCart.getItemOrdered()){
				if (m instanceof DigitalVideoDisc){
					count += 1;
				}
			}
			System.out.println("There are " + String.valueOf(count) + " DVDs in the current cart.");
		}

	}

	public static void playMedia(){
		String title = getTitle("Enter title to play: ");
		Media media = mainStore.getMedia(title);
		if (media instanceof CompactDisc){
			CompactDisc cd = (CompactDisc) media;
			try {
				cd.play();
			} catch (PlayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (media instanceof DigitalVideoDisc){
			DigitalVideoDisc dvd = (DigitalVideoDisc) media;
			try {
				dvd.play();
			} catch (PlayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void filterMediaInCart(){
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter by id");
		System.out.println("2. Filter by title");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 1-2");

		int option = chooseOption("Choose option: ");
		switch (option) {
			case 1:
				int id = chooseOption("Enter id to filter: ");
				mainCart.searchById(id);
				break;
			case 2:
				String title = getTitle("Enter title to filter: ");
				mainCart.searchByTitle(title);
				break;
			default:
				System.out.println("Invalid input. Try again!");
		}
	}

	public static void sortMediaInCart(){
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Sort by title");
		System.out.println("2. Sort by cost");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 1-2");

		int option = chooseOption("Choose option: ");
		switch (option) {
			case 1:
				mainCart.getItemOrdered().sort(Media.COMPARE_BY_COST_TITLE);
				break;
			case 2:
				mainCart.getItemOrdered().sort(Media.COMPARE_BY_TITLE_COST);
				break;
			default:
				System.out.println("Invalid input. Try again!");
		}
	}

	public static void removeMediaFromCart(){
		String title = getTitle("Enter title to remove (available in cart): ");
		Media media = mainStore.getMedia(title);
		mainCart.removeMedia(media);
		System.out.println("Removed from cart.");
	}
}
