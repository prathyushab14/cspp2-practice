import java.util.*;
class Solution {
	public static void main(String[] args) {
		ShoppingCart shop = new ShoppingCart();
		Scanner sc = new Scanner(System.in);
		int lines = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < lines; i++) {
			String[] input = sc.nextLine().split(" ");
			switch(input[0]) {
				case "Item":
				String[] tokens = input[1].split(",");
				shop.addToCatalog(new Item(tokens[0], tokens[1], tokens[2]));
                break;
				case "catalog":
				shop.showCatalog();
				break;
				case "add":
				String[] tokens1 = input[1].split(",");
				shop.addToCatalog(new Item(tokens1[0], tokens1[1]));
				break;
				case "show":
				shop.showCart();
				break;
				case "totalAmount":
				System.out.println(shop.getTotalAmount());
				break;
				case "payableAmount":
				shop.getPayableAmount();
				break;
				case "remove":
				String[] tokens12 = input[1].split(",");
				shop.removeFromCart(new Item(tokens12[0], tokens12[1]));
				break;
				case "coupon":
				shop.applyCoupon(input[1]);
				break;
				case "print":
				shop.printInvoice();
				break;
			}
		}
		
	}
}