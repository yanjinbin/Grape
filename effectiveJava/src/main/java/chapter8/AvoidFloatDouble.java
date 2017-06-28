package chapter8;

/**
 * 货币计算的时候 避免实用 float 和 double
 * nextodo
 * BigDecimal 类型  http://blog.csdn.net/u013066244/article/details/53172243
 * http://blog.csdn.net/jackiehff/article/details/8582449
 * http://welcomezhang.iteye.com/blog/2305136
 *
 *
 *
 *
 * @Author Silver bullet
 * @Since 2017/6/28.
 */
public class AvoidFloatDouble {
    public static void main(String[] args) {
        //
//        System.out.println(1.03-0.42);
//        System.out.println(1.00-9*0.10);

/*        double funds =1.00;
        int itemsBought = 0 ;
        for (double price = 0.10;funds>=price;price +=0.10){
            funds -= price;
            itemsBought++;
        }*/
/*
        int funds =100;
        int itemsBought = 0 ;
        for (double price = 1;funds>=price;price +=1){
            funds -= price;
            itemsBought++;
        }*/

        // System.out.println("itemBought:\t"+itemsBought+"funds:\t"+funds);
    }
}
