package v1ch03.InputTest;

import java.util.*;

/**
 * This program demonstrates console input.
 * 
 * @version 1.10 2004-02-10
 * @author Cay Horstmann
 */
public class InputTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// 获取名字
		System.out.println("你的名字是什么？ ");
		String name = in.nextLine();

		// get second input
		System.out.println("你今年多大？ ");
		int age = in.nextInt();

		in.close();
		// display output on console
		System.out.println("你好， " + name + "，明年, 你就 " + (age + 1) + "岁了！");
	}
}
