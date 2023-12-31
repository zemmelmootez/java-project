package com.example.tpjavaproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        VBox vb=new VBox();
        vb.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));


        Image img=new Image(new FileInputStream("C:\\Users\\ASUS\\Desktop\\tpjavaproject\\src\\main\\resources\\logo.png"));

        ImageView imageView = new ImageView(img);
        imageView.setFitHeight(240);
        imageView.setFitWidth(120);
        imageView.setPreserveRatio(true);

        BorderPane bd=new BorderPane();
        VBox buttonContainer=new VBox();

        Button home=new Button(" Home");
        Button students=new Button(" Students");
        Button courses=new Button(" Courses");
        Button stats=new Button(" Stats");

        Image imageHome=new Image("Vector.png");
        Image imageStudents=new Image("C:\\Users\\ASUS\\Desktop\\tpjavaproject\\src\\main\\resources\\Vector-1.png");
        Image imageCourses=new Image("C:\\Users\\ASUS\\Desktop\\tpjavaproject\\src\\main\\resources\\Vector-2.png");
        Image imageStats=new Image("C:\\Users\\ASUS\\Desktop\\tpjavaproject\\src\\main\\resources\\Vector-3.png");

        ImageView homeImageView=new ImageView(imageHome);
        homeImageView.setFitWidth(20);
        homeImageView.setFitHeight(20);

        ImageView StudentsImageView=new ImageView(imageStudents);
        StudentsImageView.setFitWidth(20);
        StudentsImageView.setFitHeight(20);

        ImageView coursesImageView=new ImageView(imageCourses);
        coursesImageView.setFitWidth(20);
        coursesImageView.setFitHeight(20);

        ImageView statsImageView=new ImageView(imageStats);
        statsImageView.setFitWidth(20);
        statsImageView.setFitHeight(20);

        home.setGraphic(homeImageView);
        students.setGraphic(StudentsImageView);
        stats.setGraphic(statsImageView);
        courses.setGraphic(coursesImageView);

        buttonContainer.setSpacing(12);
        buttonContainer.getChildren().addAll(home,students,courses,stats);
        buttonContainer.setAlignment(Pos.BASELINE_LEFT);

        bd.setLeft(buttonContainer);

        HomeComponent h2=new HomeComponent();
        bd.setCenter(h2.homeVbox());

        vb.setPadding(new Insets(0,10,20,30));

        vb.getChildren().addAll(imageView,bd);
        Scene scene = new Scene(vb, 1000, 650);

        stage.setTitle("");
        scene.getStylesheets().add("style.css");
        stage.getIcons().add(img);
        stage.setScene(scene);






        home.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                HomeComponent home=new HomeComponent();

                bd.setCenter(home.homeVbox());

            }
        });
        students.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                StudentComponent student=new StudentComponent();

                bd.setCenter(student.StudentVbox());
            }
        });
        courses.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                CoursesComponent co=new CoursesComponent();


                bd.setCenter(co.coursesScreen());
            }
        });


        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}