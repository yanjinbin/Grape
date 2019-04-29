package chapter2;

/** 清楚过期对象引用 obsolete reference
 * @Author Silver bullet
 * @Since 2017/6/23.
 */
public class Stack<V> {
    private  Object[] elements;
    private  int size = 0 ;

    private final  static int DEFAULT_INTIAL_CAPACITY = 16;

    private Stack(){
        elements = new Object[DEFAULT_INTIAL_CAPACITY];
    }

    public Object pop(){
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        stack.pop();
        if (size == 0) {
            throw  new RuntimeException("为空");
        }
        Object result = elements[--size];
        elements[size]=null;
        return result;
    }
}
