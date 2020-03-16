package com.thoughtworks;

import java.util.ArrayList;

public class PrintMachine {
    ArrayList<String> inputList;

    public PrintMachine() {
        inputList = new ArrayList<>();
    }

    public ArrayList<String> getInputList() {
        return inputList;
    }

    public void setInputList(ArrayList<String> inputList) {
        this.inputList = inputList;
    }

    public void updateAndPrintList(String input, String realAnswer) throws WrongInputException {
        JudgeAnswer judgeAnswer = new JudgeAnswer(input,realAnswer);
        for(String i: inputList){
            System.out.println(i);
        }
        String info = judgeAnswer.offerOutput();
        if(info!=null){
            inputList.add(info);
            System.out.println(info);
        }
    }

}
