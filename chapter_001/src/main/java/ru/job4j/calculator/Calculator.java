package ru.job4j.calculator;
/**
 * Class Сalculator для части 001 урока 3го
 *
 * @author Maxim Zlobin (mailto:hlabn@yandex.ru)
 * "since 01.10.2017
 * @version 0.1
 */
public class Calculator {
	private double result;

	/**
	 * Метод для вычисления суммы двух чисел
	 * @param first - первое слагаемое
	 * @param second - второе слагаемое
	 */
	public void add(double first, double second) {
		this.result = first + second;
	}

	/**
	 * Метод для вычисления разности двух чисел
	 * @param first - уменьшаемое
	 * @param second - вычитаемое
	 */
	public void subtract(double first, double second) {
		this.result = first - second;
	}

	/**
	 * Метод для вычисления частного двух чисел
	 * @param first - делимое
	 * @param second - делитель
	 */
	public void div(double first, double second) {
		this.result = first / second;
	}

	/**
	 * Метод для вычисления произведения двух чисел
	 * @param first - множимое
	 * @param second - множитель
	 */
	public void multiple(double first, double second) {
		this.result = first * second;
	}

	/**
	 * Метод для возвращения результата произведённого действия
	 * @return возвращает значенияе поля result
	 */
	public double getResult() {
		return this.result;
	}
}