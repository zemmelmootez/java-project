package com.example.tpjavaproject;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javafx.scene.control.Alert;

public class CoursesComponent {
    static Button Consult;
    public VBox coursesScreen(){
        VBox course=new VBox();

        // nav
        HBox hbox=new HBox();

        Label CoursesList=new Label("Courses List");
        TextField searchText=new TextField();
        searchText.setPromptText("Search");
        searchText.setStyle("-fx-background-color: transparent; -fx-background-insets: 0; -fx-border-width: 0;");
        searchText.setBorder(Border.EMPTY);



        Image img=new Image("C:\\Users\\ASUS\\Desktop\\tpjavaproject\\src\\main\\resources\\search.png");
        HBox hsearch=new HBox();
        ImageView isearch=new ImageView(img);
        hsearch.setStyle("-fx-background-insets: 20;-fx-border-color:#B5D6F6; -fx-border-width: 1;-fx-border-radius:20");
        hsearch.setAlignment(Pos.CENTER);
        isearch.setFitWidth(12);
        hsearch.setPadding(new Insets(5));
        isearch.setPreserveRatio(true);
        hsearch.getChildren().addAll(isearch,searchText);

        CoursesList.setTextFill(Paint.valueOf("#717171"));
        CoursesList.setFont(new Font("Arial",20));

        hbox.getChildren().addAll(CoursesList,hsearch);
        hbox.setSpacing(400);
        hbox.setAlignment(Pos.CENTER);
        HBox hbutton=new HBox();
        Consult=new Button("Add Course");





        Consult.setStyle("-fx-background-color:#56A2EC;-fx-text-fill:white;");
        hbutton.getChildren().addAll(Consult);
        hbutton.setPadding(new Insets(20));


        ListView<Card>l=new ListView<>();

        TilePane tilePane = new TilePane();
        tilePane.setPrefColumns(3);
        tilePane.setHgap(40);
        tilePane.setVgap(40);
        tilePane.setBackground(new Background(new BackgroundFill(Paint.valueOf("white"),CornerRadii.EMPTY,Insets.EMPTY)));

        Consult.setOnAction(actionEvent ->
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.getDialogPane().setHeader(null);
                    alert.setHeaderText(null);
                    alert.setContentText(null);
                    alert.getDialogPane().setGraphic(null);



                    Label courseLabel = new Label("Course Name:");
                    courseLabel.setStyle("-fx-font-size: 17px");
                    TextField courseTextField = new TextField();
                    courseTextField.setStyle("-fx-background-radius: 9px; -fx-background-color: #EDEDED;-fx-text-fill: black ;-fx-font-size: 15px;");
                    courseTextField.setPromptText("Enter course name");
                    courseTextField.setMinHeight(30);

                    Label instructorLabel = new Label("Instructor Name:");
                    instructorLabel.setStyle("-fx-font-size: 17px");
                    TextField instructorTextField = new TextField();
                    instructorTextField.setStyle("-fx-background-radius: 9px; -fx-background-color: #EDEDED;-fx-text-fill: black ;-fx-font-size: 15px;");
                    instructorTextField.setPromptText("Enter instructor name");
                    instructorTextField.setMinHeight(30);

                    Label imageLabel = new Label("image Link:");
                    imageLabel.setStyle("-fx-font-size: 17px");
                    TextField imageTextField = new TextField();
                    imageTextField.setStyle("-fx-background-radius: 9px; -fx-background-color: #EDEDED;-fx-text-fill: black ;-fx-font-size: 15px;");
                    imageTextField.setPromptText("Enter image name");
                    imageTextField.setMinHeight(30);

                    Label startDateLabel = new Label("Start Date:");
                    startDateLabel.setStyle("-fx-font-size: 17px");
                    DatePicker startDatePicker = new DatePicker();
                    startDatePicker.setStyle("-fx-background-radius: 9px; -fx-background-color: #EDEDED;-fx-text-fill: black ;-fx-font-size: 15px;");
                    startDatePicker.setValue(LocalDate.now());

                    Label endDateLabel = new Label("End Date:");
                    endDateLabel.setStyle("-fx-font-size: 17px");
                    DatePicker endDatePicker = new DatePicker();
                    endDatePicker.setStyle("-fx-background-radius: 9px; -fx-background-color: #EDEDED;-fx-text-fill: black ;-fx-font-size: 15px;");
                    endDatePicker.setValue(LocalDate.now());


                    Label descriptionLabel = new Label("Description:");
                    descriptionLabel.setStyle("-fx-font-size: 17px");
                    TextArea descriptionTextArea = new TextArea();
                    descriptionTextArea.setPromptText("Enter course description");
                    descriptionTextArea.setMinHeight(100);
                    descriptionTextArea.setStyle("-fx-background-radius: 9px; -fx-background-color: #EDEDED;-fx-text-fill: black ;-fx-font-size: 15px;");

                    // Create submit button
                    Button submitButton = new Button("Submit");
                    submitButton.setStyle("-fx-background-color: #56A2EC;-fx-text-fill: #FFFFFF; -fx-font-size: 17px");

                    // Set button action to close the modal

                    submitButton.setOnAction(event -> {

                        String name = courseTextField.getText();
                        String instructor = instructorTextField.getText();
                        String imageLink = imageTextField.getText();
                        LocalDate startDate = startDatePicker.getValue();
                        LocalDate endDate = endDatePicker.getValue();
                        String description = descriptionTextArea.getText();
                        Connection conn=ConnectionDataBase.connect();
                        String sql = "INSERT INTO courses (name, description, instructor, start_date, end_date,img_link) VALUES (?, ?, ?, ?, ?,?)";
                        try {
                            PreparedStatement pstmt = conn.prepareStatement(sql);

                            pstmt.setString(1, name);
                            pstmt.setString(2, description);
                            pstmt.setString(3, instructor);
                            pstmt.setDate(4, java.sql.Date.valueOf(startDate));
                            pstmt.setDate(5, java.sql.Date.valueOf(endDate));
                            pstmt.setString(6,imageLink);
                            int rowsInserted = pstmt.executeUpdate();
                            if (rowsInserted > 0) {
                                // Show a success message
                                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                                successAlert.setHeaderText(null);
                                successAlert.setContentText("Course added successfully!");
                                successAlert.showAndWait();
                                tilePane.getChildren().add( new Card(name, description, imageLink,3));

                            }
                        } catch (SQLException e) {
                            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                            errorAlert.setHeaderText(null);
                            errorAlert.setContentText("An error occurred while adding the course: " + e.getMessage());
                            errorAlert.showAndWait();
                            e.printStackTrace();
                        }


                    });

                    // Create layout and add components
                    VBox layout = new VBox();
                    layout.setSpacing(10);
                    layout.setPadding(new Insets(20, 30, 20, 30));
                    layout.setPrefHeight(300);

                    layout.getChildren().addAll(courseLabel, courseTextField,
                            instructorLabel, instructorTextField,
                            imageLabel,imageTextField,
                            startDateLabel, startDatePicker,
                            endDateLabel, endDatePicker,
                            descriptionLabel, descriptionTextArea,
                            submitButton);

                    // Set layout properties
                    layout.setAlignment(Pos.CENTER_LEFT);

                    layout.setStyle("-fx-background-color: white; -fx-border-radius: 9px; -fx-border-color: #c9c9c9; -fx-border-width: 1px;");

                    // Create the alert dialog
                    alert.getDialogPane().setContent(layout);
                    alert.showAndWait();
                }
        );

        Connection con=ConnectionDataBase.connect();
        try {
            PreparedStatement st=con.prepareStatement("select name,instructor,img_link from courses");
            ResultSet rs=st.executeQuery();
            while (rs.next()){
               tilePane.getChildren().add( new Card(rs.getString(1), rs.getString(2), rs.getString(3),3));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        hbutton.setAlignment(Pos.TOP_RIGHT);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(tilePane);
        tilePane.setStyle("-fx-background-color: white;");

// Set the background color of the scroll pane
        scrollPane.setStyle("-fx-background-color: transparent; -fx-background: white;");

        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setPadding(new Insets(0));
        tilePane.setStyle("-fx-background-color: white;");

// Set the background color of the scroll pane
        scrollPane.setStyle("-fx-background-color: white; -fx-control-inner-background: white;");

        scrollPane.setMaxWidth(tilePane.getMaxWidth());
// Set
        course.getChildren().addAll(hbox,hbutton,scrollPane);

        course.setPadding(new Insets(0,40,0,40));
        return course;
    }
}
