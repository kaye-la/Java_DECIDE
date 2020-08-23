package week6;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 1. Дан текстовый файл, содержащий целые числа. Удалить из него все четные числа.
 */
public class Task1 {
    public static void removeEvenInt(String filePath){
        try (FileReader reader = new FileReader(filePath))
        {
            int temp;
            ArrayList<String> data = new ArrayList<>();
            Scanner scanner = new Scanner(reader);

            while (scanner.hasNextInt())
            {
                temp = scanner.nextInt();
                if (temp % 2 == 1)
                    data.add("" + temp);
            }
            PrintWriter out = new PrintWriter(new FileWriter(filePath));
            for (String s : data)
                out.print(s + " ");
            out.close();
        } catch (IOException e) {
            System.out.println("An error has occured: " + e.getMessage());
        }
    }
}
