
package ru.job4j;

        import org.junit.Test;
        import java.io.ByteArrayOutputStream;
        import java.io.PrintStream;
        import static org.hamcrest.core.Is.is;
        import static org.junit.Assert.assertThat;
/**
 * Test
 * @author Maxim Zlobin (mailto:hlabn@yandex.ru)
 * @since 22.01.2018
 * @version 0.1
 */
public class CombineTwoSortedInOneSortedTest {
    @Test
    public void combineArraysTest1() {
        CombineTwoSortedInOneSorted test = new CombineTwoSortedInOneSorted();
        int[] a = {1, 2, 3, 4}, b = {1, 2, 3, 4}, expected = {1, 1, 2, 2, 3, 3, 4, 4};
        int[] result = test.combine(a, b);
        assertThat(result, is(expected));
    }
    @Test
    public void combineArraysTest2() {
        CombineTwoSortedInOneSorted test = new CombineTwoSortedInOneSorted();
        int[] a = {1, 2, 3}, b = {4, 5, 6}, expected = {1, 2, 3, 4, 5, 6};
        int[] result = test.combine(a, b);
        assertThat(result, is(expected));
    }
    @Test
    public void combineArraysTest3() {
        CombineTwoSortedInOneSorted test = new CombineTwoSortedInOneSorted();
        int[] a = {4, 5, 6}, b = {1, 2, 3}, expected = {1, 2, 3, 4, 5, 6};
        int[] result = test.combine(a, b);
        assertThat(result, is(expected));
    }
}
