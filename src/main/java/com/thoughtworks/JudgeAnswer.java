package com.thoughtworks;

import java.util.HashSet;
import java.util.Set;

public class JudgeAnswer {
    String input;
    String realAnswer;

    public JudgeAnswer() {
    }

    public JudgeAnswer(String input, String realAnswer) {
        this.input = input;
        this.realAnswer = realAnswer;
    }

    public String offerOutput()  {
        IsRightAnswer isRightAnswer = new IsRightAnswer();
        StringBuilder stringBuilder= new StringBuilder(input);
        if(!isRightAnswer.isRightAnswer(input)){
            stringBuilder.append(" Wrong input");
            try {
                throw new WrongInputException();
            } catch (WrongInputException e) {
                System.out.println(stringBuilder.toString());
                return null;
            }
        }
        Set<Character> set = new HashSet<>();
        int countA = 0;
        int countB = 0;
        for(int i=0;i<realAnswer.length();i++){
            set.add(realAnswer.charAt(i));
        }
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)==realAnswer.charAt(i)){
                countA++;
            }else{
                if(set.contains(input.charAt(i))){
                    countB++;
                }
            }
        }
        if(countA==4){
            stringBuilder.append("Win, all correct!");
        }
        stringBuilder.append(" "+countA+"A"+countB+"B");
        return stringBuilder.toString();
    }
}
