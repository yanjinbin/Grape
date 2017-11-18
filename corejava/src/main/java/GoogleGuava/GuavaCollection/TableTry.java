package GoogleGuava.GuavaCollection;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Iterator;
import java.util.Map;

/**
 * 参考链接
 * http://www.cnblogs.com/peida/p/3183505.html
 * https://goo.gl/rsgVg2
 *
 *
 * Type Parameters:
 * R - the type of the table row keys
 * C - the type of the table column keys
 * V - the type of the mapped values    V =R interactive  C  , core view for table data structure
 * <p>
 * Created by dabin on 2016/12/11.
 */
public class TableTry {
    public static void main(String[] args) {
        //建议引入泛型,更强的编译检查和消除类型转换
        //现在限定死了 R C 和V 的 类型 ,
        // 但是现实场景是,key并不一定是一种类型,Guava提供了ClassToInstanceMap supported
        Table<String, Integer, String> hashBaseTable = HashBasedTable.create();
        for (char i = 'A'; i <= 'C'; ++i) {
            for (Integer j = 1; j <= 3; ++j) {
                hashBaseTable.put(Character.toString(i), j, String.format("%c%d", i, j));
            }
        }

        System.out.println("column 2    " + hashBaseTable.column(2));
        System.out.println("row B    " + hashBaseTable.row("B"));
        System.out.println("B 2     " + hashBaseTable.get("B", 2));

        System.out.println("Contain D  1     " + hashBaseTable.contains("D", 1));
        System.out.println("Column 3     " + hashBaseTable.containsColumn(3));
        System.out.println("Row  C    " + hashBaseTable.containsRow("C"));
        System.out.println("Column  Map   " + hashBaseTable.columnMap());
        System.out.println("Row Map     " + hashBaseTable.rowMap());

        System.out.println(hashBaseTable.remove("B", 3));


        System.out.println("-------------Column correlation --------------");

        Map<Integer, Map<String, String>> columnMap = hashBaseTable.columnMap();

        Map<String, String> column2Map = hashBaseTable.column(2);
        Iterator<String> column2MapIterator = column2Map.values().iterator();
        while (column2MapIterator.hasNext()) {
            System.out.println(column2MapIterator.next());
        }

        System.out.println("--------------Row correlation----------------");
        Iterator<Map<Integer, String>> rowMapIterator = hashBaseTable.rowMap().values().iterator();
        while (rowMapIterator.hasNext()) {
            System.out.println("row值   " + rowMapIterator.next());
        }




    }
}
