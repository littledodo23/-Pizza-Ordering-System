package application;

// danah abu rayya 1210195 s8
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

public class MainMenu {
	 static String text ;
	public static void PrintMainMenu() {
		Stage stage = new Stage();
		ArrayList<PizzaOrder> order = new ArrayList<>(); // array list of type PizzaOrder
	
		Pane rootPane = new Pane();

		// Labels
		Label customerName = createLabel("Customer Name", 180, 67);
		Label orderType = createLabel("Order Type", 180, 117);
		Label pizzaSize = createLabel("Pizza Size", 180, 165);
		Label toppings = createLabel("Toppings", 180, 237);
		Label toppingPrice = createLabel("Topping Price", 180, 371);
		Label orderPrice = createLabel("Order Price", 180, 406);
		Label op1 = createLabel("", 180, 299);
		Label op2 = createLabel("", 180, 335);

		// Text Field
		TextField customerNameField = createTextField("", 325, 69);
		TextField toppingPriceField = createTextField("10", 325, 372); // "10" is default
		TextField orderPriceField = createTextField("0.0", 325, 407); // "0.0" is default
		TextField op1Field = createTextField("", 325, 300);
		TextField op2Field = createTextField("", 325, 336);

		// ComboBox
		ComboBox<String> comboBox = new ComboBox<>();
		comboBox.setValue("ToGo"); // ToGo is default
		comboBox.getItems().addAll("ToGo", "Delivery", "Seated");
		comboBox.setLayoutX(324);
		comboBox.setLayoutY(118);
		comboBox.setPrefSize(150, 25);
		comboBox.setOnAction(e -> {
			rootPane.getChildren().removeAll(op1, op1Field, op2, op2Field);
			if (comboBox.getSelectionModel().getSelectedItem().equals("Delivery")) {
				op1.setText("Trip Rate");
				op2.setText("zone");
				rootPane.getChildren().addAll(op1, op2, op1Field, op2Field);

			} else if (comboBox.getSelectionModel().getSelectedItem().equals("Seated")) {
				op1.setText("Service Charge");
				op2.setText("Number Of People");
				rootPane.getChildren().addAll(op1, op2, op1Field, op2Field);

			} else {
				rootPane.getChildren().removeAll(op1, op1Field, op2, op2Field);
			}
		});
		ToggleGroup toggleGroup = new ToggleGroup();

		// RadioButton
		RadioButton smallSizeRadioButton = createRadioButton("SMALL", 325, 170);
		RadioButton mediumSizeRadioButton = createRadioButton("MED", 399, 170);
		RadioButton largeSizeRadioButton = createRadioButton("LARGE", 325, 199);
		smallSizeRadioButton.setSelected(true);// make the small size is default
		smallSizeRadioButton.setToggleGroup(toggleGroup);
		mediumSizeRadioButton.setToggleGroup(toggleGroup);
		largeSizeRadioButton.setToggleGroup(toggleGroup);

		// checkBox
		CheckBox onionsCheckBox = createCheckBox("Onions", 325, 242);
		CheckBox olivesCheckBox = createCheckBox("Olives", 399, 242);
		CheckBox greenPeppersCheckBox = createCheckBox("Green Peppers", 325, 273);

		// Button
		Button processOrderButton = new Button("Process Order");
		processOrderButton.setLayoutX(266);
		processOrderButton.setLayoutY(448);
		processOrderButton.setPrefSize(94, 25);
		processOrderButton.setCursor(Cursor.HAND);
		processOrderButton.setOnAction(e -> {
			if (!customerNameField.equals("") && !toppingPriceField.equals("") && !orderPriceField.equals("")) {
				RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();

				String size = selectedRadioButton.getText();
				int numberOfTopping = getNumberOfSelectedCheckBox(onionsCheckBox, olivesCheckBox, greenPeppersCheckBox);

				if (comboBox.getSelectionModel().getSelectedItem().equals("Delivery")
						|| comboBox.getSelectionModel().getSelectedItem().equals("Seated")) {

					if (!op1Field.equals("") && !op2Field.equals("")) {

						if (comboBox.getSelectionModel().getSelectedItem().equals("Delivery")) {
							 text = "Delivery";
							if (size.equals("SMALL")) {
								

								PizzaOrder pizza = new Delivery(customerNameField.getText(), PizzaOrder.SMALL,
										numberOfTopping, Double.parseDouble(toppingPriceField.getText()),
										Double.parseDouble(op1Field.getText()), Integer.parseInt(op2Field.getText()));

								order.add(pizza);
								orderPriceField.setText("" + pizza.calculateOrderPrice());
							} else if (size.equals("MEDIUM")) {
								PizzaOrder pizza = new Delivery(customerNameField.getText(), PizzaOrder.MEDIUM,
										numberOfTopping, Double.parseDouble(toppingPriceField.getText()),
										Double.parseDouble(op1Field.getText()), Integer.parseInt(op2Field.getText()));

								order.add(pizza);
								orderPriceField.setText("" + pizza.calculateOrderPrice());

							} else {
								PizzaOrder pizza = new Delivery(customerNameField.getText(), PizzaOrder.LARGE,
										numberOfTopping, Double.parseDouble(toppingPriceField.getText()),
										Double.parseDouble(op1Field.getText()), Integer.parseInt(op2Field.getText()));

								order.add(pizza);
								orderPriceField.setText("" + pizza.calculateOrderPrice());
							}
						} else {
							 text = "Seated";
							if (size.equals("SMALL")) {
								PizzaOrder pizza = new Seated(customerNameField.getText(), PizzaOrder.SMALL,
										numberOfTopping, Double.parseDouble(toppingPriceField.getText()),
										Double.parseDouble(op1Field.getText()), Integer.parseInt(op2Field.getText()));
								order.add(pizza);
								orderPriceField.setText("" + pizza.calculateOrderPrice());

							} else if (size.equals("MEDIUM")) {
								PizzaOrder pizza = new Seated(customerNameField.getText(), PizzaOrder.MEDIUM,
										numberOfTopping, Double.parseDouble(toppingPriceField.getText()),
										Double.parseDouble(op1Field.getText()), Integer.parseInt(op2Field.getText()));
								order.add(pizza);
								orderPriceField.setText("" + pizza.calculateOrderPrice());
							} else {
								PizzaOrder pizza = new Seated(customerNameField.getText(), PizzaOrder.LARGE,
										numberOfTopping, Double.parseDouble(toppingPriceField.getText()),
										Double.parseDouble(op1Field.getText()), Integer.parseInt(op2Field.getText()));
								order.add(pizza);
								orderPriceField.setText("" + pizza.calculateOrderPrice());
							}

						}
					}
				} else {
					  text = "togo ";
					PizzaOrder pizza = new ToGo(customerNameField.getText(), PizzaOrder.MEDIUM, numberOfTopping,
							Double.parseDouble(toppingPriceField.getText()));
					order.add(pizza);
					orderPriceField.setText("" + pizza.calculateOrderPrice());

				}
			}
		});

		Button resetButton = new Button("Reset");
		resetButton.setLayoutX(14);
		resetButton.setLayoutY(448);
		resetButton.setPrefSize(94, 25);
		resetButton.setCursor(Cursor.HAND);
		resetButton.setOnAction(e -> {
			MainMenu.PrintMainMenu();
			stage.close();

		});

		Button PrintButton = new Button("Print");
		PrintButton.setLayoutX(592);
		PrintButton.setLayoutY(448);
		PrintButton.setPrefSize(94, 25);
		PrintButton.setCursor(Cursor.HAND);
		PrintButton.setOnAction(e -> {
			Collections.sort(order);
			Stage printAllCustomerStage = new Stage();

			Pane rootPane2 = new Pane();

			TextArea textArea = new TextArea();
			textArea.setLayoutX(5);
			textArea.setLayoutY(6);
			textArea.setPadding(new Insets(5));
			textArea.setPrefSize(688, 344);

			Button displayButton = new Button("Display");
			displayButton.setLayoutX(324);
			displayButton.setLayoutY(389);
			displayButton.setPrefSize(94, 25);
			displayButton.setCursor(Cursor.HAND);
			displayButton.setOnAction(x -> textArea.setText(getNameAndPrice(order)));

			rootPane2.getChildren().addAll(textArea, displayButton);

			Scene scene = new Scene(rootPane2, 700, 500);
			printAllCustomerStage.setResizable(false);
			printAllCustomerStage.setTitle("All Information");
			printAllCustomerStage.setScene(scene);
			printAllCustomerStage.show();
		});

		rootPane.getChildren().addAll(customerName, customerNameField, orderType, pizzaSize, comboBox,
				smallSizeRadioButton, mediumSizeRadioButton, largeSizeRadioButton, toppings, onionsCheckBox,
				olivesCheckBox, greenPeppersCheckBox, toppingPrice, toppingPriceField, orderPrice, orderPriceField,
				processOrderButton, resetButton, PrintButton);

		Scene scene = new Scene(rootPane, 700, 500);
		stage.setResizable(false);
		stage.setTitle("Pizza Program");
		stage.setScene(scene);
		stage.show();
	}

