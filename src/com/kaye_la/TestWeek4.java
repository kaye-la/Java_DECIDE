package com.kaye_la;

import week4.*;
import week4.Task6.*;
import week4.Task7.Student;

import java.util.*;

public class TestWeek4 {
    public static void run(){
        // Task 1
        System.out.println("-----------Task 1-----------");
        Collection<Integer> collection = new ArrayList<Integer>();
        collection.add(1);
        collection.add(1);
        collection.add(2);
        collection.add(3);
        System.out.println("Initital Collection: " + collection.toString());

        collection = Task1.collectionWithoutDuplicates(collection);
        System.out.println("Collection without duplicates: " + collection.toString());


        // Task 2
        System.out.println("\n-----------Task 2-----------");
        Task2.randomGenerateLists();
        Task2.compareLists();


        // Task 4
        System.out.println("\n-----------Task 4-----------");
        Integer[] arr = {1, 2, 3, 4, 1, 2, 4, 6, 9, 1};
        System.out.println(Task4.arrayToMap(arr));


        // Task 5
        System.out.println("\n-----------Task 5-----------");
        Set<Integer> firstSet = new TreeSet<Integer>();
        for (int i = 0; i < 10; i++)
            firstSet.add(i + 1);
        System.out.println("First set: " + firstSet);

        Set <Integer> secondSet = new TreeSet <Integer> ();
        for (int i = 7; i < 15; i++)
            secondSet.add(i + 1);
        System.out.println("Second set: " + secondSet);

        System.out.println("Union: " + Task5.union(firstSet, secondSet));
        System.out.println("Intersection: " + Task5.intersection(firstSet, secondSet));


        // Task 6
        System.out.println("\n-----------Task 6-----------");
        Product products = new Product();
        products.addProduct("Bear#3", "Vietnam");
        products.addProduct("Bear#4", "India");
        products.addProduct("Bear#5", "HongKong");
        products.addProduct("Bear#6", "NoName");
        products.keySet();
        products.entrySet();
        products.values();


        // Task 7
        System.out.println("\n-----------Task 7-----------");
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(2,4215, new int[]{5, 4, 3, 3},"Ivan"));
        students.add(new Student(2,4215, new int[]{3, 4, 2, 2},"Pupkin"));
        students.add(new Student(2, 4215, new int[]{2, 2, 3, 3}, "Semen"));
        students.add(new Student(2, 4215, new int[]{5, 2, 4, 3}, "Sirat"));
        students.add(new Student(2, 4215, new int[]{5, 4, 4, 4}, "Bulat"));
        students.add(new Student(3, 4215, new int[]{5, 4, 4, 4}, "NoName"));

        //students.forEach(student -> System.out.println(student.name + " " + student.averageGrade()));
        printStudents(students, 2);
        students = passedStudents(students);
        printStudents(students, 2);
    }

    public static List<Student> passedStudents(List<? extends Student> students){
        Iterator<? extends Student> temp = students.iterator();

        while (temp.hasNext()) {
            Student curr = temp.next();
            if (curr.averageGrade() < 3)
                temp.remove();
        }
        return (List<Student>) students;
    }

    public static void printStudents(List<Student> students, int course){
        Iterator<Student> temp = students.iterator();

        System.out.println("\nСписок студентов " + course + " курса:");
        while (temp.hasNext()) {
            Student curr = temp.next();
            if (curr.numberCourse == course){
                System.out.println(curr.name);
            }
        }
    }
}
