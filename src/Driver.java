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
			// task 3
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
			System.out.println("Would you like to (1) choose teams, or (2) generate two random teams of 5?");
			String _teamOption = _input.nextLine();
			if (_teamOption.equals("1")) {
				// task 6
			}
			else {
				System.out.println("Randomly generating teams of 5...");
				// task 7
			}
			// task 9 ("if you want to switch up the teams, do something here")
			// task 8 ("when you finish playing, input the final score")
		}
		else if(_option.equals("4")) {
			// task 10
		}
		else if(_option.equals("5")) {
			// task 11
		}
		
		System.out.println("Thank you for visiting! If you have more concerns, please run the program again.");
		_input.close();
	}
}
