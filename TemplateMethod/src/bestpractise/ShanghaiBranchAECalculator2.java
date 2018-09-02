package bestpractise;

/**
 * 这个是为外派员工使用的
 * 只有calculateEmployee方法不一样
 */
public class ShanghaiBranchAECalculator2 extends AECalculator {

    private boolean flag = false;

    public void setFlag(boolean shouldTax){
        flag = shouldTax;
    }

    @Override
    protected boolean shouldTax() {
        return this.flag;
    }

	@Override
	public void calculateDepartment() {
		System.out.println("计算上海的部门开销，使用上海分公司算法。");
	}

	@Override
	public void calculateEmployee() {
		System.out.println("计算上海的外派个人开销，使用上海分公司外派算法。");
	}
}
