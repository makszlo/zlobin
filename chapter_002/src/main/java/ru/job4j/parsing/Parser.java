package ru.job4j.parsing;

/**
 * Класс для парсера скобочных последовательности
 */
public class Parser {
    private char[] sentence;

    /**
     *
     * @param value - скобочная последовательности с дополнительными символами
     */
    public Parser(String value) {
        this.sentence = value.toCharArray();
    }

    /**
     * Валидатор для скобочных последовательностей
     * @return - верна ли скобочная последовательность
     */
    public boolean validate() {
        char[] tmp = new char[this.sentence.length];
        int pos = -1;
        for (char current : this.sentence) {
            if (current == 40 || current == 91 || current == 123) {
                tmp[++pos] = current;
            } else if (current == 41 || current == 93 || current == 125) {
                if (current - tmp[pos] == 1) {
                    tmp[pos--] = 0;
                } else if (current - tmp[pos] == 2) {
                    tmp[pos--] = 0;
                } else {
                    return false;
                }
            }
        }
        return pos == -1;
    }

    /**
     * Метод для разбора скобочной последовательности
     * @return String таблицу с позициями скобочек
     * @throws NotValidPhrase
     */
    public String parse() throws NotValidPhrase {
        if (!this.validate()) {
            throw new NotValidPhrase("");
        }
        StringBuilder result = new StringBuilder();
        result.append(String.format("%-10s%-10s%-10s%-10s%n", "Номер", "Начало", "Конец", "Тип"));
        int tmp, counter = 0, lastBracket = -1;
        while (lastBracket != 0) {
            lastBracket = 0;
            for (int i = 0; i < this.sentence.length; i++) {
                if (this.sentence[i] == 40 || this.sentence[i] == 91 || this.sentence[i] == 123) {
                    lastBracket = i;
                } else if (this.sentence[i] == 41 || this.sentence[i] == 93 || this.sentence[i] == 125) {
                    tmp = this.sentence[i] - this.sentence[lastBracket];
                    if (tmp == 1 || tmp == 2) {
                        result.append(String.format("%-10s%-10s%-10s%-9c%c%n", counter++ + ".", lastBracket, i, this.sentence[lastBracket], this.sentence[i]));
                        this.sentence[lastBracket] = 0;
                        this.sentence[i] = 0;
                    }
                }
            }
        }
        return result.toString();
    }

}
