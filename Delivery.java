package application;
//danah abu rayya 1210195 s8

public class Delivery extends PizzaOrder {
    private double tripRate;
    private int zone;

    public Delivery() {
    }

    public Delivery(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice, double tripRate, int zone) {
        super(customerName, pizzaSize, numberOfToppings, toppingPrice);
        this.tripRate = tripRate;
        this.zone = zone;
    }

    public double getTripRate() {
        return tripRate;
    }

    public void setTripRate(double tripRate) {
        this.tripRate = tripRate;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }

    @Override
    public String toString() {
        String size;
        if (pizzaSize == 1) {
            size = "small";
        } else if (pizzaSize == 2)
            size = "medium";
        else
            size = "large";
        return "Customer Name = " + customerName + "\nDate Ordered = " + dateOrdered + "\nPizza Size = " + size +
                "\nNumber of Toppings = " + numberOfToppings + "\nTopping Price = " + (int) toppingPrice + "\nTrip Rate = " + (int) tripRate + "\nZone = " + zone + "\nOrder Price = " + (int) calculateOrderPrice();
    }

    public double calculateOrderPrice() {
        double totalPrice = (numberOfToppings * toppingPrice) * pizzaSize;

        return totalPrice + ((tripRate / 100) * totalPrice * this.zone);
    }
}

