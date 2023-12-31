package com.example.tpjavaproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDataBase{

    public  static Connection  connect(){
        String nomDriver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://127.0.0.1/course_data";
        String user="root";
        String mp="";
        Connection con=null;
        try {
            Class.forName(nomDriver);
            con= DriverManager.getConnection(url,user,mp);
            System.out.println("conncted to dataBase");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;

    }


}
