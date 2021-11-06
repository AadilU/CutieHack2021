import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Main {
	
	public static ArrayList<MovieEntry> movies = new ArrayList<MovieEntry>();
	
	public static void main(String args[]) throws IOException, InterruptedException, ParseException{
		Movie test = new Movie(); 
		test.settingUserMovie();
		parse1(test.response.body());
	}
	
	//Parse per 1 search
	public static void parse1(String body) throws ParseException{
		JSONParser parser = new JSONParser();
		Object o = parser.parse(body);
		JSONObject jObject = (JSONObject)o;
		JSONArray jArray = null;
		try
		{
		jArray = (JSONArray) jObject.get("results");
		}
		catch(ClassCastException e) {
			MovieEntry blankEntry = new MovieEntry("", new ArrayList(), "");
			return;
		}
		
		String movieName = "";
		String movieIcon = "";
		ArrayList<String> movieStream = new ArrayList();
		
		for(int i = 0;i < jArray.size();i++) {
				MovieEntry addMovie;
			
				JSONObject jObject1 = (JSONObject) jArray.get(i);
				
				movieName = (String) jObject1.get("name");
				movieIcon = (String) jObject1.get("picture");
				
				JSONArray jArray2 = (JSONArray) jObject1.get("locations");
					for(Object n:jArray2) {
						JSONObject jObject3 = (JSONObject)n;
						String name = (String) jObject3.get("display_name");
						String url = (String) jObject3.get("url");
						movieStream.add(name + ": " + url);
					}
					addMovie = new MovieEntry(movieName, movieStream, movieIcon);
					movieStream.clear();
					movies.add(addMovie);
			}
		}
	}
