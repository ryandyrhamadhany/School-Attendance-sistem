package com.MainApp.RepositoryUnitTesting;

import com.MainApp.Entity.Attendance;
import com.MainApp.Entity.StatusHadir;
import com.MainApp.Entity.Student;
import com.MainApp.Repository.AttendanceRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AttendanceTest {
   @Test
   void absenTest() {
      Student student = new Student();
      student.setId(3);
      Attendance attendance = new Attendance(student);
      attendance.setWaktuAbsen(LocalDateTime.of(LocalDate.now(), LocalTime.now()).toString().replace("T",","));
      attendance.setStatus(StatusHadir.HADIR.toString());
      AttendanceRepositoryImpl attendanceRepository = new AttendanceRepositoryImpl();
      attendanceRepository.addAttendance(attendance);
   }
}
