package service;

import java.util.Scanner;

public class HelloService {
   public static void hello() {
       System.out.println("Привет! Что хотите сделать? \n 1 - Login \n 2 - Register \n 3 - exit");
       Scanner sc = new Scanner(System.in);
       switch (sc.nextInt()) {
           case 1: LoginService.login();
           break;
           default:
               System.out.println("Досвидос");
       }
   }
}
