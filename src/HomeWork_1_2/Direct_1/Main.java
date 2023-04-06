package HomeWork_1_2.Direct_1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¬ведите размер");
        int size = scanner.nextInt();
        int search = 5;
        int[] arr = new int[size];
        for (int i = 0; i < size - 1; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == search) {
                System.out.println(mid);
                break;
            } else if (arr[mid] < search) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

    }
}
