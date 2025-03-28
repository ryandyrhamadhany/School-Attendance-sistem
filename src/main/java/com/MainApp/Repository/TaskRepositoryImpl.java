package com.MainApp.Repository;

import com.MainApp.Entity.EntityAfterLogin.Task;
import com.MainApp.Utility.DatabaseConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository{

   private static final Logger log = LoggerFactory.getLogger(TaskRepositoryImpl.class);
   private List<Task> listTask = new ArrayList<>();
   Connection connection = new DatabaseConnection().getConnection();

   @Override
   public List<Task> findAllTask() {
      try {
         log.info("Mulai connection untuk ambil data task...");
         String query = "select * from tugas";
         Statement exec = connection.createStatement();
         ResultSet set = exec.executeQuery(query);

         while (set.next()){
            Task task = new Task();
            task.setId(set.getInt("id"));
            task.setNama_tugas(set.getString("nama_tugas"));
            listTask.add(task);
         }

         set.close();
      }catch (SQLException e){
         e.printStackTrace();
      }
      log.info("Data berhasil dibaca!!");
      return listTask;
   }

   @Override
   public Task findById(int id) {
      return null;
   }

   @Override
   public void addTask(Task task) {
      try {
         log.info("Mulai connection untuk menambahkan data tugas...");

         String value = "('"+task.getNama_tugas()+"')";
         String query = "insert into tugas (nama_tugas) values "+value;
         Statement exec = connection.createStatement();
         exec.executeUpdate(query);
         exec.close();

         log.info("Berhasil menambahkan data tugas!!");

      }catch (SQLException e){
         e.printStackTrace();
      }
   }

   @Override
   public void editTask(Task task) {

   }

   @Override
   public void removeTask(int id) {

   }
}
