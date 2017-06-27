package chapter6;

import java.util.Set;

/**
 * @Author Silver bullet
 * @Since 2017/6/27.
 */
public class Text {

    public enum  Style{BOLD,ITALIC,UNDERLINE,STRIKETHROUGH}

    public void applyStyles(Set<Style> styles){
        for (Style style:
             styles) {
            System.out.println("name is"+style.name()+"ordinal is"+style.ordinal());
        }
    }
}
