package work.icql.java.designpattern.behavioral.command;

public class GotStartCommand implements Command {

    /**
     * 数据
     */
    private Object object;

    public GotStartCommand(Object o) {
        this.object = o;
    }

    @Override
    public void execute() {
        //执行具体的逻辑
    }
}
