package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import controller.Account;
import controller.User;

public class FileManager {

	private UserManager um = UserManager.instance;
	private AccountManager am = AccountManager.instance;
	
	private File file;
	private FileWriter fw;
	private FileReader fr;
	private BufferedReader br;
	
	private String fileUsersName = "Users.txt";
	private String fileAccsName = "accs.txt";
	public static FileManager instance = new FileManager();
	
	
	public void save() {
		String data = usersData();
		try {
			file = new File(fileUsersName);
			fw = new FileWriter(file);
			fw.write(data);
			fw.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		data = accsData();
			try {
				file = new File(fileAccsName);
				fw = new FileWriter(file);
				fw.write(data);
				fw.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
	}
	private String usersData() {
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
	private String accsData() {
		String data = "";
		
		for(int i=0; i<am.getAccsSize(); i++) {
			data += am.getAcc(i).getAccCode()+"/";
			data += am.getAcc(i).getUserCode()+"/";
			data += am.getAcc(i).getUserName()+"/";
			data += am.getAcc(i).getMoney()+"\n";
		}
		return data;
	}
	public void load() {
		try {
			file = new File(fileUsersName);
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			String data = br.readLine();
			while(data != null) {
				String info[] = data.split("/");
				
				int code = Integer.parseInt(info[0]);
				String id = info[1];
				String pw = info[2];
				String name = info[3];
				
				int cnt = Integer.parseInt(info[4]);
				
				User user = new User(code, id, pw, name, cnt);
				
				um.loadUser(user);
				
				data = br.readLine();
				
				
			}
			fr.close();
			br.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			file = new File(fileAccsName);
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			String data = br.readLine();
			while(data != null) {
				String [] info = data.split("/");
				
				int num = Integer.parseInt(info[0]);
				int code = Integer.parseInt(info[1]);
				String name = info[2];
				int money = Integer.parseInt(info[3]);
				
				Account acc = new Account(num, code, name, money);
				am.loadAccount(acc);
				
				data = br.readLine();
				
			}
			fr.close();
			br.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		if(um.getUsersSize() == 0) {
			um.setAdmin();
		}
	}
}
