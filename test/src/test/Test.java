package test;

import java.util.Scanner;

public class Test {

	@SuppressWarnings("resource")
public static void main(String[] args) {

		int n, c, d, swap;
		Scanner in = new Scanner(System.in);

		System.out.println("Ввести количество цифр для сортировки");
		n = in.nextInt();
		int array[] = new int[n];

		System.out.println("Введите " + n + " числа");

		for (c = 0; c < n; c++)
			array[c] = in.nextInt();

		for (c = 0; c < (n - 1); c++) {
			for (d = 0; d < n - c - 1; d++) {
				if (array[d] > array[d + 1]) {
					swap = array[d];
					array[d] = array[d + 1];
					array[d + 1] = swap;
				}
			}
		}
		System.out.println("Отсортированный лист");

		for (c = 0; c < n; c++)
			System.out.println(array[c]);

	}

}
