package com.MainApp.Trash;

import com.MainApp.Entity.Student;
import com.MainApp.Repository.StudentRepositoryImpl;
import com.MainApp.Utility.DatabaseConnection;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ConnectionTest {
   @Test
   void name() {
      Connection connection = new DatabaseConnection().getConnection();
   }

   @Test
   void findAllTest() {
      Connection connection = new DatabaseConnection().getConnection();
      StudentRepositoryImpl studentRepository = new StudentRepositoryImpl(connection);
      List<Student> students = new ArrayList<>();
      students = studentRepository.findAllStudent();

      for (int i=0; i<students.size(); i++){
         System.out.println(students.get(i).getId());
         System.out.println(students.get(i).getNama());
         System.out.println(students.get(i).getPassword());
         System.out.println(students.get(i).getKelas());
      }
   }
}
