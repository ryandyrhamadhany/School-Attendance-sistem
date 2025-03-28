package com.MainApp.Trash;

import com.MainApp.Entity.Attendance;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CompareWaktuTest {
   @Test
   void test_waktu() {
      String time = LocalTime.now().toString();
      System.out.println(time);

   }

   @Test
   void testWaktuSplit() {
      Attendance attendance = new Attendance();
      int [] timeResult = attendance.checkTime("15:47:59");
      for (int element : timeResult){
         System.out.println(element);
      }
   }

   @Test
   void ubahFormatWaktu() {

      LocalDateTime time = LocalDateTime.of(LocalDate.of(2025,5,20),LocalTime.of(15,40,30));
      System.out.println(time.toString().replace("T",","));
   }
}
