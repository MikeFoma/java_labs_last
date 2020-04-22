package com.company;

import java.util.Scanner;

public class Main {

    //вывод двумерного массива
    static void print_two_dimensional_mass(int[][] mass) {
        System.out.println("Two-dimensional mass:");
        for (int[] m : mass) {
            for (int num : m) {
                //вывод элементов массива
                System.out.print(num + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    //вывод одномерного массива
    static void print_one_dimensional_mass(int[] mass) {
        System.out.println("One-dimensional mass:");
        for (int num : mass) {
            //вывод элементов массива
            System.out.print(num + "\t");
        }
        System.out.println();
    }

    //перевод двумерного в одномерный
    static int[] two_dimensional_to_one_dimensional(int[][] two_mass) {
        //инициализируем одномерный массив с размерностью двумерного
        int[] one_mass = new int[two_mass[two_mass.length - 1].length * two_mass.length];

        //копируем стркоки двумерного в одномерный
        int n = 0;
        for (int[] mass : two_mass) {
            System.arraycopy(mass, 0, one_mass, n * mass.length, mass.length);
            n++;
        }

        return one_mass;
    }

    //поиск среднего значения одномерного массива
    static double avg_mass(int[] mass) {
        //считаем сумму элементов массива
        int sum = 0;
        for (int num : mass) {
            sum += num;
        }

        //возвращаем среднее
        return sum / mass.length;
    }

    public static void main(String[] args) {
	// write your code here
        int n = 5;
        //int m = 5;

        //задаем размерность массива
        System.out.print("Enter N:");
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();
        n = Integer.parseInt(input);

        int[][] mass = new int[n][n];

        // заплняем массив случайными числами от 1 до 99
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mass[i][j] = 1 + (int) (Math.random() * 99);
            }
        }

        //выводим двумерный массив
        print_two_dimensional_mass(mass);
        //переводим двумерный массив в одномерный
        int[] one_mass = two_dimensional_to_one_dimensional(mass);
        //выводим одномерный массив
        print_one_dimensional_mass(one_mass);
        //выводим среднее значение одномерного массива
        System.out.println("Avarage of One-dimensional mass:" + avg_mass(one_mass));
    }
}
