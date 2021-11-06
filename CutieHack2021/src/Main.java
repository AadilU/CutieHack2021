import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
	public static void main(String args[]) throws IOException, InterruptedException{
		Movie test = new Movie(); 
		test.settingUserMovie();
		System.out.println(test.response.body());
	}
}
