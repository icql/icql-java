package work.icql.java.datastructure.list;

public interface List<E> {

    void add(int index, E e);

    void add(E e);

    void remove(int index);

    void remove(E e);

    void set(int index, E e);

    E get(int index);

    int size();
}
