package com.MainApp.Repository;

import com.MainApp.Entity.EntityAfterLogin.Task;

import java.util.List;

public interface TaskRepository {
   public List<Task> findAllTask();
   public Task findById(int id);
   public void addTask(Task task);
   public void editTask(Task task);
   public void removeTask(int id);

}
