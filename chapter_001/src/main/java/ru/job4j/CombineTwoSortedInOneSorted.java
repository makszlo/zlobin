package ru.job4j;
/**
 * Class for combine two sorted in one task.
 * @author Maxim Zlobin (mailto:hlabn@yandex.ru)
 * @since 22.01.2018
 * @version 0.1
 */
public class CombineTwoSortedInOneSorted {
    /**
     * Метод для объединения двух сортированных массивов в один
     * @param a - первый массив
     * @param b - второй массив
     * @return - объеденённый отсортированный массив
     */
    public int[] combine(int[] a, int[] b) {
        int lenghtA = a.length, lenghtB = b.length, lenght = lenghtA + lenghtB, counterA = 0, counterB = 0, i = 0;
        int[] result = new int[lenght];
        while (counterA < lenghtA && counterB < lenghtB) {
            if (a[counterA] < b[counterB]) {
                result[i] = a[counterA];
                counterA++;
            } else {
                result[i] = b[counterB];
                counterB++;
            }
            i++;
        }
        if (counterB == lenghtB) {
            System.arraycopy(a, counterA, result, i, lenghtA - counterA);
        } else {
            System.arraycopy(b, counterB, result, i, lenghtB - counterB);
        }
        return result;
    }
}
