package study.mode.simpleactory.inter.impl;

import study.mode.simpleactory.inter.PizzaIngredientFactory;
import study.mode.simpleactory.material.*;
import study.mode.simpleactory.material.inter.Cheese;
import study.mode.simpleactory.material.inter.Dough;
import study.mode.simpleactory.material.inter.Sauce;
import study.mode.simpleactory.material.inter.Veggies;

/**
 * 纽约工厂，使用纽约定制化原料
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough creeateDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        return new Veggies[]{new Garlic(),new Onion()};
    }
}
