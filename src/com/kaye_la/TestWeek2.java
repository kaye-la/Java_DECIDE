package com.kaye_la;

import week2.Task1;
import week2.Task2;
import week2.Task4.FahrenheitConverter;
import week2.Task4.KelvinConverter;

public class TestWeek2 {
    public static void run(){
        // Task 1
        Task1 task1 = new Task1(2, 3);
        System.out.println("Variable A = " + task1.getA());
        System.out.println("Variable B = " + task1.getB());
        System.out.println("Max of A & B = " + task1.max());
        System.out.println("Sum of A & B = " + task1.sum());
        System.out.println(task1.toString());

        // Task 2
        Task2[] vectors = Task2.randomGenerate(2);
        System.out.println("Vector1: " + vectors[0]);
        System.out.println("Vector2: " + vectors[1]);
        System.out.println("Length of Vector1 = " + vectors[0].length());
        System.out.println("Scalar product of Vector1 & Vector2 = " + vectors[0].scalarProduct(vectors[1]));
        System.out.println("Vector product of Vector1 & Vector2 = " + vectors[0].vectorProduct(vectors[1]));
        System.out.println("Sum of Vector1 & Vector2 = " + vectors[0].sum(vectors[1]));
        System.out.println("Difference of Vector1 & Vector2 = " + vectors[0].difference(vectors[1]));
        System.out.println("Cosine of Vector1 & Vector2 = " + vectors[0].cos(vectors[1]));

        // Task 4
        double temperature = 31;
        System.out.println("t Celsius = " + temperature);
        System.out.println("t Kelvin = " + new KelvinConverter().convertCelsius(temperature));
        System.out.println("t Fahrenheit = " + new FahrenheitConverter().convertCelsius(temperature));

        // Task 5
        int size =  (int) (Math.random() * 10);
        double[] arr = new double[size];
        double max = arr[0];
        double min = arr[0];
        double avg = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.random();
            if(max < arr[i])
                max = arr[i];
            if(min > arr[i])
                min = arr[i];
            avg += arr[i]/arr.length;
        }
        System.out.println("\nSize = " + size);
        System.out.println("Max = " + max);
        System.out.println("Min = " + min);
        System.out.println("Avg = " + avg);
    }
}
