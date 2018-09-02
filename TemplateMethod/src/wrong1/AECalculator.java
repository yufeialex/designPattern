package wrong1;

/*
 * 计算年度开销
 * 年度开销:Annual expenses，简写为AE
 *
 * 缺点：不符合单一职责，和开闭原则。
 * 有任何扩展都需要改参数，改代码，而不是通过扩展子类
 */
public class AECalculator {    // 奖金计算
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
    public void calculateDepartment(Integer branchId) {
        BranchEnum branchEnum = BranchEnum.values()[branchId];
        switch (branchEnum) {
            case BEIJING:
                System.out.println("计算北京的部门开销，使用北京分公司算法。");
                break;
            case SHANGHAI:
                System.out.println("计算上海的部门开销，使用上海分公司算法。");
                break;
            default:
                System.out.println("错误的分公司id！");
        }
    }

    //计算员工年度开销
    public void calculateEmployee(Integer branchId) {
        BranchEnum branchEnum = BranchEnum.values()[branchId];
        switch (branchEnum) {
            case BEIJING:
                System.out.println("计算北京的个人开销，使用北京分公司算法。");
                break;
            case SHANGHAI:
                System.out.println("计算上海的个人开销，使用上海分公司算法。");
                break;
            default:
                System.out.println("错误的分公司id！");
        }
    }

    public void calculateAll(Integer branchId, boolean ifTax) {
        bonusCalculate();
        System.out.println("一些共有的预处理");
        this.calculateDepartment(branchId);
        this.calculateEmployee(branchId);
        System.out.println("一些共有的后处理");
        punishCalculate();
        if(ifTax) {
            taxCalculate();
        }
    }

    public void calculateAllWithTax(Integer branchId) {
        calculateAll(branchId, true);
    }
}
