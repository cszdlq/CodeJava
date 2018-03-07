package v1ch03.CompoundInterest;

import java.util.Arrays;

/**
 * 这个程序展示了如何在二维数组中存储表格数据。
 * 
 * @version 1.40 2004-02-10
 * @author Cay Horstmann
 */
public class CompoundInterest {
	public static void main(String[] args) {
		final double STARTRATE = 10;//初始利率
		final double STARTBALANCES =10000;//初始余额
		final int NRATES = 6;//利率数组项长度
		final int NYEARS = 10;//年份数组项长度

		// 将利率设为10...15%，
		double[] interestRate = new double[NRATES];
		for (int j = 0; j < interestRate.length; j++) {
			interestRate[j] = (STARTRATE + j) / 100.0;
		}
		System.out.println("利率数组："+Arrays.toString(interestRate));
		
		double[][] balances = new double[NYEARS][NRATES];

		// 将初始余额设置为10000，初始各种利率第一年的都一样
		for (int j = 0; j < balances[0].length; j++) {
			balances[0][j] = STARTBALANCES;
		}
		// 计算未来几年的利息
		for (int i = 1; i < balances.length; i++) {
			for (int j = 0; j < balances[i].length; j++) {
				// 从上一行获得去年的余额
				double oldBalance = balances[i - 1][j];
				// 计算利息
				double interest = oldBalance * interestRate[j];
				// 计算今年的余额
				balances[i][j] = oldBalance + interest;
			}
		}

		// 打印第一行利率(宽度9)
		for (int j = 0; j < interestRate.length; j++) {
			System.out.printf("%9.0f%%", 100 * interestRate[j]);
		}
		System.out.println();

		// 打印余额表
		for (double[] row : balances) {
			// 打印表格行
			for (double b : row) {
				//宽度10，带两位小数
				System.out.printf("%10.2f", b);
			}
			System.out.println();
		}
	}
}
