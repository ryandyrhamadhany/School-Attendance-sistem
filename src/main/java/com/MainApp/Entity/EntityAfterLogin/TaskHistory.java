package com.MainApp.Entity.EntityAfterLogin;

import com.MainApp.Entity.Attendance;
import com.MainApp.Entity.Student;

public class TaskHistory {
   private int id;
   private String waktu_selesai;
   private String status;
   private Task task;
   private Student student;
   private Attendance attendance;

   public void cekStatus(){
      if (attendance.getStatus().equalsIgnoreCase("hadir")){
         status = StatusTugas.TEPAT_WAKTU.toString();
      }else {
         status = StatusTugas.TIDAK_TEPAT_WAKTU.toString();
      }
   }


   public TaskHistory(Task task, Student student, Attendance attendance) {
      this.task = task;
      this.student = student;
      this.attendance = attendance;
   }

   public TaskHistory(int id, String waktu_selesai, String status, Task task, Student student) {
      this.id = id;
      this.waktu_selesai = waktu_selesai;
      this.status = status;
      this.task = task;
      this.student = student;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getWaktu_selesai() {
      return waktu_selesai;
   }

   public void setWaktu_selesai(String waktu_selesai) {
      this.waktu_selesai = waktu_selesai;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public Task getTask() {
      return task;
   }

   public void setTask(Task task) {
      this.task = task;
   }

   public Student getStudent() {
      return student;
   }

   public void setStudent(Student student) {
      this.student = student;
   }
}
