package com.MainApp.Utility;

import java.util.Scanner;

public class UtilityFunc {

   private static Scanner scanner = new Scanner(System.in);

   public static String inputData(String info){
      System.out.print(info);
      String input = scanner.nextLine();
      return input;
   }
}
