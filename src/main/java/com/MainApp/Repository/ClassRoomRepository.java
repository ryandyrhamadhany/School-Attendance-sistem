package com.MainApp.Repository;

import com.MainApp.Entity.EntityForData.Classroom;

import java.util.List;

public interface ClassRoomRepository {
   public List<Classroom> findAllClassroom();
   public void findByIdClassroom(int id);
   public void addClassroom();
   public void editClassroom();
   public void removeClassroom();
}
