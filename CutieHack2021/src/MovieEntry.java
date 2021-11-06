import java.util.ArrayList;

public class MovieEntry {

	String movieName;
	ArrayList<String> services;
	
	MovieEntry(String name, ArrayList<String> streamList, String icon) {
		movieName = name;
		services = streamList;
		
		System.out.println(name + " available on:");
		for(int i = 0;i < streamList.size();i++) {
			System.out.println(streamList.get(i));
		}
		System.out.println(icon);
		System.out.println("\n");
	}
	
}
