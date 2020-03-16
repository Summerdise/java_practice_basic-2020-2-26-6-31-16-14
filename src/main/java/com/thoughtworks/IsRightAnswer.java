package com.thoughtworks;

import java.util.HashSet;
import java.util.Set;

public class IsRightAnswer implements Answer{
    public IsRightAnswer() {
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
}
