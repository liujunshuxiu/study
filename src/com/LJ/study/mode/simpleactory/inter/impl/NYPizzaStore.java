package com.LJ.study.mode.simpleactory.inter.impl;

import com.LJ.study.mode.simpleactory.inter.Pizza;
import com.LJ.study.mode.simpleactory.inter.PizzaIngredientFactory;
import com.LJ.study.mode.simpleactory.inter.PizzaStore;

/**
 * 纽约披萨店，使用纽约工厂
 */
public class NYPizzaStore extends PizzaStore{
    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

        if(type.equals("Cheese")){
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York Cheese Pizza");
        }

        return  pizza;
    }
}
