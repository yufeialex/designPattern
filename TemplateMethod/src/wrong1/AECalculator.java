package wrong1;

/*
 * 计算年度开销
 * 年度开销:Annual expenses，简写为AE
 */
public class AECalculator {
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

    public void calculateAll(Integer branchId) {
        System.out.println("一些共有的预处理");
        this.calculateDepartment(branchId);
        this.calculateEmployee(branchId);
        System.out.println("一些共有的后处理");
    }
}
