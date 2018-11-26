package application;

public class User {
	private String name;
	private static int id = 1;
	
	public User(String name) {
		this.name = name;
		id++;
	}
}
