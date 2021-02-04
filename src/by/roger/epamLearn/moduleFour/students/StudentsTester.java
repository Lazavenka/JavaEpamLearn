package by.roger.epamLearn.moduleFour.students;

import java.util.Arrays;

public class StudentsTester {
    public static void main(String[] args) {

        Student[] students = new Student[20];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
        }
        Arrays.sort(students);
        for (Student student : students) {
            System.out.println(student.toString());
            student.printNerd();
        }
    }
}
