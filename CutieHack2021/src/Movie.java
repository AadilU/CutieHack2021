import java.util.*;  
public class Movie {
	String user_m;
	public void setUserMovie() 
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter in the movie or TV Show you would like to search");
		user_m = sc.nextLine(); 
		
	}
	public String getUserMovie() 
	{ 
		return user_m;
	}
}
