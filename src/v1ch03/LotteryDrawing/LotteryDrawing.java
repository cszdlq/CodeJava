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

		// 用数组1 2 3填充数组...n
		int[] numbers = new int[n];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
		}
		// System.out.println(Arrays.toString(numbers));

		// 绘制k个数字并将其放入第二个数组中。
		int[] result = new int[k];
		for (int i = 0; i < result.length; i++) {
			// Math.rand0m方法将返回一个0 到1 之间（包含0、
			// 不包含1 ) 的随机浮点数。用乘以这个浮点数， 就可以得到从0 到n-l 之间的一个随机数。
			int r = (int) (Math.random() * n);
			// 数组numbers已有值，随机数就是数组的索引值(下标)
			result[i] = numbers[r];
			// 现在，必须确保不会再次抽取到那个数值， 因为所有抽彩的数值必须不相同。因此，这
			// 里用数组中的最后一个数值改写number[r]，并将n 减1。(已抽过的数字不能存在)
			numbers[r] = numbers[n - 1];
			n--;
			// System.out.println(Arrays.toString(numbers));
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
