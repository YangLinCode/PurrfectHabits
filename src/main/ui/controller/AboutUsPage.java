package ui.controller;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class AboutUsPage  {
    BorderPane borderPane;
    Button continueButton;

//    @Override
//    public void start(Stage primaryStage) throws Exception {




    public AboutUsPage(Stage primaryStage, EventHandler eventHandler) throws FileNotFoundException {
        borderPane = new BorderPane();
        borderPane.setPrefSize(1000, 500);
        borderPane.setStyle("-fx-background-color: #86D0F7");

        createLeftVBox();
        createCenterGridPane(eventHandler);

        Scene root = new Scene(borderPane);


        primaryStage.setScene(root);
        primaryStage.show();

    }

    public void  createLeftVBox() throws FileNotFoundException {
        VBox leftVBox = new VBox();
        leftVBox.setAlignment(Pos.BOTTOM_CENTER);
        leftVBox.setStyle("-fx-background-color: #86D0F7");
       /// leftVBox.setPadding(new Insets(100, 0, 0, 0));

        //Image Stuff
        FileInputStream stream = new FileInputStream("data/misc/twoCats.png");
        Image image = new Image(stream);
        ImageView logo = new ImageView(image);
        logo.setFitWidth(430);
        logo.setPreserveRatio(true);

       // VBox.setMargin(logo, new Insets(, 0, 0, 0));
        //VBox.set
        leftVBox.getChildren().add(logo);
        borderPane.setLeft(logo);
    }

    public void createCenterGridPane(EventHandler eventHandler) {
        VBox centerVBox = new VBox();
        centerVBox.setAlignment(Pos.CENTER);
        centerVBox.setStyle("-fx-background-color: #FFCB3D");
        centerVBox.setSpacing(10);
        centerVBox.setPadding(new Insets(0, 0, 50, 0));

        //Name Label Stuff
        Label whatIs = new Label("What is Purrfect Habits?");
        whatIs.setFont(new Font("Century Gothic Bold", 50));


        //Label Stuff
        Label p1 = new Label("Purrfect Habits is a habit tracker app.");
        Label p2 = new Label("but not just any habit tracker app");
        Label p3 = new Label("It rewards you with cats!");
        Label p4 = new Label("How Paw-some is that?");
        Label p5 = new Label("For each day a healthy habit is created");
        Label p6 = new Label("or an unhealthy one is broken");
        Label p7 = new Label("a new cat photo (or gif) is added");
        Label p8 = new Label("to your gallery");
        Label p9 = new Label("But watch out!");
        Label p10 = new Label("If you miss a day all you cats will be lost");
        Label p11 = new Label("Will you take on the challenge?");
        List<Label> labels = Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11);

        for (Label l: labels) {
            l.setFont(new Font("Dosis Bold", 20));
        }


        //Button Stuff
        continueButton = new Button("Continue");
        continueButton.setFont(new Font("Dosis Bold", 20));
        continueButton.setStyle("-fx-background-color: #86D0F7");
        continueButton.setOnAction(eventHandler);


        centerVBox.getChildren().addAll(whatIs, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, continueButton);
        borderPane.setCenter(centerVBox);
    }

    public Button getContinueButton() {
        return continueButton;
    }
}
