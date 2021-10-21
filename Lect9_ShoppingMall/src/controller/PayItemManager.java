package controller;

import java.util.ArrayList;

import models.PayItem;

public class PayItemManager {

	
	public static PayItemManager instance = new PayItemManager();
	private ArrayList<PayItem> pay = new ArrayList<>();
	
	private PayItemManager() {}
	
	public void printReceipt(int log) {
		for(int i=0; i<this.pay.size(); i++) {
			
		}
	}
	public PayItem get(int index) {
		return this.pay.get(index);
	}
}
