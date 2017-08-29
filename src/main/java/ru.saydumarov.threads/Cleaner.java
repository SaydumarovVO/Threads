package ru.saydumarov.threads;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Cleaner extends Thread{

    private static List<Integer> list = new ArrayList<>();
    Cleaner(List<Integer> list){
        this.list = list;
    }

    public void run(){
        synchronized (list){
            while (!Thread.interrupted()){
                if (!list.isEmpty()){
                    list.sort(Comparator.naturalOrder());
                    System.out.println(list.get(0));
                    list.remove(0);
                }
                else System.out.println("List is empty!");
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
