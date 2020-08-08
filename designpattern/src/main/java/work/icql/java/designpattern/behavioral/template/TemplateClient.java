package work.icql.java.designpattern.behavioral.template;

/**
 * 模板方法模式
 */
public class TemplateClient {

    public static void main(String[] args) {
        AbstractClass demo1 = new ConcreteClass1();
        demo1.templateMethod();

        //获取抽奖奖品规则
        AbstractClass demo2 = new ConcreteClass2();
        demo2.templateMethod();
    }
}
