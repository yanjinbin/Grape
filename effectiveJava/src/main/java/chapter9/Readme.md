异常
异常只应该用于异常的情况  不应该用于正常的程序控制流

P219 重用 标准的异常 而不是新建一个异常

P220 异常转译  底层抛出的异常 应该被转译成可以接受的可理解的异常 


构建异常链 可以帮助程序调用者深入分析 异常出现的底层原因


异常应该写入 跟失败细节相关的简洁明了的信息 以 手机更好的信息


catch 块 不处理异常的话 需要文档说明下 为什么忽略
