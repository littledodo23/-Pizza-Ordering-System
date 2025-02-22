package application;
//danah abu rayya 1210195 s8
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		MainMenu.PrintMainMenu();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