	private static Label createLabel(String text, double layoutX, double layoutY) {
		Label label = new Label(text);
		label.setLayoutX(layoutX);
		label.setLayoutY(layoutY);
		label.setPadding(new Insets(5));
		label.setPrefSize(119, 17);
		return label;
	}

	private static CheckBox createCheckBox(String text, double layoutX, double layoutY) {
		CheckBox checkBox = new CheckBox(text);
		checkBox.setLayoutX(layoutX);
		checkBox.setLayoutY(layoutY);
		checkBox.setPrefSize(104, 17);
		return checkBox;
	}

	private static RadioButton createRadioButton(String text, double layoutX, double layoutY) {
		RadioButton radioButton = new RadioButton(text);
		radioButton.setLayoutX(layoutX);
		radioButton.setLayoutY(layoutY);
		radioButton.setPrefSize(69, 17);
		return radioButton;
	}

	private static int getNumberOfSelectedCheckBox(CheckBox checkBox1, CheckBox checkBox2, CheckBox checkBox3) {
		int i = 0;
		if (checkBox1.isSelected()) {
			i += 1;
		}
		if (checkBox2.isSelected()) {
			i += 1;
		}
		if (checkBox3.isSelected()) {
			i += 1;
		}
		return i;
	}

private static TextField createTextField(String text, double x, double y) {
		TextField textField = new TextField(text);

		textField.setLayoutX(x);
		textField.setLayoutY(y);
		textField.setPrefSize(149, 25);
		return textField;

}

	private static String getNameAndPrice(ArrayList<PizzaOrder> orders) {
		StringBuilder s = new StringBuilder("Name        Price\n");
		for (PizzaOrder order : orders) {
			s.append(order.customerName).append("          ").append(order.calculateOrderPrice()).append("\t").append(text).append("\n");
		}
		return s.toString();
	}
}
