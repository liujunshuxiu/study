package study.mode.simpleactory.inter;

import study.mode.simpleactory.material.inter.Cheese;
import study.mode.simpleactory.material.inter.Dough;
import study.mode.simpleactory.material.inter.Sauce;
import study.mode.simpleactory.material.inter.Veggies;

/**
 * 工厂接口
 */
public interface PizzaIngredientFactory {
    public Dough creeateDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggies[] createVeggies();
}
