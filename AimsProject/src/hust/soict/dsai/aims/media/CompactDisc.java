package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable{
	
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc(int id, String title, String category, float cost, String director, String artist) {
		super(id, title, category, cost, director);
		this.artist = artist;
	}

	public void addTrack(Track track) {
		if (tracks.contains(track) == false) {
			tracks.add(track);
		}else {
			System.out.print("Cannot add! The track has existed!");
		}
	}
	
	public void removeTrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
		}else {
			System.out.print("Cannot remove! The track doesn't exist!");
		}
	}
	
	public String toString() {
		return (Integer.toString(getId()) + ".CD - " + getTitle() 
				+ " - " + getCategory() + " - " + getDirector() 
				+ " - " + getArtist() + " - " + Integer.toString(getLength()) 
				+ ": " + Float.toString(getCost()) + " $\n");
	}
	
	@Override
	public int getLength() {
		int sum = 0;
		for (Track track: tracks) {
			sum += track.getLength();
		}
		return sum;
	}

	@Override
	public void play() throws PlayerException{
		if (this.getLength() > 0) {
			Iterator<Track> iter = tracks.iterator();
			Track nextTrack;
			while(iter.hasNext()) {
				nextTrack = (Track) iter.next();
				try {
					nextTrack.play();
				}catch(PlayerException e) {
					System.err.println("ERROR: Cannot play track " + nextTrack.getTitle() 
							+ " because " + e.getMessage());
					throw e;
					
				}
			}
		} else {
			System.err.println("ERROR: CD length is non-positive");
			throw new PlayerException("ERROR: CD length is non-positive");
		}
	}
	
	public String getArtist() {
		return artist;
	}
	


}
