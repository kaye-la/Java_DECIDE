package week6;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

/**
 * 2. Считать данные с файла введеного пользователем, отсортировать и сохранить в другой файл (ред.)
 * Реализация для строк
 */
public class Task2 {
    public static void sortWords(String filePathInput, String filePathOutput) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePathInput))) {
            String tempLine, word;
            ArrayList<String> words = new ArrayList<String>();
            boolean flag = false;

            while ((tempLine = reader.readLine()) != null) {
                int i = 0;
                word = "";
                while (i < tempLine.length() && Character.isWhitespace(tempLine.charAt(i)))
                    i += 1;
                while (i < tempLine.length()) {
                    if (Character.isWhitespace(tempLine.charAt(i))) {
                        words.add(word);
                        word = "";
                        flag = false;
                        while (i < tempLine.length() && Character.isWhitespace(tempLine.charAt(i)))
                            i += 1;
                    }
                    else{
                        word = word + tempLine.charAt(i);
                        flag = true;
                        i +=1;
                    }
                }
                if (flag == true)
                    words.add(word);
            }
            Collections.sort(words);
            Path out = Paths.get(filePathOutput);
            Files.write(out, words, Charset.forName("UTF-8"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("An error has occured: " + e.getMessage());
        }
    }
}