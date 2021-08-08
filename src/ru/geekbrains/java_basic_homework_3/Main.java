package ru.geekbrains.java_basic_homework_3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in); // Создание объекта Scanner для ввода значений в консоль

    public static void main(String[] args) {
        int bord = 10; // Диапазон загадываемых значений (от 0 до 9)
        int tryCount = 3; // Количество попыток
        String msg = "Угадайте случайное число от 0 до 9";
        tryGuess(msg, bord, tryCount); // Вызов метода с передачей ему аргументов
    }
// 1. Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число
    public static void tryGuess (String msg, int border, int tryCount) { // Создание метода сравнения введённых и загаданных чисел
        int userNumber;
        int userAnswer;
        Random rand = new Random(); // Создание объекта Random для генерирования случайных чисел
        int randVal = rand.nextInt(border); // Создание переменной со случайным числом в указанном диапазоне
        System.out.println(msg); // Вывод сообщения о вводе
        for (int i = tryCount; i > 0; i--) { // Цикл сравнения значений, повторяется заданное число раз
            do {
                userNumber = sc.nextInt(); // Создание переменной, хранящей в себе введённое значение
                if (userNumber < 0 || userNumber > border) { // Проверка введённого значения на корректность ввода
                    System.out.println("Введённое значение вне указанного диапазона");
                }
            } while (userNumber < 0 || userNumber > border); // Цикл будет повторяться до тех пор, пока не будет введено корректное значение

            if (userNumber < randVal) { // Если введённое значение меньше случайно сгенерированного
               System.out.println("Загаданное число больше"); // Вывод оповещения
               System.out.println("Осталось попыток: " + (i - 1)); // Вывод количества оставшихся попыток
            } else if (userNumber > randVal) {
               System.out.println("Загаданное число меньше"); // Вывод оповещения
               System.out.println("Осталось попыток: " + (i - 1)); // Вывод количества оставшихся попыток
           } else {
               System.out.println("Вы угадали!"); // Вывод оповещения
               break; // Выход из цикла
           }
        }
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет"); // Вывод предложения о продолжении игры
        userAnswer = sc.nextInt(); // Считывание введённого значения
        switch (userAnswer) { // Условие по значению переменной userAnswer
            case 1: tryGuess(msg, border, tryCount); // Если введена 1, вызываем рекурсию
                break;
            case 0: System.out.println("Завершение игры"); // Если введён 0, выводим сообщение
                sc.close(); // Закрытие сканера
                break; // Выход из игры
            default:
                System.out.println("Некорректный ввод");
                System.out.println("Завершение игры");
                sc.close(); // Закрытие сканера
                break; // Выход из игры
        }
    }
}
