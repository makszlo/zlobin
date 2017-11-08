package ru.job4j.loop;
/**
 * Class for pyramid painting task.
 * @author Maxim Zlobin (mailto:hlabn@yandex.ru)
 * @since 08.11.2017
 * @version 0.1
 */
public class Paint {
    /**
     * Метод для создания переменной String с рисунком пирамиды
     * @param h - высота пирамиды
     * @return - рисунок пирамиды из символов "^"
     */
    public String piramid(int h) {
        int weight = 1 + (h - 1) * 2;
        int centPos = (weight - 1) / 2;
        String newLine = System.getProperty("line.separator");
        StringBuilder tmp = new StringBuilder();
        for (int i = 1; i <= h; i++) {
            int posStart = centPos - (i - 1);
            int posEnd = centPos + (i - 1);
            for (int j = 0; j < weight; j++) {
                if (j >= posStart && j <= posEnd) {
                    tmp.append("^");
                } else {
                    tmp.append(" ");
                }
            }
            if (i != h) {
                tmp.append(newLine);
            }
        }
        return tmp.toString();
    }
}
