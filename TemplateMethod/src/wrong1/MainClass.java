package wrong1;

public class MainClass {
	public static void main(String[] args) {
		AECalculator aeCalculator = new AECalculator();
		aeCalculator.calculateAllWithTax(0);
		System.out.println("-------------------");
		aeCalculator.calculateAll(1, false);
        System.out.println("-------------------");

	}
}
