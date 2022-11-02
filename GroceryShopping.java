package com.shopping;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.TreeMap;

public class GroceryShopping {
	static ArrayList<String> list = new ArrayList<String>();
	static LinkedHashMap<String, Integer> vegetables = new LinkedHashMap<String, Integer>();
	static LinkedHashMap<String, Integer> fruits = new LinkedHashMap<String, Integer>();
	static LinkedHashMap<String, Integer> dairy = new LinkedHashMap<String, Integer>();
	static TreeMap<String, Integer> cart = new TreeMap<String, Integer>();

	static Map.Entry<Integer, String> map;
	static Map.Entry<Integer, String> map1;
	static Map.Entry<Integer, String> map2;

	static GroceryList groc = new GroceryList();
	private static int scan;
	private static Scanner input = new Scanner(System.in);
	private static GroceryShopping grocery = new GroceryShopping();

	public static void main(String[] args) throws Exception {
		System.err.println("--------WELCOME TO ONLINE GROCERY SHOPPING--------");
		start();

	}

	public static void start() throws Exception {
		try {
			FileInputStream file = new FileInputStream(
					"D:\\Eclipse\\eclipse\\com.oct\\src\\com\\shopping\\LoginDetails.properties");
			Properties prop = new Properties();
			prop.load(file);
			System.out.println("ENTER USERNAME: ");
			groc.setUserName(input.nextLine());
			if (prop.containsKey(groc.getUserName())) {
				System.out.println("ENTER YOUR PASSWORD: ");
				groc.setPassword(input.nextInt());
				if (prop.containsValue(String.valueOf(groc.getPassword()))) {
					System.out.println("--------   GREETINGS   " + groc.getUserName() + "   WELCOME  TO  OUR  SHOPPING ---------");
					groceryList();
				} else {
					System.err.println("WRONG PASSWORD ! PLEASSE TRY AGAIN");
					start();
				}
			} else {
				System.err.println("WRONG USERNAME ! PLEASE TRY AGAIN");
				start();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void groceryList() {
		try {
			Thread.sleep(3800);

			list.add("1.VEGETABLES");
			list.add("2.FRUITS");
			list.add("3.DAIRY");
			System.out.println("----------------------------");
			System.out.println("WE HAVE  " + list.size() + " CATEGORIES IN OUR LIST ");
			for (String string : list) {
				System.out.println(string);
			}
			System.out.println("ENTER THE CHOICE: ");
			scan = input.nextInt();
			switch (scan) {
			case 1:
				veg();
				break;
			case 2:
				fruits();
				break;
			case 3:
				dairy();
				break;
			}
			purchase();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void veg() {
		int i = 0;
		vegetables.put("tomato", 50);
		vegetables.put("brinjal", 30);
		vegetables.put("onion", 40);
		vegetables.put("carrot", 35);
		vegetables.put("potato", 55);
		System.out.println("--------------------------------");
		System.out.println("WE HAVE  " + vegetables.size() + " CATEGORIES IN OUR LIST ");
		for (Map.Entry<String, Integer> map : vegetables.entrySet()) {
			System.out.println((i + 1) + " . " + map.getKey() + " - " + " costs " + map.getValue() + ".Rs");
			i++;
		}

	}

	public static void fruits() {
		int i = 0;
		fruits.put("apple", 20);
		fruits.put("orange", 30);
		fruits.put("banana", 40);
		fruits.put("mango", 35);
		fruits.put("papaya", 38);

		System.out.println("WE HAVE  " + fruits.size() + " CATEGORIES IN OUR LIST ");
		for (Map.Entry<String, Integer> map1 : fruits.entrySet()) {
			System.out.println((i + 1) + " . " + map1.getKey() + " - " + " costs " + map1.getValue() + ".Rs");
			i++;
		}

	}

	public static void dairy() {
		int i = 0;
		dairy.put("curd", 10);
		dairy.put("buttermilk", 15);
		dairy.put("cheese", 25);
		dairy.put("butter", 30);
		System.out.println("-------------------------------");
		System.out.println("WE HAVE  " + dairy.size() + " CATEGORIES IN OUR LIST ");
		for (Map.Entry<String, Integer> map2 : dairy.entrySet()) {
			System.out.println((i + 1) + " . " + map2.getKey() + " - " + " costs " + map2.getValue() + ".Rs");
			i++;
		}
	}

	public static void purchase() {
		try {
			Thread.sleep(3900);
			boolean on = false;

			int choice = 0;
			printInfo();

			while (!on) {
				System.out.println("ENTER YOUR CHOICE OPTIONS: ");
				choice = input.nextInt();
				input.nextLine();

				switch (choice) {
				case 0:
					printInfo();
					break;
				case 1:
					addGrocereyItem();
					break;
				case 2:
					removeItem();
					break;
				case 3:
					viewCart();
					break;
				case 4:
					paymentGateway();
					break;
				case 5:
					on = true;
					System.err.println("     -----SHOPPING ENDED----     ");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void printInfo() {
		try {
			Thread.sleep(4100);
			System.out.println("\nPRESS ");
			System.out.println("\t 0 - CHOICE OPTIONS");
			System.out.println("\t 1 - ADD ITEM TO THE LIST ");
			System.out.println("\t 2 - REMOVE AN ITEM ");
			System.out.println("\t 3 - VIEW CART ");
			System.out.println("\t 4 - PAYMENT GATEWAY ");
			System.out.println("\t 5 - QUIT THE APPLICATION ");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addItems(String item) throws Exception {
		if (vegetables.containsKey(item)) {
			cart.put(item, vegetables.get(item));
			System.out.println(item + " HAS ADDED TO YOUR CART");
			System.out.println();

			System.out.println("Do you wanna  Purchase on other categories 1.YES 2.NO");
			int st = input.nextInt();
			if (st == 1) {
				list.clear();
				groceryList();
			} else {
				System.err.println("WRONG PRDUCT! TRY AGAIN ");
				printInfo();
			}
		}
		if (fruits.containsKey(item)) {
			cart.put(item, fruits.get(item));
			System.out.println(item + " HAS ADDED TO YOUR CART");
			System.out.println();
			System.out.println("Do you wanna  Purchase on other categories 1.YES 2.NO");
			int st = input.nextInt();
			if (st == 1) {
				list.clear();
				groceryList();
			} else {
				System.err.println("WRONG PRDUCT! TRY AGAIN ");
				printInfo();
			}
		}
		if (dairy.containsKey(item)) {
			cart.put(item, dairy.get(item));
			System.out.println(item + " HAS ADDED TO YOUR CART");
			System.out.println();
			System.out.println("Do you wanna  Purchase on other categories 1.YES 2.NO");
			int st = input.nextInt();
			if (st == 1) {
				list.clear();
				groceryList();
			} else {
				System.err.println("WRONG PRDUCT! TRY AGAIN ");
				printInfo();
			}
		}
	}

	public static void addGrocereyItem() {
		System.out.println();
		System.err.println("PLEASE ENTER THE GROCERY ITEM: ");
		try {
			addItems(input.nextLine());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void removeItem() throws Exception {
		System.out.println("ENTER THE ITEM TO REMOVE: ");
		String itemNo = input.next();
		input.nextLine();
		if (cart.containsKey(itemNo)) {
			cart.remove(itemNo);
			System.out.println("THE ITEM HAS BEEN REMOVED");
		} else {
			System.err.println("ITEM NOT FOUND ");
			System.out.println();
			groceryList();
		}
	}

	public static void viewCart() {
		System.out.println("----------------------------");
		System.out.println("THE CART HAS " + cart.size() + " PRODUCTS");
		System.out.println();
		System.out.println("PRODUCTS IN CART ARE: " + cart);
		System.out.println();
	}

	public static void paymentGateway() {
		try {
			int amount = 0;
			System.out.println();
			System.out.println("THE CART HAS " + cart.size() + " PRODUCTS");
			System.out.println();
			System.out.println("PRODUCTS IN CART ARE: " + cart);

			for (Map.Entry<String, Integer> string : cart.entrySet()) {
				System.out.println("product- " + string.getKey() + " price- " + "RS." + string.getValue());
			}
			for (Map.Entry<String, Integer> string : cart.entrySet()) {
				amount = amount + string.getValue();
			}
			System.out.println("THE PURCHASE AMOUNT FOR THE FINAL PRODUCT is .Rs:  " + amount);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}