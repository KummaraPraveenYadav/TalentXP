package com.interns.sortable;

public class MergeSort implements Sortable {
	@Override
	public void sort(int[] arr) {
		Sortable.super.sort(arr);
	}

	public static void main(String[] args) {
		int[] ar = { 3, 1, 2, 6, 0, 9 };
		MergeSort quickSort = new MergeSort();
		quickSort.sort(ar);
		for (int a : ar) {
			System.out.print(a + " ");
		}

	}

}
