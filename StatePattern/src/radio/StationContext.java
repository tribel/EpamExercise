package radio;

/**
 * Context of the station pattern 
 * @author Tribel
 *
 */
public class StationContext {

	private Station station;
	
	public void setStation(Station st) {
		this.station = st;
	}
	
	public void nextStation() {
		if(this.station instanceof FirstRadio) {
			setStation(new SecondRadio());
		} else {
			setStation(new FirstRadio());
		}
	}
	
	public void play() {
		station.play();
	}
}
