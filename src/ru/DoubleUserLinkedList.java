package ru;

import java.util.List;

public class DoubleUserLinkedList {
    private ListElement head;
    private ListElement tail;

    void addElement(Object data){ //Добавление элемента в конец
        ListElement a = new ListElement();
        a.data = data;

        if(head == null){
            head = a;
            tail = a;
        } else {
            tail.next = a;
            a.previous = tail;
            tail = a;
        }

    }

    void addFirstElement(Object data){ //Добавление первого элемента
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

    void addElementToIndex(Object data, int index){ //Добавление элемента по индексу
        ListElement a = new ListElement();
        a.data = data;

        if(index < 0){
            System.out.println("Индекс не может быть отрицательным");
        } else if (index == 0){
            this.addFirstElement(a.data);
        } else {
            ListElement t = this.head;
            int counter = 0;
            while (t != null){
                if(counter == index-1 && t.next == null){
                    this.addElement(a.data);
                    break;
                } else if(counter == index-1){
                    a.next = t.next;
                    t.next.previous = a;
                    t.next = a;
                    a.previous = t;
                    break;
                }
                t = t.next;
                counter++;
            }
        }
    }

    void deleteFirstElement(){ //Удаление первого элемента
        if(head == null){
            System.out.println("Лист пуст");
        }else if(head.next == null){
            head = null;
            tail = null;
        }else {
            head = head.next;
            head.previous = null;
        }
    }

    void deleteLastElement(){ //Удаление последнего элемента
        if(head == null){
            System.out.println("Лист пуст");
        }else{
            tail = tail.previous;
            tail.next = null;

        }
    }

    void deleteElementToIndex(int index){
        ListElement t = this.head;
        int counter = 0;
        if(index < 0){
            System.out.println("Индекс не может быть отрицательным");
        }else if (index == 0){
            this.deleteFirstElement();
        }else{
            while (t != null){
                if(counter == index-1 && t.next.next == null){
                    this.deleteLastElement();
                    break;
                }else if(counter == index-1){
                    t.next.next.previous = t;
                    t.next = t.next.next;
                    break;
                }


                t = t.next;
                counter++;
            }
        }
    }

    void deleteAll(){
        ListElement t = this.head;
        while( t != null ){
            this.deleteFirstElement();
            t = head;
        }
    }

    void printList(){ //Печать листа
        ListElement t = this.head;
        while (t != null){
            System.out.println(t.data);
            t = t.next;
        }
    }


}
