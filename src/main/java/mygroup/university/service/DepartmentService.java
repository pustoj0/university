package mygroup.university.service;

import java.math.BigInteger;
import java.util.Optional;
import mygroup.university.dto.DepartmentStatistics;
import mygroup.university.model.Lector;

public interface DepartmentService {
    Optional<Lector> getHeadOfDepartment(String departmentName);

    Optional<DepartmentStatistics> getDepartmentStatistics(String departmentName);

    Optional<BigInteger> calculateAvgSalary(String departmentName);

    Optional<Integer> countOfEmployee(String departmentName);
}
