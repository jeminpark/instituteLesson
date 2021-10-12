package controll;

import java.util.ArrayList;
import java.util.Random;

import models.Bank;
import models.User;

public class UserManager {
	
	public static UserManager instance = new UserManager();
	
	private UserManager() {}
	
	public void setAdmin() {
		User admin = new User(9999, "admin", "0000", "관리자");
		this.users.add(admin);
	}
	
	private ArrayList<User> users = new ArrayList<>();
	
	public void joinUser() {
		System.out.print("id: ");
		String id = Bank.scan.next();
		System.out.print("pw: ");
		String pw = Bank.scan.next();
		System.out.print("name: ");
		String name = Bank.scan.next();
		
		boolean check = false;
		for(User user : this.users) {
			if(id.equals(user.getId())) {
				check = true;
			}
		}
		if(!check) {
			User newUser = new User(randomCode(), id, pw, name);
		}
		else {
			System.out.println("중복된 아이디입니다.");
		}
	}
	public int randomCode() {
		Random rand = new Random();
		
		while(true) {
			
			int rCode = rand.nextInt(8999)+1000;
			
			boolean check = false;
			for(User user : this.users) {
				if(rCode == user.getUserCode()) {
					check = true;
				}
			}
			if(!check) {
				return rCode;
				
			}
		}
		
	}
	public int login() {
		System.out.println("id: ");
		String id = Bank.scan.next();
		System.out.println("pw: ");
		String pw = Bank.scan.next();
		
		for(int i=0; i<this.users.size(); i++) {
			if(users.get(i).getId().equals(id) && users.get(i).getPw().equals(pw)) {
				return i;
			}
		}
		return -1;
	}
	public void printAllData() {
		for(User user : this.users) {
			System.out.println(user);
		}
	}
	public User getUser(int index) {
		return this.users.get(index);
	}
	public int getUsersSize() {
		return this.users.size();
	}
	public void addUser(User user) {
		this.users.add(user);
	}
}
