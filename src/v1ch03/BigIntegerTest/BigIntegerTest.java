package v1ch03.BigIntegerTest;

import java.math.*;
import java.util.*;

/**
 * 对程序清单3-5 中彩概率程序的改进， 使其可以采用大数值进行运算。 假设你被邀请参加抽奖活动， 并从490 个可能的数值中抽取60 个，
 * 这个程序将会得到中彩
 * 概率1/716395843461995557415116222540092933411717612789263493493351013459481104668848。祝你好运!
 * This program uses big numbers to compute the odds of winning the grand prize
 * in a lottery.
 * 
 * @version 1.20 2004-02-10
 * @author Cay Horstmann
 */
public class BigIntegerTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("抽取其中多少个数字？ ");
		int k = in.nextInt();

		System.out.println("一共选取多少个数字？ ");
		int n = in.nextInt();

		if (k >= n) {
			System.out.println("抽取的数字不能大于等于总共的数字!");
			main(args);
		}
		/*
		 * 计算公式： n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3*...*k)
		 */
		BigInteger lotteryOdds = BigInteger.valueOf(1);
		for (int i = 1; i <= k; i++) {
			// lotteryOdds = lotteryOdds * (n - i + 1) / i;
			lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf(n - i + 1)).divide(BigInteger.valueOf(i));
		}
		in.close();
		System.out.println("你的概率是 " + lotteryOdds + "分之一。祝你幸运!");
	}
}
