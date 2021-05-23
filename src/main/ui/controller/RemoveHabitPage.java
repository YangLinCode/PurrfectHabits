package ui.controller;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class RemoveHabitPage {
    private static final String yellow = "-fx-background-color: #FFCB3D";
    private static final String yellowHex = "FFCB3D";
    private static final String blue = "-fx-background-color: #86D0F7";
    VBox vBox;
    StackPane topStackPane;
    GridPane midGridPane;
    GridPane botGridPane;
    TextField textField;
    Button submitButton;
    Stage stage;

    public RemoveHabitPage(EventHandler eventHandler) {
        stage = new Stage();
        vBox = new VBox(10);
        vBox.setPrefSize(1000, 500);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(20));
        vBox.setStyle(blue);

        createTopStackPane();
        createMidGridPane(eventHandler);
        createBotGridPane(eventHandler);

        vBox.getChildren().addAll(topStackPane, midGridPane, botGridPane);

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }

    public void createTopStackPane() {
        topStackPane = new StackPane();
        Rectangle rectangle = new Rectangle(500, 100);
        rectangle.setFill(Color.valueOf(yellowHex));

        Label label = new Label("Which habit do you want to delete?");
        label.setFont(new Font("Century Gothic Bold", 20));

        topStackPane.getChildren().addAll(rectangle, label);
    }

    public void createMidGridPane(EventHandler eventHandler) {
        midGridPane = new GridPane();
        midGridPane.setAlignment(Pos.CENTER);

        textField = new TextField();
        textField.setMinSize(500, 50);
        textField.setPromptText("Name of Habit");
        textField.setFocusTraversable(false);
        textField.setOnAction(eventHandler);

        midGridPane.add(textField, 0, 0);
    }

    public void createBotGridPane(EventHandler eventHandler) {
        botGridPane = new GridPane();
        botGridPane.setAlignment(Pos.CENTER);

        submitButton = new Button("Delete");
        submitButton.setFont(new Font("Dosis Bold", 20));
        submitButton.setStyle(yellow);
        submitButton.setMinSize(300, 50);
        submitButton.setOnAction(eventHandler);

        botGridPane.add(submitButton, 0, 0);
    }

    public void killPage() {
        stage.close();
    }

    public TextField getTextField() {
        return textField;
    }

    public Button getSubmitButton() {
        return submitButton;
    }
}
