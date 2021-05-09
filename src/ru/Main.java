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

        /*time = System.nanoTime();
        Arrays.sort(array);
        time = System.nanoTime() - time;
        System.out.println("Время сортировки методом sort() : " + time/1000000);*/
        //System.out.println(Arrays.toString(array));

        //Задание 2.2 На основе написанного кода в задании 2.1 реализуйте линейный и двоичный поиск.
        //Оценить алгоритмы линейного и двоичного поиска с помощью базового класса System.nanoTime(),
        // при необходимости расширьте уже существующий массив данных.

        //Линейный поиск в неотсортированном массиве
        int target = 3;
        time = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            if(array[i] == target){
                time = System.nanoTime() - time;
                System.out.println("Число " + target + " найдено за " + time + " в неотсортированном массиве");
                break;
            }

        }

        //Линейный поиск в отсортированном массиве
        for (int i = 0; i < SIZE; i++) {
            if(array2[i] == target){
                time = System.nanoTime() - time;
                System.out.println("Число " + target + " найдено за " + time + " в отсортированном массиве");
                break;
            }

        }

        //Двоичный поиск в отсортированном массиве
        int first = 0; //первый индекс диапазона поиска
        int last = SIZE-1; //последний индекс диапазона поиска
        int position = (first + last) / 2;
        time = System.nanoTime();
        int index = binaryUserSearch(array2, target);
        time = System.nanoTime() - time;
        if(index < 0) {
            System.out.println("Элемент не найден");
        }else{
            System.out.println("Искомый элемент найден под индексом " + index + " за " + time);
        }




    }

    private static void fillingRandArray(int[] array) { //Заполнение массива рандомно
        for (int i = 0; i < SIZE; i++) {
            array[i] = rand.nextInt(800000);
        }
    }

    private static void fillingSortedArray(int [] array) { //Заполнение массива числами по возрастанию
        for (int i = 0; i < SIZE; i++) {
            array[i] = i+1;
        }
    }

    private static int binaryUserSearch (int[] array, int elementToSearch){
        int first = 0;
        int last = array.length - 1;

        while (first <= last){
            int middle = (first + last) / 2;

            if(array[middle] > elementToSearch) {
                last = middle - 1;
            }
            else if(array[middle] < elementToSearch) {
                first = middle + 1;
            }
            else if(array[middle] == elementToSearch){
                return middle;
            }
        }
        return -1;
    }


}
