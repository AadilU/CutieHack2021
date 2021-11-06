import java.util.*;  
public class Movie {
	public String getUserMovie() 
	{
		String user_m;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter in the movie or TV Show you would like to search");
		user_m = sc.nextLine();
		return user_m; 
		
	}
}
