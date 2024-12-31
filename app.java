
package notforget;


import java.awt.Image;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */




import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;
import java.util.Optional;
import static javafx.application.Application.launch;
import javafx.beans.property.SimpleStringProperty;
import static javafx.scene.input.KeyCode.I;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Notforget extends Application {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/hotel_management";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private GridPane grid;
    private ListView<String> rentedListView;
    private ListView<String> availableListView;
    private Stage primaryStage;

     @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Hotel Room Management System");
        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setAlignment(Pos.CENTER);
        
//        // Set the background color and image of the root pane
//        grid.setStyle("-fx-background-color: lightblue; -fx-background-image: url('background.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: cover;");


        createTable();

showSignupPage();

Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    
    private void applyStyles() {
    // Apply styles to the signup page
    grid.setStyle("-fx-background-color: #3498db;"); // Set background color

    VBox vbox = (VBox) grid.getChildren().get(0);
    vbox.setStyle("-fx-background-color: #ffffff; -fx-border-radius: 10; -fx-padding: 20; -fx-spacing: 10;"); // Set background color, border radius, padding, and spacing

    // Apply styles to form elements
    Label titleLabel = (Label) vbox.getChildren().get(0);
    titleLabel.setStyle("-fx-text-fill: #2c3e50; -fx-font-size: 24px; -fx-font-weight: bold;");

    for (Node node : vbox.getChildren().subList(1, vbox.getChildren().size() - 1)) {
        if (node instanceof Label) {
            ((Label) node).setStyle("-fx-text-fill: #34495e; -fx-font-size: 14px;");
        } else if (node instanceof TextField  node instanceof PasswordField) {
            ((TextInputControl) node).setStyle("-fx-background-color: #ecf0f1; -fx-border-color: #bdc3c7;");
        }
    }

    Button signupButton = (Button) vbox.getChildren().get(vbox.getChildren().size() - 1);
    signupButton.setStyle("-fx-background-color: #2ecc71; -fx-text-fill: white; -fx-font-weight: bold;");

    Label signinLink = (Label) vbox.getChildren().get(vbox.getChildren().size() - 2);
    signinLink.setStyle("-fx-text-fill: #ecf0f1; -fx-font-size: 12px; -fx-underline: true; -fx-cursor: hand;");
}
    private void showSignupPage() {
    grid.getChildren().clear();
 //grid.setStyle("-fx-background-color: #C1FFC1;");

    VBox vbox = new VBox();
    vbox.setSpacing(10);
    vbox.setPadding(new Insets(10));

    Label titleLabel = new Label("Signup to NewGrand");
    titleLabel.setStyle("-fx-font-size: 50px; -fx-font-weight: bold;");
    titleLabel.setAlignment(Pos.CENTER);
    vbox.getChildren().add(titleLabel);

    Label usernameLabel = new Label("Username:");
    TextField usernameField = new TextField();
//usernameLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #0077cc; -fx-padding: 5 0 0 0;");
//usernameField.setStyle("-fx-font-size: 14px; -fx-pref-height: 30px; -fx-pref-width: 200px; -fx-background-radius: 5; -fx-border-radius: 5; -fx-border-color: #0077cc; -fx-padding: 5;");
    
    
    
    Label passwordLabel = new Label("Password:");
    PasswordField passwordField = new PasswordField();
    
  //  passwordLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #0077cc; -fx-padding: 5 0 0 0;");
//passwordField.setStyle("-fx-font-size: 14px; -fx-pref-height: 30px; -fx-pref-width: 200px; -fx-background-radius: 5; -fx-border-radius: 5; -fx-border-color: #0077cc; -fx-padding: 5;");

    // New Fields
    Label firstnameLabel = new Label("First Name:");
    TextField firstnameField = new TextField();

  //  firstnameLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #0077cc; -fx-padding: 5 0 0 0;");
//firstnameField.setStyle("-fx-font-size: 14px; -fx-pref-height: 30px; -fx-pref-width: 200px; -fx-background-radius: 5; -fx-border-radius: 5; -fx-border-color: #0077cc; -fx-padding: 5;");
    
    Label lastnameLabel = new Label("Last Name:");
    TextField lastnameField = new TextField();

    
  //  lastnameLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #0077cc; -fx-padding: 5 0 0 0;");
//lastnameField.setStyle("-fx-font-size: 14px; -fx-pref-height: 30px; -fx-pref-width: 200px; -fx-background-radius: 5; -fx-border-radius: 5; -fx-border-color: #0077cc; -fx-padding: 5;");
   

Label genderLabel = new Label("Gender:");
    TextField genderField = new TextField();
    
    
    //genderLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #0077cc; -fx-padding: 5 0 0 0;");
//genderField.setStyle("-fx-font-size: 14px; -fx-pref-height: 30px; -fx-pref-width: 200px; -fx-background-radius: 5; -fx-border-radius: 5; -fx-border-color: #0077cc; -fx-padding: 5;");

Label phonenumberLabel = new Label("Phone Number:");
    TextField phonenumbe

rField = new TextField();

    Label addressLabel = new Label("Address:");
    TextField addressField = new TextField();

    Button signupButton = new Button("Signup");
    
    
    signupButton.setOnAction(event -> {
    String username = usernameField.getText().trim();
    String password = passwordField.getText();
    String firstname = firstnameField.getText().trim();
    String lastname = lastnameField.getText().trim();
    String gender = genderField.getText().trim();
    String phonenumber = phonenumberField.getText().trim();
    String address = addressField.getText().trim();

    if (username.isEmpty()  password.isEmpty()  firstname.isEmpty()  lastname.isEmpty() 
            gender.isEmpty()  phonenumber.isEmpty()  address.isEmpty()) {
        showAlert("All fields are required.");
        return;
    }

    if (isUserExists(username, phonenumber, firstname, lastname)) {
        showAlert("User with the same username, phone number, first name, or last name already exists. Please choose different values.");
        return;
    }

    try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
         PreparedStatement preparedStatement = connection.prepareStatement(
                 "INSERT INTO users (username, password, firstname, lastname, gender, phonenumber, address) VALUES (?, ?, ?, ?, ?, ?, ?)")) {

        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, firstname);
        preparedStatement.setString(4, lastname);
        preparedStatement.setString(5, gender);
        preparedStatement.setString(6, phonenumber);
        preparedStatement.setString(7, address);
        preparedStatement.executeUpdate();

        showAlert("Signup successful. Please login.");

        showLoginPage();
        applyStyles();

    } catch (SQLException e) {
        e.printStackTrace();
        showAlert("Error: " + e.getMessage());
    }
});


    vbox.getChildren().addAll(
            usernameLabel, usernameField,
            passwordLabel, passwordField,
            firstnameLabel, firstnameField,
            lastnameLabel, lastnameField,
            genderLabel, genderField,
            phonenumberLabel, phonenumberField,
            addressLabel, addressField,
            signupButton
    );

    Label signinLink = new Label("Already have an account? Sign in");
    signinLink.setStyle("-fx-underline: true; -fx-cursor: hand;");
    signinLink.setOnMouseClicked(event -> showLoginPage());

    vbox.getChildren().add(signinLink);

    grid.add(vbox, 0, 0);
}


    private void showLoginPage() {
        grid.getChildren().clear();
        grid.setStyle("-fx-background-color: #C1FFC1;");

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10));

        Label titleLabel = new Label("Login");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        vbox.getChildren().add(titleLabel);

        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Button loginButton = new Button("Login");
        loginButton.setOnAction(event -> {
            String username = usernameField.getText().trim();
            String password = passwordField.getText();

            if (username.isEmpty()  password.isEmpty()) {
                showAlert("Username and password are required.");
                return;
            }
            if (isAdmin(username, password)) {
            showAdminPage();
        }
            else{

            try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
                 PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE username=? AND password=?")) {

preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    showAlert("Login successful.");

                    showHotelManagementPage();

                } else {
                    showAlert("Invalid username or password.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
                showAlert("Error: " + e.getMessage());
            }}
        });

        vbox.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, loginButton);

        grid.add(vbox, 0, 0);
    }

    private void showAdminPage() {
    grid.getChildren().clear();
    grid.setStyle("-fx-background-color: #C1FFC1;");

    VBox vbox = new VBox();
    vbox.setSpacing(10);
    vbox.setPadding(new Insets(10));

    Label titleLabel = new Label("Admin Page");
    titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
    vbox.getChildren().add(titleLabel);

    Button viewUsersButton = new Button("View Users");
    viewUsersButton.setOnAction(event -> viewUsers());

    

    Button deleteButton = new Button("Delete Rented Classroom");
    deleteButton.setOnAction(event -> deleteClassroom());

    vbox.getChildren().addAll(viewUsersButton,  deleteButton);

    // Add a "Back" button
    Button backButton = new Button("Back to Home");
    backButton.setOnAction(event -> showHotelManagementPage());
    vbox.getChildren().add(backButton);

    grid.add(vbox, 0, 1);
}
private boolean isAdmin(String username, String password) {
    // Check for specific admin credentials
    if (username.equals("admin") && password.equals("admin123")) {
        return true;
    }

    try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
         PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM admins WHERE username=? AND password=?")) {

        selectStatement.setString(1, username);
        selectStatement.setString(2, password);

        ResultSet resultSet = selectStatement.executeQuery();
        return resultSet.next();

    } catch (SQLException e) {
        showAlert("Error: " + e.getMessage());
        return false; // Assume an error means the user is not an admin
    }
}
private void viewUsers() {
    grid.getChildren().clear();

    VBox vbox = new VBox();
    vbox.setSpacing(10);
    vbox.setPadding(new Insets(10));

    Label titleLabel = new Label("View Users");
    titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
    vbox.getChildren().add(titleLabel);

    TableView<UserDetails> table = new TableView<>();
    TableColumn<UserDetails, String> usernameColumn = new TableColumn<>("Username");
    TableColumn<UserDetails, String> firstnameColumn = new TableColumn<>("First Name");
    TableColumn<UserDetails, String> lastnameColumn = new TableColumn<>("Last Name");
    TableColumn<UserDetails, String> genderColumn = new TableColumn<>("Gender");
    TableColumn<UserDetails, String> addressColumn = new TableColumn<>("Address");

    // Bind the columns to the data model properties
    usernameColumn.setCellValueFactory(cellData -> cellData.getValue().usernameProperty());
    firstnameColumn.setCellValueFactory(cellData -> cellData.getValue().firstnameProperty());
    lastnameColumn.setCellValueFactory(cellData -> cellData.getValue().lastnameProperty());
    genderColumn.setCellValueFactory(cellData -> cellData.getValue().genderProperty());
    addressColumn.setCellValueFactory(cellData -> cellData.getValue().addressProperty());

    table.getColumns().addAll(usernameColumn, firstnameColumn, lastnameColumn, genderColumn, addressColumn);

    try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
         Statement statement = connection.createStatement()) {

ResultSet userResult = statement.executeQuery("SELECT * FROM users");
        while (userResult.next()) {
            String username = userResult.getString("username");
            String firstname = userResult.getString("firstname");
            String lastname = userResult.getString("lastname");
            String gender = userResult.getString("gender");
            String address = userResult.getString("address");

            table.getItems().add(new UserDetails(username, firstname, lastname, gender, address));
        }

    } catch (SQLException e) {
        e.printStackTrace();
        showAlert("Error: " + e.getMessage());
    }

    vbox.getChildren().add(table);

    // Add a "Back" button
    Button backButton = new Button("Back to Admin Page");
    backButton.setOnAction(event -> showAdminPage());
    vbox.getChildren().add(backButton);

    grid.add(vbox, 0, 1);
}


