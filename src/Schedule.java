import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Schedule {
	
	private File _scheduleFile;
	private String _date;
	private ArrayList<Event> _events;
	
	// constructs a schedule from the file "Schedule.txt"
	// "Schedule.txt" should include a date line as a header and a line for each event
	public Schedule() {
		findSchedule("Schedule.txt");
		Scanner fileScan;
		PrintWriter output;
		_events = new ArrayList<Event>();
		try {
			fileScan = new Scanner(_scheduleFile);
			_date = fileScan.nextLine();
			while(fileScan.hasNextLine()) {
				_events.add(new Event(fileScan.nextLine()));
			}
			fileScan.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Schedule.txt could not be found. Generating a new one.");
			try {
				output = new PrintWriter(new FileWriter("Schedule.txt"));
				output.println("Monday, March 1");
				output.println("13;Basketball;Gym");
				output.close();
				
				findSchedule("Schedule.txt");
				fileScan = new Scanner(_scheduleFile);
				_date = fileScan.nextLine();
				while(fileScan.hasNextLine()) {
					_events.add(new Event(fileScan.nextLine()));
				}
				fileScan.close();
			}
			catch (IOException e2) {
				System.out.println("An error has occured. Please create and add a new Schedule.txt manually.");
				e2.printStackTrace();
				System.exit(1);
			}
		}
	}
	
	// constructs a schedule from the file specified by customFileName
	// if the file doesn't exist, throws a ScheduleNotFoundException for the program to handle elsewhere
	public Schedule(String customFileName) throws ScheduleNotFoundException {
		findSchedule(customFileName);
		Scanner fileScan;
		_events = new ArrayList<Event>();
		try {
			fileScan = new Scanner(_scheduleFile);
			_date = fileScan.nextLine();
			while(fileScan.hasNextLine()) {
				_events.add(new Event(fileScan.nextLine()));
			}
			fileScan.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("The file " + customFileName + " could not be found. Using the default schedule instead.");
			throw new ScheduleNotFoundException("\"" + customFileName + "\" not found");
		}
	}
	
	// used to locate the schedule file in the project
	private void findSchedule(String fileName) {
		File currentDirectory = new File(".");
		if (currentDirectory.getAbsolutePath().contains("\\src") || currentDirectory.getAbsolutePath().contains("/src")) {
			_scheduleFile = new File("../" + fileName);
		}
		else {
			_scheduleFile = new File(fileName);
		}
	}
	
	// return the entire schedule in a form the user can read
	public String toString() {
		String schedule = _date + "\n";
		for(int event = 0; event < _events.size(); event++) {
			schedule += _events.get(event).toReadableString() + "\n";
		}
		return schedule;
	}
	
}
