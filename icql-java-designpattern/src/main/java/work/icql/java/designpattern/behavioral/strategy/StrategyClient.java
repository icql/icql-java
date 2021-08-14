package work.icql.java.designpattern.behavioral.strategy;

public class StrategyClient {

    public static void main(String[] args) {
        StrategyFactory factory = new StrategyFactory();
        Strategy strategyA = factory.getStrategy("A");
        strategyA.operation();
    }
}