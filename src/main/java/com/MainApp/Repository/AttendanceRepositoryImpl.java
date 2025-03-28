package com.MainApp.Repository;

import com.MainApp.Entity.Attendance;
import com.MainApp.Utility.DatabaseConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AttendanceRepositoryImpl implements AttendanceRepository{

   private static final Logger log = LoggerFactory.getLogger(AttendanceRepositoryImpl.class);
   Connection connection = new DatabaseConnection().getConnection();

   @Override
   public void findAllAttandence() {

   }

   @Override
   public void addAttendance(Attendance attendance) {
      try {
         log.info("Mulai koneksi untuk menambahkan absen");
         Statement exec = connection.createStatement();
         String query = "insert into absen (id_siswa,waktu_absen,status) values ("+attendance.getStudent().getId()+",'"+attendance.getWaktuAbsen()+"','"+attendance.getStatus()+"')";
         exec.executeUpdate(query);
         System.out.println("Berhasil menambahkan absen!!");
         log.info("Berhasil menambahkan absen!!");
      }catch (SQLException e){
         e.printStackTrace();
      }
   }
}
