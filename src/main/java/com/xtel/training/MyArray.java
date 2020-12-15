package com.xtel.training;

public class MyArray {
    public void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (arr == null || arr.length == 0)
            return;
        if (left >= right)
            return;
        int middle = left + (right - left) / 2;
        int pivot = arr[middle];
        int i = left, j = right;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (left < j) {
            quickSort(arr, left, j);
        }
        if (right > i) {
            quickSort(arr, i, right);
        }
    }
}
