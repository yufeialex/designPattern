package bestpractise;

public class MainClass {
	public static void main(String[] args) {
		BeijingBranchAECalculator beijingBranchAECalculator = new BeijingBranchAECalculator();
		beijingBranchAECalculator.calculateAll();

		System.out.println("-------------------");

        ShanghaiBranchAECalculator shanghaiBranchAECalculator = new ShanghaiBranchAECalculator();
        shanghaiBranchAECalculator.calculateAll();

        System.out.println("-------------------");

	}
}
