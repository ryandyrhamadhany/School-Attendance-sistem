package com.MainApp.Utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
   private String [] data = {"root",""};
   private String url = "jdbc:mysql://localhost:3306/absen_sekolah";
   private Logger log = LoggerFactory.getLogger(DatabaseConnection.class);

   private Connection connection;

   public DatabaseConnection() {
      try {

         Class.forName("com.mysql.cj.jdbc.Driver");
         Driver mysql = new com.mysql.cj.jdbc.Driver();
         DriverManager.registerDriver(mysql);
         log.info("Koneksi Berhasil!!");

      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public Connection getConnection(){
      try {
         return DriverManager.getConnection(url,data[0],data[1]);
      }catch (SQLException e){
         e.printStackTrace();
      }
      return null;
   }

}
