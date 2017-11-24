package ru.job4j;

public class ContainWord {
    public boolean contains(String origin, String sub) {
        int coincidenceCounter = 0;
        int wordDiff = origin.length() - sub.length();
        char[] originCh = origin.toCharArray();
        char[] subCh = sub.toCharArray();
        if (wordDiff >= 0) {
            for (int i = 0; i <= wordDiff; i++) {
                if (originCh[i] == subCh[0]) {
                    for (int j = i; j < i + sub.length(); j++) {
                        if (originCh[j] == subCh[j - i]) {
                            coincidenceCounter++;
                        } else {
                            break;
                        }
                    }
                    if (coincidenceCounter == sub.length()) {
                        return true;
                    } else {
                        coincidenceCounter = 0;
                    }
                }
            }
            return false;
        } else {
            return false;
        }
    }
}
