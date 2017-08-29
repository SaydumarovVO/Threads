package ru.saydumarov.threads;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Cleaner cleaner = new Cleaner(numbers);
        String string = "";

        cleaner.start();

        while(scanner.hasNextLine()){
            string = scanner.nextLine();
            numbers.add(Parser.toNum(string));
        }
    }
}
