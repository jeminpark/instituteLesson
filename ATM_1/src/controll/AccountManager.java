package controll;

import java.util.ArrayList;
import java.util.Random;

import models.Account;
import models.Bank;
import models.User;

public class AccountManager {
	
	private UserManager um = UserManager.instance;
	public static AccountManager instance = new AccountManager();
	
	private ArrayList<Account> Accs = new ArrayList<>();
	
	private User getUser(int log) {
		return um.getUser(log);
	}
	public void createAcc() {
		
		int userCode = getUser(Bank.log).getUserCode();
		
		int cnt = getUser(Bank.log).getAccCnt();
		if(cnt < 3) {
			this.Accs.add(new Account(randomCode(), userCode));
			getUser(Bank.log).setAccCnt(++cnt);
			System.out.println("계좌생성 완료");
		}
		else {
			System.out.println("최대계좌 개수를 초과했습니다.");
		}
	}
	public void deleteAcc() {
		printAcc();
		System.out.println("삭제할 계좌선택: ");
		
		String input = Bank.scan.next();
		int delIdx = findIndex(input);
	}
	private int findIndex(String input) {
		int index = -1;
		try {
			int userCode = getUser(Bank.log).getUserCode();
			int cnt = getUser(Bank.log).getAccCnt();
			
			int num = Integer.parseInt(input);
			
			if(num >= 0 && num < cnt) {
				
				int tempCnt = 0;
				for(int i=0; i<this.Accs.size(); i++) {
					if(userCode == this.Accs.get(i).getUserCode()) {
						index = i;
						tempCnt ++;
						if(tempCnt == num) {
							break;
						}
					}
				}
			}
		}
		catch(Exception e) {
			
		}
		return index;
	}
	public void inputMoney() {
		printAcc();
		System.out.print("입금할 계좌선택: ");
		
		String input = Bank.scan.next();
		int index = findIndex(input);
		
		if(index != -1) {
			Account temp = this.Accs.get(index);
			int balance = temp.getMoney();
			System.out.print("입금금액: ");
			int money = Bank.scan.nextInt();
			
			if(money > 0 ) {
				balance += money;
				temp.setMoney(money);
				System.out.printf("입금완료, 잔액: %d원", balance);
			}
		}
	}
	public void outMoney() {
		printAcc();
		System.out.print("출금할 계좌선택: ");
		
		String input = Bank.scan.next();
		int index = findIndex(input);
		
		if(index != -1) {
			Account temp = this.Accs.get(index);
			int balance = temp.getMoney();
			
			System.out.println("출금금액: ");
			int money = Bank.scan.nextInt();
			
			if(balance >= money) {
				balance -= money;
				temp.setMoney(balance);
				System.out.printf("출금완료, 잔액: %d 원",balance);
			}
		}
	}
	public void withdraw() {
		System.out.println("이체할 계좌번호: ");
		int target = Bank.scan.nextInt();
		
		int targetIdx = -1;
		for(int i=0; i<this.Accs.size(); i++) {
			if(target == this.Accs.get(i).getAccNum()) {
				targetIdx = i;
			}
		}
		printAcc();
		System.out.print("출금할 계좌선택: ");
		
		String input = Bank.scan.next();
		int index = findIndex(input);
		
		if(targetIdx != -1 && index != -1) {
			System.out.print("이체할금액: ");
			int money = Bank.scan.nextInt();
			
			Account temp = this.Accs.get(index);
			int balance = temp.getMoney();
			
			if(balance >= money) {
				balance -= money;
				temp.setMoney(balance);
				
				temp = this.Accs.get(targetIdx);
				balance = temp.getMoney();
				
				balance += money;
				temp.setMoney(balance);
			}
			else {
				System.out.println("잔액이 부족합니다.");
			}
		}
		else {
			System.out.println("존재하지 않는 계좌입니다.");
		}
	}
	private int randomCode() {
		Random rand = new Random();
		
		while(true) {
			int rCode = rand.nextInt(8999)+1000;
			
			boolean check = false;
			for(Account acc : this.Accs) {
				if(rCode == acc.getUserCode()) {
					check = true;
				}
			}
			if(!check) {
				return rCode;
			}
		}
	}
	public void printAcc() {
		int userCode = getUser(Bank.log).getUserCode();
		
		for(int i=0; i<this.Accs.size(); i++) {
			if(userCode == Accs.get(i).getUserCode()) {
				System.out.print(i+1+") ");
				
				System.out.println(Accs.get(i));
			}
		}
	}
	public void printAllData() {
		for(Account acc : this.Accs) {
			System.out.println(acc);
		}
	}
	public Account getAccount(int index) {
		return this.Accs.get(index);
	}
	public int getAccsSize() {
		return this.Accs.size();
	}
	public void addAccount(Account acc) {
		this.Accs.add(acc);
	}
	
	
}
