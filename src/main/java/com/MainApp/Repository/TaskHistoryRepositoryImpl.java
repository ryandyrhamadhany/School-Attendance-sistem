package com.MainApp.Repository;

import com.MainApp.Entity.Attendance;
import com.MainApp.Entity.EntityAfterLogin.Task;
import com.MainApp.Entity.EntityAfterLogin.TaskHistory;
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

public class TaskHistoryRepositoryImpl implements TaskHistoryRepository{

   private static final Logger log = LoggerFactory.getLogger(TaskHistoryRepositoryImpl.class);

   private List<TaskHistory> taskHistoryList = new ArrayList<>();
   Connection connection = new DatabaseConnection().getConnection();

   @Override
   public List<TaskHistory> findAllTaskHistory() {
      try {
         String query = "select " +
                 "tugas_history.id," +
                 "tugas.id as id_tugas," +
                 "siswa.id as id_siswa," +
                 "tugas_history.waktu_selesai," +
                 "tugas_history.status" +
                 " from" +
                 " tugas_history" +
                 " join" +
                 " tugas on tugas_history.id_tugas=tugas.id" +
                 " join" +
                 " siswa on tugas_history.id_siswa=siswa.id";
         Statement statement = connection.createStatement();
         ResultSet set = statement.executeQuery(query);

         while (set.next()){
            Task task = new Task();
            Student student = new Student();
            Attendance attendance = new Attendance();
            TaskHistory taskHistory = new TaskHistory(task,student,attendance);
            taskHistory.setId(set.getInt("id"));
            taskHistory.setWaktu_selesai(set.getString("waktu_selesai"));
            taskHistory.setStatus(set.getString("status"));
            taskHistoryList.add(taskHistory);
         }

      }catch (SQLException e){
         e.printStackTrace();
      }
      return taskHistoryList;
   }

   @Override
   public TaskHistory findById(int id) {
      return null;
   }

   @Override
   public void addTaskHistory(TaskHistory taskHistory) {
      try {
         log.info("Mulai connection untuk menambahkan data tugas history...");

         String value = "("+taskHistory.getTask().getId()+","+taskHistory.getStudent().getId()+",'"+taskHistory.getWaktu_selesai()+"','"+taskHistory.getStatus()+"')";
         String query = "insert into tugas_history (id_tugas,id_siswa,waktu_selesai,status) values "+value;
         Statement exec = connection.createStatement();
         exec.executeUpdate(query);

         exec.close();

         log.info("Berhasil menambahkan data tugas history!!");

      }catch (SQLException e){
         e.printStackTrace();
      }
   }

   @Override
   public void editTaskHistory(TaskHistory task) {

   }

   @Override
   public void removeTaskHistory(int id) {

   }
}
