package ui.controller;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class LoginPage {
    VBox loginVBox;
    CheckBox rememberMe;
    TextField email;
    TextField password;
    Button signInButton;


    public LoginPage(Stage primaryStage, EventHandler eventHandler) throws Exception {
        loginVBox = new VBox(15);
        loginVBox.setAlignment(Pos.CENTER);
        loginVBox.setPrefSize(1000, 500);
        loginVBox.setStyle("-fx-background-color: #86D0F7");

        //Image Stuff
        FileInputStream stream = new FileInputStream("data/misc/anonCat.png");
        Image image = new Image(stream);
        ImageView logo = new ImageView(image);
        logo.setFitWidth(200);
        logo.setPreserveRatio(true);

        //TextField stuff
        email = new TextField();
        password = new TextField();
        email.setPromptText("Email");
        email.setFocusTraversable(false);
        password.setPromptText("Password");
        password.setFocusTraversable(false);
        email.setMaxSize(200, 200);
        password.setMaxSize(200, 200);

        //Button Stuff
        signInButton = new Button("Sign In");
        signInButton.setFont(new Font("Dosis Bold", 20));
        signInButton.setStyle("-fx-background-color: #FFCB3D");
        signInButton.setOnAction(eventHandler);

        //CheckBox Stuff
        rememberMe = new CheckBox("Remember Me?");

        Scene root = new Scene(loginVBox);
        loginVBox.getChildren().addAll(logo, email, password, signInButton, rememberMe);
        primaryStage.setScene(root);
        primaryStage.show();
    }

    public CheckBox getRememberMe() {
        return rememberMe;
    }

    public TextField getEmail() {
        return email;
    }

    public TextField getPassword() {
        return password;
    }

    public Button getSignInButton() {
        return signInButton;
    }
}


