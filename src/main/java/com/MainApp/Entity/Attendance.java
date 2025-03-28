package com.MainApp.Entity;

import com.MainApp.Entity.EntityForData.Classroom;
import com.MainApp.Repository.ClassroomRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Attendance {
   private static final Logger log = LoggerFactory.getLogger(Attendance.class);
   private int id;
   private String waktuAbsen;
   private String status;
   private Student student;
   private List<Classroom> listwaktu = new ArrayList<>();
   private ClassroomRepositoryImpl classroomRepository = new ClassroomRepositoryImpl();

   public int [] checkTime(String time){
      Scanner splitTime = new Scanner(time).useDelimiter(":");
      int [] timeResult = new int[3];
      for (int i=0; i<timeResult.length; i++){
         timeResult[i] = Integer.parseInt(splitTime.next());
      }
      return timeResult;
   }

   public void checkAttendanceTimeAndStatus(){
      if (student.isOnline()){
         int [] now = new int[3];
         now[0] = LocalTime.now().getHour();
         now[1] = LocalTime.now().getMinute();
         now[2] = LocalTime.now().getSecond();
         String timeNow = LocalDateTime.of(LocalDate.now(),LocalTime.of(now[0],now[1],now[2])).toString().replace("T",",");
         setWaktuAbsen(timeNow);

         listwaktu = classroomRepository.findAllClassroom();
         for (int i =0; i<listwaktu.size(); i++){
            if (listwaktu.get(i).getNama().equals(student.getKelas())){
//               setId(listwaktu.get(i).getId());
               int [] waktuMulai = checkTime(listwaktu.get(i).getJam_mulai());
               int [] waktuAkhir = checkTime(listwaktu.get(i).getJam_selesai());

               if (
                       (now[0] > waktuMulai[0] && now[0] < waktuAkhir[0]) ||
                               (now[1] > waktuMulai[1] && now[1] < waktuAkhir[1]) ||
                               (now[2] > waktuMulai[2] && now[2] < waktuAkhir[2])
               ){
                  setStatus(StatusHadir.HADIR.toString());
               } else if ((now[0] > waktuMulai[0] && now[0] > waktuAkhir[0])) {
                  setStatus(StatusHadir.TERLAMBAT.toString());
               }else {
                  setStatus(StatusHadir.TIDAK_HADIR.toString());
               }
            }
         }
      }else {
         log.info("Student is Offline Can't check Status");
      }
   }





   public Attendance() {
   }

   public Attendance(Student student) {
      this.student = student;
   }

   public Attendance(int id, String waktuAbsen, String status, Student student) {
      this.id = id;
      this.waktuAbsen = waktuAbsen;
      this.status = status;
      this.student = student;
   }

   public Student getStudent() {
      return student;
   }

   public void setStudent(Student student) {
      this.student = student;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getWaktuAbsen() {
      return waktuAbsen;
   }

   public void setWaktuAbsen(String waktuAbsen) {
      this.waktuAbsen = waktuAbsen;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }
}
