module com.example.tpjavaproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.tpjavaproject to javafx.fxml;
    exports com.example.tpjavaproject;
}