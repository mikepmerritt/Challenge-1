public class Event {
	
	private int _time; // expects military time (int between 0 and 23)
	private String _readableTime;
	private String _type;
	private String _location;
	
	// constructor for making new events, used when dealing with user
	public Event(int time, String type, String location) {
		_time = time;
		_type = type;
		_location = location;
		convertTime();
	}
	//Added getters for each part of an event
	public int getTime() {
		convertTime();
		return _time;
	}

	public String getType(){
		return _type;
	}

	public String getLocation(){
		return _location;
	}
	
	public String getReadableTime() {
		return _readableTime;
	}
	
	// constructor for making existing events, used when dealing with schedule file
	public Event(String formatted) {
		String[] information = formatted.split(";");
		_time = Integer.parseInt(information[0]);
		_type = information[1];
		_location = information[2];
		convertTime();
	}
	
	// convert the time integer into a more readable format
	private void convertTime() {
		if(_time == 0) {
			_readableTime = "12:00 AM";
		}
		else if(_time < 12) {
			_readableTime = _time + ":00 AM";
		}
		else if(_time == 12) {
			_readableTime = "12:00 PM";
		}
		else if(_time < 24){
			_readableTime = (_time - 12) + ":00 PM";
		}
		else {
			_readableTime = "Sometime today";
		}
	}
	
	// return the event data in a format used by the schedule file
	public String toString() {
		return _time + ";" + _type + ";" + _location;
	}
	
	// return the event data in a format that the user can easily read
	public String toReadableString() {
		return _readableTime + ": " + _type + " at " + _location;
	}
	
}
