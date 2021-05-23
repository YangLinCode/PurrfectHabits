package ui.controller;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Award;
import model.Gallery;
import model.Habit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class GalleryPage {

    public GalleryPage(Habit habit) {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10,10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        ScrollPane scrollPane = new ScrollPane(gridPane);
        List<Award> allAwards = habit.getAwardsGallery().getAllAwards();

        int rowCount = 0;
        int columnCount = 0;
        for (Award award : allAwards) {
            String dateReceived = award.getDateReceived().toString();
            String extension = (award.getAwardType() == Award.AwardType.PAWSOME_ACHIEVEMENT) ? ".gif" : ".png";
            try {
                FileInputStream inputStream = new FileInputStream("data/habits/" + habit.getTitle() + "/" + habit.getTitle() + "_Gallery/" + dateReceived + extension);
                ImageView imageView = new ImageView(new Image(inputStream));
                gridPane.add(imageView, rowCount, columnCount);

                if (rowCount == 3) {
                    rowCount = 0;
                    columnCount++;
                } else {
                    rowCount++;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        Scene scene = new Scene(scrollPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
