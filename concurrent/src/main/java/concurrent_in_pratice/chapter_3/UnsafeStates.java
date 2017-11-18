package concurrent_in_pratice.chapter_3;


/**
 * UnsafeStates
 * <p/>
 * Allowing internal mutable state to escape
 *
 * @author Brian Goetz and Tim Peierls
 */
class UnsafeStates {
    private String[] states = new String[]{
            "AK", "AL" /*...*/
    }; //本来私有的 getStates(）一搞 那就使对象脱离了正确的作用域


    public String[] getStates() {
        return states;
    }
}
