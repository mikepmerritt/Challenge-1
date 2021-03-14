import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Schedule schedule;
		
		System.out.println("Welcome! Do you have a custom schedule? (yes/no)");
		String response = input.nextLine();
		if(response.equalsIgnoreCase("yes")) {
			System.out.println("What is the name of the custom schedule file?");
			String customFileName = input.nextLine();
			try {
				schedule = new Schedule(customFileName);
			}
			catch (ScheduleNotFoundException e) {
				schedule = new Schedule();
			}
		}
		else if (!response.equalsIgnoreCase("no")) {
			System.out.println("Sorry, that input was invalid. Using the default schedule.");
			schedule = new Schedule();
		}
		else {
			schedule = new Schedule();
		}
		System.out.println("Here is the schedule:");
		System.out.println(schedule);

		System.out.println("Would you like to RSVP for an event?");
		String _userChoice = input.nextLine();
		if(_userChoice.equalsIgnoreCase("Yes")) {
			System.out.println("Please enter the event you would like to RSVP for in the order it appears in the schedule. Ex: 0, 1, 2...");
			int _eventChoice = input.nextInt();
			try {
				Event _chosenEvent = schedule.getEvent(_eventChoice);
				schedule.reserveEvent(_chosenEvent);
			}
			catch (IndexOutOfBoundsException e) {
				System.out.println("Sorry, that input was invalid.");
			}
		} else {

		}
		input.close();
	}
}
