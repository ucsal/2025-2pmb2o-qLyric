import br.com.mariojp.solid.ocp.*;

public class Main {
	public static void main(String[] args) {
		DiscountCalculator calc = new DiscountCalculator();
		System.out.println("REGULAR 100 -> " + calc.apply(100, CustomerType.REGULAR));
		System.out.println("PREMIUM 100 -> " + calc.apply(100, CustomerType.PREMIUM));
		System.out.println("PARTNER 100 -> " + calc.apply(100, CustomerType.PARTNER));
	}
}
