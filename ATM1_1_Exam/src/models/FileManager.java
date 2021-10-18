package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileManager {

	private File file;
	private FileWriter fw;
	private FileReader fr;
	private BufferedReader br;
	
	private String fileUsersName = "Users.txt";
	private String fileAccs = "accs.txt";
	public static FileManager instance = new FileManager();
	
	
	public void save() {
		String data = "";
		
	}
	public void load() {
		
	}
}
