package work.icql.java.designpattern.structural.proxy.b_dynamic;

public class UserServiceImpl implements UserService {

    @Override
    public void action() {
        System.out.println("被代理类-action方法 执行了。。。");
    }
}
