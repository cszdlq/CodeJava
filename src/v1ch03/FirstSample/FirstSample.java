package v1ch03.FirstSample;

import java.util.Scanner;

/**
 * This is the first sample program in Core Java Chapter 3 标签用法，跳出语句。
 * 
 * @version 1.01 1997-03-22
 * @author Gary Cornell
 */
public class FirstSample {
	public static void main(String[] args) {
		System.out.println("We will not use 'Hello, World!'");
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		aaa: if (s.equals("1")) {
			break aaa;
		}
		if (s.equals("2")) {
			System.out.println(s);
		}
		in.close();

	}
}
