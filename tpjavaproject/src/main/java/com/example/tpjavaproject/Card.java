package com.example.tpjavaproject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Card extends VBox {

    public Card(String title, String description, String imageUrl,int chapterNum) {
        // Create the title label
        Label titleLabel = new Label(title);
        titleLabel.getStyleClass().add("card-title");

        // Create the description label
        Label descriptionLabel = new Label(description);
        descriptionLabel.getStyleClass().add("card-description");

        VBox textContainer = new VBox();

        HBox hbutton=new HBox();
        Button chapter=new Button();
        chapter.setText(String.valueOf(chapterNum)+" chapter");
        Image chapImg=new Image("C:\\Users\\ASUS\\Desktop\\tpjavaproject\\src\\main\\resources\\chapter.png");
        ImageView chapView=new ImageView(chapImg);
        chapter.setGraphic(chapView);
        hbutton.setSpacing(20);
        Button Consult=new Button("Consult");
        Consult.setStyle("-fx-background-color:#56A2EC;-fx-text-fill:white;");
        hbutton.getChildren().addAll(chapter,Consult);


        textContainer.getChildren().addAll(descriptionLabel,titleLabel);


       // textContainer.setPadding(new Insets(10, 10, 10, 10));

        ImageView imageView = new ImageView(new Image(imageUrl));
        imageView.setFitWidth(230);
        imageView.setFitHeight(140);
        imageView.setSmooth(true);
        setPrefWidth(40);
        setMaxWidth(200);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(0);
        dropShadow.setOffsetY(3);
        dropShadow.setColor((Color) Paint.valueOf("00000025"));
        VBox info=new VBox();
        info.getChildren().addAll(textContainer,hbutton);
        info.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY,Insets.EMPTY)));
        info.setEffect(dropShadow);
        info.setPadding(new Insets(8));

        info.setSpacing(5);

        getChildren().addAll(imageView,info);

        getStyleClass().add("card");
    }
}
