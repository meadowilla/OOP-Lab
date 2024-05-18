package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

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
	public void play() {
		for (Track track: tracks) {
			System.out.println("Playing track: " + getTitle());
			System.out.println("Track length: " + getLength());
			track.play();
		}
	}
	
	public String getArtist() {
		return artist;
	}
	


}
