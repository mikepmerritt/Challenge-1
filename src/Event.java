
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
	// setting up random teams
	public static void randomTeams(String[] _arr) {
		String[] _teamOneSize = new String[5];
		String[] _teamTwoSize = new String[5];
		int _teamOneIndex = 0;
        int _teamTwoIndex = 0;

		int i = 0;
		 while (_teamOneIndex < 5 && _teamTwoIndex < 5) {
			 double _result = Math.random();
			 if (_result < .5) {
				 System.out.println("Team 1");
				 _teamOneSize[_teamOneIndex] = _arr[i];
				 _teamOneIndex++;
			 }
			 else {
				 System.out.println("Team 2");
				 _teamTwoSize[_teamTwoIndex] = _arr[i];
				 _teamTwoIndex++;
			 }
			 i++;
		 }
	        
		 if (_teamOneIndex == 5) {
			 for (int j = i; j < 10; j++) {
				 _teamTwoSize[_teamTwoIndex] = _arr[j];
	             _teamTwoIndex++;
			 }
	     	}
		 else {
			 for (int j = i; j < 10; j++) {
				 _teamOneSize[_teamOneIndex] = _arr[j];
				 _teamOneIndex++;
			 }
	     	}
	        
	     	System.out.println("Team 1");
	     	for(int t1 = 0; t1 < _teamOneSize.length; t1++) {
	     		System.out.println(_teamOneSize[t1]);
	        }
	        System.out.println("Team 2");
	        for(int t2 = 0; t2 < _teamTwoSize.length; t2++) {
	            System.out.println(_teamTwoSize[t2]);
	        }
		}
}
