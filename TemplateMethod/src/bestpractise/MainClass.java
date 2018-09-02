package bestpractise;

public class MainClass {
	public static void main(String[] args) {
		AECalculator beijingBranchAECalculator = new BeijingBranchAECalculator();
		beijingBranchAECalculator.calculateAll();

		System.out.println("-------------------");

        ShanghaiBranchAECalculator shanghaiBranchAECalculator = new ShanghaiBranchAECalculator();
        shanghaiBranchAECalculator.setFlag(false);
        shanghaiBranchAECalculator.calculateAll();

        System.out.println("-------------------");

	}
}
