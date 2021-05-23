package ui.controller;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class WelcomePage {
    GridPane gridPane;
    Button getStartedButton;

    public WelcomePage(Stage primaryStage, EventHandler eventHandler) throws FileNotFoundException {
        gridPane = new GridPane();
        gridPane.setPrefSize(1000, 500);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: #86D0F7");

        //Image Stuff
        FileInputStream stream = new FileInputStream("data/misc/catLogo.png");
        Image image = new Image(stream);
        ImageView logo = new ImageView(image);
        logo.setFitWidth(300);
        logo.setPreserveRatio(true);

        //Label Stuff
        Label welcomeTo = new Label("WELCOME TO");
        Label purrfectHabits = new Label("PURRFECT HABITS");
        welcomeTo.setFont(new Font("Showcard Gothic", 50));
        purrfectHabits.setFont(new Font("Showcard Gothic", 50));

        //Button Stuff
        getStartedButton = new Button("Get Started");
        getStartedButton.setFont(new Font("Dosis Bold", 20));
        getStartedButton.setStyle("-fx-background-color: #FFCB3D");
        getStartedButton.setOnAction(eventHandler);

        gridPane.add(logo, 0, 0, 1, 3);
        gridPane.add(welcomeTo, 1, 0);
        gridPane.add(purrfectHabits, 1, 1);
        gridPane.add(getStartedButton, 1, 2);

        GridPane.setHalignment(welcomeTo, HPos.CENTER);
        GridPane.setHalignment(purrfectHabits, HPos.CENTER);
        GridPane.setHalignment(getStartedButton, HPos.CENTER);


        Scene root = new Scene(gridPane);
        primaryStage.setScene(root);
        primaryStage.show();
    }

    public Button getGetStartedButton() {
        return getStartedButton;
    }
}

