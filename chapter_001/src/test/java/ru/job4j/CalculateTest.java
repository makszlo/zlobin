/**
* Test
*
* @author Maxim Zlobin (mailto:hlabn@yandex.ru)
* "since 31.10.2017
* @version 0.1
*/
package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculateTest {		
	@Test
	public void testMethod() {
		String input = "Max";
		String expect = "Echo, echo, echo : Max";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}
}