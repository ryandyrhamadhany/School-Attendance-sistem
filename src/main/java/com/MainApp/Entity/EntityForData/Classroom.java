package com.MainApp.Entity.EntityForData;

public class Classroom {
   private int id;
   private String nama;
   private String jam_mulai;
   private String jam_selesai;

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

   public String getJam_mulai() {
      return jam_mulai;
   }

   public void setJam_mulai(String jam_mulai) {
      this.jam_mulai = jam_mulai;
   }

   public String getJam_selesai() {
      return jam_selesai;
   }

   public void setJam_selesai(String jam_selesai) {
      this.jam_selesai = jam_selesai;
   }
}
