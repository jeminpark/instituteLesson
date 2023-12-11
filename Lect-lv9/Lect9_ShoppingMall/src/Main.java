
import controller.ShopManager;
import models.Shop;

public class Main {

	public static void main(String[] args) {
		
		Shop.setName("SHOPPING");
		ShopManager.instance.run();
		
		
	}
}
