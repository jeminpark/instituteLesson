package models;

import java.util.ArrayList;
import java.util.Random;

import controller.Bank;
import controller.User;

public class UserManager {

	public static UserManager instance = new UserManager();
	private ArrayList<User> users = new ArrayList<>();
	
	private UserManager() {}
	
	public void setAdmin() {
		User temp = new User(9999, "admin", "0000", "관리자");
		this.users.add(temp);
	}
	public void addUser() {
		System.out.print("id: ");
		String id = Bank.scan.next();
		System.out.print("pw: ");
		String pw = Bank.scan.next();
		System.out.print("name: ");
		String name = Bank.scan.next();
		
		boolean check = false;
		for(int i=0; i<this.users.size(); i++) {
			if(this.users.get(i).getId().equals(id)) {
				check = true;
			}
		}
		if(!check) {
			User newUser = new User(randomCode(), id, pw, name);
			this.users.add(newUser);
			System.out.println("회원가입 성공");
		}
		else {
			System.out.println("중복된 아이디가 있습니다.");
		}
		
	}
	public int randomCode() {
		Random rand = new Random();
		
		int rCode = rand.nextInt(8999)+1000;
		while(true) {
			
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
	public int login() {
		System.out.print("id: ");
		String id = Bank.scan.next();
		System.out.print("pw: ");
		String pw = Bank.scan.next();
		
		for(int i=0; i<this.users.size(); i++) {
			if(this.users.get(i).getId().equals(id) && this.users.get(i).getPw().equals(pw)) {
				System.out.println("로그인 성공");
				return i;
				
			}
		}
		System.out.println("id 혹은 pw를 확인해주세요.");
		return -1;
	
	}
	public void deleteUser() {
		System.out.println("Pw를 입력하세요.");
		String pw = Bank.scan.next();
		
		int check = -1;
		for(int i=0; i<this.users.size(); i++) {
			if(this.users.get(i).getPw().equals(pw)) {
				check = i;
				
			}
		}
		if(check == -1) {
			System.out.println("pw가 일치하지 않습니다.");
		}
		else {
			this.users.remove(check);
			System.out.println("회원 탈퇴 성공");
			Bank.log = -1;
		}
	}
	public User get(int index) {
		return this.users.get(index);
	}
	public void printAllUser() {
		for(int i=0; i<this.users.size(); i++) {
			System.out.println(i+1+") ");
			System.out.println(this.users.get(i)+"\n");
			
		}
		System.out.println();
	}
}
