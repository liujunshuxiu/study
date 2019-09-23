package study.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListStreamTest {

    public static class Student {

        private int id;
        private String name;
        private int score;

        public Student(int id, String name, int score) {
            this.id = id;
            this.name = name;
            this.score = score;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }

    public static void main(String[] args){
        List<Student> students = new ArrayList<>();

//        students.add(new Student(1,"张三",90));
//        students.add(new Student(2,"李四",60));
//        students.add(new Student(3,"王五",30));
//        students.add(new Student(4,"赵六",85));

        int studentId = 3;


//        System.out.println(students.stream().filter(o -> o.getId() == studentId).findAny().orElse(null).getScore());


        String unknown = students.stream()
                .filter(user -> user.getId() < 10)
                .map(user -> user.getName()).findAny()
                .orElse("Unknown");
 
        System.out.println(unknown);
    }

}
