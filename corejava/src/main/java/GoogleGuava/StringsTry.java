package GoogleGuava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

import java.util.regex.Pattern;

/**
 *
 * https://github.com/google/guava/wiki/StringsExplained
 *
 * @author Silver & Bullet
 *         since 2016-十二月
 */
public class StringsTry {
    public static void main(String[] args) {
        String[] stringArray = new String[]{"john", null, "harry", "James"};
        String separator = ";";
        String Substitute4NullText = "it is not null text ";

        //Joiner In Action
        printJoinerFun(stringArray, separator);

        newPrintJoinerFun(stringArray, separator, Substitute4NullText);


        //Splitter in Action

        printSplitterFun();
        String charsToRemove = "%^#";
        String stringToFilter = "I have 20% of my assets in #2 pencils! :^)";
        int length = 3;
        printSpliterOnCharMatcher(charsToRemove, stringToFilter);

        printSplitterOnFixedLength(stringToFilter, length);

    }

    //use join  skip null value
    public static void printJoinerFun(String[] array, String separator) {
        Joiner joiner = Joiner.on(separator).skipNulls();//会 Precondition.checkNotNull()
        String join = joiner.join(array);
        System.out.println("Strings joined by ;  is  " + join);
    }
    //use useForNull()

    public static void newPrintJoinerFun(String[] array, String separator, String nullText) {
        Joiner joiner = Joiner.on(separator).useForNull(nullText);
        String join = joiner.join(array);
        System.out.println("new PrinterJoinerFun method print     " + join);
    }

    //splitter
    public static void printSplitterFun() {
        Iterable<String> split = Splitter.on(",").trimResults().omitEmptyStrings().split("fao,bar,,,:,qux");
        for (String s :
                split) {
            System.out.println("splitter string is   " + s);
        }
    }

    public static void printSpliterOnCharMatcher(String pattern, String rawInput) {
        String filtered = CharMatcher.anyOf(pattern).removeFrom(rawInput);
        System.out.println("filtered value is   " + filtered);
    }


    public static void printSplitterCharMatcher(String toFilter, CharMatcher charmatcher) {
        Iterable<String> split = Splitter.on(charmatcher).trimResults().omitEmptyStrings().split(toFilter);
        for (String s :
                split) {
            System.out.println("s的值    " + s);
        }
    }


    public static void printSplitterOnFixedLength(String stringToFilter, int length) {
        Iterable<String> split = Splitter.fixedLength(length).trimResults().omitEmptyStrings().split(stringToFilter);
        for (String s :
                split) {
            System.out.println("s的值   " + s);
        }

    }

    public static void printSpliterOnCharMatcher(Pattern pattern, String rawInput) {
        Iterable<String> split = Splitter.on(pattern).split(rawInput);
        for (String s : split
                ) {
            System.out.println("s的值    " + s);
        }

    }

    public static void printSplitterOnStringPattern(String strPattern, String rawInput) {
        Iterable<String> split = Splitter.onPattern(strPattern).trimResults().omitEmptyStrings().split(rawInput);

        for (String s :
                split) {
            System.out.println("s的值    " + s);
        }
    }


    public static void useTrimResult(CharMatcher charMatcher, String rawInput,String separator) {
        Iterable<String> split = Splitter.on(separator).trimResults(charMatcher).omitEmptyStrings().split(rawInput);

        for (String s :
                split) {
            System.out.println("s的值    " + s);
        }
    }


    //Todo  MapSplitter
    public static void useMapSplitter(){

    }


    public static void printJoinerFun(){
        Joiner joiner = Joiner.on(";").useForNull(null);
        String join = joiner.join("Harry", "John");
        System.out.println(join);
    }

}
