package com.MainApp.Service;

import com.MainApp.Entity.Attendance;
import com.MainApp.Entity.EntityAfterLogin.Task;
import com.MainApp.Entity.EntityAfterLogin.TaskHistory;
import com.MainApp.Entity.EntityForData.Classroom;
import com.MainApp.Entity.Student;
import com.MainApp.Repository.AttendanceRepositoryImpl;
import com.MainApp.Repository.TaskHistoryRepositoryImpl;
import com.MainApp.Repository.TaskRepositoryImpl;
import com.MainApp.Utility.UtilityFunc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ShcoolAttendanceSystem {
   private static final Logger log = LoggerFactory.getLogger(ShcoolAttendanceSystem.class);
   private Classroom classroom;
   private Task task;
   private TaskHistory taskHistory;
   private Student student;
   private Attendance attendance;

   private TaskRepositoryImpl taskRepository = new TaskRepositoryImpl();
   private AttendanceRepositoryImpl attendanceRepository = new AttendanceRepositoryImpl();
   private TaskHistoryRepositoryImpl taskHistoryRepository = new TaskHistoryRepositoryImpl();

   List<Task> listTask = new ArrayList<>();

   public ShcoolAttendanceSystem(Task task, TaskHistory taskHistory, Student student, Attendance attendance) {
      this.task = task;
      this.taskHistory = taskHistory;
      this.student = student;
      this.attendance = attendance;
   }

   public ShcoolAttendanceSystem(Classroom classroom, Task task, TaskHistory taskHistory, Student student, Attendance attendance) {
      this.classroom = classroom;
      this.task = task;
      this.taskHistory = taskHistory;
      this.student = student;
      this.attendance = attendance;
   }




   public void addAttendance(){
      if (student.isOnline()){
         attendance.checkAttendanceTimeAndStatus();
         attendanceRepository.addAttendance(attendance);
      }else {
         log.info("Student is Offline Can't Add Attendance");
      }
   }

   public void displayTaskList(){
      listTask = taskRepository.findAllTask();
      System.out.println("_____Pilih Tugas_____");
      for (int i=0; i< listTask.size(); i++){
         System.out.println((i+1)+". "+listTask.get(i).getNama_tugas());
      }
      String pilih = UtilityFunc.inputData("Masukan Pilihan Anda: ");
      for (int i=0; i< listTask.size(); i++){
         if ((i+1) == Integer.parseInt(pilih)){
            task.setId(listTask.get(i).getId());
            task.setNama_tugas(listTask.get(i).getNama_tugas());
            System.out.println("siswa Sedang mengerjakan tugas "+task.getNama_tugas()+"...");
         }
      }
      log.info("siswa Sedang mengerjakan tugas...");
      student.StudentWorking();
   }

   public void sendTask(){
      if (student.isWork()){
         String waktu_selesai_tugas = LocalDateTime.of(LocalDate.now(), LocalTime.now()).toString().replace("T",",");
         taskHistory.setWaktu_selesai(waktu_selesai_tugas);
         taskHistory.cekStatus();
         taskHistoryRepository.addTaskHistory(taskHistory);
      }
   }

}
