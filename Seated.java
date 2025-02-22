package application;
//danah abu rayya 1210195 s8
public class Seated extends PizzaOrder {
	private double serviceCharge;
	private int numberOfPeople;

	public Seated(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice, double serviceCharge,
			int numberOfPeople) {
		super(customerName, pizzaSize, numberOfToppings, toppingPrice);
		this.serviceCharge = serviceCharge;
		this.numberOfPeople = numberOfPeople;
	}

	@Override
	public String toString() {
		String size = "";
		if (pizzaSize == 1) {
			size = "small";
		} else if (pizzaSize == 2)
			size = "medium";
		return "Seated{" + "serviceCharge=" + serviceCharge + ", numberOfPeople=" + numberOfPeople + ", customerName='"
				+ customerName + '\'' + ", dateOrdered=" + dateOrdered + ", pizzaSize=" + size + ", numberOfToppings="
				+ numberOfToppings + ", toppingPrice=" + (int) toppingPrice + ",price =" + (int) calculateOrderPrice()
				+ '}';
	}

	public double calculateOrderPrice() {
		return (this.numberOfToppings * this.toppingPrice * this.pizzaSize) + this.serviceCharge * this.numberOfPeople;
	}
}
