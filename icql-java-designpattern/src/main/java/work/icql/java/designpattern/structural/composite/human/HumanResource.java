package work.icql.java.designpattern.structural.composite.human;

public abstract class HumanResource {

    protected long id;

    protected double salary;

    public HumanResource(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public abstract double calculateSalary();
}
