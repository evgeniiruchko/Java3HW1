package ru.geekbrains.Java3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        //1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
        Integer[] intArray= {1,2,3,4,5,6,7,8,9,10};
        String[] stringArray = {"один", "два" , "три" , "четыре" , "пять" , "шесть" , "семь" , "восемь" , "девять" , "десять"};
        changePositions(intArray, 1, 2);
        System.out.println("1 задание:");
        for (Object obj:intArray) {
            System.out.print(obj + " ");
        }
        System.out.print(System.lineSeparator());
        changePositions(stringArray,0, 9);
        for (Object obj:stringArray) {
            System.out.print(obj + " ");
        }
        System.out.print(System.lineSeparator());

        //2. Написать метод, который преобразует массив в ArrayList;
        ArrayList<Object> newIntList = arrayToArrayList(intArray);
        ArrayList<Object> newStringList = arrayToArrayList(stringArray);
        System.out.println("2 задание: " + newIntList.toString());
        System.out.println("2 задание: " + newStringList.toString());

/*
3. Большая задача:
a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
c. Для хранения фруктов внутри коробки можете использовать ArrayList;
d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
g. Не забываем про метод добавления фрукта в коробку.
*/
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        Apple apple5 = new Apple();
        Apple apple6 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Orange orange4 = new Orange();
        ArrayList<Apple> apples1= new ArrayList<>();
        ArrayList<Apple> apples2= new ArrayList<>();
        ArrayList<Orange> oranges1= new ArrayList<>();

        Box<Apple> box1 = new Box<>(apples1);
        Box<Apple> box2 = new Box<>(apples2);
        Box<Orange> box3 = new Box<>(oranges1);
        box1.add(apple1);
        box1.add(apple2);
        box1.add(apple3);
        box3.add(orange1);
        box3.add(orange2);

        System.out.println("Вес box1 = " + box1.getWeight());
        System.out.println("Вес box3 = " + box3.getWeight());
        System.out.println("Вес box1 = вес box3? " + box1.compare(box3));

        box2.add(apple4);
        box2.add(apple5);
        System.out.println("Вес box2 = " + box2.getWeight());
        box1.transfer(box2);
        System.out.println("Вес box2 после пересыпания= " + box2.getWeight());
        System.out.println("Вес box1 после пересыпания= " + box1.getWeight());


        //Box<Apple> box1 = new Box<Apple>(apple1, apple2, apple3);


    }



    public static Object changePositions(Object T[], int firstIndex, int secondIndex) {
        if (firstIndex < 0 || secondIndex < 0 || firstIndex >= T.length || secondIndex >= T.length){
            System.out.println("Ошибка. Индекс находится за пределами массива, будет выведен исходный массив");
        } else {
            Object temp = T[firstIndex];
            T[firstIndex] = T[secondIndex];
            T[secondIndex] = temp;
        }
        return T;
    }

    public static ArrayList<Object> arrayToArrayList(Object T[]){
        ArrayList<Object> arrList = new ArrayList<>();
        for (Object obj: T) {
            arrList.add(obj);
        }
        return arrList;
    }
}
