package work.icql.java.designpattern.creational.factory.abstractfactory;

public interface ObjectFactory {

    IObject createObject1(String type);

    IObject createObject2(String type);
}
