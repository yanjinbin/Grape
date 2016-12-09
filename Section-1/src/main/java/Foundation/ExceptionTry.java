package Foundation;

import java.sql.SQLException;

/**
 * https://goo.gl/3Edt0L
 *
 * Created by yanjinbin on 16-12-10.
 */
public class ExceptionTry {
    public static void main(String[] args) {
        //unchecked exception ,属于RuntimeException的之类,RuntimeException和Error,是unchecked exception 两大类,
        //RuntimeException 一般是程序逻辑错误,可以不处理,但是原则上都应该去思考尽可能避免发生 defensive programming ,如果碰到了,那么应当需要try catch住
        throwNullExce("哈哈");
        try {//checked exception 编译时候就会不通过,必须程序自己处理好
            throwSQLEXEC("嘿嘿");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void throwNullExce(String s)throws NullPointerException{
        System.out.println("s的值   "+s);
    }

    public static void throwSQLEXEC(String s) throws SQLException{
        System.out.println("s value is");
    }
}
