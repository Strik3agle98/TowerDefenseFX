package application;


public class User implements Comparable<User>{
	private String name;
	private static int id = 1;
	private static int mode = 1;
	private int userId;
	private int maxScore = 0;
	public User(String name) {
		this.name = name;
		this.userId = id++;
	}
	public int compareToByScore(User u) {
		if(this.maxScore == u.maxScore) {
			return this.name.compareTo(u.name);
		}
		else {
			return this.maxScore - u.maxScore;
		}
	}
	public int compareToByAlphabet(User u) {
		if(this.name.equals(u.name)) {
			return this.maxScore - u.maxScore;
		}
		return this.name.compareTo(u.name);
	}
	public int compareTo(User u) {
		switch(mode) {
			case 1: return compareToByScore(u);
			case 2: return compareToByAlphabet(u);
			default : return compareToByScore(u);
		}
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxScore() {
		return this.maxScore;
	}
	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}
	public int getId() {
		return this.userId;
	}
	public void setId(int id) {
		this.userId = id;
	}
	public static int getMode() {
		return mode;
	}
	public static void setMode(int m) {
		mode = m;
	}
}
