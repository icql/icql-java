package work.icql.java.designpattern.behavioral.state;

public class MarioStateMachine implements IMario {

    private int score;

    private IMario currentState;

    public MarioStateMachine() {
        this.score = 0;
        this.currentState = new SmallMario(this);
    }

    public int getScore() {
        return this.score;
    }

    public IMario getCurrentState() {
        return this.currentState;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCurrentState(IMario currentState) {
        this.currentState = currentState;
    }


    @Override
    public void obtainMushRoom() {
        this.currentState.obtainMushRoom();
    }

    @Override
    public void obtainFireFlower() {
        this.currentState.obtainFireFlower();
    }

    @Override
    public void meetMonster() {
        this.currentState.meetMonster();
    }
}
