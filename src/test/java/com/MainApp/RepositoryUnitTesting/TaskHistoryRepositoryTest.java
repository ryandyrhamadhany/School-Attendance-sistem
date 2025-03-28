package com.MainApp.RepositoryUnitTesting;

import com.MainApp.Entity.Attendance;
import com.MainApp.Entity.EntityAfterLogin.Task;
import com.MainApp.Entity.EntityAfterLogin.TaskHistory;
import com.MainApp.Entity.StatusHadir;
import com.MainApp.Entity.Student;
import com.MainApp.Repository.TaskHistoryRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TaskHistoryRepositoryTest {
   @Test
   void testTambahHistoryAbsen() {
      Task task = new Task();
      task.setId(1);
      task.setNama_tugas("Matematika");

      Student student = new Student();
      student.setId(3);
      Attendance attendance = new Attendance(student);
      attendance.setId(1);
      attendance.setStatus(StatusHadir.HADIR.toString());

      TaskHistory taskHistory = new TaskHistory(task,student, attendance);
      taskHistory.setWaktu_selesai(LocalDateTime.of(LocalDate.now(), LocalTime.now()).toString().replace("T",","));
      taskHistory.cekStatus();

      TaskHistoryRepositoryImpl taskHistoryRepository = new TaskHistoryRepositoryImpl();

      taskHistoryRepository.addTaskHistory(taskHistory);
   }
}
