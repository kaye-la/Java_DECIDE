package week2;

/**
 * Создайте класс, который описывает вектор (в трёхмерном пространстве).
 */
public class Task2 {
    private double x;
    private double y;
    private double z;

    public Task2(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double length(){
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double scalarProduct(Task2 vector){
        return (x * vector.x + y * vector.y + z * vector.z);
    }

    public Task2 vectorProduct(Task2 vector){
        return new Task2(y * vector.z - z * vector.y,
                z * vector.x - x * vector.z,
                x * vector.y - y * vector.x);
    }

    public double cos(Task2 vector){
        return scalarProduct(vector) / (this.length() * vector.length());
    }

    public Task2 sum(Task2 vector){
        return new Task2(x + vector.x,
                y + vector.y,
                z + vector.z);
    }

    public Task2 difference(Task2 vector) {
        return new Task2(x - vector.x,
                y - vector.y,
                z - vector.z);
    }

    public static Task2[] randomGenerate(int N) {
        Task2[] res = new Task2[N];

        for(int i =0; i < N; i++){
            res[i] = new Task2(Math.random(), Math.random(), Math.random());
        }
        return res;
    }

    @Override
    public String toString() {
        return "Vector {" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                "}";
    }
}
