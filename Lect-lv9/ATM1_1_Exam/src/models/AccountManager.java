package models;

import java.util.ArrayList;
import java.util.Random;

import controller.Account;
import controller.Bank;

public class AccountManager {

	private UserManager um = UserManager.instance;
	public static AccountManager instance = new AccountManager();
	private ArrayList<Account> accs = new ArrayList<>();
	
	private AccountManager() {}
	
	public void createAcc() {
		
		int userCode = um.get(Bank.log).getUserCode();
		int cnt = um.get(Bank.log).getAccCnt();
		String userName = um.get(Bank.log).getName();
		
		
		if(cnt < 3) {			
			
				Account newAcc = new Account(randomCode(), userCode, userName );
				this.accs.add(newAcc);
				um.get(Bank.log).setAccCnt(++cnt);
				System.out.println("���� ���� �Ϸ�");		
			
		}
		else {
			System.out.println("���� ���� �ѵ� �ʰ�");
		}
	}
	public int randomCode() {
		Random rand = new Random();
		
		int rCode = rand.nextInt(8999)+1000;
		while(true) {
			
			boolean check = false;
			for(int i=0; i<this.accs.size(); i++) {
				if(rCode == this.accs.get(i).getAccCode()) {
					check = true;
				}
			}
			if(!check) {
				return rCode;
			}
		}
		
	}
	public void deleteAcc() {
		printAccs();		
		
		System.out.println("������ ���¼���: ");
		String input = Bank.scan.next();
		int delIdx = findIndex(input); // +1;
		
		int cnt = um.get(Bank.log).getAccCnt();
		if(delIdx != -1) {
			this.accs.remove(delIdx);
			um.get(Bank.log).setAccCnt(--cnt);
			System.out.println("���� ���� �Ϸ�");
		}
		else {
			System.out.println("������ ���°� �����ϴ�.");
		}
		
	}
	public int findIndex(String input) {
		int index = -1;
		
		try {
			int userCode = um.get(Bank.log).getUserCode();
			int cnt = um.get(Bank.log).getAccCnt();
			int num = Integer.parseInt(input)-1;
			
			if(num >= 0 && num < cnt) {
				int tempCnt = 0;
				
				for(int i=0; i<this.accs.size(); i++) {
					if(userCode == this.accs.get(i).getUserCode()) {
						index = i;
						if(num == tempCnt) {	
							break;
						}
						tempCnt++;
					}
				}
				
			}
			
		}
		catch(Exception e) {
			
		}
		
		return index;
	}
	public void inputCash() {
		printAccs();
		System.out.print("�Ա��� ���¼���: ");
		String input = Bank.scan.next();
		int index = findIndex(input);
		
		if(index != -1) {
			Account temp = this.accs.get(index);
			int balance = temp.getMoney();
			System.out.print("�Ա��� �ݾ� �Է�: ");
			int cash = Bank.scan.nextInt();
			
			if(cash > 0 ) {
				balance += cash;
				temp.setMoney(balance);
				System.out.println("�ԱݿϷ�");
			}
		}
	}
	public void withdraw() {
		printAccs();
		System.out.print("����� ���¼���: ");
		String input = Bank.scan.next();
		int index = findIndex(input);
		
		if(index != -1) {
			Account temp = this.accs.get(index);
			int balance = temp.getMoney();
			System.out.print("����� �ݾ� �Է�: ");
			int outCash = Bank.scan.nextInt();
			
			if(outCash > 0 && outCash <= balance) {
				balance -= outCash;
				temp.setMoney(balance);
				System.out.println("��� �Ϸ�");
			}
			
		}
	}
	public void sendMoney() {
		printAccs();
		System.out.print("��ü�� ���� ����: ");
		String input = Bank.scan.next();
		int index = findIndex(input);
		
		if(index != -1) {
			printAllData();
			System.out.println("���� ���¹�ȣ 4�ڸ� �Է�: ");
			int acc = Bank.scan.nextInt();
			
			int check = -1;
			for(int i=0; i<this.accs.size(); i++) {
				if(acc == this.accs.get(i).getAccCode()) {
					check = i;
				}
			}
			if(check == -1) {
				System.out.println("���� ���¹�ȣ �Դϴ�.");
			}
			else {
				Account temp = this.accs.get(index);
				int balance = temp.getMoney();
				Account other = this.accs.get(check);
				int otherbalance = other.getMoney();
				System.out.print("��ü�� �ݾ�: ");
				int sendMoney = Bank.scan.nextInt();
				
				if(sendMoney > 0 && sendMoney <= balance) {
					balance -= sendMoney;
					temp.setMoney(balance);
					otherbalance += sendMoney;
					other.setMoney(otherbalance);
					System.out.println("��ü ����");
				}
			}
			
		}
	}
	public void printAccs() {
		int userCode = um.get(Bank.log).getUserCode();
		int n= 1;
		for(int i=0; i<this.accs.size(); i++) {
			if(userCode == this.accs.get(i).getUserCode()) {
				System.out.print(n+") ");
				System.out.print(this.accs.get(i)+"\n");
				n++;
			}
			
		}
		System.out.println();
	}
	public Account getAcc(int index) {
		return this.accs.get(index);
	}
	public void printAllData() {
		for(int i=0; i<this.accs.size(); i++) {
			System.out.print(i+1+") ");
			System.out.print(this.accs.get(i)+"\n");
		}
		System.out.println();
	}
	public int getAccsSize() {
		return this.accs.size();
	}
	public void loadAccount(Account acc) {
		this.accs.add(acc);
	}
	
	
	
}
