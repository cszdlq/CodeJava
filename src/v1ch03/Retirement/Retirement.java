package v1ch03.Retirement;

import java.util.*;

/**
 * while循环
 * 
 * 计算需要多长时间才能够存储一定数量的退休金， 假定每年存 人相同数量的金额，而且利率是固定的。 This program demonstrates a
 * <code>while</code> loop.
 * 
 * @version 1.20 2004-02-10
 * @author Cay Horstmann
 */
public class Retirement {
	public static void main(String[] args) {
		// read inputs
		Scanner in = new Scanner(System.in);

		System.out.println("你退休需要多少钱？");
		double goal = in.nextDouble();

		System.out.println("你每年要存储退休金多少钱？ ");
		double payment = in.nextDouble();

		System.out.println("年利率为%: ");
		double interestRate = in.nextDouble();

		double balance = 0;
		int years = 0;

		// 在未达成目标时更新帐户余额
		while (balance < goal) {
			// 加上今年的付款和利息
			balance += payment;
			double interest = balance * interestRate / 100;
			balance += interest;
			years++;
		}
		in.close();
		System.out.println("你可以在 " + years + " 年内退休。");
	}
}
