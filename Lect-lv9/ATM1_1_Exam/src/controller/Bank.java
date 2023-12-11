package controller;

import java.util.Scanner;

public class Bank {

	public static Scanner scan = new Scanner(System.in);
	public static int log = -1;
	public static String name;
	
	public static String getName() {
		return Bank.name;
	}
	public static void setName(String name) {
		Bank.name = name;
	}
	
}
