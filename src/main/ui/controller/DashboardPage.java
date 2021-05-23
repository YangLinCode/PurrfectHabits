package ui.controller;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VerticalDirection;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DashboardPage  {
    private static final String yellow = "-fx-background-color: #FFCB3D";
    private static final String blue = "-fx-background-color: #86D0F7";
    private static final String grey = "-fx-background-color: #E1E2E3";
//    private static final String backgroundGrey = "-fx-background-color: #E9F3F9";
    private static final String backgroundGrey = "-fx-background-color: #F5F9FC";
    private BorderPane borderPane;
    private BorderPane centerBorderPane;
    private VBox leftPane;
    private HBox topPane;
    private Quote quoteOfTheDay;
    private Button settingsButton;
    private Button profileButton;
    private Button friendsButton;
    private Button logoutButton;
    private Button leaderboardButton;
    private Button addHabitButton;
    private Button removeHabitButton;

    public DashboardPage(Stage primaryStage, EventHandler eventHandler, Dashboard dashboard) throws Exception {
        borderPane = new BorderPane();
        borderPane.setPrefSize(1664, 1000);
        createLeftPane();
        createTopPane();
        createCenterPane(dashboard, eventHandler);
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void createLeftPane() {
        leftPane = new VBox(45);
        leftPane.setStyle(yellow);
        leftPane.setPadding(new Insets(10, 10, 10, 10));
        borderPane.setLeft(leftPane);
        try {
            FileInputStream profileStream = new FileInputStream("data/misc/profile.png");
            FileInputStream logoutStream = new FileInputStream("data/misc/logout.png");
            FileInputStream leaderboardStream = new FileInputStream("data/misc/leaderboard.png");
            FileInputStream friendsStream = new FileInputStream("data/misc/friends.png");
            FileInputStream settingsStream = new FileInputStream("data/misc/settings.png");
            ImageView settingsImage = new ImageView(new Image(settingsStream));
            ImageView friendsImage = new ImageView(new Image(friendsStream));
            ImageView leaderboardImage = new ImageView(new Image(leaderboardStream));
            ImageView logoutImage = new ImageView(new Image(logoutStream));
            ImageView profileImage = new ImageView(new Image(profileStream));

            List<ImageView> images = Arrays.asList(profileImage, friendsImage, leaderboardImage, settingsImage, logoutImage);
            for (ImageView im : images) {
                im.setFitWidth(50);
                im.setFitHeight(50);
            }

            settingsButton = new Button("", settingsImage);
            settingsButton.setFocusTraversable(false);
            profileButton = new Button("", profileImage);
            profileButton.setFocusTraversable(false);
            logoutButton = new Button("", logoutImage);
            logoutButton.setFocusTraversable(false);
            friendsButton = new Button("", friendsImage);
            friendsButton.setFocusTraversable(false);
            leaderboardButton = new Button("", leaderboardImage);
            leaderboardButton.setFocusTraversable(false);

            leftPane.getChildren().addAll(profileButton, friendsButton, leaderboardButton, settingsButton, logoutButton);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void createTopPane() {
        topPane = new HBox(10);
        topPane.setStyle(blue);
        topPane.setPadding(new Insets(10, 10, 10, 10));
        borderPane.setTop(topPane);

        try {
            FileInputStream inputStream = new FileInputStream("data/misc/anonCat.png");
            ImageView imageView = new ImageView(new Image(inputStream));
            imageView.setFitWidth(70);
            imageView.setFitHeight(70);
            topPane.getChildren().add(imageView);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        QuoteOfTheDay generator = new QuoteOfTheDay();
        quoteOfTheDay = generator.getQuoteOfTheDay();

        Label dashboardLabel = new Label("Dashboard");
        dashboardLabel.setFont(new Font("Century Gothic Bold", 55));
        topPane.getChildren().add(dashboardLabel);

        Separator separator = new Separator(Orientation.VERTICAL);
        topPane.getChildren().add(separator);

        Label sayingLabel = new Label("\"" + quoteOfTheDay.getSaying() + "\"" + "\n" + "- " + quoteOfTheDay.getAuthor());
        sayingLabel.setFont(new Font("Century Gothic", 25));
        sayingLabel.setWrapText(true);
        sayingLabel.setMaxWidth(1200);
        topPane.getChildren().add(sayingLabel);
    }

    public void createCenterPane(Dashboard dashboard, EventHandler eventHandler) {
        centerBorderPane = new BorderPane();
        centerBorderPane.setStyle(backgroundGrey);

        createCenterTopPane(eventHandler);
        createCenterCenterPane(dashboard);
        createCenterBotPane(dashboard);

        borderPane.setCenter(centerBorderPane);
    }

    public void createCenterTopPane(EventHandler eventHandler) {
        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(10));

        addHabitButton = new Button("Add");;
        removeHabitButton = new Button("Remove");
        addHabitButton.setOnAction(eventHandler);
        removeHabitButton.setOnAction(eventHandler);
        List<Button> buttons = Arrays.asList(addHabitButton, removeHabitButton);
        for (Button b: buttons) {
            b.setStyle(grey);
            b.setFont(new Font("Dosis", 20));
            b.setPrefSize(100, 20);
        }
        hBox.getChildren().addAll(buttons);
        centerBorderPane.setTop(hBox);
    }

    public void createCenterCenterPane(Dashboard dashboard) {
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(20);
        gridPane.setPadding(new Insets(10, 20, 10, 20));

        int rowCount = 0;
        int colCount = 0;
        for (Habit habit : dashboard.getAllHabits()) {
            List<Award> allAwards = habit.getAwardsGallery().getAllAwards();
            if (allAwards.size() == 0) {
                try {
                    FileInputStream inputStream = new FileInputStream("data/misc/catLogo.png");
                    ImageView imageView = new ImageView(new Image(inputStream));
                    imageView.setFitHeight(180);
                    imageView.setFitWidth(200);
                    Button button = new Button(habit.getTitle(), imageView);
                    gridPane.add(button, colCount, rowCount);

                    if (colCount == 4) {
                        colCount = 0;
                        rowCount++;
                    } else {
                        colCount++;
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                Award lastAwardReceived = allAwards.get(allAwards.size() - 1);
                String lastAwardReceivedDate = lastAwardReceived.getDateReceived().toString();
                String extension = (lastAwardReceived.getAwardType() == Award.AwardType.PAWSOME_ACHIEVEMENT) ? ".gif" : ".png";
                try {
                    FileInputStream inputStream = new FileInputStream("data/habits/" + habit.getTitle() + "/" + habit.getTitle() + "_Gallery/" + lastAwardReceivedDate + extension);
                    ImageView imageView = new ImageView(new Image(inputStream));
                    imageView.setFitHeight(180);
                    imageView.setFitWidth(200);
                    Button button = new Button(habit.getTitle(), imageView);
                    gridPane.add(button, colCount, rowCount);

                    if (colCount == 4) {
                        colCount = 0;
                        rowCount++;
                    } else {
                        colCount++;
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        centerBorderPane.setCenter(gridPane);
    }

    public void createCenterBotPane(Dashboard dashboard) {
        HBox hBox = new HBox(20);
        hBox.setPadding(new Insets(10, 10, 10, 10));

        NumberAxis xAxisLineGraph = new NumberAxis();
        xAxisLineGraph.setLabel("Day #");
        NumberAxis yAxisLineGraph = new NumberAxis();
        yAxisLineGraph.setLabel("Total # of Awards");
        LineChart lineChart = new LineChart(xAxisLineGraph, yAxisLineGraph);
        XYChart.Series dataSeriesLineGraph = new XYChart.Series();
        dataSeriesLineGraph.setName("Total # of Awards Over Time");
        dataSeriesLineGraph.getData().add(new XYChart.Data(0, 0));
        dataSeriesLineGraph.getData().add(new XYChart.Data(1, 1));
        dataSeriesLineGraph.getData().add(new XYChart.Data(2, 4));
        dataSeriesLineGraph.getData().add(new XYChart.Data(3, 10));
        dataSeriesLineGraph.getData().add(new XYChart.Data(4, 5));
        dataSeriesLineGraph.getData().add(new XYChart.Data(5, 20));
        lineChart.getData().add(dataSeriesLineGraph);
        hBox.getChildren().add(lineChart);


        PieChart pieChart = new PieChart();
        PieChart.Data slice1 = new PieChart.Data("# Total Relapses", 4);
        PieChart.Data slice2 = new PieChart.Data("# Pawsome Achievements", 7);
        pieChart.getData().add(slice1);
        pieChart.getData().add(slice2);
        hBox.getChildren().add(pieChart);

        CategoryAxis xAxisBarGraph = new CategoryAxis();
        xAxisBarGraph.setLabel("Habits");
        NumberAxis yAxisBarGraph = new NumberAxis();
        yAxisBarGraph.setLabel("# of Awards");
        BarChart barChart = new BarChart(xAxisBarGraph, yAxisBarGraph);
        XYChart.Series dataSeriesBarGraph = new XYChart.Series();
        dataSeriesBarGraph.setName("# of Awards For Select Habits");
        dataSeriesBarGraph.getData().add(new XYChart.Data("Exercise More", 20));
        dataSeriesBarGraph.getData().add(new XYChart.Data("Read Everyday", 13));
        dataSeriesBarGraph.getData().add(new XYChart.Data("Go To Bed On Time", 23));
        barChart.getData().add(dataSeriesBarGraph);
        hBox.getChildren().add(barChart);

        centerBorderPane.setBottom(hBox);
    }

    public Button getAddHabitButton() {
        return addHabitButton;
    }

    public Button getRemoveHabitButton() {
        return removeHabitButton;
    }
}



