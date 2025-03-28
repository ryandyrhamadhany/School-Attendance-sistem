package com.MainApp.Repository;

import com.MainApp.Entity.EntityAfterLogin.TaskHistory;

import java.util.List;

public interface TaskHistoryRepository {
   public List<TaskHistory> findAllTaskHistory();
   public TaskHistory findById(int id);
   public void addTaskHistory(TaskHistory task);
   public void editTaskHistory(TaskHistory task);
   public void removeTaskHistory(int id);
}
