package com.LJ.study.mode.simpleactory.inter;

import com.LJ.study.mode.simpleactory.material.inter.Cheese;
import com.LJ.study.mode.simpleactory.material.inter.Dough;
import com.LJ.study.mode.simpleactory.material.inter.Sauce;
import com.LJ.study.mode.simpleactory.material.inter.Veggies;

/**
 * 工厂接口
 */
public interface PizzaIngredientFactory {
    public Dough creeateDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggies[] createVeggies();
}
