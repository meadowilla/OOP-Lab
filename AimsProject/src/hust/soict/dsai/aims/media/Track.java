package hust.soict.dsai.aims.media;

public class Track implements Playable{
	private String title;
	private int length;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Track track = (Track) obj;
		if (this.title != null && this.length == track.length){
			return this.title.equals(track.title);
		} else {
			return track.title == null;
		}
	}
	
	@Override
	public void play() {
		System.out.println("Playing Track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}
		
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}
	
}
