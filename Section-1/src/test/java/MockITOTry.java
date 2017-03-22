/**
 * @author Silver & Bullet
 *         on 三月-14
 */
public class MockITOTry {
    public void mockito() {

        ////你可以模拟具体的类，而不只是接口
        //LinkedList mockedList = mock(LinkedList.class);
        //
        ////打桩
        //when(mockedList.get(0)).thenReturn("first");
        //when(mockedList.get(1)).thenThrow(new RuntimeException());
        //
        ////以下代码打印出"first"字符串
        //System.out.println(mockedList.get(0));
        //
        ////以下代码抛出运行时异
        //System.out.println(mockedList.get(1));
        //
        ////以下代码打印出"null"，因为get(999)没有被打桩
        //System.out.println(mockedList.get(999));
        //
        ////尽管是可以验证一个打过桩的调用，但通常是多余的
        ////如果你的代码关心get(0)返回值的内容，那么其他东西就会中断（往往在verify()执行之前就发生了）。
        ////如果你的代码不关心get(0)返回值的内容，那么它就不应该被打桩。不相信吗？看看这里。
        //verify(mockedList).get(0);
    }
}
