package controller;

import java.util.ArrayList;
import java.util.Random;

import models.Shop;
import models.User;

public class UserManager {

	public static UserManager instance = new UserManager();
	private ArrayList<User> users = new ArrayList<>();
	
	private UserManager() {}
	
	public int login() {
		System.out.print("id: ");
		String id = Shop.scan.next();
		System.out.print("pw: ");
		String pw = Shop.scan.next();
		
		
		for(int i=0; i<this.users.size(); i++) {
			if(this.users.get(i).getId().equals(id) && this.users.get(i).getPw().equals(pw)) {
				System.out.println("로그인 성공");
				return i;
			}
		}
		System.out.println("id 혹은 pw를 확인해주세요.");
		return -1;
	}
	public void addUser() {
		System.out.print("id: ");
		String id = Shop.scan.next();
		System.out.print("pw: ");
		String pw = Shop.scan.next();
		System.out.print("name: ");
		String name = Shop.scan.next();
		
		boolean check = false;
		for(int i=0; i<this.users.size(); i++) {
			if(this.users.get(i).getId().equals(id)) {
				check = true;
			}
		}
		if(!check) {
			User user = new User(randomCode(), id, pw, name);
			this.users.add(user);
			System.out.println("회원가입 성공");
		}
	}
	public int randomCode() {
		Random rand = new Random();
		
		while(true) {
			int rCode = rand.nextInt(8999)+1000;
			
			boolean check = false;
			for(int i=0; i<this.users.size(); i++) {
				if(rCode == this.users.get(i).getUserCode()) {
					check = true;
				}
			}
			if(!check) {
				return rCode;
			}
		}
		
	}
	public void deleteUser() {
		System.out.print("탈퇴를 진행하려면 pw를 입력하세요 :");
		String pw = Shop.scan.next();
		
		if(this.users.get(Shop.log).getPw().equals(pw)) {
			User temp = this.users.get(Shop.log);
			this.users.remove(temp);
			Shop.log = -1;
			System.out.println("회원 탈퇴 성공");
		}
	}
	public User getUser(int index) {
		return this.users.get(index);
	}
}
