package work.icql.java.designpattern.behavioral.strategy;

/**
 * 具体的策略A
 */
public class ConcreteStrategyA implements Strategy {

    @Override
    public void operation() {
        System.out.println("具体的策略A");
    }
}
