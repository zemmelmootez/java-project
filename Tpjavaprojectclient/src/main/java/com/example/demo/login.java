package com.example.demo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login extends Application {
    BorderPane borderPane;

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        //partie top
        Image img = new Image("C:\\Users\\HP\\Desktop\\projet\\src\\main\\resources\\img.png");
        ImageView imageView1 = new ImageView(img);
        imageView1.setFitHeight(400);
        imageView1.setFitWidth(400);
        imageView1.setPreserveRatio(true);
        borderPane = new BorderPane();
        borderPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        Image image = new Image(new FileInputStream("C:\\Users\\HP\\Desktop\\projet\\src\\main\\resources\\cap.png"));
        Image logo = new Image("C:\\Users\\HP\\Desktop\\projet\\src\\main\\resources\\logcap.pngo.png");
        ImageView imageView = new ImageView(logo);
        imageView.setFitWidth(170);
        imageView.setFitHeight(130);
        imageView.setPreserveRatio(true);


        HBox hbox = new HBox();
        hbox.setSpacing(80);
        Rectangle rec = new Rectangle(250, 100);
        rec.setFill(Color.valueOf("#56A2EC"));
        hbox.getChildren().addAll(imageView, rec);
        borderPane.setTop(hbox);

        //partie left
        Rectangle rectangle = new Rectangle(250, 800);
        rectangle.setFill(Color.valueOf("#56A2EC"));
        Rectangle rectangle1 = new Rectangle(250, 800);
        rectangle1.setFill(Color.WHITE);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(rectangle1, rectangle);

        StackPane stackPane = new StackPane(hBox, imageView1);
        stackPane.setAlignment(Pos.TOP_CENTER);
        borderPane.setLeft(stackPane);

        // partie center

        VBox vbox = new VBox();
        Label welcome = new Label("Welcome Back !");
        Label email = new Label("Email");
        Label password = new Label("password");
        welcome.setFont(Font.font("poppins", 50));
        email.setFont(Font.font("poppins", 25));
        password.setFont(Font.font("poppins", 25));
        welcome.setTextFill(Color.valueOf("#111111"));
        email.setTextFill(Color.valueOf("#111111"));
        password.setTextFill(Color.valueOf("#111111"));

        TextField textFieldmail = new TextField();
        textFieldmail.setPromptText("example@gmail.com");
        TextField textFieldpass = new TextField();
        textFieldpass.setPromptText("............");
        textFieldmail.setStyle("-fx-background-radius: 9px; -fx-background-color: #EDEDED;-fx-text-fill: black ;-fx-font-size: 14px;");
        textFieldpass.setStyle("-fx-background-radius: 9px; -fx-background-color: #EDEDED;-fx-text-fill: black; -fx-font-size: 14px;");

        textFieldpass.setMaxWidth(330);
        textFieldmail.setMaxWidth(330);
        textFieldmail.setMinHeight(45);
        textFieldpass.setMinHeight(45);


        Button login = new Button("Login");
        login.setFont(Font.font("poppins", 24));
        login.setMinWidth(330);
        login.setMinHeight(16);
        login.setStyle("-fx-background-radius: 11px; -fx-background-color: #008BFC;-fx-text-fill: #FFFFFF");

       Label errorLabel = new Label("Email or password is incorrect.");
        errorLabel.setStyle("-fx-text-fill: red;");
        errorLabel.setVisible(false);

        VBox vbox1 = new VBox();
        vbox1.getChildren().addAll(email, textFieldmail, password, textFieldpass, login,errorLabel);

        vbox.getChildren().addAll(welcome, vbox1);
        vbox.setSpacing(70);
        vbox1.setSpacing(23);
        vbox.setPadding(new Insets(0, 0, 0, 100));


        borderPane.setCenter(vbox);


        Scene scene = new Scene(borderPane, 1000, 650);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(image);
        primaryStage.setTitle("EduVerse");
        primaryStage.show();

        login.setOnAction(actionEvent -> {
            MainHome mainHome = new MainHome();
            Connection connection=ConnectionDataBase.connect();
            PreparedStatement statement;
            ResultSet rs;
            String requete = " select * From admin where email=? and password=? ";
            try {
                statement = connection.prepareStatement(requete);
                statement.setString(1, textFieldmail.getText());
                statement.setString(2, textFieldpass.getText());
                rs = statement.executeQuery();
                if (rs.next()) {
                    primaryStage.setScene(mainHome.startHome());
                }
                else {
                    errorLabel.setVisible(true);
                }
            } catch (SQLException | FileNotFoundException e) {
                throw new RuntimeException(e);
            }


        });

        Platform.runLater(() -> vbox1.requestFocus());
    }

}
