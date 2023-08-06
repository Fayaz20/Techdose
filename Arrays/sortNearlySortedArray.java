import java.util.Scanner;

class Main {
	static void sortNearlySortedArray(int A[], int size, int k) {
		int i, key, j;
		for (i = 1; i < size; i++) {
			key = A[i];
			j = i - 1;
			while (j >= Math.max(0, i - k) && A[j] > key) {
				A[j + 1] = A[j];
				j--;
			}
			A[j + 1] = key;
		}
		for(i=0; i<size; i++)
			System.out.print(A[i] + " ");
	}

	public static void main(String[] args) {
		int A[] = {6, 5, 3, 2, 8, 10, 9};
		int size = 6;
		int k = 3;
		sortNearlySortedArray(A, size, k);
	}
}
