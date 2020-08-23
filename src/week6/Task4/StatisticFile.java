package week6.Task4;

import week6.Task3.PhoneEntry;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StatisticFile {
    /*
    ArrayList<StatisticFileEntry> statisticFile;

    public StatisticFile(){
        statisticFile = new ArrayList<>();
    }

    public void add(StatisticFileEntry entry){
        statisticFile.add(entry);
    }

    public void viewAllStatisticFile() {
        System.out.println("\nViewing all statistic file:");
        for (int i = 0; i < statisticFile.size(); i++)
            System.out.println(statisticFile.get(i).IP + "\t" + statisticFile.get(i).time
                    + "\t" + statisticFile.get(i).dayOfWeek);
    }
     */

    public static void viewAllStatisticFile(List<StatisticFileEntry> statisticFile) {
        System.out.println("\nViewing all statistic file:");
        for (int i = 0; i < statisticFile.size(); i++)
            System.out.println(statisticFile.get(i).getIP() + "\t" + statisticFile.get(i).getTime()
                    + "\t" + statisticFile.get(i).getDayOfWeek());
    }

    public static String createRandomIP(){
        String res = "";

        for (int j = 0; j < 4; j++){
            int[] ints = new Random().ints(1,0, 255).toArray();
            res += ints[0];
            if (j != 3)
                res += ".";
        }
        return res;
    }

    public static void createRandomStatisticFile(String fileName, int sizeEntries){
        int size = sizeEntries;
        Random rnd = new Random();
        boolean flag = false;
        String tempIP = "";

        try (PrintWriter writer = new PrintWriter(fileName)){
            for (int i = 0; i < size; i++){
                if (flag == false) {
                    tempIP = createRandomIP();
                    flag = true;
                } else if (flag == true){
                    if (rnd.nextBoolean())
                        flag = false;
                }
                writer.print(tempIP + " ");
                int[] temp = rnd.ints(1,0, 23).toArray();
                writer.print(temp[0] + "");
                temp = rnd.ints(2, 0, 60).toArray();
                writer.print(":" + temp[0] + ":" + temp[1]);
                writer.print(" " + DayOfWeek.of(rnd.nextInt(7) + 1));
                writer.println();
            }
            System.out.println("\nCreated random statistic FILE successfully");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    public static void analyzeStatisticFile(String fileName){
        List<DayOfWeek> maxDays = new ArrayList<>();
        List<String> maxTime = new ArrayList<>();

        // Nujno commentirovat' cod? Nije primer
        // Reading all lines from file to stream
        try (Stream<String> stream = Files.lines(Paths.get(fileName))){
            List<String> temp = new ArrayList<>();
            List<StatisticFileEntry> statisticFile = new ArrayList<>();
            // stream -> list
            temp = stream.collect(Collectors.toList());
            // filling "statisticFile" with all statistic info
            temp.forEach(i -> statisticFile.add(new StatisticFileEntry(i)));
            //viewAllStatisticFile(statisticFile);
            List<Integer> countIPs = countIP(statisticFile);
            List<String> distinctIPs = distinctIPs(statisticFile);

            for (int i = 0; i < distinctIPs.size(); i++){
                maxDays.add(maxDayForIP(statisticFile, distinctIPs.get(i)));
                int finalI = i;
                List<StatisticFileEntry> currentIPEntries = statisticFile.stream()
                        .filter(d -> d.getIP().equals(distinctIPs.get(finalI)))
                        .collect(Collectors.toList());
                maxTime.add(maxTimeForInput(currentIPEntries));
                //System.out.println(distinctIPs.get(i) + ": " + maxTimeForInput(currentIPEntries));
            }

            try (PrintStream p = new PrintStream("week6-task4-output.txt")){
                for (int i = 0; i < distinctIPs.size(); i++){
                    p.println("IP: " + distinctIPs.get(i)
                            + " Visit's number: " + countIPs.get(i)
                            + " Popular day: " + maxDays.get(i)
                            + " Popular time: " + maxTime.get(i)
                            + "-" + (Integer.parseInt(maxTime.get(i)) + 1)
                            + "hrs.");
                }

                p.println("Popular time in general: " + maxTimeForInput(statisticFile)
                        + "-" + (Integer.parseInt(maxTimeForInput(statisticFile)) + 1)
                        + "hrs.");
                System.out.println("\nAnalysis stored to FILE");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String maxTimeForInput(List<StatisticFileEntry> statisticFile){
        long max = 0;
        String maxTime = null;

        //viewAllStatisticFile(statisticFile);
        for (int i = 0; i < 24; i++) {
            int finalI = i;
            long temp = statisticFile.stream()
                    .filter(d -> d.time.substring(0, d.time.indexOf(":")).equals(finalI + ""))
                    .count();
            if (temp > max) {
                max = temp;
                maxTime = statisticFile.stream()
                        .filter(d -> d.time.substring(0, d.time.indexOf(":")).equals(finalI + ""))
                        .flatMap(p -> Stream.of(p.getTime()))
                        .map(d -> d.substring(0, d.indexOf(":")))
                        .distinct()
                        .collect(Collectors.joining());
            }
        }
        return maxTime;
    }

    public static DayOfWeek maxDayForIP(List<StatisticFileEntry> statisticFile, String IP){
        long max = 0;
        DayOfWeek maxDay = null;
        List<StatisticFileEntry> currentIPEntries = statisticFile.stream()
                .filter(d -> d.getIP().equals(IP))
                .collect(Collectors.toList());
        for (int i = 1; i < 8; i++) {
            int finalI = i;
            long temp = currentIPEntries.stream()
                    .filter(d -> d.getDayOfWeek() == DayOfWeek.of(finalI))
                    .count();
            if (temp > max) {
                max = temp;
                maxDay = DayOfWeek.of(i);
            }
        }
        return maxDay;
    }

    public static List<String> distinctIPs(List<StatisticFileEntry> statisticFile){
        return  statisticFile.stream()
                .flatMap(p -> Stream.of(p.getIP()))
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Integer> countIP(List<StatisticFileEntry> statisticFile){
        List<String> IPs = statisticFile.stream()
                .flatMap(p -> Stream.of(p.getIP()))
                .distinct()
                .collect(Collectors.toList());
        List<Integer> countIPs= new ArrayList<>();

        for (int i = 0; i < IPs.size(); i++){
            int count = 0;
            for (int j = 0; j < statisticFile.size(); j++){
                if (IPs.get(i).equals(statisticFile.get(j).getIP()))
                    count += 1;
            }
            countIPs.add(count);
        }
        return countIPs;
    }
}
