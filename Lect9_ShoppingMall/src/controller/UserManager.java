package controller;

import java.util.ArrayList;
import java.util.Random;

import models.Shop;
import models.User;

public class UserManager {

	public static UserManager instance = new UserManager();
	
	
	private UserManager() {}
	
	public void setAdmin() {
		User admin = new User(9999, "admin", "0000","관리자" );
	}
	
	private ArrayList<User> users = new ArrayList<>();
	
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
			System.out.println("회원가입성공");
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
			if(users.get(i).getId().equals(id) && users.get(i).getPw().equals(pw)) {
				System.out.println("로그인성공");
				return i;
			}
		}
		return -1;
		
	}
	
}
