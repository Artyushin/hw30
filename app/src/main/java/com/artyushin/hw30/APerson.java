package com.artyushin.hw30;


public class APerson {
    public static String fullName;
    public static int age;
    public static int hiPressure;
    public static int lowPressure;
    public static int pulse;
    public static String tachycardia;
    public static String date;
    public static double weight;
    public static int numberSteps;

    @Override
    public String toString() {
        return "ФИО:   " + fullName + '\n' +
                "Возраст:   " + age + '\n' +
                "Верхнее давление:   " + hiPressure + '\n' +
                "Нижнее давление:   " + lowPressure + '\n' +
                "Пульс:   " + pulse + '\n' +
                "Тахикардия:   " + tachycardia + '\n' +
                "Дата измерения:   " + date + '\n' +
                "Вес:   " + weight + '\n' +
                "Количество шагов:   " + numberSteps;
    }
}
