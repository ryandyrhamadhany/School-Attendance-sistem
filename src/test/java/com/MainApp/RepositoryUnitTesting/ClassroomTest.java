package com.MainApp.RepositoryUnitTesting;

import com.MainApp.Entity.EntityForData.Classroom;
import com.MainApp.Repository.ClassroomRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ClassroomTest {
   @Test
   void kelasTest() {
      List<Classroom> classrooms = new ArrayList<>();
      ClassroomRepositoryImpl classroomRepository = new ClassroomRepositoryImpl();
      classrooms = classroomRepository.findAllClassroom();
      for (int i=0; i< classrooms.size(); i++){
         System.out.println(classrooms.get(i).getId());
         System.out.println(classrooms.get(i).getNama());
         System.out.println(classrooms.get(i).getJam_mulai());
         System.out.println(classrooms.get(i).getJam_selesai());
      }
   }
}
