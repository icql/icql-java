package work.icql.java.designpattern.behavioral.iterator;

public interface List<E> {

    Iterator iterator();

    int size();

    E get(int index);

    void add(E e);
}
