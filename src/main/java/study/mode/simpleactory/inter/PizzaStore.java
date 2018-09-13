package main.java.study.mode.simpleactory.inter;

/**
 * 披萨商店，提供订购披萨，关键的创造披萨要求各自实现
 */
public abstract class PizzaStore {
    
    public Pizza orderPizza(String type){
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        
        return pizza;
    }

    protected abstract Pizza createPizza(String type);

}
