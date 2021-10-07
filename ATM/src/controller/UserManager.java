package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import models.Bank;
import models.User;

public class UserManager {
	
	public static UserManager instance = new UserManager();
	
	
	private UserManager() {}
	//users : 중앙 (총) 데이터
	private ArrayList<User> users = new ArrayList<>();
	// 가입
	public void printUser() {
		for(int i=0; i<users.size(); i++) {
			System.out.println(users.get(i).toString());
		}
	}
	public void joinUser() {
		System.out.print("id: ");
		String id = Bank.scan.next();
		System.out.print("pw: ");
		String pw = Bank.scan.next();
		System.out.print("name: ");
		String name = Bank.scan.next();
		
		
		User newUser = new User(randomCode(), id, pw, name);
		this.users.add(newUser);
	}
	public int randomCode() {
		Random rand = new Random();
		//중복되지않는 유저코드
		int rCode = rand.nextInt(8999)+1000;
		
		boolean check = false;
		for(int i=0; i<users.size();i++) {
			if(rCode == users.get(i).getUserCode()) {
				check = true;
			}
		}
		return rCode;

				
	}
	public int login() {
		System.out.print("id: ");
		String id = Bank.scan.next();
		System.out.print("pw: ");
		String pw = Bank.scan.next();
				
		for(int i=0; i<this.users.size(); i++) {
			if(users.get(i).getId().equals(id) && users.get(i).getPw().equals(pw)) {
				return i;
				
			}
		}
		return  -1;
	}
	public void removeUser(int log) {
		this.users.remove(log);
	}
	public void addAccount(int log) {
		
	}
	
	
	
}