public static class UserDetails {
    private final SimpleStringProperty username;
    private final SimpleStringProperty firstname;
    private final SimpleStringProperty lastname;
    private final SimpleStringProperty gender;
    private final SimpleStringProperty address;

    private UserDetails(String username, String firstname, String lastname, String gender, String address) {
        this.username = new SimpleStringProperty(username);
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.gender = new SimpleStringProperty(gender);
        this.address = new SimpleStringProperty(address);
    }

   public StringProperty usernameProperty() {
        return username;
    }

    public StringProperty firstnameProperty() {
        return firstname;
    }

    public StringProperty lastnameProperty() {
        return lastname;
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public StringProperty addressProperty() {
        return address;
    }
}

    private void showHotelManagementPage() {
        grid.getChildren().clear();

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10));

        Label titleLabel = new Label("NewGrand Hotel Rooms");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        vbox.getChildren().add(titleLabel);

        Button viewDetailButton = new Button("View Detail Classrooms");
        viewDetailButton.setOnAction(event -> viewDetailClassroom());
        
        Button feedbackButton = new Button("Feedback");
feedbackButton.setOnAction(event -> showFeedbackPopup());
vbox.getChildren().add(feedbackButton);


        vbox.getChildren().add(viewDetailButton);
        
Button priceButton = new Button("would you Rent room and Price");
priceButton.setOnAction(event -> showPriceOptions());
vbox.getChildren().add(priceButton);

        grid.add(vbox, 0, 1);

