package chapter6;

import java.util.EnumSet;

/**
 * 用 EnumSet 代替位域表示法的操作（交集和并集） ，
 * 还可以补齐 不能遍历的缺点
 *
 * @Author Silver bullet
 * @Since 2017/6/27.
 */
public class TextTry {
    public static void main(String[] args) {
        Text text = new Text();
        text.applyStyles(EnumSet.of(Text.Style.BOLD, Text.Style.ITALIC));
    }
}
