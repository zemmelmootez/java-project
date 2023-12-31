package com.example.tpjavaproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HomeComponent extends VBox {
    int total_student=0;
    int student_in_Progress=0;
    int student_graduated=0;
    Connection con=ConnectionDataBase.connect();
    HomeComponent(){

        try {
            PreparedStatement st=con.prepareStatement("SELECT  total_students, students_in_progress, students_graduated FROM courses ");
            ResultSet rs=st.executeQuery();

            while(rs.next()){

                total_student+=rs.getInt(1);
                student_in_Progress+=rs.getInt(2);
                student_graduated+=rs.getInt(3);
            }

        }
        catch (Exception e){

        }
    }
    public VBox content(String color){

         VBox co=new VBox();
        HBox hcompleteted=new HBox();
        Image img = null;
        Image img2=null;
        Label CompletetdValue=new Label();
        Label lcompleted=new Label();
        switch (color){
            case "red":{
                co.setStyle("-fx-border-radius: 25;-fx-background-radius:25;-fx-background-color:#F9BC9050");
                img=new Image("C:\\Users\\ASUS\\Desktop\\tpjavaproject\\src\\main\\resources\\fluent-mdl2_learning-tools.png");
                img2=new Image("C:\\Users\\ASUS\\Desktop\\tpjavaproject\\src\\main\\resources\\Rectangle 9.png");
                CompletetdValue.setText(String.valueOf(student_graduated));
                lcompleted.setText("Completed Courses");
                break;
            }
            case "green":{
                co.setStyle("-fx-border-radius: 25;-fx-background-radius:25;-fx-background-color:#ABF99070");
                img=new Image("C:\\Users\\ASUS\\Desktop\\tpjavaproject\\src\\main\\resources\\simple-icons_futurelearn.png");
                img2=new Image("C:\\Users\\ASUS\\Desktop\\tpjavaproject\\src\\main\\resources\\Rectangle 10.png");
                CompletetdValue.setText(String.valueOf(student_in_Progress));
                lcompleted.setText("Courses In Progress");

                break;
            }
            default:
                co.setStyle("-fx-border-radius: 25;-fx-background-radius:25;-fx-background-color:#90E6F950");
                img=new Image("C:\\Users\\ASUS\\Desktop\\tpjavaproject\\src\\main\\resources\\ph_student-light.png");
                img2=new Image("C:\\Users\\ASUS\\Desktop\\tpjavaproject\\src\\main\\resources\\Rectangle 11.png");
                CompletetdValue.setText(String.valueOf(total_student));
                lcompleted.setText("Total Students");

        }
        ImageView completedView = new ImageView(img);


        completedView.setFitHeight(20);
        completedView.setFitWidth(40);

        completedView.setPreserveRatio(true);


        lcompleted.setFont(Font.font("ARIAl", FontWeight.MEDIUM,14));
        hcompleteted.setSpacing(10);
        hcompleteted.setAlignment(Pos.CENTER);
        hcompleteted.getChildren().addAll(completedView,lcompleted);

        co.setPadding(new Insets(20));


        CompletetdValue.setFont(Font.font("ARIAl", FontWeight.BOLD,30));
        co.setSpacing(20);

        ImageView img2view=new ImageView(img2);
        img2view.setFitWidth(140);
        img2view.setPreserveRatio(true);

        co.getChildren().addAll(hcompleteted,CompletetdValue,img2view);



        return  co;


    }
    public VBox homeVbox(){

        VBox home=new VBox();
        home.setPadding(new Insets(0,80,0,80));
        Label l1=new Label("Overview");

        l1.setTextFill(Paint.valueOf("#717171"));
        l1.setFont(new Font("Arial",20));
        HBox h1=new HBox();

        VBox CompletedCourses=this.content("red");
        VBox CoursesInProgress=this.content("green");
        VBox TotalStudent=this.content("blue");



        h1.getChildren().addAll(CompletedCourses,CoursesInProgress,TotalStudent);

        h1.setSpacing(30);



        HBox lineContent=new HBox();
        lineContent.getChildren().add(h1);

        home.setSpacing(50);

        Label l2=new Label("Most enrolled courses");
        l2.setTextFill(Paint.valueOf("#717171"));
        l2.setFont(new Font("Arial",20));

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                           );
        try {
            PreparedStatement st=con.prepareStatement("Select name,total_students from courses");
            ResultSet rs=st.executeQuery();
            while (rs.next()){
                pieChartData.add(new PieChart.Data(rs.getString(1),rs.getInt(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



        // Create the pie chart
        PieChart pieChart = new PieChart(pieChartData);

        pieChart.setLegendVisible(true);
        pieChart.setLegendSide(Side.RIGHT);

        pieChart.setLabelLineLength(0);
        pieChart.setLabelsVisible(false);



        home.getChildren().addAll(l1,lineContent,l2,pieChart);











        return home;

    }

}
