import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Main {
	public static void main(String args[]) throws IOException, InterruptedException, ParseException{
		Movie test = new Movie(); 
		test.settingUserMovie();
		parse1(test.response.body());
	}
	
	//Parse per 1 search
	public static void parse1(String body) throws ParseException {
		JSONParser parser = new JSONParser();
		Object o = parser.parse(body);
		JSONObject jObject = (JSONObject)o;
		JSONArray jArray = (JSONArray) jObject.get("results");
		
		String movieName = "";
		ArrayList<String> movieStream = new ArrayList();
		
		for(int i = 0;i < jArray.size();i++) {
				MovieEntry addMovie;
			
				JSONObject jObject1 = (JSONObject) jArray.get(i);
				
				movieName = (String) jObject1.get("name");
				
				JSONArray jArray2 = (JSONArray) jObject1.get("locations");
					for(Object n:jArray2) {
						JSONObject jObject3 = (JSONObject)n;
						String name = (String) jObject3.get("display_name");
						movieStream.add(name);
					}
					addMovie = new MovieEntry(movieName, movieStream);
					movieStream.clear();
			}
		}
	}
