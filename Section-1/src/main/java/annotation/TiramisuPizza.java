package annotation;

/**
 * @Author Silver bullet
 * @Since 2017/7/2.
 */
@Factory(type = Meal.class, id = "Tiramisu")
public class TiramisuPizza implements Meal {
    @Override
    public int getPrice() {
        return 8;
    }
}
