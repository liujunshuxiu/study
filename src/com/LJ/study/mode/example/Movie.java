package com.LJ.study.mode.example;

/**
 * 多个属性
 */
public class Movie {
    private final int servingSize;  //required
    private final int servings;     //required
    private final int calories;     //optional
    private final int fat;          //optional
    private final int sodium;       //optional
    private final int carbohydrate;//optional

    //静态内部类
    public static class Builder{
        //required
        private final int servingSize;
        private final int servings;

        //optional
        private int calories = 0;
        private int fat = 0;
        private int carbohydrate = 0;
        private int sodium = 0;

        public Builder(int servingSize,int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val){
            calories = val;
            return this;
        }

        public Builder fat(int val){
            calories = val;
            return this;
        }

        public Builder carbohydrate(int val){
            calories = val;
            return this;
        }

        public Builder sodium(int val){
            calories = val;
            return this;
        }

        public Movie build(){
            return new Movie(this);
        }
    }

    private Movie(Builder builder){
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}
