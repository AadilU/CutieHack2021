import java.io.IOException;
import org.json.simple.*;

public class Main {
	public static void main(String args[]) throws IOException, InterruptedException{
		Movie test = new Movie(); 
		test.settingUserMovie();
		System.out.println(test.response.body());
	}
}
