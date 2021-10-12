package models;

import java.util.Scanner;

public class Shop {

	public static Scanner scan = new Scanner(System.in);
	
	private static String name;
	
	public static int log = -1;
	
	private Shop() {}
	
	public static String getName() {
		return Shop.name;
	}
	public static void setName(String name) {
		Shop.name = name;
	}
}
