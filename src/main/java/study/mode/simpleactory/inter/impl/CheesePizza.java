package study.mode.simpleactory.inter.impl;

import study.mode.simpleactory.inter.Pizza;
import study.mode.simpleactory.inter.PizzaIngredientFactory;

public class CheesePizza extends Pizza {

    PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory){
        this.ingredientFactory = ingredientFactory;
    }


    @Override
    protected void prepare() {
        System.out.println("Prepareing"+name);
        dough = ingredientFactory.creeateDough();
        sauce = ingredientFactory.createSauce();
        veggies = ingredientFactory.createVeggies();
        cheese = ingredientFactory.createCheese();
    }
}
