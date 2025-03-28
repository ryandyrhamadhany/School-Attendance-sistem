package com.MainApp.Repository;

import com.MainApp.Entity.EntityForData.Classroom;
import com.MainApp.Utility.DatabaseConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClassroomRepositoryImpl implements ClassRoomRepository{
   private static final Logger log = LoggerFactory.getLogger(ClassroomRepositoryImpl.class);
   Connection connection = new DatabaseConnection().getConnection();
   List<Classroom> listClass = new ArrayList<Classroom>();

   @Override
   public List<Classroom> findAllClassroom() {
      try {
         log.info("mulai connection dari repository untuk ambil data");
         Statement rs = connection.createStatement();
         String query = "select " +
                 "id," +
                 "kelas," +
                 "waktu_mulai," +
                 "waktu_selesai" +
                 " from" +
                 " kelas";
         ResultSet st = rs.executeQuery(query);
         while (st.next()){
            Classroom classroom = new Classroom();
            classroom.setId(st.getInt("id"));
            classroom.setNama(st.getString("kelas"));
            classroom.setJam_mulai(st.getString("waktu_mulai"));
            classroom.setJam_selesai(st.getString("waktu_selesai"));
            listClass.add(classroom);
         }

         rs.close();
      }catch (SQLException e){
         e.printStackTrace();
      }
      log.info("Data dari database berhasil dibaca");
      return listClass;
   }

   @Override
   public void findByIdClassroom(int id) {

   }

   @Override
   public void addClassroom() {

   }

   @Override
   public void editClassroom() {

   }

   @Override
   public void removeClassroom() {

   }
}
