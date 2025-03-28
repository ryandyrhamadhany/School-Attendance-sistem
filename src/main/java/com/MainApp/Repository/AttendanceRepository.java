package com.MainApp.Repository;

import com.MainApp.Entity.Attendance;

public interface AttendanceRepository {
   public void findAllAttandence();
   public void addAttendance(Attendance attendance);
}
