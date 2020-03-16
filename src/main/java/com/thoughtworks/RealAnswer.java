package com.thoughtworks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class RealAnswer implements Answer{
    String answer;

    public RealAnswer() {
    }

    public String getAnswer() {
        RandomAnswer randomAnswer = new RandomAnswer();
        try {
            String readAnswer = readFile();
            IsRightAnswer isRightAnswer = new IsRightAnswer();
            if (isRightAnswer.isRightAnswer(readAnswer)) {
                return readAnswer;
            } else {
                return randomAnswer.getRandomAnswer();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return randomAnswer.getRandomAnswer();
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


    public String readFile() throws IOException {
        try (Reader input = new FileReader(".\\src\\main\\resources\\answer.txt")) {
            BufferedReader br = new BufferedReader(input);
            return br.readLine();
        }
    }
}
