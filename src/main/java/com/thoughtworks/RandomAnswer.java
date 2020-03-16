package com.thoughtworks;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomAnswer implements Answer {
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


}
