package study.daily;

import org.springframework.beans.BeanUtils;
import study.mode.example.Movie;

public class DataCopyTest {

    public static class superVO{
        private String company;

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }
    }

    public static class superEntity{
        private String company;

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }
    }

    public static class Student extends superEntity{

        private int id;
        private String name;
        private int score;

        public Student(int id, String name, int score,String company) {
            this.id = id;
            this.name = name;
            this.score = score;
            super.company = company;
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

    public static class StudentCopy extends superVO{

        private int id;
        private String name;
        private int score;

        public StudentCopy() {
        }

        public StudentCopy(int id, String name, int score) {
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
            return "StudentCopy{" +
                    "company='" + super.company + '\'' +
                    ", id=" + id +
                    ", name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }


    public static void main(String[] args){
        Student student = new Student(1, "张三", 90,"测试");
//        StudentCopy copy = new StudentCopy();
//        BeanUtils.copyProperties(student,copy);
//        System.out.println(copy.toString());


        Movie movie = (Movie)null;
        System.out.println(movie);
    }
}
