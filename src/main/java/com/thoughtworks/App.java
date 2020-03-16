package com.thoughtworks;

import java.io.*;
import java.util.Scanner;

public class App {

  public static void main(String[] args) throws IOException, WrongInputException {
    RealAnswer realAnswer = new RealAnswer();
    String answer = realAnswer.getAnswer();
    Scanner scanner = new Scanner(System.in);
    PrintMachine printMachine = new PrintMachine();
    int count = printMachine.getInputList().size();
    while(count<6){
      String input = scanner.nextLine();
      printMachine.updateAndPrintList(input,answer);
      count = printMachine.getInputList().size();
      if(answer.equals(input)){
        break;
      }
    }
    System.out.println("Unfortunately, you have no chance, the answer is "+answer+"!");
  }
}
