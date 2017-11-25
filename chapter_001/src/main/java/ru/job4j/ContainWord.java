package ru.job4j;

public class ContainWord {
    public boolean contains(String origin, String sub) {
        int coincidenceCounter = 0;
        char[] originCh = origin.toCharArray();
        char[] subCh = sub.toCharArray();
        int subLength = sub.length();
        for (int i = 0; i <= origin.length() - subLength; i++) {
            if ((originCh[i] == subCh[0]) && (coincidenceCounter != subLength)) {
                coincidenceCounter = 1;
                for (int j = i + 1; j < i + subLength; j++) {
                    if (originCh[j] == subCh[j - i]) {
                        coincidenceCounter++;
                    } else {
                        break;
                    }
                }
            }
        }
        return coincidenceCounter == subLength;
    }
}

