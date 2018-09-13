package main.java.study.mode.simpleactory.inter;

import main.java.study.mode.simpleactory.material.inter.Cheese;
import main.java.study.mode.simpleactory.material.inter.Dough;
import main.java.study.mode.simpleactory.material.inter.Sauce;
import main.java.study.mode.simpleactory.material.inter.Veggies;

/**
 * 工厂接口
 */
public interface PizzaIngredientFactory {
    public Dough creeateDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggies[] createVeggies();
}
