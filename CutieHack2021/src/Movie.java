import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;  
public class Movie {
	String user_m;
	HttpRequest request;
	HttpResponse<String> response;
	public void settingUserMovie() throws IOException, InterruptedException 
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter in the movie or TV Show you would like to search");
		user_m = sc.nextLine(); 
		setUserApi();
	}
	public void setUserMovie(String Program_s) throws IOException, InterruptedException 
	{ 
		user_m = Program_s;
		setUserApi();
	}
	public String getUserMovie() 
	{ 
		return user_m;
	}
	private void setUserApi() throws IOException, InterruptedException 
	{ 
		int temp, length = user_m.length();
		while (user_m.contains(" "))
		{ 
			temp = user_m.indexOf(" ");
			user_m = user_m.substring(0, temp) + "%20" + user_m.substring(temp + 1, length);
			length = user_m.length();
		}
		request = HttpRequest.newBuilder()
				.uri(URI.create("https://utelly-tv-shows-and-movies-availability-v1.p.rapidapi.com/lookup?term=" + user_m + "&country=us"))
				.header("x-rapidapi-host", "utelly-tv-shows-and-movies-availability-v1.p.rapidapi.com")
				.header("x-rapidapi-key", "99733d641cmshb68877f62552883p18b4a8jsna783d2c52835")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build(); 
		 response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
	}
}
