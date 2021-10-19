package models;

import java.util.Scanner;

public class Shop {

	public static Scanner scan = new Scanner(System.in);
	
	public static int log = -1;
	
	private static String name;
	
	public static String getName() {
		return Shop.name;
	}
	public static void setName(String name) {
		Shop.name = name;
	}
	
}
