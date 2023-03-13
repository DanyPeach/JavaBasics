package com.by.lab2.chapter2C10;

import java.util.Arrays;
import java.util.Random;

public class MatrixManipulations {
    public static void main(String[] args) {
        //Найти максимальный элемент(ы) в матрице и удалить из матрицы все строки и столбцы, его содержащи

        // Задаем значения строк и колонок и генерим рандомную матрицу
        int numRows = 5;
        int numCols = 5;
        int[][] matrix = generateMatrix(numRows, numCols);

        // Выводим начальную матрицу
        System.out.println("Original matrix:");
        printMatrix(matrix);

        // Находим максимальный элемент
        int maxVal = Integer.MIN_VALUE;
        int[] maxIndices = new int[2];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (matrix[i][j] > maxVal) {
                    maxVal = matrix[i][j];
                    maxIndices[0] = i;
                    maxIndices[1] = j;
                }
            }
        }

        // Убирае колонки и строки, которые содержат максимальный элемент
        int[][] newMatrix = new int[numRows - 1][numCols - 1];
        int rowIndex = 0;
        for (int i = 0; i < numRows; i++) {
            if (i == maxIndices[0]) {
                continue;
            }
            int colIndex = 0;
            for (int j = 0; j < numCols; j++) {
                if (j == maxIndices[1]) {
                    continue;
                }
                newMatrix[rowIndex][colIndex] = matrix[i][j];
                colIndex++;
            }
            rowIndex++;
        }

        // Выводим новую матрицу
        System.out.println("New matrix:");
        printMatrix(newMatrix);
    }

    // Генерируем матрицу с указанным кол-вом колонок и строк
    public static int[][] generateMatrix(int numRows, int numCols) {
        Random rand = new Random();
        int[][] matrix = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                matrix[i][j] = rand.nextInt(100);
            }
        }
        return matrix;
    }

    // Выводим матрицу
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
