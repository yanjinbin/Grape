package annotation;

/**
 * @Author Silver bullet
 * @Since 2017/7/2.
 */
@Factory(type = Meal.class, id = "Margherita")
public class MargheritaPizza implements Meal {
    @Override
    public int getPrice() {
        return 6;
    }
}
