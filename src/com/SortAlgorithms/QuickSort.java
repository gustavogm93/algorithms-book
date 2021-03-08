package com.SortAlgorithms;

public class QuickSort {

	public static int cuantos;

	public static void main(String[] args) {
		int[] c = { 1, 3, 5, 2, 4, 6, 7, 8 };

		quickSort(c, 0, c.length - 1);

		showArray(c);
	}

	/**
	 * Obtener Minimo Cambios para ordenar Ascendentemente. Limite: Array sin
	 * numeros repetidos.
	 */
	public static int minimumSwaps(int[] arr) {
		
		int i, c = 0, n = arr.length;
		for (i = 0; i < n; i++) {
			if (arr[i] == (i + 1))
				continue;
			swap(arr, i, arr[i] - 1);
			c++;
			i--;
		}
		return c;
	}

	public static void swap(int[] arr, int i, int comp) {

		int temp = arr[i];
		arr[i] = arr[comp];
		arr[comp] = temp;
	}

	public static void quickSort(int[] arr, int start, int end) {

		if (start >= end)
			return;

		int pivot = getPivot(arr, start, end);

		quickSort(arr, start, pivot - 1);
		quickSort(arr, pivot + 1, end);
	}

	public static int getPivot(int[] arr, int start, int end) {
		int pivotIndex = start - 1;

		for (int i = start; i < end; i++) {

			if (arr[i] < arr[end]) {
				pivotIndex++;
				swap(arr, pivotIndex, i);
				cuantos++;
			}

		}
		swap(arr, pivotIndex + 1, end);

		return pivotIndex + 1;
	}

	public static void showArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	};

}
