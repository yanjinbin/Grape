/**
 * @Author Grape
 * @Since 2017/8/13.
 */
public class StringInternTry {
    public static void main(String[] args) {


        // 看一下 String.intern()方法的契约

        /**
         * Returns a canonical representation for the string object.
         * <p>
         * A pool of strings, initially empty, is maintained privately by the
         * class {@code String}.
         * <p>
         * When the intern method is invoked, if the pool already contains a
         * string equal to this {@code String} object as determined by
         * the {@link #equals(Object)} method, then the string from the pool is
         * returned. Otherwise, this {@code String} object is added to the
         * pool and a reference to this {@code String} object is returned.
         * <p>
         * It follows that for any two strings {@code s} and {@code t},
         * {@code s.intern() == t.intern()} is {@code true}
         * if and only if {@code s.equals(t)} is {@code true}.
         * <p>
         * All literal strings and string-valued constant expressions are
         * interned. String literals are defined in section 3.10.5 of the
         * <cite>The Java&trade; Language Specification</cite>.
         *
         * @return  a string that has the same contents as this string, but is
         *          guaranteed to be from a pool of unique strings.
         */

        String intern = "s".intern();// String.intern() 方法
    }
}
