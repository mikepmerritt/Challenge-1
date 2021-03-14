import java.util.Scanner;
public class Driver {
	
	public static void main(String[] args) {
		Schedule schedule = new Schedule();
		System.out.println(schedule);
		String[] _arr = new Array[10];
		String[] _players = players();
	}
	
	public Array[] players(String[] _arr) {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Please enter the name of the 10 players");
		for (i = 0; i <= 10;i++) {
			_arr[i] = myScanner.readLine();
		}
		return _arr[];
	}
}
