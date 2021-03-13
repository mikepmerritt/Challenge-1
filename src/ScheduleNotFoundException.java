import java.io.FileNotFoundException;

public class ScheduleNotFoundException extends FileNotFoundException {
	public ScheduleNotFoundException(String s) {
		super(s);
	}
}
