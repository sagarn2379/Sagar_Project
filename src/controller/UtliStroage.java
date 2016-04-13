package controller;

import java.util.ArrayList;
import java.util.List;

import model.User;

public class UtliStroage {

	 static List<User> userList = new ArrayList<User>();

	
	public List<User> getUserList() {
		if(UtliStroage.userList == null){
			UtliStroage.userList = new ArrayList<User>();
			addAdmintoList();
		}
		return userList;
	}

	public void setUserList(List<User> userList) {
		
		UtliStroage.userList = userList;
	}
	
	public static void addAdmintoList(){
		User admin = new User("admin", null, "a@g.c", "111111111", "a");
		if(UtliStroage.userList.size() == 0)
			UtliStroage.userList.add(admin); 
		
	}
	
}
