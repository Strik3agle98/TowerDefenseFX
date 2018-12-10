package application;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import logic.User;

public class DataManager {
	private Data data;
	private ArrayList<User> users;
	private FileWriter fw;
	public DataManager(Data data) {
		this.data = data;
		users = data.users;
	}
	public boolean saveDataToTextFile() {
		try {
			fw = new FileWriter("assets/score.txt",true);
			for(int i = 0; i < users.size(); i++) {
				fw.write(users.get(i).getId() + ":" + users.get(i).getName() + ":" 
						+ users.get(i).getMaxScore() + "\n");
			}
			return true;
			
		} catch (IOException e) {
			System.out.println("File score.txt reading error occured...");
			return false;
		}
	}
	public void saveUserToTextFile() {
		
	}
}
