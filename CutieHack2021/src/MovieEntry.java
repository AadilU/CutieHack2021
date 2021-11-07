import java.util.ArrayList;

public class MovieEntry {

	String movieName;
	ArrayList<String> services;
	
	MovieEntry(String name, ArrayList<String> movieStream, String icon) {
		movieName = name;
		services = new ArrayList<String>();
		
		System.out.println(name + " available on:");
		for(int i = 0;i < movieStream.size();i++) {
			services.add(movieStream.get(i));
		}
		System.out.println(icon);
		System.out.println("\n");
	}
	
}
