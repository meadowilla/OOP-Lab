package hust.soict.dsai.aims.media;

// import hust.soict.dsai.aims.media.MediaComparatorByCostTitle;
// import hust.soict.dsai.aims.media.MediaComparatorByTitleCost;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public abstract class Media {
	
	private int id;
	private String title;
	private String category;
	private float cost;
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = 
		new MediaComparatorByTitleCost();

	public static final Comparator<Media> COMPARE_BY_COST_TITLE = 
		new MediaComparatorByCostTitle();
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Media media = (Media) obj;
		return this.title != null? this.title.equals(media.title): media.title == null;
	}
	
	public Media(int id, String title, String category, float cost) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	public String toString() {
		return (Integer.toString(getId()) + ".Media - " + getTitle() 
				+ " - " + getCategory() + ": " 
				+ Float.toString(getCost()) + " $\n");
	}
	
	public static void main(String args[]) {
		List<Media> mediae = new ArrayList<Media>();
		CompactDisc cd = new CompactDisc(1, "CD102", "CompactDisc", (float) 0.36, "Meadowilla", "SohappyChild");
		cd.addTrack(new Track("Yeu", 16));
		cd.addTrack(new Track("Mo", 19));
		DigitalVideoDisc dvd = new DigitalVideoDisc(2, "DVD113", "DigitalVideoDisc", (float) 1.5, 86, "PTH");
		Book book = new Book(3, "B124", "Book", (float) 15.7);
		book.addAuthor("Meadow");
		book.addAuthor("PTH");
		
		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(book);
		
		for (Media m: mediae) {
			System.out.println(m.toString());
		}
	}
	

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}
	
}
