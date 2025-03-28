package com.MainApp.UnitTestingForInput;

import com.MainApp.Entity.Attendance;
import com.MainApp.Entity.EntityAfterLogin.Task;
import com.MainApp.Entity.EntityAfterLogin.TaskHistory;
import com.MainApp.Entity.Student;

import java.time.LocalTime;

public class TestApp {
   public static void main(String[] args) {
      TestApp app = new TestApp();
//      app.testTaskHistory();
      app.testAttandence();
   }

   public void testAttandence(){
      Student student = new Student();
      student.logInAccount();
      Attendance attendance = new Attendance(student);
      attendance.checkAttendanceTimeAndStatus();
      System.out.println(attendance.getId());
      System.out.println(attendance.getStudent().getId());
      System.out.println(attendance.getWaktuAbsen());
      System.out.println(attendance.getStatus());
   }

   public void testTaskHistory(){
      Task task = new Task();
      Student student = new Student();
      Attendance attendance = new Attendance(student);
      TaskHistory taskHistory = new TaskHistory(task,student,attendance);

      student.logInAccount();
      attendance.checkAttendanceTimeAndStatus();
      task.setId(1);
      task.setNama_tugas("matematika");
      taskHistory.setWaktu_selesai(LocalTime.now().toString());
      taskHistory.cekStatus();

      System.out.println(taskHistory.getId());
      System.out.println(taskHistory.getTask().getId());
      System.out.println(taskHistory.getStudent().getId());
      System.out.println(taskHistory.getWaktu_selesai());
      System.out.println(taskHistory.getStatus());
   }
}
