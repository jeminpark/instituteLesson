package models;

public class Receipt {

	private String receiptUserid;
	private int receiptUserCode;
	private String receiptItemName;
	private int receiptItemPrice;
	private int receiptItemCnt;
	private int receiptTotal;
	
	public Receipt(String receiptUserId, int receiptUserCode, String receiptItemName, int receiptItemPrice, int receiptTotal) {
		this.receiptUserid = receiptUserId;
		this.receiptUserCode = receiptUserCode;
		this.receiptItemName = receiptItemName;
		this.receiptItemPrice = receiptItemPrice;
		this.receiptTotal = receiptTotal;
	}

	public int getReceiptItemCnt() {
		return receiptItemCnt;
	}

	public void setReceiptItemCnt(int receiptItemCnt) {
		this.receiptItemCnt = receiptItemCnt;
	}

	public String getReceiptUserid() {
		return this.receiptUserid;
	}

	public int getReceiptUserCode() {
		return this.receiptUserCode;
	}

	public String getReceiptItemName() {
		return this.receiptItemName;
	}

	public int getReceiptItemPrice() {
		return this.receiptItemPrice;
	}
	public int getReceiptTotal() {
		return this.receiptTotal;
	}
	
	
	@Override
	public String toString() {
		String str = "";
		
		str+= this.receiptItemCnt+") ";
		str+= this.receiptUserid+"/";
		str+= this.receiptUserCode+"/";
		str+= this.receiptItemName+"/";
		str+= this.receiptItemPrice+"\n";
		
		return str;
	}
}
