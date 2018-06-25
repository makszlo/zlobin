package ru.job4j.parsing;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Класс для тестирования парсера скобочной последовательности
 */
public class ParserTest {
    /**
     * Тест невалидной скобочной последовательности
     * @throws NotValidPhrase
     */
    @Test(expected = NotValidPhrase.class)
    public void notValidPhrase() throws NotValidPhrase {
        Parser parser = new Parser("{dsfds(]{324}5345}");
        parser.parse();
    }

    /**
     * Тест валидной последовательности
     * @throws NotValidPhrase
     */
    @Test
    public void validPhrase() throws NotValidPhrase {
        Parser parser = new Parser("(){}[({[]}{(())})]");
        assertThat(parser.validate(), is(true));
    }
}
