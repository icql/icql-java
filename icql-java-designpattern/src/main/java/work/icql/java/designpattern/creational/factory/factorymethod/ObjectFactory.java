package work.icql.java.designpattern.creational.factory.factorymethod;

public interface ObjectFactory {
    IObject createObject(String type);
}
