package com.MainApp.View;

import com.MainApp.Entity.Attendance;
import com.MainApp.Entity.EntityAfterLogin.Task;
import com.MainApp.Entity.EntityAfterLogin.TaskHistory;
import com.MainApp.Entity.Student;
import com.MainApp.Service.ShcoolAttendanceSystem;
import com.MainApp.Utility.UtilityFunc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ViewAplikasiMain {
   private static final Logger log = LoggerFactory.getLogger(ViewAplikasiMain.class);
   Student student = new Student();
   Attendance attendance = new Attendance(student);

   Task task = new Task();
   TaskHistory taskHistory = new TaskHistory(task,student,attendance);

   ShcoolAttendanceSystem shcoolAttendanceSystem = new ShcoolAttendanceSystem(task,taskHistory,student,attendance);

   public void view(){
      while (true){
         System.out.println();
         System.out.println("_____Aplikasi sistem absen sekolah_____");
         System.out.println("1. Log In");
         System.out.println("2. Register Account");
         System.out.println("3. Log Out");
         String pilih = UtilityFunc.inputData("Masukan Pilihan Anda: ");
         if (pilih.equals("1")){
            viewLogin();
         } else if (pilih.equals("2")) {
            viewRegisterAccount();
         } else if (pilih.equals("3")) {
            viewLogOutAccount();
            break;
         }
      }
   }

   public void viewLogin(){

      System.out.println("_____Log In Account_____");
      student.logInAccount();
      shcoolAttendanceSystem.addAttendance();
      shcoolAttendanceSystem.displayTaskList();
      shcoolAttendanceSystem.sendTask();
      student.StudentWorking();
   }

   public void viewRegisterAccount(){
      System.out.println("_____Register Account_____");
      student.registerAcoount();
   }

   public void viewLogOutAccount(){
      System.out.println("_____Log Out Account_____");
      String pilih = UtilityFunc.inputData("Apakah Anda ingin log out (y/n): ");
      if (pilih.equals("y")){
         student.setOnline(false);
      }else {
         
      }
   }

}
