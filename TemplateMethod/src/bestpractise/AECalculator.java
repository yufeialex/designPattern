package bestpractise;

/*
 * 计算年度开销
 * 年度开销:Annual expenses，简写为AE
 */
public abstract class AECalculator {
    /**
     * 钩子方法，用于子类在有限的范围控制处理流程
     * @return
     */
    protected boolean shouldTax(){
        return true;
    }

    // 奖金计算
    private void bonusCalculate() {
        System.out.println("共有的奖金计算");
    }
    // 扣税计算
    private void taxCalculate() {
        System.out.println("共有的税务计算");
    }

    // 惩罚计算
    private void punishCalculate() {
        System.out.println("共有的惩罚计算");
    }

	//计算部门年度开销
	public abstract void calculateDepartment();
	
	//计算员工年度开销
	public abstract void calculateEmployee();

    /**
     * 定义为final，防止子类恶意修改
     */
	public final void calculateAll() {
        bonusCalculate();
        System.out.println("一些共有的预处理");
        this.calculateDepartment();
		this.calculateEmployee();
        System.out.println("一些共有的后处理");
        punishCalculate();
        if(shouldTax()) {
            taxCalculate();
        }
    }
}
