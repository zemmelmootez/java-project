package com.example.tpjavaproject;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class AddCourse extends Stage {
    public AddCourse() {

        Label emailLabel = new Label("Email");
        emailLabel.setStyle("-fx-font-size: 17px");
        TextField emailTextField = new TextField();
        emailTextField.setPromptText("example@gmail.com");
        emailTextField.setStyle("-fx-background-radius: 9px; -fx-background-color: #EDEDED;-fx-text-fill: black ;-fx-font-size: 15px;");
        emailTextField.setMinHeight(30);
        VBox emailbox=new VBox();
        emailbox.setSpacing(10);
        emailbox.getChildren().addAll(emailLabel,emailTextField);


        Label nameLabel = new Label("Name");
        nameLabel.setStyle("-fx-font-size: 17px");
        TextField nameTextField= new TextField();
        nameTextField.setPromptText("john smith");
        nameTextField.setStyle("-fx-background-radius: 9px; -fx-background-color: #EDEDED;-fx-text-fill: black ;-fx-font-size: 15px;");
        nameTextField.setMinHeight(30);
        nameTextField.setMinWidth(50);

        VBox namebox =new VBox();
        namebox.getChildren().addAll(nameLabel,nameTextField);
        namebox.setSpacing(10);
        HBox nameEmail=new HBox();
        nameEmail.getChildren().addAll(emailbox,namebox);
        nameEmail.setSpacing(10);

        Label subscriptionLabel =new Label("Subscription Date");
        subscriptionLabel.setStyle("-fx-font-size: 17px");
        DatePicker datePicker = new DatePicker();
        datePicker.setStyle("-fx-background-radius: 9px; -fx-background-color: #EDEDED;-fx-text-fill: black ;-fx-font-size: 15px;");
        datePicker.setValue(LocalDate.now());

        Label courseLabel =new Label("Course");
        courseLabel.setStyle("-fx-font-size: 17px");
        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-background-color: #56A2EC;-fx-text-fill: #FFFFFF; -fx-font-size: 17px");

        HBox hBox =new HBox();
        hBox.getChildren().add(submitButton);
        hBox.setAlignment(Pos.TOP_RIGHT);

        courseLabel.setStyle("-fx-font-size: 17px");

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Java", "Web development", "Python");

        comboBox.getSelectionModel().selectFirst();
        comboBox.setStyle("-fx-background-radius: 9px; -fx-background-color: #EDEDED;-fx-text-fill: black ;-fx-font-size: 15px;");



        submitButton.setOnAction(event -> {
            close();
        });
        VBox conteneur = new VBox(nameEmail,courseLabel,comboBox,subscriptionLabel,datePicker,hBox);
        conteneur.setAlignment(Pos.TOP_LEFT);
        conteneur.setSpacing(15);
        Scene scene = new Scene(conteneur,430,300);
        setResizable(false);
        setScene(scene);

    }
}


