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
		input.close();
	}
	
}
