package org.example.myVariants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DemoClass {

    public static void demoAList(){
        MyArrayList<Integer> testArrayList = new MyArrayList<>(15);

        for(int i= 0; i< testArrayList.getCapacity(); i++){
            testArrayList.add(i);

        }
        testArrayList.arrayInfo (testArrayList);

        System.out.println("Добавляем элемент 15:");
        testArrayList.add(15);
        testArrayList.arrayInfo (testArrayList);

        System.out.println("Добавляем элемент 12 по индексу 2:");
        testArrayList.add(2,12);
        testArrayList.arrayInfo (testArrayList);

        System.out.println("Удаляем элемент по индексу 6:");
        testArrayList.delete(6);
        testArrayList.arrayInfo (testArrayList);

        System.out.println("Удаляем первое вхождение элемента 12:");
        testArrayList.delete((Integer)12);
        testArrayList.arrayInfo (testArrayList);

        System.out.println("Вывод элемента с индексом 8: " + testArrayList.get(8));

        System.out.println("Замена значения элемента с индексом4:");
        testArrayList.set(4,55);
        testArrayList.arrayInfo (testArrayList);

        Scanner in = new Scanner(System.in);
        waitForEnter(in);
    }

    public static void demoLList(){
        MyLinkedList list = new MyLinkedList();

        for(int i= 0; i<10; i++){
            list.addFirst(i);
        }
        System.out.println("Список: ");
        list.print();

        System.out.println("Добавляем элементы в конец");
        list.addLast(33);
        list.addLast(4);
        list.print();

        System.out.println("Добавляем элемент по индексу 2");
        list.addByIndex(2,44);
        list.print();

        System.out.println("Удаляем четверку(только первое вхождение)");
        list.removeElement(4);
        list.print();

        System.out.println("Удаляем первый элемент");
        list.removeFirst();
        list.print();

        System.out.println("Удаляем последний элемент");
        list.removeLast();
        list.print();


        Scanner in = new Scanner(System.in);
        waitForEnter(in);

    }

    public static void demoHashTreeify() {

        HashMap<Person,Integer> test = new HashMap<>();

        ArrayList<Person> perArr= new ArrayList<>();

        for(int i = 0; i<11; i++){
            perArr.add(new Person(10+i));
            test.put(perArr.get(i),i+1);

            if(i==9){
                System.out.println("Текущий размер мапы: "+test.entrySet().size());
                System.out.println("До добавления 11 элемента обычный Node т.е в бакете односвязный список");
                System.out.println(test.entrySet().toArray()[1].getClass() + "\n");
            }else if(i==10){
                System.out.println("После добавления 11 элемента TreeNode т.е в бакете теперь дерево");
                System.out.println(test.entrySet().toArray()[1].getClass() + "\n");
            }
        }
        System.out.println("Теперь последовательно удалим элементы, пока дерево не перестроится обратно в односвязный список: ");

        String condition ="";
        int i = 0;
        while (!condition.equals("class java.util.HashMap$Node")){
            test.remove(perArr.get(i));
            System.out.println("Удаляем person"+(i+1));
            System.out.println("Тип ноды: " + test.entrySet().toArray()[1].getClass() + "\n");
            condition = test.entrySet().toArray()[1].getClass().toString();
            i++;
        }

        System.out.println("После удаления " + i + " элементов списка, бакет вернулся к односвязному списку.");

        Scanner in = new Scanner(System.in);
        waitForEnter(in);

    }

    private static void waitForEnter(Scanner scanner) {
        System.out.println("\n Нажмите Enter, чтобы продолжить...");
        scanner.nextLine();
    }
}
