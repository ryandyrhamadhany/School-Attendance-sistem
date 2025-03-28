package com.MainApp.Trash;

import com.MainApp.Entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EntityTest {
   @Test
   void entitytesting() {
      Student student = new Student();
      student.registerAcoount();
   }

   @Test
   void testStudentLogin() {
      Student student = new Student();
      Assertions.assertEquals(true,student.logInAccount());
   }

   @Test
   void testlogicGate() {
      boolean halo = true || true || false;
      System.out.println(halo);
   }
}
