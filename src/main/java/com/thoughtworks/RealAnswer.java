package com.thoughtworks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RealAnswer {
    String answer;

    public RealAnswer() {
    }

    public String getAnswer() {
        try {
            String readAnswer = readFile();
            if (isRightAnswer(readAnswer)) {
                return readAnswer;
            } else {
                return getRandomAnswer();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getRandomAnswer();
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isRightAnswer(String string) {
        if (string.length() != 4) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (ch < '0' || ch > '9') {
                return false;
            }
            if (set.contains(ch)) {
                return false;
            } else {
                set.add(ch);
            }
        }
        return true;
    }

    public String getRandomAnswer() {
        Set<Integer> set = new HashSet<>();
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        while (stringBuilder.length() < 4) {
            int i = random.nextInt(9);
            if (!set.contains(i)) {
                stringBuilder.append(i);
                set.add(i);
            }
        }
        return stringBuilder.toString();
    }

    public String readFile() throws IOException {
        try (Reader input = new FileReader(".\\src\\main\\resources\\answer.txt")) {
            BufferedReader br = new BufferedReader(input);
            return br.readLine();
        }
    }
}