HBox hbox = new HBox();
hbox.setSpacing(10);
hbox.setPadding(new Insets(10));

rentedListView = new ListView<>();
availableListView = new ListView<>();

hbox.getChildren().addAll(rentedListView, availableListView);

Button deleteButton = new Button("Delete Classroom");
deleteButton.setOnAction(event -> deleteClassroom());



vbox.getChildren().addAll(hbox, deleteButton);

        grid.add(vbox, 0, 1);
    }
    public void populateRooms() {
    try (Connection connection = DriverManager.getConnection(DATABASE_URL, "root", "");
         Statement statement = connection.createStatement()) {

        statement.executeUpdate("TRUNCATE TABLE available_classrooms"); // Empty the table if it contains any data

        for (int i = 1; i <= 50; i++) {
            String classroomName = "Room " + i;
            statement.executeUpdate("INSERT INTO available_classrooms (classroom_name) VALUES ('" + classroomName + "')");
        }

        System.out.println("50 rooms inserted successfully.");

    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error: " + e.getMessage());
    }
}

private void showFeedbackPopup() {
    TextInputDialog feedbackDialog = new TextInputDialog();
    feedbackDialog.setTitle("Feedback");
    feedbackDialog.setHeaderText("Provide your feedback:");
    feedbackDialog.setContentText("Feedback:");

    Optional<String> result = feedbackDialog.showAndWait();
    result.ifPresent(feedback -> sendFeedbackToServer(feedback));
}

