package controller;

import java.util.ArrayList;
import java.util.Random;

import models.Shop;
import models.User;

public class UserManager {

	public static UserManager instance = new UserManager();
	
	
	private UserManager() {}
	
	private ArrayList<User> users = new ArrayList<>();
	
	public void setAdmin() {
		User admin = new User(9999, "admin", "0000", "관리자");
		this.users.add(admin);
	}
	
	public void joinUser() {
		System.out.print("id: ");
		String id = Shop.scan.next();
		System.out.print("pw: ");
		String pw = Shop.scan.next();
		System.out.print("name: ");
		String name = Shop.scan.next();
		
		boolean check = false;
		for(User user : this.users) {
			if(id.equals(user.getId())) {
				check = true;
			}
		}
		if(!check) {
			User newUser = new User(randomCode(), id, pw, name);
			this.users.add(newUser);
			System.out.println("회원가입 성공");
		}
		else {
			System.out.println("중복되는 아이디가 있습니다.");
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
		System.out.print("id: ");
		String id = Shop.scan.next();
		System.out.print("pw: ");
		String pw = Shop.scan.next();
		
		for(int i=0; i<this.users.size(); i++) {
			
			if(this.users.get(i).getId().equals(id) && this.users.get(i).getPw().equals(pw)) {
				System.out.println("로그인성공");
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
	public int getUsersSize() {
		return this.users.size();
	}
	
}
