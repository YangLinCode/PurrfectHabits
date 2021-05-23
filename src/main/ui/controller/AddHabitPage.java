package ui.controller;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AddHabitPage {
    private static final String yellow = "-fx-background-color: #FFCB3D";
    private static final String yellowHex = "FFCB3D";
    private static final String blue = "-fx-background-color: #86D0F7";
    VBox vBox;
    StackPane topStackPane;
    GridPane topGridPane;
    StackPane bottomStackPane;
    GridPane bottomGridPane;
    GridPane middleGridPane;
    GridPane bottomBottomGridPane;
    Button submitButton;
    RadioButton makeHabit;
    RadioButton breakHabit;
    TextField nameField;
    TextField motivationField;
    Stage addStage;

    public AddHabitPage(EventHandler eventHandler) {
        addStage = new Stage();

        vBox = new VBox(10);
        vBox.setPrefSize(1000, 500);
        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle(blue);

        createTopStackPane();
        createFirstGridPane(eventHandler);
        createMiddleGridPane(eventHandler);
        createBottomStackPane();
        createSecondGridPane();
        createBottomBottomGridPane(eventHandler);

        vBox.getChildren().addAll(topStackPane, topGridPane, middleGridPane,bottomStackPane, bottomGridPane, bottomBottomGridPane);

        Scene scene = new Scene(vBox);
        addStage.setScene(scene);
        addStage.show();
    }

    public void createTopStackPane() {
        topStackPane = new StackPane();
        Rectangle rectangle = new Rectangle(500, 100);
        rectangle.setFill(Color.valueOf(yellowHex));

        Label prompt = new Label("Do you want to make or break a habit?");
        prompt.setFont(new Font("Century Gothic Bold", 20));

        topStackPane.getChildren().addAll(rectangle, prompt);
    }

    public void createFirstGridPane(EventHandler eventHandler) {
        topGridPane = new GridPane();
        topGridPane.setAlignment(Pos.CENTER);

        makeHabit = new RadioButton("Make");
        breakHabit = new RadioButton("Break");
        makeHabit.setFont(new Font("Dosis Bold", 20));
        breakHabit.setFont(new Font("Dosis Bold", 20));
        ToggleGroup toggleGroup = new ToggleGroup();
        makeHabit.setToggleGroup(toggleGroup);
        breakHabit.setToggleGroup(toggleGroup);
        makeHabit.setOnAction(eventHandler);
        breakHabit.setOnAction(eventHandler);

        topGridPane.add(makeHabit, 1, 0);
        topGridPane.add(breakHabit, 1, 1);
    }

    public void createMiddleGridPane(EventHandler eventHandler) {
        middleGridPane = new GridPane();
        middleGridPane.setAlignment(Pos.CENTER);

        nameField = new TextField();
        nameField.setOnAction(eventHandler);
        nameField.setPromptText("Name of Habit");
        nameField.setFocusTraversable(false);
        nameField.setMinSize(500, 50);

        middleGridPane.add(nameField, 0, 0);
    }

    public void createBottomStackPane() {
        bottomStackPane = new StackPane();
        Rectangle rectangle = new Rectangle(500, 100);
        rectangle.setFill(Color.valueOf(yellowHex));

        Label prompt = new Label("What is your motivation?");
        prompt.setFont(new Font("Century Gothic Bold", 20));

        bottomStackPane.getChildren().addAll(rectangle, prompt);
    }

    public void createSecondGridPane() {
        bottomGridPane = new GridPane();
        bottomGridPane.setAlignment(Pos.CENTER);

        motivationField = new TextField();
        motivationField.setMinSize(500, 100);
        motivationField.setFocusTraversable(false);
        bottomGridPane.add(motivationField, 0, 0);
    }

    public void createBottomBottomGridPane(EventHandler eventHandler) {
        bottomBottomGridPane = new GridPane();
        bottomBottomGridPane.setAlignment(Pos.CENTER);

        submitButton = new Button("Submit");
        submitButton.setFont(new Font("Dosis Bold", 20));
        submitButton.setStyle(yellow);
        submitButton.setOnAction(eventHandler);

        bottomBottomGridPane.add(submitButton, 0, 0);
    }

    public Button getSubmitButton() {
        return submitButton;
    }

    public RadioButton getMakeHabit() {
        return makeHabit;
    }

    public RadioButton getBreakHabit() {
        return breakHabit;
    }

    public TextField getNameField() {
        return nameField;
    }

    public TextField getMotivationField() {
        return motivationField;
    }

    public void killPage() {
        addStage.close();
    }
}


