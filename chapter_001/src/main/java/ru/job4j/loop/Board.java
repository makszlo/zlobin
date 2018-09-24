package ru.job4j.loop;
/**
 * Class for board task.
 * @author Maxim Zlobin (mailto:hlabn@yandex.ru)
 * @since 08.11.2017
 * @version 0.1
 */
public class Board {
    /**
     * Рисует шахматную доску
     * @param weight - ширина доски
     * @param height - высота доски
     * @return - String с шахматной доской
     */
    public String paint(int weight, int height) {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < weight; j++) {
                if ((i + j) % 2 == 0) {
                    tmp.append("X");
                } else {
                    tmp.append(" ");
                }
            }
            tmp.append(System.lineSeparator());
        }
        return tmp.toString();
    }
}
