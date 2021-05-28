package ru;

import java.util.List;
import java.util.ListIterator;

public class UserLinkedList {

    private ListElement head;
    private ListElement tail;

    void addElement(Object data) { //Добавление элемента в конец
        ListElement a = new ListElement();
        a.data = data;
        if(head == null){
            head = a;
            tail = a;
        } else {
            tail.next = a;
            tail = a;
            tail.next = null;
        }
    }

    void addFirstElement(Object data) { //Добавление элемента в начало
        ListElement a = new ListElement();
        a.data = data;
        if(head == null){
            head = a;
            tail = a;
        } else {
            a.next = head;
            head = a;
        }
    }

    void addElementToIndex(Object data, int index) { //Добавление элемента по индексу
        if (index < 0) {
            System.out.println("Отрицательных индексов не существует");
        } else if (index == 0){
            this.addFirstElement(data);
        } else {
            ListElement a = new ListElement();
            a.data = data;

            ListElement t = this.head;
            int counter = 0;
            while(t != null){
                if(counter == index - 1){
                    a.next = t.next;
                    if(a.next == null){
                        tail = a;
                    }
                    t.next = a;
                    break;
                }
                counter++;
                t = t.next;
            }

        }
    }

    void deleteFirstElement(){//Удаление первого элемента
        if(head.next != null){
            head = head.next;
        }else {
            head = null;
            tail = null;
        }
    }

    void deleteLastElement(){  //Удаление последнего элемента
        ListElement t = this.head;
        while (t != null){
            if(t.next == tail){
                t.next = null;
                tail = t;
            }
            t = t.next;
        }
    }

    void deletElementToIndex(int index){ //Удаление элемента по индексу
        if(index < 0){

            System.out.println("Отрицательного индекса не существует");

        }else if (index == 0){

            this.deleteFirstElement();

        }else{

            ListElement t = this.head;
            int counter = 0;

            while (t != null){
                if (counter == index-1){
                    if (t.next == null){
                        System.out.println("Такого элемента нет");
                        break;
                    }else if (t.next.next == null){
                        this.deleteLastElement();
                        break;
                    }else{
                        t.next = t.next.next;
                        break;
                    }
                }
                t = t.next;
                counter++;
            }
        }


    }


    void printList(){ //Печать
        ListElement t = this.head;
        while(t != null){
            System.out.println(t.data);
            t = t.next;
        }
    }
}
