package bestpractise;

/*
 * 计算年度开销
 * 年度开销:Annual expenses，简写为AE
 */
public abstract class AECalculator {
	//计算部门年度开销
	public abstract void calculateDepartment();
	
	//计算员工年度开销
	public abstract void calculateEmployee();
	
	public void calculateAll() {
        System.out.println("一些共有的预处理");
        this.calculateDepartment();
		this.calculateEmployee();
        System.out.println("一些共有的后处理");
    }
}
