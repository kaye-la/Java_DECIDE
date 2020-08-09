package week4.Task7;

public class Student {
    public int numberCourse;
    public int group;
    public int[] grade;
    public String name;

    public Student(int numberCourse, int group, int[] grade, String name) {
        this.numberCourse = numberCourse;
        this.group = group;
        this.grade = grade;
        this.name = name;
    }

    public double averageGrade() {
        double average = 0;
        for (int i = 0; i < grade.length; i++) {
            average += grade[i];
        }
        return average /= grade.length;
    }
}