private void sendFeedbackToServer(String feedback) {
    try (Socket socket = new Socket("localhost", 5555)) {
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.writeObject(feedback);
        System.out.println("Feedback sent to server: " + feedback);

        showAlert("Feedback submitted successfully.");

    } catch (IOException e) {
        showAlert("Error sending feedback: " + e.getMessage());
        e.printStackTrace();
    }
}

    
    
   private void deleteClassroom() {
    TextInputDialog dialog = new TextInputDialog();
    dialog.setTitle("Delete Classroom");
    dialog.setHeaderText(null);
    dialog.setContentText("Enter the room number to delete:");

    dialog.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\d*")) {
            dialog.getEditor().setText(newValue.replaceAll("[^\\d]", ""));
        }
    });

    Optional<String> result = dialog.showAndWait();
    if (result.isPresent()) {
        String roomNumber = result.get();
        String classroomName = "Room " + roomNumber;

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
             PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM rented_classrooms WHERE classroom_name = ?")) {

            deleteStatement.setString(1, classroomName);
            int deletedRows = deleteStatement.executeUpdate();

            if (deletedRows > 0) {
                showAlert("Room " + roomNumber + " deleted successfully.");

                // Move back to available classrooms
                try (PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO available_classrooms (classroom_name) VALUES (?)")) {
                    insertStatement.setString(1, classroomName);
                    insertStatement.executeUpdate();

                    updateClassroomListViews();

                    // Add a "Back" button
                    Button backButton = new Button("Back to Home");
                    backButton.setOnAction(event -> showHotelManagementPage());
                    VBox vbox = (VBox) grid.getChildren().get(0);
                    vbox.getChildren().add(backButton);
                } catch (SQLException e) {
                    showAlert("Error moving room back to available classrooms: " + e.getMessage());
                }
            } else {
                showAlert("Room " + roomNumber + " not found in rented classrooms.");
            }

        } catch (SQLException e) {
            showAlert("Error deleting room: " + e.getMessage());
        }
    }
}
private void showPriceOptions() {
    grid.getChildren().clear();

    VBox vbox = new VBox();
    vbox.setSpacing(10);
    vbox.setPadding(new Insets(10));

    Label titleLabel = new Label("Price Options");
    titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
    vbox.getChildren().add(titleLabel);

    Button vipButton = new Button("VIP Classrooms (Room 41 - Room 50)");
    vipButton.setOnAction(event -> showRoomPriceOptions("VIP"));
    
    Button normalButton = new Button("Normal Classrooms (Room 1 - Room 40)");
    normalButton.setOnAction(event -> showRoomPriceOptions("Normal"));

    vbox.getChildren().addAll(vipButton, normalButton);

    // Add a "Back" button
    Button backButton = new Button("Back to Home");
    backButton.setOnAction(event -> showHotelManagementPage());
    vbox.getChildren().add(backButton);

    grid.add(vbox, 0, 1);
}
private void showRoomPriceOptions(String roomCategory) {
    grid.getChildren().clear();

VBox vbox = new VBox();
    vbox.setSpacing(10);
    vbox.setPadding(new Insets(10));

    Label titleLabel = new Label(roomCategory + " Classrooms");
    titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
    vbox.getChildren().add(titleLabel);

    ListView<String> roomListView = new ListView<>();
    vbox.getChildren().add(roomListView);

    updateRoomListView(roomListView, roomCategory);

    Button selectButton = new Button("Select Room");
    selectButton.setOnAction(event -> showRoomPricePopup(roomListView, roomCategory));

    // Add a "Back" button
    Button backButton = new Button("Back to Price Options");
    backButton.setOnAction(event -> showPriceOptions());
    vbox.getChildren().addAll(selectButton, backButton);

    grid.add(vbox, 0, 1);
}

