package v1ch03.Retirement2;

import java.util.*;

/**
 * do while循环 首先计算退休账户中的余额’然后再询问是否打算退休。 只要用户回答“ N”，
 * 循环就重复执行。这是一个需要至少执行一次的循环的很好示例， 因为用户必须先看到余额才能知道是否满足退休所用。 This program
 * demonstrates a <code>do/while</code> loop.
 * 
 * @version 1.20 2004-02-10
 * @author Cay Horstmann
 */
public class Retirement2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("你每年要存储退休金多少？");
		double payment = in.nextDouble();
		System.out.println("利率为 %: ");
		double interestRate = in.nextDouble();
		double balance = 0;
		int year = 0;
		String input;
		// 在用户尚未准备退休时更新帐户余额
		do {
			// 加上今年的付款和利息
			balance += payment;
			double interest = balance * interestRate / 100;
			balance += interest;
			year++;

			// 打印当前的退休金
			System.out.printf("%d年后, 你的退休金总共有 %,.2f%n", year, balance);

			// 询问是否准备退休并获得投入
			System.out.println("准备退休了吗？(Y/N) ");
			input = in.next();
		} while (input.equals("N"));
		in.close();
	}
}
