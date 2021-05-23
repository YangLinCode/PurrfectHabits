package ui.controller;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
    private static final String pink = "-fx-background-color: #EB4034";

    public static void display(String title, String message) {
        Stage window = new Stage();


        // (1) block user interaction with other windows until this one is taken care of
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);
        label.setFont(new Font("Dosis Bold", 20));
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.setStyle(pink);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);

        // (2) block user interaction with other windows until this one is taken care of
        window.showAndWait();

        // (1) and (2) set it up so that you have to deal with the window before going
        // back to the other main window
    }
}
