package ru.geekbrains.java_basic_homework_3;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	Random rand = new Random();
	int randVal = rand.nextInt(10);
        System.out.println(randVal);
    }
}
