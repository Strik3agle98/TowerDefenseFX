package application;

import java.util.ArrayList;
import java.util.Collections;
public class Data{
	ArrayList<User> users;
	public Data(ArrayList<User> u) {
		users = u;
	}
	public void addUser(User u) {
		users.add(u);
	}
	public boolean removeUser(User u) {
		boolean con = false;
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getName().equals(u.getName())) {
				users.remove(i);
				con = true;
			}
		}
		return con;
	}
	public void sortUserByScore() {
		User.setMode(1);
		Collections.sort(users);
	}
	public void sortUserByAlphabet() {
		User.setMode(2);
		Collections.sort(users);
	}
}
