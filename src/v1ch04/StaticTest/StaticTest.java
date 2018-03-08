package v1ch04.StaticTest;

/**
 * 这个程序演示静态方法。
 * 
 * @version 1.01 2004-02-19
 * @author Cay Horstmann
 */
public class StaticTest {
	public static void main(String[] args) {
		// 填充带有三个员工对象的工作人员数组
		Employee[] staff = new Employee[3];

		staff[0] = new Employee("Tom", 40000);
		staff[1] = new Employee("Dick", 60000);
		staff[2] = new Employee("Harry", 65000);

		// 打印出所有员工对象的信息
		for (Employee e : staff) {
			e.setId();
			System.out.println("姓名=" + e.getName() + ",ID=" + e.getId() + ",薪水=" + e.getSalary());
		}

		int n = Employee.getNextId(); // 调用静态方法
		System.out.println("下一个可用ID=" + n);
	}
}

// 内部类
class Employee {
	private static int nextId = 1;

	private String name;
	private double salary;
	private int id;

	public Employee(String n, double s) {
		name = n;
		salary = s;
		id = 0;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public int getId() {
		return id;
	}

	public void setId() {
		id = nextId; // 将ID设置为下一个可用ID
		nextId++;
	}

	public static int getNextId() {
		return nextId; // 返回静态字段
	}

	public static void main(String[] args) // 单元测试;
	{
		Employee e = new Employee("Harry", 50000);
		System.out.println(e.getName() + " " + e.getSalary());
	}
}
