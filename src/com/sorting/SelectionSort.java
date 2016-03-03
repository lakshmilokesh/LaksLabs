package com.sorting;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{7,1,2,4,3};
		sort(a);
		System.out.println("sorted" + a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

	}
	
	public static void sort(int[] a) {
		int size = a.length;
		for (int i = 0; i < size; i++) {
			int min = i;
			for (int j = i+1; j < size; j++) {
				if (a[min] > a[j] ) {
					min = j;
				}
			}
			exch(a,min,i);
		}
	}

	private static void exch(int[] a, int min, int i) {
		// TODO Auto-generated method stub
		int temp = a[min];
		a[min] = a[i];
		a[i] = temp;
	}

}
