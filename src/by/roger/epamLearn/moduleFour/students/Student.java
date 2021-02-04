package by.roger.epamLearn.moduleFour.students;
/*
3. Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив
из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и
номеров групп студентов, имеющих оценки, равные только 9 или 10
 */
import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;

public class Student implements Comparable<Student>, Serializable {
    private String name;
    private int group;
    private int[] progress;

    public Student() {
        name = nameGen();
        group = groupGenerator();
        progress = progressGenerator();
    }

    public Student(String name, int group, int[] progress) {
        this.name = name;
        this.group = group;
        this.progress = progress;
    }
    private String nameGen(){
        StringBuilder sb = new StringBuilder();
        String[] prefix = {"А", "Во","У","Ту" ,"Па" , "Е","Во" ,"Ку" , "Жда", "Бе","Му" ,"Ле"};
        String[] root = {"воре", "кан","зовен" , "гов", "гор", "чмов","нов","кор" ,"сук" ,"шко" , "чкав", "коч","скрес" ,"выр" ,"левск" , "кон", "чен",};
        String[] postfix = {"ко", "ва","ев","ов","ич","ка","ий"};
        String[] initials = {"А.А.", "В.А.","Б.А.","С.А.","А.И.","А.Н.","А.В.","А.Д.","К.В.","Л.С.","В.В.","У.Ф."};

        sb.append(prefix[new Random().nextInt(prefix.length)]);
        sb.append(root[new Random().nextInt(root.length)]);
        sb.append(postfix[new Random().nextInt(postfix.length)]);
        sb.append(" ");
        sb.append(initials[new Random().nextInt(initials.length)]);
        return sb.toString();
    }
    private int groupGenerator(){
        int[] groups = {840301, 142791, 940301, 740301, 842791, 943201, 743201, 143201};
        return groups[new Random().nextInt(groups.length)];
    }
    private int[] progressGenerator(){
        int[] prog = new int[4];
        for (int i = 0; i < prog.length; i++) {
            Random rnd = new Random();
            prog[i] = 6 + rnd.nextInt(5);
        }
        return prog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int[] getProgress() {
        return progress;
    }

    public void setProgress(int[] progress) {
        this.progress = progress;
    }

    private boolean isStudentNerd(){
        boolean ans = true;
        for (int j : progress) {
            if (j<9) {
                return false;
            }
        }
        return ans;
    }
    public void printNerd(){
        if (isStudentNerd()){
            System.out.println("Студент: "+name+" из группы "+group+" - отличник");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (group != student.group) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        return Arrays.equals(progress, student.progress);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + group;
        result = 31 * result + Arrays.hashCode(progress);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group=" + group +
                ", progress=" + Arrays.toString(progress) +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        Integer group1 = group;
        Integer group2 = o.getGroup();
        int sCom = group1.compareTo(group2);
        if(sCom !=0 ){
            return sCom;
        }
        return name.compareTo(o.getName());
    }
}
