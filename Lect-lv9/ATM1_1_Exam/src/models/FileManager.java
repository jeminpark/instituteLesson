package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import controller.Account;
import controller.User;

public class FileManager {

	private File file;
	private FileWriter fw;
	private FileReader fr;
	private BufferedReader br;
	
	private String fileUsersName = "users.txt";
	private String fileAccsName = "accs.txt";
	
	private UserManager um = UserManager.instance;
	private AccountManager am = AccountManager.instance;
	public static FileManager instance = new FileManager();
	
	public void save() {
		String data = usersData();
		try {
			this.file = new File(fileUsersName);
			this.fw = new FileWriter(file);
			this.fw.write(data);
			this.fw.close();
		}
		catch(Exception e) {
			
		}
		data = accsData();
		try {
			this.file = new File(fileAccsName);
			this.fw = new FileWriter(file);
			this.fw.write(data);
			this.fw.close();
			
		}
		catch(Exception e) {
			
		}
	}
	public void load() {
		try {
			this.file = new File(fileUsersName);
			this.fr = new FileReader(file);
			this.br = new BufferedReader(fr);
			
			String data = br.readLine();
			while(data != null) {
				String temp[] = data.split("/");
				
				int userCode = Integer.parseInt(temp[0]);
				String userId = temp[1];
				String userPw = temp[2];
				String userName = temp[3];
				int userAccCnt = Integer.parseInt(temp[4]);
				
				User user = new User(userCode, userId, userPw, userName, userAccCnt);
				um.loadUser(user);
				
				data = br.readLine();
			}
			fr.close();
			br.close();
		}
		catch(Exception e) {
			
		}
		try {
			this.file = new File(fileAccsName);
			this.fr = new FileReader(file);
			this.br = new BufferedReader(fr);
			
			String data = br.readLine();
			while(data != null) {
				String temp[] = data.split("/");
				
				int accCode = Integer.parseInt(temp[0]);
				int userCode = Integer.parseInt(temp[1]);
				String userName = temp[2];
				int money = Integer.parseInt(temp[3]);
				
				Account acc = new Account(accCode, userCode, userName, money);
				am.loadAccount(acc);
				
				data = br.readLine();
			}
			fr.close();
			br.close();
			
			if(um.getUsersSize() == 0) {
				um.setAdmin();
			}
		}
		catch(Exception e) {
			
		}
	}
	public String usersData() {
		String data = "";
		for(int i=0; i<um.getUsersSize(); i++) {
			data += um.get(i).getUserCode()+"/";
			data += um.get(i).getId()+"/";
			data += um.get(i).getPw()+"/";
			data += um.get(i).getName()+"/";
			data += um.get(i).getAccCnt()+"\n";
		}
		return data;
	}
	public String accsData() {
		String data = "";
		for(int i=0; i<am.getAccsSize(); i++) {
			data += am.getAcc(i).getAccCode()+"/";
			data += am.getAcc(i).getUserCode()+"/";
			data += am.getAcc(i).getUserName()+"/";
			data += am.getAcc(i).getMoney()+"\n";
		}
		return data;
	}
	
}
