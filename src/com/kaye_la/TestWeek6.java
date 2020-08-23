package com.kaye_la;

import week6.Task1;
import week6.Task2;
import week6.Task3.PhoneBook;
import week6.Task4.StatisticFile;
import week6.Task4.StatisticFileEntry;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.time.DayOfWeek;
import java.util.*;
import java.util.stream.IntStream;

public class TestWeek6 {
    public static void run(){
        // Task 1
        // Example 1 - with Delimiter new line("\n")
        System.out.println("-----------Task 1-----------");
        List<String> lines1 = Arrays.asList("1\n", "23\n", "13\n", "210\n", "20\n", "12\n", "84\n", "2\n", "1\n",
                "43\n", "283\n", "2\n");
        Path file1 = Paths.get("week6-task1-example1.txt");
        try {
            Files.write(file1, lines1, Charset.forName("UTF-8"));
        } catch (IOException e) {
            System.out.println("An error has occured: " + e.getMessage());
        }
        Task1.removeEvenInt(file1.toString());

        // Example 2 - with Delimiter space(" ")
        String lines2 = "1 23 13 210 20 12 84 2 1 43 283 2";
        Path file2 = Paths.get("week6-task1-example2.txt");
        try {
            Files.write(file2, Collections.singleton(lines2), Charset.forName("UTF-8"));
        } catch (IOException e) {
            System.out.println("An error has occured: " + e.getMessage());
        }
        Task1.removeEvenInt(file2.toString());

        // Task 2
        System.out.println("-----------Task 2-----------");
        //String lines_task2 = "Hey asdw            asdl;aw WUwjasd adad sadas";
        String lines_task2 = "abacaba bacaba     \r\n       acaba caba aba \tba \ra";
        Path file_input_task2 = Paths.get("week6-task2-input.txt");
        Path file_output_task2 = Paths.get("week6-task2-output.txt");
        try {
            Files.write(file_input_task2, Collections.singleton(lines_task2), Charset.forName("UTF-8"));
            Task2.sortWords(file_input_task2.toString(), file_output_task2.toString());
        } catch (IOException e) {
            System.out.println("An error has occured: " + e.getMessage());
        }

        // Task 3
        System.out.println("-----------Task 3-----------");
        //String lines_task2 = "Hey asdw            asdl;aw WUwjasd adad sadas";
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Saidov", "2010", "+711111111");
        phoneBook.add("Petrov", "2010", "+722222222");
        phoneBook.add("Semenov", "2006", "+733333333");
        phoneBook.add("Ivanov", "2006", "+744444444");
        phoneBook.add("Degtyarov", "2004", "+755555555");
        phoneBook.add("Smith", "2004", "+766666666");
        phoneBook.add("Donald", "2000", "+777777777");
        phoneBook.add("Reginald", "2000", "+788888888");
        phoneBook.add("Reginald", "1998", "+799999999");

        phoneBook.findNumber("Saidov");
        phoneBook.viewAllPhoneBook();

        String task3_fileName = "week6-task3.txt";
        phoneBook.WritePhoneBook(task3_fileName);
        PhoneBook.findNumberInPhoneBookFile(task3_fileName, "Reginald");
        PhoneBook.phoneQuantityFromYear(task3_fileName, 2005);


        // Task 4
        System.out.println("-----------Task 4-----------");
        /*
        StatisticFile statisticFile = new StatisticFile();
        statisticFile.add(new StatisticFileEntry("192.123.243.2", "13:23", DayOfWeek.FRIDAY));
        statisticFile.add(new StatisticFileEntry("192.123.243.2", "13:23", DayOfWeek.FRIDAY));
        statisticFile.add(new StatisticFileEntry("192.123.243.2 12:23:2 SATURDAY"));
        statisticFile.viewAllStatisticFile();
         */
        String task4_fileName = "week6-task4-input.txt";
        StatisticFile.createRandomStatisticFile(task4_fileName, 50);
        StatisticFile.analyzeStatisticFile(task4_fileName);
        //System.out.println(DayOfWeek.SUNDAY.getValue());

    }
}
/*
String s = r.ints(48, 122)
                .filter(i -> (i < 57 || i > 65) && (i < 90 || i > 97))
                .mapToObj(i -> (char) i)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
 */