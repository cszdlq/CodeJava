package v1ch03.LotteryArray;

/**
 *这个程序演示了一个三角形数组。
 * Arrays.toString() 打印一维数组
 * System.out.printf("%5d", odd);
 * 1.数字占四格。如果数字小于四位数的话，设数字长度为len,则空4-len，再输出数字。否则直接输出数字。
 * 2.如果输出少于四位则占四位，按右对齐；如果输出值大于四位则按输出值的位数显示。
 * 
 * @version 1.20 2004-02-10
 * @author Cay Horstmann
 */
public class LotteryArray {
	public static void main(String[] args) {
		final int NMAX = 10;

		// 分配的三角形阵列
		int[][] odds = new int[NMAX + 1][];
		for (int n = 0; n <= NMAX; n++) {
			odds[n] = new int[n + 1];
		}

		// 填充三角形阵列
		for (int n = 0; n < odds.length; n++) {
			for (int k = 0; k < odds[n].length; k++) {
				// 二项式系数的计算： n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3*...*k)
				int lotteryOdds = 1;
				for (int i = 1; i <= k; i++) {
					lotteryOdds = lotteryOdds * (n - i + 1) / i;
				}
				odds[n][k] = lotteryOdds;
			}
		}
		// 打印三角形阵列
		for (int[] row : odds) {
			// System.out.println(Arrays.toString(row));
			for (int odd : row) {
				// 打印4个
				System.out.printf("%4d", odd);
			}
			System.out.println();
		}
	}
}
