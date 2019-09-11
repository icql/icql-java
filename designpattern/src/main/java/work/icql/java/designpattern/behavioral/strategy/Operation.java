package work.icql.java.designpattern.behavioral.strategy;

/**
 * @author qinglin.chen
 * @date 2019/8/9 16:35
 */
public interface Operation {
    /**
     * 操作
     *
     * @param num1
     * @param num2
     * @return
     */
    int doOperation(int num1, int num2);
}