package com.LJ.study.mode.example;

public class TestRenference {

    public static void main(String[] args) {
        Car car = new Car("red");
        System.out.println(car);
        function2(car);
        System.out.println(car);
    }


    static class Car{

        public Car(String color) {
            this.color = color;
        }

        private String color;

        @Override
        public String toString() {
            return "Car{" +
                    "color='" + color + '\'' +
                    '}';
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

     static void function1(Car car) {
        car.setColor("blue");
    }

    static void function2(Car car) {
        Car car2 = new Car("black");
        car = car2;
        car.setColor("orange");
    }
}