private void updateRoomListView(ListView<String> roomListView, String roomCategory) {
    roomListView.getItems().clear();

    int startRoomNumber = (roomCategory.equals("VIP")) ? 41 : 1;
    int endRoomNumber = (roomCategory.equals("VIP")) ? 50 : 40;

    for (int i = startRoomNumber; i <= endRoomNumber; i++) {
        String classroomName = "Room " + i;
        if (!isRoomRented(classroomName)) {
            roomListView.getItems().add(classroomName);
        }
    }
}

private boolean isRoomRented(String classroomName) {
    try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
         PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM rented_classrooms WHERE classroom_name = ?")) {

        selectStatement.setString(1, classroomName);
        ResultSet resultSet = selectStatement.executeQuery();

        return resultSet.next();

    } catch (SQLException e) {
        showAlert("Error: " + e.getMessage());
        return true; // Assume an error means the room is rented to be cautious
    }
}

private void showRoomPricePopup(ListView<String> roomListView, String roomCategory) {
    String selectedRoom = roomListView.getSelectionModel().getSelectedItem();
    if (selectedRoom == null) {
        showAlert("Please select a room first.");
        return;
    }

    int roomPrice = (roomCategory.equals("VIP")) ? 2000 : 1200;

    Alert priceAlert = new Alert(Alert.AlertType.CONFIRMATION);
    priceAlert.setTitle("Room Price Confirmation");
    priceAlert.setHeaderText("Confirm the price for " + selectedRoom);
    priceAlert.setContentText("The price for the room is " + roomPrice + " Birr. Do you agree?");

    ButtonType yesButton = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
    ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
    priceAlert.getButtonTypes().setAll(yesButton, noButton);

    Optional<ButtonType> result = priceAlert.showAndWait();
    if (result.isPresent() && result.get() == yesButton) {
        rentRoom(selectedRoom);
    }
}


