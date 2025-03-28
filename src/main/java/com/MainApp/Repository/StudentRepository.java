package com.MainApp.Repository;

import com.MainApp.Entity.Student;

import java.util.List;

public interface StudentRepository {

   public List<Student> findAllStudent();
   public Student findById(int id);
   public void addStudent(Student student);
   public void editStudent(int id,Student student);
   public void hapusStudent(int id);

}
