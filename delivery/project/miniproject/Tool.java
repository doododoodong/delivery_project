package miniproject;

import java.util.Scanner;

public class Tool {
	
	static Scanner in = new Scanner(System.in);
	
	public static void print(String msg) {
		System.out.println(msg);
	}
	
	public static int selectNum(String msg) {
		System.out.print(msg);
		return in.nextInt();
	}
	
	public static long selectNumL(String msg) {
		System.out.print(msg);
		return in.nextLong();
	}
	
	public static String selectId(String msg) {
		System.out.print(msg);
		return in.next();
	}
	
	public static String selectIdL(String msg) {
		System.out.print(msg);
		in.nextLine();
		return in.nextLine();
	}
	
}
