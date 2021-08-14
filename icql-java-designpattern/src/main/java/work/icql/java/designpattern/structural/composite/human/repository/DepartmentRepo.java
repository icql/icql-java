package work.icql.java.designpattern.structural.composite.human.repository;

import java.util.List;

public interface DepartmentRepo {

    List<Long> getSubDepartmentIds(long id);
}
