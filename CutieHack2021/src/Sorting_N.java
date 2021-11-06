import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Sorting_N {
	public void main(String[] args) throws IOException, InterruptedException {
		int i = 0;
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://utelly-tv-shows-and-movies-availability-v1.p.rapidapi.com/lookup?term=Attack%20on%20Titan&country=us"))
				.header("x-rapidapi-host", "utelly-tv-shows-and-movies-availability-v1.p.rapidapi.com")
				.header("x-rapidapi-key", "99733d641cmshb68877f62552883p18b4a8jsna783d2c52835")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		String S = response.body();  
		System.out.println(response.body());
		System.out.println("HEY");
	}

}

