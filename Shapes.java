
package Shapes;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Shapes extends Application {

	// validate the user input || input: String || output: true,false;
	public boolean isValid(TextField text_field, Text infoMessage, VBox vbox) {

		vbox.getChildren().clear();

		String userInput = text_field.getText();

		int textLength = text_field.getText().length();

		if (textLength == 0) {
			showUserFeedback(1,infoMessage);
			return false;

		} else if (isInteger(userInput) == false) {
			showUserFeedback(2,infoMessage);
			return false;

		} else if (isInteger(userInput) == true) {
			int user = Integer.parseInt(userInput);

			if (user < 3) {
				showUserFeedback(3,infoMessage);
				return false;
			}

			else if (user > 7) {
				showUserFeedback(4,infoMessage);
				return false;
			} else {
				return true;
			}

		} else {
			return true;

		}

	}

	// show messages to the user
	public void showUserFeedback(int msgId, Text msgLable) {

		if (msgId == 1) {
			msgLable.setText("Input is empty, you should enter an integer number");

		} else if (msgId == 2) {
			msgLable.setText("You must enter an integer number!!");

		} else if (msgId == 3) {
			msgLable.setText("Number is less than three");

		} else if (msgId == 4) {
			msgLable.setText("Number is greater than seven");

		}
	}

	// check if is it integer || input: String||output: true,false;
	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	// draw shape || input:integer >=3 && <= 7||output: shape
	public void drawShap(TextField number_of_sides, VBox shape, Text infoMessage) {

		if (isValid(number_of_sides, infoMessage, shape)) {

			System.out.println("\n");

			shape.getChildren().clear();
			infoMessage.setText("");

			Polygon polygonpShape = new Polygon();

			int userNumber = Integer.parseInt(number_of_sides.getText());

			if (userNumber % 2 == 0) {
				polygonpShape.setFill(Color.BLUE);

			} else {
				polygonpShape.setFill(Color.RED);

			}

			if (userNumber == 7) {

				Double[] points = {

						200.0, 50.0, 400.0, 50.0, 450.0, 150.0, 400.0, 250.0, 200.0, 250.0, 150.0, 150.0, 150.0,
						100.0 };

				polygonpShape.getPoints().addAll(points);
				shape.getChildren().addAll(polygonpShape);

			}
			if (userNumber == 6) {

				Double[] points = {

						200.0, 50.0, 400.0, 50.0, 450.0, 150.0, 400.0, 250.0, 200.0, 250.0, 150.0, 150.0 };

				polygonpShape.getPoints().addAll(points);
				shape.getChildren().addAll(polygonpShape);

			}
			if (userNumber == 5) {

				Double[] points = {

						200.0, 50.0, 400.0, 50.0, 450.0, 150.0, 400.0, 250.0, 200.0, 250.0, };

				polygonpShape.getPoints().addAll(points);
				shape.getChildren().addAll(polygonpShape);

			}
			if (userNumber == 4) {

				Double[] points = {

						200.0, 50.0, 400.0, 50.0, 450.0, 150.0, 400.0, 250.0 };

				polygonpShape.getPoints().addAll(points);
				shape.getChildren().addAll(polygonpShape);

			}
			if (userNumber == 3) {

				Double[] points = {

						200.0, 50.0, 400.0, 50.0, 450.0, 150.0 };

				polygonpShape.getPoints().addAll(points);
				shape.getChildren().addAll(polygonpShape);

			}

		}
	}

	public void start(Stage mainStage) {

		mainStage.setTitle("Summative Assessment 1");

		// section one

		Text appHead = new Text("Shapes Application");
		appHead.setFont(Font.font("Arial", FontWeight.BOLD, 50));
		appHead.setStroke(Color.GREEN);

		VBox sectionOne = new VBox(appHead);
		sectionOne.setAlignment(Pos.CENTER);

		// section two

		Text infoText = new Text("- Enter number of sides -");
		infoText.setFont(Font.font("Arial", FontWeight.THIN, 20));

		Text infoMessage = new Text("");
		infoMessage.setFont(Font.font("Arial", FontWeight.BOLD, 18));
		infoMessage.setStroke(Color.RED);

		TextField userInput = new TextField("");
		userInput.setMaxWidth(80);
//		userInput.setPrefHeight(10);

		VBox sectionTwo = new VBox(infoText, infoMessage);
		sectionTwo.setAlignment(Pos.CENTER);

		// section three

		// container three contains the user buttons
		Button showShapeBtn = new Button("Show shape");
		Button increseBtn = new Button("Increse shape");
		Button decreseBtn = new Button("Decrese shape");

		HBox sectionThree = new HBox(showShapeBtn, increseBtn, decreseBtn);
		sectionThree.setAlignment(Pos.CENTER);

		// Shape section

		VBox shape = new VBox(10);
		shape.setAlignment(Pos.CENTER);

		shape.getChildren().removeAll();

		// main container

		VBox component = new VBox(sectionOne, sectionTwo, userInput, sectionThree, shape);
		component.setAlignment(Pos.CENTER);

		Scene scene = new Scene(component, 550, 400);
		mainStage.setScene(scene);
		mainStage.show();

		// event handler for showShapeBtn
		showShapeBtn.setOnAction(e -> drawShap(userInput, shape, infoMessage));

		// event handler for increseBtn
		increseBtn.setOnAction(e -> {
			if (userInput.getText().isEmpty()) {

				infoMessage.setText("You must enter a number");

			} else {

				infoMessage.setText("");

				int incBtn = Integer.parseInt(userInput.getText());
				int incBtn2 = (incBtn) + (1);
				String s1 = String.valueOf(incBtn2);
				infoMessage.setText(s1);

				TextField increse = new TextField(s1);
				drawShap(increse, shape, infoMessage);
				userInput.setText(s1);
			}

		});

		// event handler for decreseBtn
		decreseBtn.setOnAction(e -> {
			if (userInput.getText().isEmpty()) {

				infoMessage.setText("You must enter a number");

			} else {

				infoMessage.setText("");

				int decBtn = Integer.parseInt(userInput.getText());
				int decBtn2 = (decBtn) - (1);
				String s1 = String.valueOf(decBtn2);
				infoMessage.setText(s1);

				TextField decrese = new TextField(s1);
				drawShap(decrese, shape, infoMessage);
				userInput.setText(s1);

			}

		});
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
