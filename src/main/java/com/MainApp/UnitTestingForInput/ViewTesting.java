package com.MainApp.UnitTestingForInput;

import com.MainApp.View.ViewAplikasiMain;

public class ViewTesting {

   public static void main(String[] args) {
      LogOUutAccount();
   }

   public static void registerAccount(){
      ViewAplikasiMain viewAplikasiMain = new ViewAplikasiMain();
      viewAplikasiMain.viewRegisterAccount();
   }

   public static void LoginAccount(){
      ViewAplikasiMain viewAplikasiMain = new ViewAplikasiMain();
      viewAplikasiMain.viewLogin();
   }

   public static void LogOUutAccount(){
      ViewAplikasiMain viewAplikasiMain = new ViewAplikasiMain();
      viewAplikasiMain.viewLogOutAccount();
   }
}
