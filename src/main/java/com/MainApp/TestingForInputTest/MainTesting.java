package com.MainApp.TestingForInputTest;

import com.MainApp.Entity.Attendance;
import com.MainApp.Entity.Student;

public class MainTesting {
   public static void main(String[] args) {
      Student student = new Student();
      if (student.logInAccount()){
         Attendance attendance = new Attendance(student);
         attendance.checkAttendanceTimeAndStatus();

         System.out.println(attendance.getId());
         System.out.println(attendance.getWaktuAbsen());
         System.out.println(attendance.getStatus());
      }
   }
}
