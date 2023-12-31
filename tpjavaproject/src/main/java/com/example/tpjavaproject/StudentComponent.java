package com.example.tpjavaproject;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class StudentComponent {
    public VBox StudentVbox(){

        VBox home=new VBox();
        Button b1=new Button("this is student");
        home.getChildren().add(b1);
        return home;

    }
}
