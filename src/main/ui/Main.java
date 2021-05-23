package ui;

import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.List;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new HabitsApp(primaryStage);
    }
}

