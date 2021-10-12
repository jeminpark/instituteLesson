package models;

import java.util.Scanner;

public class Bank {
	
	public static Scanner scan = new Scanner(System.in);
	
	private static String name;
	
	public static int log = -1;
		
	private Bank() {}
	
	public static String getName() {
		return Bank.name;
	}
	public static void setName(String name) {
		Bank.name = name;
	}
	
}
