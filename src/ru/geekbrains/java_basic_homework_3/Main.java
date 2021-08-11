package ru.geekbrains.java_basic_homework_3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in); // Создание объекта Scanner для ввода значений в консоль

    public static void main(String[] args) {
        System.out.println("Выберите игру: 1 - Угадай число; 2 - Угадай слово");
        int gameVar;
        if (sc.hasNextInt()) {
        gameVar = sc.nextInt();
        switch (gameVar) {
            case 1: taskFirst(); // Запуск первого задания
                break;
            case 2: taskSecond(); // Запуск второго задания
                break;
            default: System.out.println("Введено некорректное число!");
                System.out.println("Приложение закрывается");
            break;
        }
        } else {
        	System.out.println("Это не число!");
        	System.out.println("Завершение игры");
        }
        sc.close(); // Закрытие сканера
    }
    public static void taskFirst() {
        // 1. Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число
        int bord = 10; // Диапазон загадываемых значений (от 0 до 9)
        int tryCount = 3; // Количество попыток
        String msg = "Угадайте случайное число от 0 до 9";
        tryGuess(msg, bord, tryCount); // Вызов метода первой задачи с передачей ему аргументов.
    }
    public static void taskSecond() {
        // 2. Создать массив из слов. При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь
        String msg2 = "Попробуйте угадать слово";
        String[] stringArr = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random rand = new Random(); // Создание объекта Random для генерирования случайных чисел
        int randArrVal = rand.nextInt(stringArr.length - 1); // Создание переменной со случайным числом в диапазоне размеров массива
        String askWord = stringArr[randArrVal]; // Получение случайной строки из массива
        int wordLength = askWord.length(); // Возвращаем длину строки
        arrWork(msg2, askWord, wordLength); // Вызов метода второй задачи с передачей ему аргументов.
    }

    public static void tryGuess (String msg, int border, int tryCount) { // Создание метода сравнения введённых и загаданных чисел
        int userNumber = 0;
        int userAnswer;
        Random rand = new Random(); // Создание объекта Random для генерирования случайных чисел
        int randVal = rand.nextInt(border); // Создание переменной со случайным числом в указанном диапазоне
        System.out.println(msg); // Вывод сообщения о вводе
        for (int i = tryCount; i > 0; i--) { // Цикл сравнения значений, повторяется заданное число раз
            do {
                if (sc.hasNextInt()) {
                userNumber = sc.nextInt(); // Создание переменной, хранящей в себе введённое значение
                if (userNumber < 0 || userNumber > border) { // Проверка введённого значения на корректность ввода
                    System.out.println("Введённое значение вне указанного диапазона");
                }
            } else {
        	System.out.println("Это не число!");
        	System.out.println("Завершение игры");
        	return;
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
        if (sc.hasNextInt()) {
        userAnswer = sc.nextInt(); // Считывание введённого значения
        switch (userAnswer) { // Условие по значению переменной userAnswer
            case 1: tryGuess(msg, border, tryCount); // Если введена 1, вызываем рекурсию
                break;
            case 0: System.out.println("Завершение игры"); // Если введён 0, выводим сообщение
                break; // Выход из игры
            default:
                System.out.println("Некорректный ввод");
                System.out.println("Завершение игры");
                break; // Выход из игры
        }
    } else {
    	System.out.println("Это не число!");
        System.out.println("Завершение игры");
        return;
    }
    }

    public static void arrWork(String msg2, String askWord, int wordLength) {
        System.out.println(msg2); // Вывод сообщения о начале игры
        String userString; // Создание переменной для хранения пользовательской строки
        int k = 0; // Счётчик угаданных символов. Требуется для заполнения 15 символов знаком решётки
        userString = sc.next().toLowerCase(); // Запись в переменную пользовательской строки с преобразованием регистра символов
        int userWordLength = userString.length(); // Получения длины введённой строки
        if (askWord.equals(userString)) { // Условие со сравнением строк
            System.out.println("Вы угадали!"); // Вывод сообщения о совпадении строк
            System.out.println("Завершение игры");
        } else {
            System.out.println("Неверно!"); // Вывод сообщения о неправильном вводе
            for (int i = 0; i < wordLength && i < userWordLength; i++) { // Цикл посимвольного сравнения строк
                if (askWord.charAt(i) == userString.charAt(i)) {
                    System.out.print(askWord.charAt(i)); // Вывод совпадающих букв
                } else {
                        System.out.print("#"); // При несовпадении букв вывести символ решётки
                }
                k++; // Счётчик символов увеличивается на единицу за каждый проход цикла
            }
            for (int j = 0; j < 15 - k; j++){ // Цикл заполнения символами решётки до 15 символов
                System.out.print("#");
            }
            System.out.println(); // Перевод строки
            arrWork(msg2, askWord, wordLength); // Использование рекурсии
        }
    }

}
