import java.util.Scanner;
public class Driver {
	
	public static void main(String[] args) {
		Schedule schedule = new Schedule();
		System.out.println(schedule);
		String[] _arr = new String[10];
		Event.randomTeams(players(_arr));
	}
	
	public static String[] players(String[] _arr) {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Please enter the name of the 10 players");
		for (int i = 0; i < 10;i++) {
			_arr[i] = myScanner.nextLine();
		}
		return _arr;
	}
}
