package conversion.model;

public class Location {
	String latitude;
	String human_address;
	boolean need_recording;
	String longitude;
	
	public Location() {}
	
	public Location(String latitude,String human_address,boolean need_recording,String longitude) {
		super();
		this.latitude =latitude;
		this.human_address = human_address;
		this.need_recording = need_recording;
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getHuman_address() {
		return human_address;
	}

	public void setHuman_address(String human_address) {
		this.human_address = human_address;
	}

	public boolean isNeed_recording() {
		return need_recording;
	}

	public void setNeed_recording(boolean need_recording) {
		this.need_recording = need_recording;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	
}
