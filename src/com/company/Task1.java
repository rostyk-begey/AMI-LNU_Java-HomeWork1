package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.File;

public class Task1 {
    private static int digitsSum(int number) {
        int result = 0;
        while (number > 0) {
            result += number % 10;
            number /= 10;
        }
        return result;
    }

    private static int max(int[] array) {
        int result = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] > result) {
                result = array[i];
            }
        }
        return result;
    }

    public static int[] execute(int[][] matrix, int rows, int cols) {
        int[] result = new int[rows];
        for (int i = 0; i < rows; ++i) {
            int[] digitSums = new int[cols];
            for (int k = 0; k < cols; ++k) {
                digitSums[k] = digitsSum(matrix[i][k]);
            }
            result[i] = max(digitSums);
        }

        return result;
    }

    public static int randInt() {
        Random r = new Random();
        int low = 10;
        int high = 100;
        return r.nextInt(high-low) + low;
    }

    public static void printMatrix(int[][] matrix)
    {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void Run() {
        var in = new Scanner(System.in);
        System.out.print("Enter rows number: ");
        int rows = in.nextInt();
        System.out.print("Enter cols number: ");
        int cols = in.nextInt();

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                System.out.printf("Enter [%s][%s]: ", i, j);
                matrix[i][j] = in.nextInt();
            }
        }

        int[] result = execute(matrix, rows, cols);

        System.out.printf("Result: %s%n", Arrays.toString(result));
    }

    public static void RunTest() {
        int rows = 4;
        int cols = 6;
        System.out.printf("Running test for random (%s x %s) matrix\n", rows, cols);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                matrix[i][j] = randInt();
            }
        }
        printMatrix(matrix);

        int[] result = execute(matrix, rows, cols);

        System.out.printf("Result: %s\n\n", Arrays.toString(result));
    }
}
