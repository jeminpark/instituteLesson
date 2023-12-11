package models;

public class Cart {
	
	private String cartUserId;
	private int cartUserCode;
	private String cartItemName;
	private int cartItemPrice;
	
	public Cart(String cartUserId, int cartUserCode, String cartItemName, int cartItemPrice ) {
		this.cartUserId = cartUserId;
		this.cartUserCode = cartUserCode;
		this.cartItemName = cartItemName;
		this.cartItemPrice = cartItemPrice;
	}
	public String getCartUserId() {
		return cartUserId;
	}
	public int getCartUserCode() {
		return cartUserCode;
	}
	public String getCartItemName() {
		return cartItemName;
	}
	public int getCartItemPrice() {
		return cartItemPrice;
	}
	@Override
	public String toString() {
		
		return this.cartUserId+"/"+this.cartUserCode+"/"+this.cartItemName+"/"+this.cartItemPrice;
	}
}
