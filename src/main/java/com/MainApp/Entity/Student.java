package com.MainApp.Entity;

import com.MainApp.Repository.StudentRepositoryImpl;
import com.MainApp.Utility.DatabaseConnection;
import com.MainApp.Utility.UtilityFunc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Student {
   private static final Logger log = LoggerFactory.getLogger(Student.class);
   private int id;
   private String nama;
   private String password;
   private String kelas;
   private boolean work = false;
   private boolean online = false;

   DatabaseConnection database = new DatabaseConnection();
   StudentRepositoryImpl studentRepository = new StudentRepositoryImpl(database.getConnection());

   public boolean logInAccount(){
      log.info("mulai koneksi untuk login...");
      String nama = UtilityFunc.inputData("Masukan nama: ");
      String password = UtilityFunc.inputData("Masukan password: ");
      List <Student> student = studentRepository.findAllStudent();
      for (Student element : student){
         if (element.getNama().equals(nama) && element.getPassword().equals(password)){
            this.setId(element.getId());
            this.setNama(element.getNama());
            this.setPassword(element.getPassword());
            this.setKelas(element.getKelas());
            this.online = true;
            log.info("Log In berhasil");
            return true;
         }
      }
      log.info("Login gagal!!");
      System.out.println("Login Gagal!!");
      return false;
   }

   public void logOutAccount(){
      this.setId(0);
      this.setNama(null);
      this.setPassword(null);
      this.setKelas(null);
      this.online = false;
      log.info("Log Out berhasil");
   }

   public void registerAcoount(){
      String nama = UtilityFunc.inputData("Masukan nama: ");
      String password = UtilityFunc.inputData("Masukan password: ");
      String kelas = UtilityFunc.inputData("Masukan Kelas(id-kelas): ");
      List <Student> student = studentRepository.findAllStudent();

      setNama(nama);
      setPassword(password);
      setKelas(kelas);

      boolean isExist = true;
      for (Student element : student){
         if (element.getNama().equals(nama) || element.getPassword().equals(password)){
            System.out.println("Data siswa sudah terdaftar");
            log.info("Data siswa sudah ada");
            isExist = false;
            break;
         }
      }
         if (isExist){
            studentRepository.addStudent(this);
            setNama(null);
            setPassword(null);
            setKelas(null);
         }
   }

   public void StudentWorking(){
      System.out.println("Student is working");
      this.work = !this.work;
   }








   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getNama() {
      return nama;
   }

   public void setNama(String nama) {
      this.nama = nama;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getKelas() {
      return kelas;
   }

   public void setKelas(String kelas) {
      this.kelas = kelas;
   }

   public boolean isWork() {
      return work;
   }

   public void setWork(boolean work) {
      this.work = work;
   }

   public boolean isOnline() {
      return online;
   }

   public void setOnline(boolean online) {
      this.online = online;
   }
}
