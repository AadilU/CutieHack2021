import java.io.IOException;
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
	
	public static void parse1(String body) throws ParseException {
		JSONParser parser = new JSONParser();
		Object o = parser.parse(body);
		JSONObject jObject = (JSONObject)o;
		JSONArray jArray = (JSONArray) jObject.get("results");
		
		for(Object n:jArray) {
			JSONObject jNum = (JSONObject) n;
			String num = (String) jNum.get("id");
			System.out.println(num);
		}
	}
}
