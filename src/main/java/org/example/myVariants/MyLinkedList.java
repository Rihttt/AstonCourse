package org.example.myVariants;

public class MyLinkedList {
    private MyNode head;
    private MyNode tail;

    public MyLinkedList() {
        head = null;
        tail = null;
    }

    private boolean isEmpty(){
        return head == null;
    }

    public void addFirst(int data){
        MyNode temp = new MyNode(data);
        if(isEmpty()){
            tail = temp;
        }else{
            head.prev = temp;
        }
        temp.next = head;
        head = temp;
    }

    public void addLast(int data){
        MyNode temp = new MyNode(data);
        if(isEmpty()){
            head = temp;
        }else
            tail.next = temp;
        temp.prev = tail;
        tail = temp;
    }

    public void addByIndex(int index, int data){
        MyNode current = head;
        int c=0;

        while(current != null && c != index){
            current= current.next;
            c++;
        }
        MyNode temp = new MyNode(data);

        current.prev.next = temp;
        temp.prev = current.prev;
        current.prev = temp;
        temp.next = current;
    }

    public void removeFirst(){

        if(head.next == null){ //Проверка что в списке больше 1 элемента
           tail = null;
        }else
            head.next.prev = null;
        head = head.next;
    }

    public void removeLast(){
        if(head.next == null){
            head = null;
        }else
            tail.prev.next = null;
        tail = tail.prev;
    }

    public void removeElement(int element){
        MyNode current = head;

        while(current.data != element){
            current=current.next;
            if(current == null){
                return;
            }
        }
        if(current == head){
            removeFirst();
        }else
            current.prev.next = current.next;
        if(current == tail){
            removeLast();
        }else
            current.next.prev=current.prev;

    }

    public void print(){
        MyNode temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}
