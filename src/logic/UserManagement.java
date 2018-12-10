package logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class UserManagement {
	public ArrayList<User> userList;
	public String inputFile = "assets/score.txt";
	
	public UserManagement() {
		userList = new ArrayList<User>();
		readInput();
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
						User user = new User(name, score);
						userList.add(user);
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
		Collections.sort(userList);
		Collections.reverse(userList);
		for(int i = 0;i < 5;i++) {
			Top5.add(userList.get(i));
		}
		return Top5;
	}
}
