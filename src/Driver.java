import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {
		Schedule schedule = new Schedule();
		System.out.println(schedule);
		System.out.println("Would you like to RSVP for an event?");
		Scanner _input= new Scanner(System.in);
		String _userChoice = _input.nextLine();
		if(_userChoice.equalsIgnoreCase("Yes")) {
			System.out.println("Please enter the event you would like to RSVP for in the order it appears in the schedule. Ex: 0, 1, 2...");
			int _eventChoice = _input.nextInt();
			Event _chosenEvent = schedule.getEvent(_eventChoice);
			schedule.reserveEvent(_chosenEvent);
		} else {

		}
	}
}
