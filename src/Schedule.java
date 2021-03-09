import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Schedule {
	
	private File _scheduleFile;
	private String _date;
	private ArrayList<Event> _events;
	
	// constructs a schedule from the file "Schedule.txt"
	// "Schedule.txt" should include a date line as a header and a line for each event
	public Schedule() {
		findSchedule();
		_events = new ArrayList<Event>();
		try {
			Scanner fileScan = new Scanner(_scheduleFile);
			_date = fileScan.nextLine();
			while(fileScan.hasNextLine()) {
				_events.add(new Event(fileScan.nextLine()));
			}
		}
		catch (FileNotFoundException e) {
			// do nothing - there aren't any events yet as there is no file
		}
	}
	
	private void findSchedule() {
		File currentDirectory = new File(".");
		if (currentDirectory.getAbsolutePath().contains("\\src") || currentDirectory.getAbsolutePath().contains("/src")) {
			_scheduleFile = new File("../Schedule.txt");
		}
		else {
			_scheduleFile = new File("Schedule.txt");
		}
	}
	
	// return the entire schedule in a form the user can read
	public String toString() {
		String schedule = _date + "\n";
		for(int event = 0; event < _events.size(); event++) {
			schedule += _events.get(event).toReadableString();
		}
		return schedule;
	}
	
}
