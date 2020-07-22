package week2;

/**
 * Создать класс с двумя переменными. Добавить функцию вывода на экран и функцию изменения этих переменных.
 * Добавить функцию, которая находит сумму значений этих переменных,
 * и функцию которая находит наибольшее значение из этих двух переменных.
 */
public class Task1 {
    int a, b;

    public Task1(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int sum() {
        return a + b;
    }

    public int max() {
        return a > b ? a : b;
    }

    @Override
    public String toString() {
        return "Variable {" +
                "a=" + a +
                ", b=" + b +
                "}\n";
    }
}
