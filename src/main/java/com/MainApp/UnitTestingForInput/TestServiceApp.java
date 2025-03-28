package com.MainApp.UnitTestingForInput;

import com.MainApp.Entity.Attendance;
import com.MainApp.Entity.EntityAfterLogin.Task;
import com.MainApp.Entity.EntityAfterLogin.TaskHistory;
import com.MainApp.Entity.Student;
import com.MainApp.Service.ShcoolAttendanceSystem;

public class TestServiceApp {
   Student student = new Student();
   Attendance attendance = new Attendance(student);

   Task task = new Task();
   TaskHistory taskHistory = new TaskHistory(task,student,attendance);

   ShcoolAttendanceSystem shcoolAttendanceSystem = new ShcoolAttendanceSystem(task,taskHistory,student,attendance);

   public static void main(String[] args) {
      TestServiceApp testServiceApp = new TestServiceApp();
      testServiceApp.student.logInAccount();
      testServiceApp.attendance.checkAttendanceTimeAndStatus();
//
//      testServiceApp.addAttendance();
      testServiceApp.shcoolAttendanceSystem.displayTaskList();

      testServiceApp.shcoolAttendanceSystem.sendTask();

   }

   public void addAttendance(){
      shcoolAttendanceSystem.addAttendance();
   }
}
