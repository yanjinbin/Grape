package chapter6;

import java.util.EnumSet;

/**
 * @Author Silver bullet
 * @Since 2017/6/27.
 */
public class TextTry {
    public static void main(String[] args) {
        Text text = new Text();
        text.applyStyles(EnumSet.of(Text.Style.BOLD, Text.Style.ITALIC));
    }
}
