package week4.Task6;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Product {
    private HashMap<String, String> products;

    public Product(HashMap<String, String> products) {
        this.products = products;
    }

    public Product() {
        products = new HashMap<String, String>();
    }

    public void addProduct(String name, String manufacturer) {
        products.put(name, manufacturer);
    }

    public void entrySet() {
        System.out.println("\nПары значений продуктов в базе (Name, Manufacturer):");
        Iterator<Map.Entry<String, String>> temp = products.entrySet().iterator();

        while (temp.hasNext()) {
            Map.Entry<String, String> pair = temp.next();
            System.out.println("(" + pair.getKey() + ", " + pair.getValue() + ")");
        }
    }

    public void keySet() {
        System.out.println("\nИмена продуктов в базе:");
        Iterator<String> temp = products.keySet().iterator();

        while (temp.hasNext()) {
            String name = temp.next();
            System.out.println(name);
        }
    }

    public void values() {
        System.out.println("\nЗначения продуктов (Производитель) в базе:");
        Iterator<String> temp = products.values().iterator();

        while (temp.hasNext()) {
            String res = temp.next();
            System.out.println(res);
        }
    }
}
