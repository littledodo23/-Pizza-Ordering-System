package application;
//danah abu rayya 1210195 s8

import java.util.Date;

public abstract class PizzaOrder implements Comparable<PizzaOrder> {
    protected  String customerName;
    protected Date dateOrdered;
    protected int pizzaSize;
    static final int SMALL = 1;
    static final int MEDIUM = 2;
    static final int LARGE = 3;
    protected int numberOfToppings;
    protected double toppingPrice;


    public PizzaOrder() {
    }

    public PizzaOrder(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice) {
        this.customerName = customerName;
        this.pizzaSize = pizzaSize;
        dateOrdered = new Date();
        this.numberOfToppings = numberOfToppings;
        this.toppingPrice = toppingPrice;
    }

    public int getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(int pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(Date dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public int getNumberOfToppings() {
        return numberOfToppings;
    }

    public void setNumberOfToppings(int numberOfToppings) {
        this.numberOfToppings = numberOfToppings;
    }

    public double getToppingPrice() {
        return toppingPrice;
    }

    public void setToppingPrice(double toppingPrice) {
        this.toppingPrice = toppingPrice;
    }

    @Override
    public String toString() {
        return "PizzaOrder{" +
                "customerName= '" + customerName + '\'' +
                ", dateOrdered= " + dateOrdered +
                ", pizzaSize= " + pizzaSize +
                ", numberOfToppings= " + numberOfToppings +
                ", toppingPrice= " + (int) toppingPrice +
                ", price= " + (int) calculateOrderPrice() +
                '}';
    }

    protected abstract double calculateOrderPrice();
   
    public void printOrderInfo() {
        System.out.println(customerName + "\t\t" + (int) calculateOrderPrice());
    }

    @Override
    public int compareTo(PizzaOrder o) {
        return (int) (this.calculateOrderPrice() - o.calculateOrderPrice());
    }
    abstract String getLable ();
}

