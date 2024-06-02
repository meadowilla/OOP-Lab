package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{
	
	public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
		super(id, title, category, cost, length, director);
	}

	public boolean isMatch(String title) {
		if (getTitle() == title) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return (Integer.toString(getId()) + ".DVD - " + getTitle() 
				+ " - " + getCategory() + " - " + getDirector() 
				+ " - " + Integer.toString(getLength()) + ": " 
				+ Float.toString(getCost()) + " $\n");
	}
	
	@Override
	public void play() throws PlayerException{
		if (this.getLength() > 0) {
			System.out.println("Playing DVD: " + getTitle());
			System.out.println("DVD length: " + getLength());
		} else {
			throw new PlayerException("ERROR: DVD length is non-positve!");
		}
	}
}
