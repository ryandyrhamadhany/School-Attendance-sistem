package com.MainApp.Repository;

public interface SchoolSystemRepository {
   public void getAllTask();
   public void getTaskById(int id);
   public void addTask(int id, String TaskName);
   public void editTask(int id, String TaskName);
   public void deleteTask(int id);

   public void getAllTaskHistory();
   public void addTaskHistory(int id,int idTask, int idStudent,String tgl_wwaktu,String status);
}
