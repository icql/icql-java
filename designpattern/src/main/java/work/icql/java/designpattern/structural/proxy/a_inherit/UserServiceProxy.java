package work.icql.java.designpattern.structural.proxy.a_inherit;

/**
 * 继承实现的代理模式
 */
public class UserServiceProxy extends UserService {

    @Override
    public void action() {
        //附加功能
        System.out.println("代理类-action方法 执行了。。。");
        super.action();
    }
}
