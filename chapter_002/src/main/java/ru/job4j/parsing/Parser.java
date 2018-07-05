package ru.job4j.parsing;

/**
 * Класс для парсера скобочных последовательности
 * @author Zlobin Maxim
 * @version 1.0
 */
public class Parser {
    /** Скобочная последовательность**/
    private char[] sentence;
    /** Используемые скобки **/
    private final static char[] LEFT = {'(', '[', '{'};
    private final static char[] RIGHT = {')', ']', '}'};
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
        CharStack stack = new CharStack(this.sentence.length);
        char last;
        for (char current : this.sentence) {
            if (current == LEFT[0] || current == LEFT[1] || current == LEFT[2]) {
                stack.push(current);
            } else if (current == RIGHT[0] || current == RIGHT[1] || current == RIGHT[2]) {
                try {
                    last = stack.pop();
                } catch (ArrayIndexOutOfBoundsException e) {
                    return false;
                }
                if (!(current == RIGHT[0] && last == LEFT[0]
                        || current == RIGHT[1] && last == LEFT[1]
                        || current == RIGHT[2] && last == LEFT[2])) {
                    return false;
                }
            }
        }
        try {
            stack.pop();
            return false;
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
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
                if (this.sentence[i] == LEFT[0] || this.sentence[i] == LEFT[1] || this.sentence[i] == LEFT[3]) {
                    lastBracket = i;
                } else if (this.sentence[i] == RIGHT[0] || this.sentence[i] == RIGHT[1] || this.sentence[i] == RIGHT[2]) {
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
