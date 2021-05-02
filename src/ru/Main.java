package ru;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static Random rand = new Random();
    public static final int SIZE = 1000000;

    public static void main(String[] args) {
	    // Задание 2.1 На основе программного кода из домашнего задания №1 реализуйте массив на основе существующих примитивных или ссылочных типов данных.
        //Выполните обращение к массиву и базовые операции класса Arrays.
        //Оценить выполненные методы с помощью базового класса System.nanoTime().

        int[] array = new int[SIZE];
        fillingRandArray(array);

        int[] array2 = new int[SIZE];
        fillingSortedArray(array2);

        long time = System.nanoTime();
        System.out.println(Arrays.toString(array));
        time = System.nanoTime() - time;
        System.out.println("Время выполнения toString: " + time/1000000);

        time = System.nanoTime();
        System.out.println(Arrays.binarySearch(array2, 49900));
        time = System.nanoTime() - time;
        System.out.println("Время выполнения двоичного поиска: " + time/1000 );

        time = System.nanoTime();
        Arrays.sort(array);
        time = System.nanoTime() - time;
        System.out.println("Время сортировки методом sort() : " + time/1000000);
        //System.out.println(Arrays.toString(array));
        
    }

    private static void fillingRandArray(int[] array) {
        for (int i = 0; i < SIZE; i++) {
            array[i] = rand.nextInt(99);
        }
    }

    private static void fillingSortedArray(int [] array) {
        for (int i = 0; i < SIZE; i++) {
            array[i] = i+1;
        }
    }


}
