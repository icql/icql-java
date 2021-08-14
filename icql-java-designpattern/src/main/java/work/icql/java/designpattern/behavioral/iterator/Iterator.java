package work.icql.java.designpattern.behavioral.iterator;

public interface Iterator<E> {

    boolean hasNext();

    void next();

    E currentItem();
}