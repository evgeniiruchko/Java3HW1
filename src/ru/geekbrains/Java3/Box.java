package ru.geekbrains.Java3;

import java.util.ArrayList;

public class Box <T extends Fruit>{
    private ArrayList<T> box;

    Box(ArrayList<T> T) {
        this.box = T;
    }


    public double getWeight(){
        if (box.size() > 0){
            return box.size() * box.get(0).getWeight();
        } else return 0;
    }

    public boolean compare(Box otherBox){
        return this.getWeight() == otherBox.getWeight();
    }

    public void transfer(Box<T> otherBox) {
        if (this.box.equals(otherBox.box)) {
            return;
        }
        if (this.box.get(0).getClass() == otherBox.box.get(0).getClass()) {
            otherBox.box.addAll(this.box);
            this.box.clear();
        }else
            System.out.println("Содержимое коробок различается по типу, пересыпать не будем");
    }

    public void add(T fruit){
        box.add(fruit);
    }
}