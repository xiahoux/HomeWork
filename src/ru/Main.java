package ru;

import java.sql.SQLOutput;
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


        /*Задание 2.3
        Создайте массив размером 400 элементов.
                Выполните сортировку с помощью метода sort().
                Оцените сортировку с помощью базового класса System.nanoTime().*/


        int[] arrayForSort = new int[400];
        for (int i = 0; i < arrayForSort.length; i++) {
            arrayForSort[i] = rand.nextInt(400);
        }
        time = System.nanoTime();
        Arrays.sort(arrayForSort);
        time = System.nanoTime() - time;
        System.out.println(Arrays.toString(arrayForSort));
        System.out.println("Сортировка методом sort() заняла " + time);

        /*Задание 2.4
        На основе существующего массива данных из задания 2.3 реализуйте алгоритм сортировки пузырьком.
        Оцените сортировку с помощью базового класса System.nanoTime().
                Сравните время выполнения алгоритмы сортировки методом sort() из задания 2.1 и сортировку пузырьком.*/


        int[] bubbleArray = new int[400];
        for (int i = 0; i < bubbleArray.length; i++) {
            bubbleArray[i] = rand.nextInt(400);
        }

        long timeBubble = System.nanoTime();
        bubbleUserSort(bubbleArray);
        timeBubble = System.nanoTime() - timeBubble;
        System.out.println(Arrays.toString(bubbleArray));
        System.out.println("Сортировка выполнена за " + timeBubble);

        System.out.println("Время сортировки sort(): " + time);
        System.out.println("Время сортировки пузырьком: " + timeBubble);


        /*Задание 2.5
        На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом выбора.
                Оцените сортировку с помощью базового класса System.nanoTime().
                Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3 и 2.4.*/

        int[] selectionArray = new int[400];
        for (int i = 0; i < selectionArray.length; i++) {
            selectionArray[i] = rand.nextInt(400);
        }

        long timeSelection = System.nanoTime();
        selectionUserSort(selectionArray);
        timeSelection = System.nanoTime() - timeSelection;

        System.out.println(Arrays.toString(selectionArray));
        System.out.println("Время сортировки sort():    " + time);
        System.out.println("Время сортировки пузырьком: " + timeBubble);
        System.out.println("Время сортировки выбором:   " + timeSelection);


        //Задание 2.6
        //На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом вставки.
        //Оцените сортировку с помощью базового класса System.nanoTime().
        //Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3, 2.4 и 2.5.

        int[] insertionArray = new int[400];
        for (int i = 0; i < insertionArray.length; i++) {
            insertionArray[i] = rand.nextInt(400);
        }

        long timeInsertion = System.nanoTime();
        insertionUserSort(insertionArray);
        timeInsertion = System.nanoTime() - timeInsertion;

        System.out.println(Arrays.toString(insertionArray));
        System.out.println("Время сортировки sort():    " + time);
        System.out.println("Время сортировки пузырьком: " + timeBubble);
        System.out.println("Время сортировки выбором:   " + timeSelection);
        System.out.println("Время сортировки вставкой:  " + timeInsertion);



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

    private static int[] bubbleUserSort(int[] array){
        int buf;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 1; j < array.length; j++) {
                if(array[j-1] > array[j]){
                    buf = array[j-1];
                    array[j-1] = array[j];
                    array[j] = buf;
                }
            }
        }
        return array;
    }

    private static int[] selectionUserSort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            int min = array[i];
            int indexMin = i;
            for (int j = i+1; j < array.length; j++) {
                if(min > array[j]){
                    min = array[j];
                    indexMin = j;
                }
            }
            array[indexMin] = array[i];
            array[i] = min;
        }
        return array;
    }
    
    private static int[] insertionUserSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int buf;
            for (int j = 0; j < i; j++) {
                if(array[j] > array[i]){
                    buf = array[j];
                    array[j] = array[i];
                    array[i] = buf;
                }
            }
        }
        return array;
    }

}
