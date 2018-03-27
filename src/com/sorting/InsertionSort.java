package com.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = new Integer[]{7,1,2,4,3};
		sort(a);
		System.out.println("sorted" + a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

	}
	
	public static void sort(Integer[] a) {
		int size = a.length;
		for (int i = 0 ; i < size; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j] < a[j-1]) {
					exch(a,j,j-1);
				}
				else {
					break;
				}
			}
		}
	}


	public static void exch(Integer[] a, int j, int i) {
		// TODO Auto-generated method stub
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}
}
