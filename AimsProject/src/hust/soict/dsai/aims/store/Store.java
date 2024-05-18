package hust.soict.dsai.aims.store;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore;
	
	public Store() {
		itemsInStore = new ArrayList<Media>();
	}
	
	public void addMedia(Media media) {
		itemsInStore.add(media);
	}
	public void removeMedia(Media media) {
		for(int i=0;i<itemsInStore.size();i++) {
			if (itemsInStore.get(i).getId() == media.getId()) {
				itemsInStore.remove(i);
			}
		}
	}
	public Media getMedia(String title){
		for (Media media: itemsInStore){
			if (media.getTitle().equals(title)){
				return media;
			} else {
				System.out.println("The media doesn't exist!");
			}
		}
		return null;
	}
	
	public void print() {
		System.out.println("********** STORE **********");
		String ans = "Items: \n";
		for (Media media: itemsInStore) {
			ans += media.toString();
		}
		System.out.println(ans);
	}
}
