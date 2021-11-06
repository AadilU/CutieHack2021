import java.io.IOException;

public class Main {
	public static void main(String args[]) throws IOException, InterruptedException{
		Movie test = new Movie(); 
		test.settingUserMovie();
		System.out.println(test.response.body());
	}
}
