package annotation;

/**
 * @Author Silver bullet
 * @Since 2017/7/2.
 */
public class PizzaStore {

    private MealFactory mealFactory = new MealFactory();

    public Meal order(String mealName) {
        return mealFactory.create(mealName);

//        if (mealName == null) {
//            throw new IllegalArgumentException("Name of the meal is null!");
//        }
//
//        if ("Margherita".equals(mealName)) {
//            return new MargheritaPizza();
//        }
//
//        if ("Calzone".equals(mealName)) {
//            return new CalzonePizza();
//        }
//
//        if ("Tiramisu".equals(mealName)) {
//            return new TiramisuPizza();
//        }
//
//        throw new IllegalArgumentException("unknown mealName , please check it out");
    }

    public static void main(String[] args) {
        String meanlName = null;

        PizzaStore pizzaStore = new PizzaStore();
        Meal order = pizzaStore.order(meanlName);
        System.out.println(order.getPrice());
    }
}
