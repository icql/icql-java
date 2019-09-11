package work.icql.java.designpattern.behavioral.strategy.impl;

import work.icql.java.designpattern.behavioral.strategy.Operation;

/**
 * @author qinglin.chen
 * @date 2019/8/9 17:14
 */
public class OperationSubtract implements Operation {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
