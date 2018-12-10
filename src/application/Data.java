package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import logic.NullNameException;
import logic.User;
public class Data{
	private ArrayList<User> users;
	private String inputFile = "assets/score.txt";
	private User user;
	public Data(ArrayList<User> u) {
		users = u;
		readInput();
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
	
	public void readInput() {
		boolean readingEmployeeList = false;
		File file = null;
		BufferedReader fileReader = null;
		String thisLine = null;
		try {
			file = new File(inputFile);
			fileReader = new BufferedReader(new FileReader(file));
			while ((thisLine = fileReader.readLine()) != null) {
				if (thisLine.trim().equals("---Player List---")) {
					readingEmployeeList = true;
					continue;
				} else {
					if (readingEmployeeList) {
						String[] info = thisLine.split(",");
						
						String name = info[0].trim();
						int score = Integer.parseInt(info[1].trim());
						try {
							user = new User(name, score);
						} catch (NullNameException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						users.add(user);
					}
				}
			}
		} 
		catch (IOException e) {
		    e.printStackTrace();
		} 
		finally {
		    try {
		        fileReader.close();
		    } 
		    catch (IOException e) {
		        e.printStackTrace();
		    }
		}
	}
	
	public ArrayList<User> getTop5(){
		ArrayList<User> Top5 = new ArrayList<User>();
		Collections.sort(users);
		Collections.reverse(users);
		for(int i = 0;i < 5;i++) {
			Top5.add(users.get(i));
		}
		return Top5;
	}
	
	public void updateFile() {
		try {
			FileWriter writer = new FileWriter(new File("assets/score.txt"));
			writer.write("---Player List---\n");
			for(User u: users) {
				writer.write(String.format("%s, %s\n", u.getName(), Integer.toString(u.getMaxScore())));
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//getter and setter
	public ArrayList<User> getUsers(){
		return users;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
}
