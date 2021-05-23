package ui.controller;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class CreateAccountPage {
    BorderPane borderPane;
    TextField nameField;
    TextField emailField;
    TextField passwordField;
    TextField confirmPasswordField;
    Button createButton;

    public CreateAccountPage(Stage primaryStage, EventHandler eventHandler) throws FileNotFoundException {
        borderPane = new BorderPane();
        borderPane.setPrefSize(1000, 500);
        borderPane.setStyle("-fx-background-color: #FFCB3D");

        createLeftVBox();
        createCenterGridPane(eventHandler);

        Scene root = new Scene(borderPane);

        primaryStage.setScene(root);
        primaryStage.show();
    }

    public void  createLeftVBox() throws FileNotFoundException {
        VBox leftVBox = new VBox();
        leftVBox.setAlignment(Pos.CENTER);
        leftVBox.setStyle("-fx-background-color: #FFCB3D");

        //Image Stuff
        FileInputStream stream = new FileInputStream("data/misc/createAccCat.png");
        Image image = new Image(stream);
        ImageView logo = new ImageView(image);
        logo.setFitWidth(400);
        logo.setPreserveRatio(true);

        VBox.setMargin(logo, new Insets(100, 0, 100, 0));
        leftVBox.getChildren().add(logo);
        borderPane.setLeft(logo);
    }

    public void createCenterGridPane(EventHandler eventHandler) {
        //TODO: Make method smaller for checkstyle & readability
        VBox centerVBox = new VBox();
        centerVBox.setAlignment(Pos.CENTER);
        centerVBox.setStyle("-fx-background-color: #86D0F7");
        centerVBox.setSpacing(50);
        centerVBox.setPadding(new Insets(0, 0, 50, 0));

        GridPane gridPane = new GridPane();

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(15);
        gridPane.setHgap(20);

        //Name Label Stuff
        Label createAcc = new Label("Create Your Account");
        createAcc.setFont(new Font("Century Gothic Bold", 50));


        //Label Stuff
        Label name = new Label("Name");
        Label emailAddress = new Label("Email Address");
        Label password = new Label("Password");
        Label confirmPassword = new Label("Confirm Password");
        List<Label> labels = Arrays.asList(name, emailAddress, password, confirmPassword);
        for (Label label: labels) {
            label.setFont(new Font("Dosis Bold", 20));
        }

        //TextField Stuff
        nameField = new TextField();
        nameField.setPromptText("ex. Jessica");
        nameField.setFocusTraversable(false);
        emailField = new TextField();
        emailField.setPromptText("ex. meow@gmail.com");
        emailField.setFocusTraversable(false);
        passwordField = new TextField();
        confirmPasswordField = new TextField();

        //Button Stuff
        createButton = new Button("Create");
        createButton.setFont(new Font("Dosis Bold", 20));
        createButton.setStyle("-fx-background-color: #FFCB3D");
        createButton.setOnAction(eventHandler);

        gridPane.add(name, 0, 0);
        gridPane.add(nameField, 1, 0);
        gridPane.add(emailAddress, 0, 1);
        gridPane.add(emailField, 1, 1);
        gridPane.add(password, 0, 2);
        gridPane.add(passwordField, 1, 2);
        gridPane.add(confirmPassword, 0, 3);
        gridPane.add(confirmPasswordField, 1, 3);
        gridPane.add(createButton, 0, 4, 2, 1);

        centerVBox.getChildren().addAll(createAcc, gridPane);
        borderPane.setCenter(centerVBox);
    }

    public TextField getNameField() {
        return nameField;
    }

    public TextField getEmailField() {
        return emailField;
    }

    public TextField getPasswordField() {
        return passwordField;
    }

    public TextField getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public Button getCreateButton() {
        return createButton;
    }
}
