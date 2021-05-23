package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Dashboard;
import model.Habit;
import model.exceptions.HabitAlreadyExistsException;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.controller.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HabitsApp implements EventHandler<ActionEvent> {
    private static final String habitsFolderDirectory = "./data/habits";
    private static final String isInitialDirectory = "./data/misc/launch.json";
    private static final String signInDirectory = "./data/misc/signIn.json";
    private static final String accountDirectory = "./data/misc/account.json";
    private Dashboard dashboard;
    private JsonReader jsonReader;
    private JsonReader isInitialReader;
    private JsonReader rememberMeReader;
    private JsonReader accountReader;
    private JsonWriter jsonWriter;
    private JsonWriter isInitialWriter;
    private JsonWriter rememberMeWriter;
    private JsonWriter accountWriter;
    private WelcomePage welcomePage;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private AboutUsPage aboutUsPage;
    private CreateAccountPage createAccountPage;
    private AddHabitPage addHabitPage;
    private RemoveHabitPage removeHabitPage;
    private GalleryPage galleryPage;
    private Stage primaryStage;

    public HabitsApp(Stage primaryStage) {
        this.primaryStage = primaryStage;
        try {
            FileInputStream inputStream = new FileInputStream("data/misc/anonCat.png");
            Image icon = new Image(inputStream);
            primaryStage.getIcons().add(icon);
            primaryStage.setTitle("PurrfectHabits");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        jsonReader = new JsonReader(habitsFolderDirectory);
        try {
            dashboard = jsonReader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        jsonWriter = new JsonWriter(habitsFolderDirectory);
        isInitialReader = new JsonReader(isInitialDirectory);
        rememberMeReader = new JsonReader(signInDirectory);
        if (isInitialReader.readIsInitial()) {
            try {
                welcomePage = new WelcomePage(primaryStage, this);
                isInitialWriter = new JsonWriter(isInitialDirectory);
                isInitialWriter.setIsInitialLaunchFalse();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            if (!rememberMeReader.readShouldRemember()) {
                try {
                    loginPage = new LoginPage(primaryStage, this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    dashboardPage = new DashboardPage(primaryStage, this, dashboard);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void handle(ActionEvent event) {
        welcomePageListener(event);
        aboutUsPageListener(event);
        createAccountPageListener(event);
        loginPageListener(event);
        dashboardPageListener(event);
        addPageListener(event);
        removePageListener(event);
    }

    private void welcomePageListener(ActionEvent event) {
        if (welcomePage != null && event.getSource() == welcomePage.getGetStartedButton()) {
            try {
                aboutUsPage = new AboutUsPage(primaryStage, this);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void aboutUsPageListener(ActionEvent event) {
        if (aboutUsPage != null && event.getSource() == aboutUsPage.getContinueButton()) {
            try {
                createAccountPage = new CreateAccountPage(primaryStage, this);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void createAccountPageListener(ActionEvent event) {
        if (createAccountPage != null && event.getSource() == createAccountPage.getCreateButton()) {
            TextField name = createAccountPage.getNameField();
            TextField email = createAccountPage.getEmailField();
            TextField password = createAccountPage.getPasswordField();
            TextField confirmPassword = createAccountPage.getConfirmPasswordField();

            if (!password.getText().equals(confirmPassword.getText())) {
                AlertBox.display("PurrfectHabits", "Passwords do not match.");
            } else if (!password.getText().equals("")) {
                accountWriter = new JsonWriter(accountDirectory);
                accountWriter.saveAccountDetails(name.getText(), email.getText(), password.getText());
                AlertBox.display("PurrfectHabits", "Account was successfully created. Please log in.");
                try {
                    loginPage = new LoginPage(primaryStage, this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void loginPageListener(ActionEvent event) {
        if (loginPage != null && event.getSource() == loginPage.getSignInButton()) {
            CheckBox rememberMe = loginPage.getRememberMe();
            TextField email = loginPage.getEmail();
            TextField password = loginPage.getPassword();

            accountReader = new JsonReader(accountDirectory);
            if (email.getText().equals(accountReader.readEmail()) && password.getText().equals(accountReader.readPassword())) {
                if (rememberMe.isSelected()) {
                    rememberMeWriter = new JsonWriter(signInDirectory);
                    rememberMeWriter.setRememberMeTrue();
                }

                try {
                    dashboardPage = new DashboardPage(primaryStage, this, dashboard);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                AlertBox.display("PurrfectHabits", "Email or password is incorrect.");
            }
        }
    }

    private void dashboardPageListener(ActionEvent event) {
        if (dashboardPage != null && event.getSource() == dashboardPage.getAddHabitButton()) {
            addHabitPage = new AddHabitPage(this);
        } else if (dashboardPage != null && event.getSource() == dashboardPage.getRemoveHabitButton()) {
            removeHabitPage = new RemoveHabitPage(this);
        }
    }

    private void addPageListener(ActionEvent event) {
        if (addHabitPage != null && event.getSource() == addHabitPage.getSubmitButton()) {
            RadioButton makeable = addHabitPage.getMakeHabit();
            TextField nameField = addHabitPage.getNameField();
            TextField motivationField = addHabitPage.getMotivationField();

            String title = nameField.getText();
            String purpose = motivationField.getText();
            Habit.HabitType habitType = (makeable.isSelected()) ? Habit.HabitType.MAKEABLE : Habit.HabitType.BREAKABLE;

            Habit habit = new Habit(title, purpose, habitType);
            try {
                dashboard.addHabit(habit);
                jsonWriter.saveDashboard(dashboard);
                dashboardPage = new DashboardPage(primaryStage, this, dashboard);
                addHabitPage.killPage();
                AlertBox.display("PurrfectHabits", "Habit was successfully added.");
            } catch (HabitAlreadyExistsException e) {
                AlertBox.display("PurrfectHabits", "That habit already exists in your dashboard.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void removePageListener(ActionEvent event) {
        if (removeHabitPage != null && event.getSource() == removeHabitPage.getSubmitButton()) {
            Habit toRemove = new Habit(removeHabitPage.getTextField().getText());
            // TODO: fix removeHabit() bug
            dashboard.removeHabit(toRemove);
            removeHabitPage.killPage();
            AlertBox.display("PurrfectHabits", "Habit was successfully removed.");
        }
    }
}
