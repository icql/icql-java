package work.icql.java.designpattern.behavioral.state;

/**
 * 马里奥状态
 */
public interface IMario {
    //以下是定义的事件

    /**
     * 获得蘑菇
     */
    void obtainMushRoom();

    /**
     * 获得火焰花
     */
    void obtainFireFlower();

    /**
     * 接触怪兽
     */
    void meetMonster();
}
