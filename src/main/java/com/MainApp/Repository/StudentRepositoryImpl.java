package com.MainApp.Repository;

import com.MainApp.Entity.Student;
import com.MainApp.Utility.DatabaseConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository{
   private static final Logger log = LoggerFactory.getLogger(StudentRepositoryImpl.class);
   private List <Student> students = new ArrayList<Student>();
   Connection connection;

   public StudentRepositoryImpl(Connection connection) {
      this.connection = connection;
   }

   @Override
   public List<Student> findAllStudent() {
      try {
         log.info("mulai connection dari repository untuk ambil data");
         Statement rs = connection.createStatement();
         String query = "select " +
                  "siswa.id_siswa as id_siswa," +
                  "siswa.nama," +
                  "siswa.password," +
                  "kelas.kelas as kelas_siswa" +
                 " from" +
                  " siswa" +
                 " join" +
                  " kelas on siswa.id_kelas=kelas.id";
         ResultSet st = rs.executeQuery(query);
         while (st.next()){
            Student student = new Student();
            student.setId(st.getInt("id_siswa"));
            student.setNama(st.getString("nama"));
            student.setPassword(st.getString("password"));
            student.setKelas(st.getString("kelas_siswa"));
            students.add(student);
         }

         rs.close();
      }catch (SQLException e){
         e.printStackTrace();
      }
      log.info("Data dari database berhasil dibaca");
      return students;
   }

   @Override
   public Student findById(int id) {
      return null;
   }

   @Override
   public void addStudent(Student student) {
      try {
         log.info("Mulai Connection dari repository untuk tambah data");
         Statement rs = connection.createStatement();
         String value = "('"+student.getNama()+"','"+student.getPassword()+"',"+student.getKelas()+")";
         String query = "insert into siswa (nama,password,id_kelas) values "+value;
         rs.executeUpdate(query);
         log.info("data siswa berhasil ditambahkan!");
         rs.close();
      }catch (SQLException e){
         e.printStackTrace();
      }

   }

   @Override
   public void editStudent(int id, Student student) {

   }

   @Override
   public void hapusStudent(int id) {

   }
}
