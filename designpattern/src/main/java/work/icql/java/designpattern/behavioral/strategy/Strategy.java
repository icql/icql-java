package work.icql.java.designpattern.behavioral.strategy;

/**
 * @author qinglin.chen
 * @date 2019/8/9 17:16
 */
public class Strategy {

    private Operation operation;

    public Strategy(Operation operation) {
        this.operation = operation;
    }

    public int executeStrategy(int num1, int num2) {
        return operation.doOperation(num1, num2);
    }
}