package v1ch03.LotteryDrawing;

import java.util.*;

/**
 * This program demonstrates array manipulation.
 * 
 * @version 1.20 2004-02-10
 * @author Cay Horstmann
 */
public class LotteryDrawing {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("抽取其中多少个数字？ ");
		int k = in.nextInt();

		System.out.println("一共选取多少个数字？ ");
		int n = in.nextInt();

		// 用数组1 2 3填充数组。..n
		int[] numbers = new int[n];
		for (int i = 0; i < numbers.length; i++)
			numbers[i] = i + 1;

		// 绘制k个数字并将其放入第二个数组中。
		int[] result = new int[k];
		for (int i = 0; i < result.length; i++) {
			// 在0和n - 1之间建立一个随机索引。
			int r = (int) (Math.random() * n);

			// 在随机位置选择元素。
			result[i] = numbers[r];

			// 将最后一个元素移动到随机位置
			numbers[r] = numbers[n - 1];
			n--;
		}

		// 打印整理后的数组，Arrays.sort：数组顺序排序
		Arrays.sort(result);
		System.out.println("下注以下组合。它会让你富有！");
		for (int r : result) {
			System.out.println(r);
		}
		in.close();
	}
}