private void rentRoom(String classroomName) {
    try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
         PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO rented_classrooms (classroom_name) VALUES (?)");
         PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM available_classrooms WHERE classroom_name = ?")) {

        insertStatement.setString(1, classroomName);
        insertStatement.executeUpdate();

        deleteStatement.setString(1, classroomName);
        deleteStatement.executeUpdate();

        showAlert("Room " + classroomName + " rented successfully.");

        updateRoomListView(rentedListView, "Normal");
        updateRoomListView(availableListView, "Normal");

} catch (SQLException e) {
        showAlert("Error: " + e.getMessage());
    }
}
private boolean isUserExists(String username, String phonenumber, String firstname, String lastname) {

try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
         PreparedStatement selectStatement = connection.prepareStatement(
                 "SELECT * FROM users WHERE username=? OR phonenumber=? OR firstname=? OR lastname=?")) {

        selectStatement.setString(1, username);
        selectStatement.setString(2, phonenumber);
        selectStatement.setString(3, firstname);
        selectStatement.setString(4, lastname);

        ResultSet resultSet = selectStatement.executeQuery();
        return resultSet.next();

    } catch (SQLException e) {
        showAlert("Error: " + e.getMessage());
        return true; // Assume an error means the user exists to be cautious
    }
}


   

   private void viewDetailClassroom() {
    grid.getChildren().clear();

    VBox vbox = new VBox();
    vbox.setSpacing(10);
    vbox.setPadding(new Insets(10));

    Label titleLabel = new Label("View Classroom Details");
    titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
    vbox.getChildren().add(titleLabel);

    Button rentedButton = new Button("Rented Classrooms");
    rentedButton.setOnAction(event -> {
        rentedListView.setVisible(true);
        availableListView.setVisible(false);
    });

    Button availableButton = new Button("Total Classrooms");
    availableButton.setOnAction(event -> {
        rentedListView.setVisible(false);
        availableListView.setVisible(true);
    });

   

    rentedListView.setVisible(false);
    availableListView.setVisible(false);

    vbox.getChildren().addAll(rentedButton, availableButton,  rentedListView, availableListView);

    // Add a "Back" button
    Button backButton = new Button("Back to Home");
    backButton.setOnAction(event -> showHotelManagementPage());
    vbox.getChildren().add(backButton);

    grid.add(vbox, 0, 1);

    updateClassroomListViews();
}





   private void updateClassroomListViews() {
    try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
         Statement statement = connection.createStatement()) {

        ResultSet rentedResult = statement.executeQuery("SELECT * FROM rented_classrooms");
        rentedListView.getItems().clear();
        while (rentedResult.next()) {
            String classroomName = rentedResult.getString("classroom_name");
            rentedListView.getItems().add(classroomName);
        }

        availableListView.getItems().clear();
        for (int i = 1; i <= 50; i++) {
            String classroomName = "Room " + i;
            availableListView.getItems().add(classroomName);
        }
        

    } catch (SQLException e) {
        e.printStackTrace();
        showAlert("Error: " + e.getMessage());
    }
}

    private void createTable() {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(255), password VARCHAR(255))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS rented_classrooms (id INT AUTO_INCREMENT PRIMARY KEY, classroom_name VARCHAR(255))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS available_classrooms (id INT AUTO_INCREMENT PRIMARY KEY, classroom_name VARCHAR(255))");

        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error: " + e.getMessage());
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Hotel Room Management System");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
   

// Create a class for room details

public static void main(String[] args) {
        launch(args);
        
        
    }
}
