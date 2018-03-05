package v1ch03.LotteryOdds;

import java.util.*;

/**
 * 	这个程序用来计算抽奖中奖的概率。例
	如， 如果必须从1 ~ 50 之间的数字中取6 个数字来抽奖， 那么会有(50 x 49 x 48 x 47 x 46 x 45)/
	(1 x 2 x 3 x 4 x 5 x 6) 种可能的结果， 所以中奖的几率是1/15 890700。祝你好运！
 * This program demonstrates a <code>for</code> loop.
 * @version 1.20 2004-02-10
 * @author Cay Horstmann
 */
public class LotteryOdds
{
   public static void main(String[] args)
   {
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
       * 二项式系数的计算 n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3*...*k)
       */

      int lotteryOdds = 1;
      for (int i = 1; i <= k; i++) {
         lotteryOdds = lotteryOdds * (n - i + 1) / i;
      }
      in.close();
      System.out.println("你的概率是 " + lotteryOdds + "分之一。祝你幸运!");
   }
}
