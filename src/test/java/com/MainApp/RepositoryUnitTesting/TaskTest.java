package com.MainApp.RepositoryUnitTesting;

import com.MainApp.Entity.EntityAfterLogin.Task;
import com.MainApp.Repository.TaskRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TaskTest {
   @Test
   void tugastest() {
      List<Task> tasks = new ArrayList<>();
      TaskRepositoryImpl taskRepository = new TaskRepositoryImpl();
      tasks = taskRepository.findAllTask();

      for (int i=0; i< tasks.size(); i++){
         System.out.println(tasks.get(i).getId());
         System.out.println(tasks.get(i).getNama_tugas());
      }
   }

   @Test
   void tugasTambahTest() {
      Task task = new Task();
      task.setNama_tugas("Fisika");
      TaskRepositoryImpl taskRepository = new TaskRepositoryImpl();
      taskRepository.addTask(task);
   }
}
