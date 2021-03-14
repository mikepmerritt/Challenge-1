import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {
		Scanner _input = new Scanner(System.in);
		Schedule _schedule;
		
		// get and print schedule file
		System.out.println("Welcome! Do you have a custom schedule? (yes/no)");
		String _response = _input.nextLine();
		if(_response.equalsIgnoreCase("yes")) {
			System.out.println("What is the name of the custom schedule file?");
			String _customFileName = _input.nextLine();
			try {
				_schedule = new Schedule(_customFileName);
			}
			catch (ScheduleNotFoundException e) {
				_schedule = new Schedule();
			}
		}
		else if (!_response.equalsIgnoreCase("no")) {
			System.out.println("Sorry, that input was invalid. Using the default schedule.");
			_schedule = new Schedule();
		}
		else {
			_schedule = new Schedule();
		}
		System.out.println("Here is the schedule:");
		System.out.println(_schedule);
		
		System.out.println("Please type the number for the option you would like to do.");
		System.out.println("1. Schedule reservation");
		System.out.println("2. RSVP to an event or rent equipment");
		System.out.println("3. Play a sport");
		System.out.println("4. Schedule another event");
		System.out.println("5. Get a membership");
		String _option = _input.nextLine();
		
		if(_option.equals("1")) {
			addEvent(_input, _schedule, "Gym");
		}
		else if(_option.equals("2")) {
			System.out.println("Would you like to RSVP for an event?");
			String _userChoice = _input.nextLine();
			if(_userChoice.equalsIgnoreCase("Yes")) {
				System.out.println("Please enter the event you would like to RSVP for in the order it appears in the schedule. Ex: 0, 1, 2...");
				int _eventChoice = _input.nextInt();
				try {
					Event _chosenEvent = _schedule.getEvent(_eventChoice);
					_schedule.reserveEvent(_chosenEvent);
				}
				catch (IndexOutOfBoundsException e) {
					System.out.println("Sorry, that input was invalid.");
				}
			} else {

			}
			// task 12
		}
		else if(_option.equals("3")) {
			// task 5
			SportsArray _sportArray = new SportsArray();
			System.out.println(_sportArray.toString());
			System.out.println("Please enter the name of the sport you would like to play?");
			String _choice = _input.nextLine();
			String _sportChoice = _choice.toLowerCase();
			Sport _sport = new Sport(_sportChoice);
			System.out.println("You have selected to play: " + _sport);
			System.out.println("Would you like to (1) choose teams, or (2) generate two random teams of 5?");
			String _teamOption = _input.nextLine();
			if (_teamOption.equals("1")) {
				// task 6
			}
			else {
				System.out.println("Randomly generating teams of 5...");
				String[] _arr = new String[10];
				Event.randomTeams(players(_arr));
			}
			// task 9 ("if you want to switch up the teams, do something here")
			midGameSubs();
			// task 8 ("when you finish playing, input the final score")
			gameScore();
		}
		else if(_option.equals("4")) {
			// task 10
			String _type, _location;
			int _hour;
			try {
				PrintWriter output = new PrintWriter(new FileOutputStream("Schedule.txt", true));
				  System.out.println("Please type in the hour you'd like to schedule in military time.");
				_hour  = _input.nextInt();
				_input.nextLine();
				while (_hour < 0 || _hour > 24)  {
					System.out.println("Please type in the hour you'd like to schedule in military time.");
					_hour  = _input.nextInt();
					_input.nextLine();
				} 
				System.out.println("Please type in the event you'd like to schedule.");
				_type = _input.nextLine();
				System.out.println("Please type in the area you'd like to reserve.");
				_location = _input.nextLine();
				Event _newEvent = new Event(_hour, _type, _location);
				output.println(_newEvent);
				System.out.println("Thanks, we have now updated the schedule!");
				//output.println("17;Basketball;Gym");
				output.close();
	        }
	        catch (FileNotFoundException e) {
	            System.out.println("The schedule file could not be found.");
	        }
		}
		else if(_option.equals("5")) {
			// task 11
		}
		
		System.out.println("Thank you for visiting! If you have more concerns, please run the program again.");
		_input.close();
	}
	
	// schedules a reservation
	// if successful, the new event will be added to the schedule file
	// input should be _input from main, schedule should be _schedule from main, and location should be where the event is
	public static void addEvent(Scanner input, Schedule schedule, String location) {
		
		String formattedOutput = "";
		
		System.out.println("What hour would you like to reserve the " + location + " for? (1-12)");
		int _timeChoice;
		
		try {
			// get hour
			_timeChoice = Integer.parseInt(input.nextLine());
			if(_timeChoice < 1 || _timeChoice > 12) {
				throw new NumberFormatException(); // bad time, exit with failure
			}
			
			// get time of day
			System.out.println("Would you like the reservation at " + _timeChoice + " AM or " + _timeChoice + " PM? (AM/PM)");
			String _timeOfDay = input.nextLine();
			if (_timeOfDay.equals("AM")) {
				if(_timeChoice == 12) {
					formattedOutput += 0;
				}
				else {
					formattedOutput += _timeChoice;
				}
			}
			else if (_timeOfDay.equals("PM")) {
				if(_timeChoice == 12) {
					formattedOutput += _timeChoice;
				}
				else {
					formattedOutput += _timeChoice + 12;
				}
			}
			else {
				throw new NumberFormatException(); // bad time, exit with failure
			}
			
			// get sport
			System.out.println("What are you scheduling with this reservation? (example: \"Basketball\")");
			String _activity = input.nextLine();
			formattedOutput += ";" + _activity + ";" + location;
			
			// write to the file
			try {
				boolean conflict = false;
				Scanner searchForConflicts = new Scanner(schedule.getScheduleFile());
				searchForConflicts.nextLine(); // skip date
				while(searchForConflicts.hasNextLine()) {
					if(formattedOutput.substring(0, 2).equals(searchForConflicts.nextLine().substring(0, 2))) {
						conflict = true;
					}
				}
				if(!conflict) {
		            PrintWriter output = new PrintWriter(new FileOutputStream(schedule.getScheduleFile(), true));
		            output.println(formattedOutput);
		            output.close();
				}
				else {
					System.out.println("Unfortunately there is already an event scheduled at that time, so your event could not be scheduled.");
				}
	        }
	        catch (FileNotFoundException e) {
	            System.out.println("The schedule file could not be found.");
	        }
		}
		catch (NumberFormatException e) {
			System.out.println("An error occurred, most likely due to invalid input. Please run the program again to retry.");
		}
	}
	
	public static String[] players(String[] _arr) {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Please enter the name of the 10 players");
		for (int i = 0; i < 10;i++) {
			_arr[i] = myScanner.nextLine();
		}
		return _arr;
	}
	public static void gameScore() {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("How many points does Team 1 have?");
		int _teamOneScore = myScanner.nextInt();
		System.out.println("How many points does Team 2 have?");
		int _teamTwoScore = myScanner.nextInt();
		if (_teamOneScore > _teamTwoScore) {
			System.out.println("Team One Wins!");
		}
		else if (_teamOneScore < _teamTwoScore) {
			System.out.println("Team Two Wins!");
		}	
		else {
			System.out.println("The game ended as a tie!");
		}
	}
	public static void midGameSubs() {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Do you want to changed the made up teams?");
		String _answer = myScanner.nextLine();
		if (_answer.equalsIgnoreCase("Yes")) {
			Event.randomTeams(players(_arr));
		}
		else {
			return;
		}
	}
}

