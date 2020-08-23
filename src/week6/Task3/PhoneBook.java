package week6.Task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {
    ArrayList<PhoneEntry> phoneBook;

    public PhoneBook() {
        phoneBook = new ArrayList<>();
    }

    public void add(String surname, String phoneYear, String phoneNumber){
        PhoneEntry entry = new PhoneEntry(surname, phoneYear, phoneNumber);
        phoneBook.add(entry);
    }

    public void add(PhoneEntry entry){
        phoneBook.add(entry);
    }

    public void viewAllPhoneBook() {
        System.out.println("\nViewing all PhoneBook:");
        for (int i = 0; i < phoneBook.size(); i++)
            System.out.println(phoneBook.get(i).surname + "\t" + phoneBook.get(i).phoneYear
                    + "\t" + phoneBook.get(i).phoneNumber);
    }

    public void findNumber(String surname){
        boolean check = false;
        for (int i = 0; i < phoneBook.size(); i++){
            if (surname.equals(phoneBook.get(i).surname)){
                System.out.print("\nContact \"" + surname + "\" found: ");
                System.out.print(phoneBook.get(i).surname + " " + phoneBook.get(i).phoneNumber + "\n");
                check = true;
            }
        }
        if (check == false)
            System.out.println("\nContact \"" + surname + "\" not found...");
    }

    public void WritePhoneBook (String file) {
        try (PrintStream p = new PrintStream(file)){
            for (int i = 0; i < phoneBook.size(); i++) {
                p.println(phoneBook.get(i).surname + "\t" + phoneBook.get(i).phoneYear
                        + "\t" + phoneBook.get(i).phoneNumber + "\n");
            }
            System.out.println("\nPhonebook stored to FILE");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    public static void findNumberInPhoneBookFile (String filePath, String surname){
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file)
                    .useDelimiter("\\n");
            boolean check = false;

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                if (line.toLowerCase().indexOf(surname.toLowerCase()) >= 0){
                    System.out.print("\nContact \"" + surname + "\" found: " + line);
                    check = true;
                }
            }
            if (check == false)
                System.out.println("\nContact \"" + surname + "\" not found...");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    public static void phoneQuantityFromYear (String filePath, int phoneYear){
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file)
                    .useDelimiter("\\t");
            boolean check = false;
            int count = 0;

            while(scanner.hasNext()){
                int year = -1;
                scanner.next();
                if(scanner.hasNext()){
                    year = Integer.parseInt(scanner.next());
                    if (year >= phoneYear)
                        count += 1;
                }
            }
            System.out.println("\nQuantity of phones since " + phoneYear + " year: " + count + "pc.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
