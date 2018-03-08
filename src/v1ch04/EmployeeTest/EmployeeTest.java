package v1ch04.EmployeeTest;

import java.time.*;

/**
 * 这个程序测试员工类
 * 
 * @version 1.12 2015-05-08
 * @author Cay Horstmann
 */
public class EmployeeTest {
	public static void main(String[] args) {
		// 填充带有三个员工对象的工作人员数组
		Employee[] staff = new Employee[3];

		staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
		staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

		// 把每个人的薪水提高5%
		for (Employee e : staff) {
			e.raiseSalary(5);
		}

		// 打印出所有员工对象的信息
		for (Employee e : staff) {
			System.out.println("name=" + e.getName() + ",薪水=" + e.getSalary() + ",hireDay=" + e.getHireDay());
		}
	}
}

// 内部类
class Employee {
	private String name;
	private double salary;
	private LocalDate hireDay;

	// 内部类构造器
	public Employee(String n, double s, int year, int month, int day) {
		name = n;
		salary = s;
		hireDay = LocalDate.of(year, month, day);
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public LocalDate getHireDay() {
		return hireDay;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
}
