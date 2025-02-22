package application;
//danah abu rayya 1210195 s8
public class ToGo extends PizzaOrder {

	public ToGo(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice) {
		super(customerName, pizzaSize, numberOfToppings, toppingPrice);
	}

	@Override
	protected double calculateOrderPrice() {
		return this.numberOfToppings * this.toppingPrice * this.pizzaSize;
	}

	@Override
	public String toString() {
		String size = "";
		if (pizzaSize == 1) {
			size = "small";
		} else if (pizzaSize == 2)
			size = "medium";
		return "ToGo{" + "customerName='" + customerName + '\'' + ", dateOrdered=" + dateOrdered + ", pizzaSize=" + size
				+ ", numberOfToppings=" + numberOfToppings + ", toppingPrice=" + (int) toppingPrice + ",price ="
				+ (int) calculateOrderPrice() + '}';
	}
}
