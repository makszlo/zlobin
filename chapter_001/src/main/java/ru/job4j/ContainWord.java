package ru.job4j;

public class ContainWord {
    /**
     * Метод для проверки содержится ли слово в строке текста
     * @param origin - строка текста
     * @param sub - проверяемое слово
     * @return - содержит / не содержит
     */
    public boolean contains(String origin, String sub) {
        int counter = 0;
        char[] originCh = origin.toCharArray();
        char[] subCh = sub.toCharArray();
        int length = sub.length();
        for (int i = 0; i <= origin.length() - length; i++) {
            if ((originCh[i] == subCh[0]) && (counter != length)) {
                counter = 1;
                for (int j = i + 1; j < i + length; j++) {
                    if (originCh[j] == subCh[j - i]) {
                        counter++;
                    } else {
                        break;
                    }
                }
            }
        }
        return counter == length;
    }
}

