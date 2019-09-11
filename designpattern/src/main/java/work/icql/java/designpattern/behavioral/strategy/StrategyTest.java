package work.icql.java.designpattern.behavioral.strategy;

import work.icql.java.designpattern.behavioral.strategy.impl.OperationAdd;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinglin.chen
 * @date 2019/8/10 9:57
 * @Title StrategyTest
 * @Description
 */
public class StrategyTest {
    public static void main(String[] args) {
        Strategy strategy = new Strategy(new OperationAdd());
        System.out.println(strategy.executeStrategy(1, 2));
        List<String> list = new ArrayList<>();
        list.add("fdf");
        list.add("fdf");

        System.out.println(list);

    }
}
