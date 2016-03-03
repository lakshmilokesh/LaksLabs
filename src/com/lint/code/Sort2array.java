package com.lint.code;

/*
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 *
 * Note:
 * You may assume that A has enough space (size that is greater or equal to m + n) to
 * hold additional elements from B. 
 * The number of elements initialized in A and B are m and n respectively.
 */

public class Sort2array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int A[] = new int[]{4,5,6,0,0,0,0,0,0};
		int B[] = new int[] {1,2,5};
		System.out.println("---- Result ----");
		merge(A, 3, B, 3);


	}

	public static void merge(int A[], int m, int B[], int n) {

		int new_size = (m + n)-1;
		int m_last = m-1;
		int n_last = n-1;

		while (new_size >= 0) {
			/*System.out.println("new size A[ "+ new_size + "]" +  A[new_size]);
			if (m_last >= 0)
				System.out.println("A[" + m_last + "]" + A[m_last]);
			if (n_last >= 0)
				System.out.println("B[" + n_last + "]" + B[n_last]);
			else
				System.out.println("inside else");*/


			if (m_last < 0 && n_last >= 0) {

				A[new_size] = B[n_last];
				new_size--;
				n_last--;
			}

			else if (m_last >=0  && n_last < 0) {
				break;
			}

			else if (A[m_last] > B[n_last] ) {

				A[new_size] = A[m_last];
				m_last--;
				new_size--;
			}
			else if(A[m_last] < B[n_last]) {	

				A[new_size] = B[n_last];
				n_last--;
				new_size--;
			}
			else {

				A[new_size] = A[m_last];
				m_last--;
				new_size--;
			}

		}
		//Printing sorted array
		for (int i = 0; i < m+n; i++) {
			System.out.println("-->" + A[i]);
		}
	}
}
